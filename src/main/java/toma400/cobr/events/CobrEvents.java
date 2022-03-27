package toma400.cobr.events;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.core.CobrItems;

@Mod.EventBusSubscriber(modid = Cobr.MOD_ID)
public class CobrEvents {

    @SubscribeEvent
    public static void travellerStoneSwitcher(PlayerInteractEvent.RightClickBlock event) {
        if(!event.getEntity().level.isClientSide()){
            Player player = ((Player) event.getPlayer());
            BlockPos blockpos = ((BlockPos) event.getPos());
            BlockState blockstate = event.getWorld().getBlockState(blockpos);
            if(blockstate == CobrBlocks.EMPTY_TRAVELLER_STONE.get().defaultBlockState()) {
                if(player.getMainHandItem().getItem() == Items.GOLD_INGOT) {
                    player.getMainHandItem().shrink(1);
                    event.getWorld().setBlock(blockpos, CobrBlocks.DUNE_TRAVELLER_STONE.get().defaultBlockState(), 1);
                }
                if(player.getMainHandItem().getItem() == Items.EMERALD) {
                    player.getMainHandItem().shrink(1);
                    event.getWorld().setBlock(blockpos, CobrBlocks.RAINFOREST_ISLANDS_TRAVELLER_STONE.get().defaultBlockState(), 1);
                }
                if(player.getMainHandItem().getItem() == Items.DIAMOND) {
                    player.getMainHandItem().shrink(1);
                    event.getWorld().setBlock(blockpos, CobrBlocks.PERMAFROST_TRAVELLER_STONE.get().defaultBlockState(), 1);
                }
                if(player.getMainHandItem().getItem() == Items.VINE) {
                    player.getMainHandItem().shrink(1);
                    event.getWorld().setBlock(blockpos, CobrBlocks.EVERGREEN_DEPTHS_TRAVELLER_STONE.get().defaultBlockState(), 1);
                }
            }
        }
    }

    @SubscribeEvent
    public static void disbandmentScrollSigning(PlayerInteractEvent.RightClickItem event) {
        if(!event.getEntity().level.isClientSide()){
            Player player = ((Player) event.getPlayer());
            ItemStack itemstack = ((ItemStack) event.getItemStack());
            if(itemstack.getItem() == CobrItems.DISBANDMENT_SCROLL.get()) {
                if(itemstack.getOrCreateTag().getBoolean("if_signed") == false) {
                    itemstack.getOrCreateTag().putBoolean("if_signed", true);
                    itemstack.getOrCreateTag().putString("assigned_by", player.getStringUUID());
                } else {
                    player.sendMessage (new TranslatableComponent("event.cobr.disbandment_owner_info" + itemstack.getOrCreateTag().getString("assigned_by")), player.getUUID());
                }
            }

            }
        }

    @SubscribeEvent
    public static void bonemealing (BonemealEvent event) {
        if(!event.getEntity().level.isClientSide()){
            BlockState blockstate = event.getBlock();
            BlockPos blockpos = event.getPos();
            ItemStack item = event.getStack();
            if(blockstate == CobrBlocks.LAIS_LEAVES.get().defaultBlockState()) {
                item.shrink(1);
                event.getWorld().setBlock(blockpos, CobrBlocks.BLOOMING_LAIS_LEAVES.get().defaultBlockState(), 1);
            }

        }
    }

    //public static void disbandment(PlayerInteractEvent.EntityInteract event) {
    //    if(!event.getEntity().level.isClientSide()){
    //        Player player = ((Player) event.getPlayer());
    //        Entity target = ((Entity) event.getTarget());
    //        if(player.getMainHandItem().getItem() == CobrItems.DISBANDMENT_SCROLL.get()) {
    //            if(target.getTags().contains("if_signed")) {
    //                target.getPersistentData().putBoolean("sth sth", true);
    //            }
    //        }
    //    }
    //}


}
