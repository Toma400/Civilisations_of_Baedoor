package net.mcreator.cobr.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Block;

import net.mcreator.cobr.block.EoticBambooGrowingBlock;
import net.mcreator.cobr.CobrMod;

import java.util.Map;

public class EoticBambooVerticalBreakingProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CobrMod.LOGGER.warn("Failed to load dependency x for procedure EoticBambooVerticalBreaking!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CobrMod.LOGGER.warn("Failed to load dependency y for procedure EoticBambooVerticalBreaking!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CobrMod.LOGGER.warn("Failed to load dependency z for procedure EoticBambooVerticalBreaking!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CobrMod.LOGGER.warn("Failed to load dependency world for procedure EoticBambooVerticalBreaking!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double checked_y_value = 0;
		checked_y_value = (double) 1;
		for (int index0 = 0; index0 < (int) (12); index0++) {
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + checked_y_value), (int) z))).getBlock() == EoticBambooGrowingBlock.block)) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) (y + checked_y_value), (int) z)), (World) world,
							new BlockPos((int) x, (int) (y + checked_y_value), (int) z));
					world.destroyBlock(new BlockPos((int) x, (int) (y + checked_y_value), (int) z), false);
				}
				checked_y_value = (double) (checked_y_value + 1);
			} else {
				break;
			}
		}
	}
}
