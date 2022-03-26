package toma400.cobr.elements.blocks.templated;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class MatBlocks extends Block {

    public MatBlocks(Properties properties) {
        super(properties);
    }

    private static final VoxelShape MAT_SHAPE = Stream.of(
            Block.box(0,0,0,16,1,16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        //return super.getShape(pState, pLevel, pPos, pContext);
        return MAT_SHAPE;
    }
}
