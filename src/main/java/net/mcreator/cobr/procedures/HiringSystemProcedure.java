package net.mcreator.cobr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.cobr.item.DisbandmentScrollItem;
import net.mcreator.cobr.CobrMod;

import java.util.Map;
import java.util.HashMap;

public class HiringSystemProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
			Entity entity = event.getTarget();
			PlayerEntity sourceentity = event.getPlayer();
			if (event.getHand() != sourceentity.getActiveHand()) {
				return;
			}
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CobrMod.LOGGER.warn("Failed to load dependency entity for procedure HiringSystem!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				CobrMod.LOGGER.warn("Failed to load dependency sourceentity for procedure HiringSystem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((EntityTypeTags.getCollection().getTagByID(new ResourceLocation(("forge:cobr_hireables").toLowerCase(java.util.Locale.ENGLISH)))
				.contains(entity.getType()))) {
			if (((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Blocks.EMERALD_BLOCK.asItem())
					&& (EntityTypeTags.getCollection()
							.getTagByID(new ResourceLocation(("forge:cobr_emerald_hiring").toLowerCase(java.util.Locale.ENGLISH)))
							.contains(entity.getType())))) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = ((sourceentity instanceof LivingEntity)
							? ((LivingEntity) sourceentity).getHeldItemMainhand()
							: ItemStack.EMPTY);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				entity.getPersistentData().putString("owner", sourceentity.getUniqueID().toString());
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					HiringCostProcedure.executeProcedure($_dependencies);
				}
			} else if (((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Blocks.DIAMOND_BLOCK.asItem())
					&& (EntityTypeTags.getCollection()
							.getTagByID(new ResourceLocation(("forge:cobr_diamond_hiring").toLowerCase(java.util.Locale.ENGLISH)))
							.contains(entity.getType())))) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = ((sourceentity instanceof LivingEntity)
							? ((LivingEntity) sourceentity).getHeldItemMainhand()
							: ItemStack.EMPTY);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				entity.getPersistentData().putString("owner", sourceentity.getUniqueID().toString());
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					HiringCostProcedure.executeProcedure($_dependencies);
				}
			} else if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == DisbandmentScrollItem.block)) {
				if (((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getOrCreateTag().getBoolean("if_signed")) == (false))) {
					if ((((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getOrCreateTag().getString("if_signed"))).equals((entity.getPersistentData().getString("owner"))))) {
						if (entity instanceof PlayerEntity) {
							ItemStack _stktoremove = ((sourceentity instanceof LivingEntity)
									? ((LivingEntity) sourceentity).getHeldItemMainhand()
									: ItemStack.EMPTY);
							((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) entity).container.func_234641_j_());
						}
						entity.getPersistentData().putString("owner", "");
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							DisbandmentCostProcedure.executeProcedure($_dependencies);
						}
					} else {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent("Disbandment Scroll signature doesn't match with the ownership of entity!"), (false));
						}
					}
				} else {
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Disbandment Scroll is not signed!"), (false));
					}
				}
			}
		}
	}
}
