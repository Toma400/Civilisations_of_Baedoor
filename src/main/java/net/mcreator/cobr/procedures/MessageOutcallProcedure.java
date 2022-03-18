package net.mcreator.cobr.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.cobr.potion.CobrMessagingPotionPotionEffect;
import net.mcreator.cobr.CobrMod;

import java.util.Map;
import java.util.Collection;

public class MessageOutcallProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CobrMod.LOGGER.warn("Failed to load dependency entity for procedure MessageOutcall!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == CobrMessagingPotionPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity));
	}
}
