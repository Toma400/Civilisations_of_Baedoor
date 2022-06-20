package toma400.cobr.events;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.core.CobrItems;

import static toma400.cobr.elements.behaviours.Bonemealing.BONEMEALABLE;
import static toma400.cobr.elements.behaviours.Carving.CARVABLES;

@Mod.EventBusSubscriber(modid = Cobr.MOD_ID)
public class CobrEvents {

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
                    String assigning = itemstack.getOrCreateTag().getString("assigned_by");
                    player.sendMessage (new TranslatableComponent("event.cobr.disbandment_owner_info", assigning), player.getUUID());
                }
            }

            }
        }

    @SubscribeEvent
    public static void bonemealing (BonemealEvent event) {
        if(!event.getEntity().level.isClientSide()){
            Block block = event.getBlock().getBlock();
            BlockPos blockpos = event.getPos();
            ItemStack item = event.getStack();
            if(BONEMEALABLE.containsKey(block)) {
                item.shrink(1);
                event.getWorld().setBlock(blockpos, BONEMEALABLE.get(block).defaultBlockState(), 1);
                event.getWorld().addParticle(ParticleTypes.COMPOSTER, 3f, 3f, 3f, 1f, 1f, 1f);
            }

        }
    }

    /** <b>CARVING</b>
     *
     *  <p>Carving is stripping alternative set for pickaxes. It allows player to carve stone-like blocks to their aesthetical variants.
     */
    @SubscribeEvent
    public static void pickaxeCarving(PlayerInteractEvent.RightClickBlock event) {
        if(!event.getEntity().level.isClientSide()){
            Player player = (event.getPlayer());
            BlockPos blockPos = (event.getPos());
            Level world = (event.getWorld());
            BlockState blockstate = world.getBlockState(blockPos);
            Block block = blockstate.getBlock();
            // Checks whether item is pickaxe, and if block is inside CARVABLES map
            if (player.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof PickaxeItem) {
                if (CARVABLES.containsKey(block)) {
                    world.addParticle(ParticleTypes.ASH, 1D, 3D, 1D, 3D, 3D, 3D);
                    world.setBlock(blockPos, CARVABLES.get(block).defaultBlockState(), 11);
                }
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
