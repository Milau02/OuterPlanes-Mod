package ml.milau.outerplanes.core.world.feature.tree.decorators;

import com.mojang.serialization.Codec;
import ml.milau.outerplanes.core.util.OuterPlanesTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class RootedDecorator extends TreeDecorator {
    //base code, not part of root placing
    public static final Codec<RootedDecorator> CODEC = BlockStateProvider.CODEC.fieldOf("provider").xmap(RootedDecorator::new, (p_69327_) -> {return p_69327_.provider;}).codec();
    private final BlockStateProvider provider;
    public RootedDecorator(BlockStateProvider p_69306_) {this.provider = p_69306_;}
    protected TreeDecoratorType<?> type() {return TreeDecoratorType.ALTER_GROUND;}


    public void place(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, Random pRandom, List<BlockPos> pLogPositions, List<BlockPos> pLeafPositions) {

        if (!pLogPositions.isEmpty()) {
            int yLevel = getLowestLog(pLevel,pLogPositions);
            pLogPositions.forEach(System.out::println);
            Stream<BlockPos> lowestTrunks = pLogPositions.stream().filter((p_69310_) -> {return p_69310_.getY() == yLevel;});
            BlockPos centerLog = new BlockPos(getCornerLog(lowestTrunks,pLevel,pBlockSetter,pRandom));
            System.out.println(centerLog);
            genStrand(pLevel,pBlockSetter,pRandom,centerLog.north(),Direction.NORTH,Direction.WEST,Direction.EAST);
            genStrand(pLevel,pBlockSetter,pRandom,centerLog.east().east(),Direction.EAST,Direction.NORTH,Direction.SOUTH);
            genStrand(pLevel,pBlockSetter,pRandom,centerLog.east().south().south(),Direction.SOUTH,Direction.EAST,Direction.WEST);
            genStrand(pLevel,pBlockSetter,pRandom,centerLog.south().west(),Direction.WEST,Direction.SOUTH,Direction.NORTH);
        }
    }
    public static int getLowestLog(LevelSimulatedReader pLevel, List<BlockPos> pLogPositions){
        int i = 0;
        BlockPos tempLog = pLogPositions.get(i);
        if(pLevel.isStateAtPosition(tempLog,RootedDecorator::isLog)){
            return tempLog.getY();
        }
        else{
            while(!pLevel.isStateAtPosition(tempLog,RootedDecorator::isLog)){
                i++;
                tempLog = pLogPositions.get(i);
            }
            return tempLog.getY();
        }
    }
    public static boolean isLog(BlockState pBlockState){
        return pBlockState.is(BlockTags.LOGS);
    }
    public static boolean isAppropriate(BlockState pBlockState) {
        return pBlockState.is(BlockTags.DIRT);// || pBlockState.is(OuterPlanesTags.Blocks.ASTRAL_TURF) || pBlockState.is(OuterPlanesTags.Blocks.SOULTREE_TURF)
    }
    private void placeBlockAt(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, Random pRandom, BlockPos pPos) {
        if (pLevel.isStateAtPosition(pPos,RootedDecorator::isAppropriate)) {
            pBlockSetter.accept(pPos, this.provider.getState(pRandom, pPos));
        }
    }

    private Vec3i getCornerLog (Stream<BlockPos>lowestTrunks,LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, Random pRandom){
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        int counting = 0;
        for(BlockPos log : lowestTrunks.toList()){
            BlockPos ground = new BlockPos(log.getX(),log.getY()-1,log.getZ());
            placeBlockAt(pLevel,pBlockSetter,pRandom,ground);
            x = x + log.getX();
            y = y + log.getY();
            z = z + log.getZ();
            counting++;
        }
        x = x / counting;
        y = y / counting;
        z = z / counting;
        return new Vec3i(x,y-1,z);
    }

    private void genStrand(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, Random pRandom, BlockPos startPos, Direction dir, Direction left, Direction right){
        for(int i = 0; i < 3; i++){
            placeBlockAt(pLevel,pBlockSetter,pRandom,startPos);
            int choice = pRandom.nextInt(3);
            switch (choice){
                case 0 -> startPos = startPos.offset(dir.getNormal()).offset(left.getNormal()); //go left
                case 2 -> startPos = startPos.offset(dir.getNormal()).offset(right.getNormal()); //go right
                case 1 -> {
                    //placeBlockAt(pLevel,pBlockSetter,pRandom,startPos.offset(dir.getNormal())); //straight double place
                    startPos = startPos.offset(dir.getNormal());
                    //.offset(dir.getNormal());
                }
            }
        }
    }
}
