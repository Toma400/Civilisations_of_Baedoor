package net.mcreator.cobr.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.cobr.CobrMod;

import java.util.Map;

public class BlockUpdaterProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CobrMod.LOGGER.warn("Failed to load dependency x for procedure BlockUpdater!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CobrMod.LOGGER.warn("Failed to load dependency y for procedure BlockUpdater!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CobrMod.LOGGER.warn("Failed to load dependency z for procedure BlockUpdater!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CobrMod.LOGGER.warn("Failed to load dependency world for procedure BlockUpdater!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = (double) (-8);
		for (int index0 = 0; index0 < (int) (17); index0++) {
			sy = (double) (-8);
			for (int index1 = 0; index1 < (int) (17); index1++) {
				sz = (double) (-8);
				for (int index2 = 0; index2 < (int) (17); index2++) {
					if (world instanceof World)
						((World) world).notifyNeighborsOfStateChange(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz)),
								((World) world).getBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz))).getBlock());
					System.out.println((("Updated block on position: ") + "" + ((new java.text.DecimalFormat("#########").format((x + sx)))) + ""
							+ (" | ") + "" + ((new java.text.DecimalFormat("#########").format((y + sy)))) + "" + (" | ") + ""
							+ ((new java.text.DecimalFormat("#########").format((z + sz))))));
					sz = (double) (sz + 1);
				}
				sy = (double) (sy + 1);
			}
			sx = (double) (sx + 1);
		}
	}
}
