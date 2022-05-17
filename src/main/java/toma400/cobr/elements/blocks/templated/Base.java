package toma400.cobr.elements.blocks.templated;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.trees.Tree;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;
import toma400.cobr.core.CobrBlocks;

import java.util.Random;
import java.util.function.Supplier;

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

    public static class SaplingBlock extends BushBlock implements IGrowable {

        public static final IntegerProperty STAGE = BlockStateProperties.STAGE;

        private Supplier<Tree> tree;

        public SaplingBlock(Supplier<Tree> treeIn, Properties properties) {
            super(properties);
            this.tree = treeIn;
        }

        @Override
        public boolean isValidBonemealTarget(IBlockReader pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
            return true;
        }

        @Override
        public boolean isBonemealSuccess(World world, Random pRand, BlockPos pPos, BlockState pState) {
            return (double)world.random.nextFloat() < 0.33D;
        }

        @Override
        public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
            super.tick(state, world, pos, random);
            if(!world.isAreaLoaded(pos, 1)) {
                return;
            }
            if(world.getLightEmission(pos.above()) >= 9 && random.nextInt(7) == 0) {
                this.performBonemeal(world, random, pos, state);
            }
        }

        @Override
        public void performBonemeal(ServerWorld world, Random random, BlockPos pos, BlockState state) {
            if (state.getValue(STAGE) == 0) {
                world.setBlock(pos, state.cycle(STAGE), 4);
            } else {
                if(!(ForgeEventFactory.saplingGrowTree(world, random, pos))) {
                    return;
                } else {
                    this.tree.get().growTree(world, world.getChunkSource().getGenerator(), pos, state, random);
                }
            }
        }

        @Override
        protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
            builder.add(STAGE);
        }
    }
}
