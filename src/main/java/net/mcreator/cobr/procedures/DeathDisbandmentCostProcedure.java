package net.mcreator.cobr.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.entity.Entity;

import net.mcreator.cobr.CobrModVariables;
import net.mcreator.cobr.CobrMod;

import java.util.Map;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.JsonObject;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class DeathDisbandmentCostProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CobrMod.LOGGER.warn("Failed to load dependency entity for procedure DeathDisbandmentCost!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				CobrMod.LOGGER.warn("Failed to load dependency sourceentity for procedure DeathDisbandmentCost!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		File player_data = new File("");
		double disband_value = 0;
		player_data = new File(((FMLPaths.GAMEDIR.get().toString()) + "" + ("/cobr_data/")),
				File.separator + ((sourceentity.getUniqueID().toString()) + "" + (".json")));
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
					sourceentity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.monthly_cost = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if ((EntityTypeTags.getCollection().getTagByID(new ResourceLocation(("forge:cobr_emerald_hiring").toLowerCase(java.util.Locale.ENGLISH)))
				.contains(entity.getType()))) {
			disband_value = (double) 5;
		} else if ((EntityTypeTags.getCollection()
				.getTagByID(new ResourceLocation(("forge:cobr_diamond_hiring").toLowerCase(java.util.Locale.ENGLISH))).contains(entity.getType()))) {
			disband_value = (double) 15;
		}
		{
			double _setval = (double) (((sourceentity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new CobrModVariables.PlayerVariables())).monthly_cost) - disband_value);
			sourceentity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.monthly_cost = _setval;
				capability.syncPlayerVariables(sourceentity);
			});
		}
		{
			Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
			JsonObject values = new JsonObject();
			JsonObject empire_values = new JsonObject();
			empire_values.addProperty("monthly_cost", ((sourceentity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new CobrModVariables.PlayerVariables())).monthly_cost));
			values.add("empire_values", empire_values);
			try {
				FileWriter fileWriter = new FileWriter(player_data);
				fileWriter.write(mainGSONBuilderVariable.toJson(values));
				fileWriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}
