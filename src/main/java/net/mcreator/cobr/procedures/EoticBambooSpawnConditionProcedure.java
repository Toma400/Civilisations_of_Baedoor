package net.mcreator.cobr.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.cobr.CobrMod;

import java.util.Map;

public class EoticBambooSpawnConditionProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CobrMod.LOGGER.warn("Failed to load dependency x for procedure EoticBambooSpawnCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CobrMod.LOGGER.warn("Failed to load dependency y for procedure EoticBambooSpawnCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CobrMod.LOGGER.warn("Failed to load dependency z for procedure EoticBambooSpawnCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CobrMod.LOGGER.warn("Failed to load dependency world for procedure EoticBambooSpawnCondition!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		return ((((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getMaterial() == net.minecraft.block.material.Material.SAND)
				|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getMaterial() == net.minecraft.block.material.Material.SAND))
				|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getMaterial() == net.minecraft.block.material.Material.SAND)
						|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))))
								.getMaterial() == net.minecraft.block.material.Material.SAND)));
	}
}
