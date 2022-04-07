package toma400.cobr.elements.blocks.templated;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class DataGenHelper {

    /*
    *  CLASS HERE IS USED MOSTLY FOR DATAGEN OF MODELS/BLOCKSTATES, BUT ALSO AS A REFERENCE FOR GENERAL BLOCKSTATE PROPERTIES
    *  DataGenHelper should be mostly referenced, and follow texturing naming as stated in core.datagen.BlocksGen
    */

    public static class EachSideHorizontalBlock extends Block {

        public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

        public EachSideHorizontalBlock(Properties p_49795_) {
            super(p_49795_);
            this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
        }

        @Override
        public BlockState getStateForPlacement(BlockPlaceContext pContext) {
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
        protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
            pBuilder.add(FACING);
        }
    }
}
