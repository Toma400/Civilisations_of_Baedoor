package net.mcreator.cobr.procedures;

import net.minecraft.item.ItemStack;

import net.mcreator.cobr.CobrMod;

import java.util.Map;

public class DisbandmentSignedProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				CobrMod.LOGGER.warn("Failed to load dependency itemstack for procedure DisbandmentSigned!");
			return false;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		return ((itemstack).getOrCreateTag().getBoolean("if_signed"));
	}
}
