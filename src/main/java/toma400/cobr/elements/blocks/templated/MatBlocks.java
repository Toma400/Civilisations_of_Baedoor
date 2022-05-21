package toma400.cobr.elements.blocks.templated;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import toma400.cobr.core.CobrBlocks;

import java.util.stream.Stream;

import static net.minecraft.block.NetherPortalBlock.AXIS;

public class MatBlocks extends Block {

    public MatBlocks(Properties properties) {
        super(properties);
    }

    //SHAPE
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        return VoxelShapes.or(box(0, 0, 0, 16, 1, 16));
    }


    //FIRE-RELATIONS SECTION
    @Override
    public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        if (state.getBlock().asItem() == CobrBlocks.EOTIC_BAMBOO_MAT.get().asItem()) {
            return true;
        }
        return false;
    }
    @Override
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        if (state.getBlock().asItem() == CobrBlocks.EOTIC_BAMBOO_MAT.get().asItem()) {
            return 20;
        }
        return 0;
    }
    @Override
    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        if (state.getBlock().asItem() == CobrBlocks.EOTIC_BAMBOO_MAT.get().asItem()) {
            return 5;
        }
        return 0;
    }
}
