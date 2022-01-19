package net.mcreator.cobr.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.cobr.CobrModVariables;
import net.mcreator.cobr.CobrMod;

import java.util.Map;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.JsonObject;
import com.google.gson.Gson;

public class EmpireInfoGetProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CobrMod.LOGGER.warn("Failed to load dependency entity for procedure EmpireInfoGet!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		File player_data = new File("");
		player_data = new File("location", File.separator + "name.extension");
		if (!player_data.exists()) {
			try {
				player_data.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(player_data));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				JsonObject importing = new Gson().fromJson(jsonstringbuilder.toString(), JsonObject.class);
				{
					double _setval = (double) importing.get("values").getAsJsonObject().get("empire_values").getAsJsonObject().get("monthly_cost")
							.getAsDouble();
					entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.monthly_cost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Empire Status:"), (false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("___________________"), (false));
		}
		if (((((entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CobrModVariables.PlayerVariables())).empire_name))
				.equals(""))) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Empire not set yet."), (false));
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent((("Name: ") + "" + (((entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new CobrModVariables.PlayerVariables())).empire_name)))),
						(false));
			}
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("___________________"), (false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("Monthly cost: ") + ""
					+ ((new java.text.DecimalFormat("######").format(((entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new CobrModVariables.PlayerVariables())).monthly_cost)))))),
					(false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("___________________"), (false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("Financial reserve supplies: ") + ""
					+ ((new java.text.DecimalFormat("######").format(((entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new CobrModVariables.PlayerVariables())).civilisation_table_storage)))))),
					(false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("___________________"), (false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("Day of the month: ") + ""
					+ ((new java.text.DecimalFormat("######").format(((entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new CobrModVariables.PlayerVariables())).month_counter))))
					+ "" + ("/ 30"))), (false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("___________________"), (false));
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("Days left to payout: ") + ""
					+ ((new java.text.DecimalFormat("######").format((30 - ((entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new CobrModVariables.PlayerVariables())).month_counter))))))),
					(false));
		}
	}
}
