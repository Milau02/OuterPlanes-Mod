package ml.milau.outerplanes.core.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Optional;
import java.util.stream.Stream;

public class ImbuementAltarBlock extends Block {

    private static final VoxelShape SHAPE = Stream.of(
            Block.box(1, 0, 1, 15, 2, 15),
            Block.box(4, 2, 4, 12, 4, 12),
            Block.box(6, 4, 6, 10, 11, 10),
            Block.box(4, 11, 4, 12, 13, 12),
            Block.box(0, 10, 0, 4, 15, 4),
            Block.box(0, 10, 12, 4, 15, 16),
            Block.box(12, 10, 0, 16, 15, 4),
            Block.box(12, 10, 12, 16, 15, 16),
            Block.box(1, 11, 4, 4, 14, 12),
            Block.box(10, 10, 5, 11, 11, 11),
            Block.box(6, 10, 10, 10, 11, 11),
            Block.box(12, 11, 4, 15, 14, 12),
            Block.box(4, 11, 12, 12, 14, 15),
            Block.box(4, 11, 1, 12, 14, 4),
            Block.box(6, 10, 5, 10, 11, 6),
            Block.box(5, 10, 5, 6, 11, 11)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if(!SHAPE.isEmpty()){
            return SHAPE;
        }
        else{
            return Shapes.block();
        }
    }

    public ImbuementAltarBlock(Properties properties) {
        super(properties);
    }
}
