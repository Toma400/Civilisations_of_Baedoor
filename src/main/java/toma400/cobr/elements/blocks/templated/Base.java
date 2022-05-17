package toma400.cobr.elements.blocks.templated;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import toma400.cobr.core.CobrBlocks;

public class Base {

    /*
     *  CLASS HERE IS USED MOSTLY FOR DATAGEN OF MODELS/BLOCKSTATES, BUT ALSO AS A REFERENCE FOR GENERAL BLOCKSTATE PROPERTIES
     *  DataGenHelper should be mostly referenced, and follow texturing naming as stated in core.datagen.BlocksGen
     */

    public static class EachSideHorizontalBlock extends Block {

        public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

        public EachSideHorizontalBlock(Properties properties) {
            super(properties);
            this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
        }

        @Override
        public BlockState getStateForPlacement(BlockItemUseContext pContext) {
            return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
        }

        @Override
        public BlockState rotate(BlockState pState, Rotation pRotation) {
            return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
        }

        @Override
        public BlockState mirror(BlockState pState, Mirror pMirror) {
            return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
        }

        @Override
        protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
            pBuilder.add(FACING);
        }
    }
}
