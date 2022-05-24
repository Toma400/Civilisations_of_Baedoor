package toma400.cobr.entities.properties;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.projectile.ThrownPotion;

import java.util.ArrayList;

public class Resistances {

    public static boolean TertenImmune (DamageSource source) {
        ArrayList<DamageSource> TertensImmunities = new ArrayList<>();
        TertensImmunities.add(DamageSource.ON_FIRE);
        TertensImmunities.add(DamageSource.WITHER);
        TertensImmunities.add(DamageSource.DRAGON_BREATH);
        TertensImmunities.add(DamageSource.CACTUS);
        return TertensImmunities.contains(source) || source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud;
    }
}
