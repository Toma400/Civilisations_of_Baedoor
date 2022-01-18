package net.mcreator.cobr.procedures;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.cobr.CobrModVariables;
import net.mcreator.cobr.CobrMod;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

public class HiringCostPayoutProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CobrMod.LOGGER.warn("Failed to load dependency entity for procedure HiringCostPayout!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CobrMod.LOGGER.warn("Failed to load dependency world for procedure HiringCostPayout!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		double payout = 0;
		payout = (double) 0;
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if ((Items.EMERALD == (itemstackiterator).getItem())) {
						payout = (double) (payout + (((itemstackiterator)).getCount()));
					}
				}
			}
		}
		if ((payout >= ((entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new CobrModVariables.PlayerVariables())).monthly_cost))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(Items.EMERALD);
				((PlayerEntity) entity).inventory
						.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(),
								(int) ((entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new CobrModVariables.PlayerVariables())).monthly_cost),
								((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Successfully paid monthly cost for the hired troops!"), (false));
			}
		} else if (((payout + ((entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new CobrModVariables.PlayerVariables())).civilisation_table_storage)) >= ((entity
						.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new CobrModVariables.PlayerVariables())).monthly_cost))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(Items.EMERALD);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) payout,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			{
				double _setval = (double) (((entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new CobrModVariables.PlayerVariables())).civilisation_table_storage) + payout);
				entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.civilisation_table_storage = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) (((entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new CobrModVariables.PlayerVariables())).civilisation_table_storage)
						- ((entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new CobrModVariables.PlayerVariables())).monthly_cost));
				entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.civilisation_table_storage = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent("You do not have enough resources to pay the monthly cost of hired troops!"), (false));
			}
		}
	}
}
