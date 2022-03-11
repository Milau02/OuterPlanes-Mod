package ml.milau.outerplanes.world.feature.tree.decorators;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
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
            int i = pLogPositions.get(0).getY();
            Stream<BlockPos> lowestTrunks = pLogPositions.stream().filter((p_69310_) -> {return p_69310_.getY() == i;});
            BlockPos centerLog = new BlockPos(getCornerLog(lowestTrunks,pLevel,pBlockSetter,pRandom));
            genStrand(pLevel,pBlockSetter,pRandom,centerLog.north(),Direction.NORTH,Direction.WEST,Direction.EAST);
            genStrand(pLevel,pBlockSetter,pRandom,centerLog.east().east(),Direction.EAST,Direction.NORTH,Direction.SOUTH);
            genStrand(pLevel,pBlockSetter,pRandom,centerLog.east().south().south(),Direction.SOUTH,Direction.EAST,Direction.WEST);
            genStrand(pLevel,pBlockSetter,pRandom,centerLog.south().west(),Direction.WEST,Direction.SOUTH,Direction.NORTH);
        }
    }

    private void placeBlockAt(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, Random pRandom, BlockPos pPos) {
        if (Feature.isGrassOrDirt(pLevel, pPos)) {
            pBlockSetter.accept(pPos, this.provider.getState(pRandom, pPos));
        }
    }

    private Vec3i getCornerLog (Stream<BlockPos>lowestTrunks,LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, Random pRandom){
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        int counting = 0;
        for(BlockPos log : lowestTrunks.toList()){
            placeBlockAt(pLevel,pBlockSetter,pRandom,log);
            x = x + log.getX();
            y = y + log.getY();
            z = z + log.getZ();
            counting++;
        }
        x = x / counting;
        y = y / counting;
        z = z / counting;
        return new Vec3i(x,y,z);
    }

    private void genStrand(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, Random pRandom, BlockPos startPos, Direction dir, Direction left, Direction right){
        for(int i = 0; i < 3; i++){
            placeBlockAt(pLevel,pBlockSetter,pRandom,startPos);
            int choice = pRandom.nextInt(4);
            switch (choice){
                case 0 -> startPos = startPos.offset(dir.getNormal()).offset(left.getNormal());
                case 1 -> startPos = startPos.offset(dir.getNormal());
                case 2 -> startPos = startPos.offset(dir.getNormal()).offset(right.getNormal());
                case 3 -> {
                    placeBlockAt(pLevel,pBlockSetter,pRandom,startPos.offset(dir.getNormal()));
                    startPos = startPos.offset(dir.getNormal()).offset(dir.getNormal());
                }
            }
        }
    }
}
