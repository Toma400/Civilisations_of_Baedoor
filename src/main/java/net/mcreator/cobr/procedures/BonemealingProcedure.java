package net.mcreator.cobr.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;

import java.util.Map;
import java.util.HashMap;

public class BonemealingProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onBonemeal(BonemealEvent event) {
			PlayerEntity entity = event.getPlayer();
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			World world = event.getWorld();
			ItemStack itemstack = event.getStack();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("itemstack", itemstack);
			dependencies.put("entity", entity);
			dependencies.put("blockstate", event.getBlock());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		double grow_chance = 0;
	}
}
