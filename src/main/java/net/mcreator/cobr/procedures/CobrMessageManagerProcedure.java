package net.mcreator.cobr.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.cobr.potion.CobrMessagingPotionPotionEffect;
import net.mcreator.cobr.CobrMod;

import java.util.Map;

public class CobrMessageManagerProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CobrMod.LOGGER.warn("Failed to load dependency entity for procedure CobrMessageManager!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(CobrMessagingPotionPotionEffect.potion, (int) 60, (int) 1, (false), (false)));
	}
}
