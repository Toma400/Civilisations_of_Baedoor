package toma400.cobr.entities.properties;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.util.DamageSource;

import java.util.ArrayList;

public class Resistances {

    public static boolean TertenImmune (DamageSource source) {
        ArrayList<DamageSource> TertensImmunities = new ArrayList<>();
        TertensImmunities.add(DamageSource.ON_FIRE);
        TertensImmunities.add(DamageSource.WITHER);
        TertensImmunities.add(DamageSource.DRAGON_BREATH);
        TertensImmunities.add(DamageSource.CACTUS);
        return TertensImmunities.contains(source) || source.getDirectEntity() instanceof PotionEntity || source.getDirectEntity() instanceof AreaEffectCloudEntity;
    }
}
