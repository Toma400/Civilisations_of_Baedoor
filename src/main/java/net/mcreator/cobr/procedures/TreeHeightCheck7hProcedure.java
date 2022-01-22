package net.mcreator.cobr.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.cobr.CobrMod;

import java.util.Map;

public class TreeHeightCheck7hProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CobrMod.LOGGER.warn("Failed to load dependency x for procedure TreeHeightCheck7h!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CobrMod.LOGGER.warn("Failed to load dependency y for procedure TreeHeightCheck7h!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CobrMod.LOGGER.warn("Failed to load dependency z for procedure TreeHeightCheck7h!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CobrMod.LOGGER.warn("Failed to load dependency world for procedure TreeHeightCheck7h!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		return ((((world.getBlockState(new BlockPos((int) x, (int) (y + 7), (int) z))).getBlock() == Blocks.AIR)
				&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 6), (int) z))).getBlock() == Blocks.AIR)
						&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 5), (int) z))).getBlock() == Blocks.AIR)))
				&& ((((world.getBlockState(new BlockPos((int) x, (int) (y + 4), (int) z))).getBlock() == Blocks.AIR)
						&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 3), (int) z))).getBlock() == Blocks.AIR))
						&& (((world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z))).getBlock() == Blocks.AIR)
								&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR))));
	}
}
