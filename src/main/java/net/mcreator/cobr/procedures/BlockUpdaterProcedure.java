package net.mcreator.cobr.procedures;

import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.cobr.CobrMod;

import java.util.Map;

public class BlockUpdaterProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CobrMod.LOGGER.warn("Failed to load dependency entity for procedure BlockUpdater!");
			return;
		}
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
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = (double) (-8);
		for (int index0 = 0; index0 < (int) (17); index0++) {
			sy = (double) (-8);
			for (int index1 = 0; index1 < (int) (17); index1++) {
				sz = (double) (-8);
				for (int index2 = 0; index2 < (int) (17); index2++) {
					if (entity instanceof PlayerEntity) {
						Entity _ent = entity;
						BlockPos _bp = new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz));
						_ent.world.getBlockState(_bp).getBlock().onBlockActivated(_ent.world.getBlockState(_bp), _ent.world, _bp,
								(PlayerEntity) entity, Hand.MAIN_HAND,
								BlockRayTraceResult.createMiss(new Vector3d(_bp.getX(), _bp.getY(), _bp.getZ()), Direction.UP, _bp));
					}
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
