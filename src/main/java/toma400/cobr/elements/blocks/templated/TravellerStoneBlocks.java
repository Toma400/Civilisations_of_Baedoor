package toma400.cobr.elements.blocks.templated;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import toma400.cobr.core.CobrBlocks;

public class TravellerStoneBlocks extends Block {

    public TravellerStoneBlocks(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState blockstate, Level world, BlockPos blockpos, Player player, InteractionHand hand, BlockHitResult hit) {
        super.use(blockstate, world, blockpos, player, hand, hit);
        {
            if(!player.level.isClientSide()){
                if(blockstate == CobrBlocks.EMPTY_TRAVELLER_STONE.get().defaultBlockState()) {
                    if(player.getMainHandItem().getItem() == Items.GOLD_INGOT) {
                        player.getMainHandItem().shrink(1);
                        world.setBlock(blockpos, CobrBlocks.DUNE_TRAVELLER_STONE.get().defaultBlockState(), 1);
                        return InteractionResult.SUCCESS;
                    }
                    if(player.getMainHandItem().getItem() == Items.EMERALD) {
                        player.getMainHandItem().shrink(1);
                        world.setBlock(blockpos, CobrBlocks.RAINFOREST_ISLANDS_TRAVELLER_STONE.get().defaultBlockState(), 1);
                        return InteractionResult.SUCCESS;
                    }
                    if(player.getMainHandItem().getItem() == Items.DIAMOND) {
                        player.getMainHandItem().shrink(1);
                        world.setBlock(blockpos, CobrBlocks.PERMAFROST_TRAVELLER_STONE.get().defaultBlockState(), 1);
                        return InteractionResult.SUCCESS;
                    }
                    if(player.getMainHandItem().getItem() == Items.VINE) {
                        player.getMainHandItem().shrink(1);
                        world.setBlock(blockpos, CobrBlocks.EVERGREEN_DEPTHS_TRAVELLER_STONE.get().defaultBlockState(), 1);
                        return InteractionResult.SUCCESS;
                    }
                    else {
                        return InteractionResult.FAIL;
                    }
                }
            }
            return InteractionResult.SUCCESS;
        }
    }
}