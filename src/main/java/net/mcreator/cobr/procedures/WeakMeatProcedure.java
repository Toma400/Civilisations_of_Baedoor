package net.mcreator.cobr.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.cobr.CobrMod;

import java.util.Map;

public class WeakMeatProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CobrMod.LOGGER.warn("Failed to load dependency entity for procedure WeakMeat!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((20 >= (Math.random() * 100))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HUNGER, (int) 60, (int) 1));
		}
	}
}
