package net.mcreator.cobr.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.cobr.CobrModVariables;
import net.mcreator.cobr.CobrMod;

import java.util.Map;
import java.util.HashMap;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.JsonObject;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class PlayerDataImportProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			Entity entity = event.getPlayer();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", entity.getPosX());
			dependencies.put("y", entity.getPosY());
			dependencies.put("z", entity.getPosZ());
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CobrMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerDataImport!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CobrMod.LOGGER.warn("Failed to load dependency x for procedure PlayerDataImport!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CobrMod.LOGGER.warn("Failed to load dependency y for procedure PlayerDataImport!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CobrMod.LOGGER.warn("Failed to load dependency z for procedure PlayerDataImport!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CobrMod.LOGGER.warn("Failed to load dependency world for procedure PlayerDataImport!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		File player_data = new File("");
		File cobr_folder = new File("");
		cobr_folder = new File(FMLPaths.GAMEDIR.get().toString(), File.separator + "/cobr_data/");
		cobr_folder.mkdirs();
		player_data = new File(((FMLPaths.GAMEDIR.get().toString()) + "" + ("/cobr_data/")), File.separator
				+ (((((entity.getDisplayName().getString())) + "" + ("_") + "" + ((entity.getUniqueID().toString().substring((int) 1, (int) 8)))))
						+ "" + (".json")));
		if (!player_data.exists()) {
			try {
				player_data.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		if ((((entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new CobrModVariables.PlayerVariables())).is_data_ext_stored) == (false))) {
			System.out.println("Player data file successfully created!");
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				JsonObject values = new JsonObject();
				values.addProperty("full_UUID", entity.getUniqueID().toString());
				JsonObject empire_values = new JsonObject();
				empire_values.addProperty("monthly_cost", 0);
				values.add("empire_values", empire_values);
				try {
					FileWriter fileWriter = new FileWriter(player_data);
					fileWriter.write(mainGSONBuilderVariable.toJson(values));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
			System.out.println("Player data successfully initialised!");
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.is_data_ext_stored = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			System.out.println("Player data file already existing! Import started.");
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
					double _setval = (double) importing.get("empire_values").getAsJsonObject().get("monthly_cost").getAsDouble();
					entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.monthly_cost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				System.out.println((("Monthly cost data successfully imported! Its value is: ") + ""
						+ ((new java.text.DecimalFormat("####").format(((entity.getCapability(CobrModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new CobrModVariables.PlayerVariables())).monthly_cost))))));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Player data successfully imported!");
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("team add uuid_targets".replace("uuid", (entity.getUniqueID().toString().substring((int) 1, (int) 8)))));
		}
		System.out.println("Player target team successfully added!");
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("team list uuid_targets".replace("uuid", (entity.getUniqueID().toString().substring((int) 1, (int) 8)))));
		}
	}
}
