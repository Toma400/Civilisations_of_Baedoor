package net.mcreator.cobr.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;

import net.mcreator.cobr.item.BoneSabreItem;
import net.mcreator.cobr.CobrMod;

import java.util.Map;

public class SabreRegistryProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				CobrMod.LOGGER.warn("Failed to load dependency itemstack for procedure SabreRegistry!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CobrMod.LOGGER.warn("Failed to load dependency world for procedure SabreRegistry!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		IWorld world = (IWorld) dependencies.get("world");
		if ((net.minecraftforge.fml.ModList.get().isLoaded("wobr"))) {
			if ((((itemstack).getOrCreateTag().getDouble("registryCheck")) <= 4)) {
				if (((itemstack).getItem() == BoneSabreItem.block)) {
					(itemstack).getOrCreateTag().putDouble("sabre_defence", 10);
					(itemstack).getOrCreateTag().putDouble("sabre_cooldown", 20);
					(itemstack).getOrCreateTag().putBoolean("Invulnerable", (true));
				}
				(itemstack).getOrCreateTag().putDouble("registryCheck", 5);
			}
		}
	}
}
