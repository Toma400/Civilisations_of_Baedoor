package toma400.cobr.elements.blocks.templated;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import toma400.cobr.core.CobrBlocks;

import java.util.stream.Stream;

public class MatBlocks extends Block {

    public MatBlocks(Properties properties) {
        super(properties);
    }

    //SHAPE
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Block.box(0,0,0,16,1,16);
    }

    //FIRE-RELATIONS SECTION
    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        if (state.getBlock() == CobrBlocks.EOTIC_BAMBOO_MAT.get()) {
            return true;
        }
        return false;
    }
    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        if (state.getBlock() == CobrBlocks.EOTIC_BAMBOO_MAT.get()) {
            return 20;
        }
        return 0;
    }
    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        if (state.getBlock() == CobrBlocks.EOTIC_BAMBOO_MAT.get()) {
            return 5;
        }
        return 0;
    }
}
