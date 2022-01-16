package net.mcreator.cobr.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.cobr.CobrMod;

import java.util.Map;

public class TempOasisEsrahProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CobrMod.LOGGER.warn("Failed to load dependency x for procedure TempOasisEsrah!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CobrMod.LOGGER.warn("Failed to load dependency y for procedure TempOasisEsrah!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CobrMod.LOGGER.warn("Failed to load dependency z for procedure TempOasisEsrah!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CobrMod.LOGGER.warn("Failed to load dependency world for procedure TempOasisEsrah!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					(("fill") + ""
							+ (((" ") + "" + ((new java.text.DecimalFormat("###").format((x - 30)))) + "" + (" ") + ""
									+ ((new java.text.DecimalFormat("###").format((y - 3)))) + "" + (" ") + ""
									+ ((new java.text.DecimalFormat("###").format((z - 30))))))
							+ ""
							+ (((" ") + "" + ((new java.text.DecimalFormat("###").format((x + 30)))) + "" + (" ") + ""
									+ ((new java.text.DecimalFormat("###").format((y + 15)))) + "" + (" ") + ""
									+ ((new java.text.DecimalFormat("###").format((z + 30))))))
							+ "" + (((" ") + "" + ("cobr:esrah_log") + "" + (" ") + "" + ("replace") + "" + (" ") + "" + ("minecraft:jungle_log")))));
		}
	}
}
