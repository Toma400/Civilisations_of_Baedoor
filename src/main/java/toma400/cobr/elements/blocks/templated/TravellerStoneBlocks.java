package toma400.cobr.elements.blocks.templated;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import toma400.cobr.core.CobrBlocks;

public class TravellerStoneBlocks extends Block {

    public TravellerStoneBlocks(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType use(BlockState blockstate, World world, BlockPos blockpos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        super.use(blockstate, world, blockpos, player, hand, hit);
        {
            if(!player.level.isClientSide()){
                if(blockstate == CobrBlocks.EMPTY_TRAVELLER_STONE.get().defaultBlockState()) {
                    if(player.getMainHandItem().getItem() == Items.GOLD_INGOT) {
                        player.getMainHandItem().shrink(1);
                        world.setBlock(blockpos, CobrBlocks.DUNE_TRAVELLER_STONE.get().defaultBlockState(), 1);
                        return ActionResultType.SUCCESS;
                    }
                    else if(player.getMainHandItem().getItem() == Items.EMERALD) {
                        player.getMainHandItem().shrink(1);
                        world.setBlock(blockpos, CobrBlocks.RAINFOREST_ISLANDS_TRAVELLER_STONE.get().defaultBlockState(), 1);
                        return ActionResultType.SUCCESS;
                    }
                    else if(player.getMainHandItem().getItem() == Items.DIAMOND) {
                        player.getMainHandItem().shrink(1);
                        world.setBlock(blockpos, CobrBlocks.PERMAFROST_TRAVELLER_STONE.get().defaultBlockState(), 1);
                        return ActionResultType.SUCCESS;
                    }
                    else if(player.getMainHandItem().getItem() == Items.VINE) {
                        player.getMainHandItem().shrink(1);
                        world.setBlock(blockpos, CobrBlocks.EVERGREEN_DEPTHS_TRAVELLER_STONE.get().defaultBlockState(), 1);
                        return ActionResultType.SUCCESS;
                    }
                    return ActionResultType.FAIL;
                }
                return ActionResultType.FAIL;
            }
            return ActionResultType.FAIL;
        }
    }
}