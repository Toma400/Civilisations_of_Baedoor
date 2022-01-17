package net.mcreator.cobr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.cobr.CobrModVariables;
import net.mcreator.cobr.CobrMod;

import java.util.Map;
import java.util.HashMap;

public class MonthlyCostCounterProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CobrMod.LOGGER.warn("Failed to load dependency entity for procedure MonthlyCostCounter!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CobrMod.LOGGER.warn("Failed to load dependency world for procedure MonthlyCostCounter!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		double payout = 0;
		if (((world.getWorldInfo().getDayTime()) == 6000)) {
			if ((((entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new CobrModVariables.PlayerVariables())).month_counter) <= 30)) {
				{
					double _setval = (double) (((entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new CobrModVariables.PlayerVariables())).month_counter) + 1);
					entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.month_counter = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					PlayerDataImportProcedure.executeProcedure($_dependencies);
				}
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("world", world);
					HiringCostPayoutProcedure.executeProcedure($_dependencies);
				}
			} else {
				{
					double _setval = (double) 0;
					entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.month_counter = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
