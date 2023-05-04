package toma400.cobr.entities.list.tertens;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;
import toma400.cobr.core.CobrEntities;
import toma400.cobr.entities.properties.Resistances;

import java.util.ArrayList;

public class TertenMercenary extends PathfinderMob {

    public TertenMercenary(EntityType<? extends PathfinderMob> entity, Level world) {
        super(entity, world);
    }

    //----------------------------------------------------------
    //  GENERAL ATTRIBUTES
    //----------------------------------------------------------
    // Basic modifiers
    public static AttributeSupplier setAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30)
                .add(Attributes.ARMOR, 8)
                .add(Attributes.ARMOR_TOUGHNESS, 0)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0)

                .add(Attributes.MOVEMENT_SPEED, 3.0)
                .add(Attributes.FOLLOW_RANGE, 64)

                .add(Attributes.ATTACK_DAMAGE, 4)
                .add(Attributes.ATTACK_KNOCKBACK, 0)
                .add(Attributes.ATTACK_SPEED, 1.2)
                .build();
    }
    // Resistance and immunity
    public boolean hurt(DamageSource source, float amount) {
        if (Resistances.TertenImmune(source)) {
            return false;
        } else {
            return super.hurt(source, amount);
        }
    }

    //----------------------------------------------------------
    //  BEHAVIOURS
    //----------------------------------------------------------
    protected void registerGoals() {
        //this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(this.getClass())); // set "setAlertOthers" to count all tertens nearby, and mage

        this.goalSelector.addGoal(2, new FollowMobGoal(this, 1.0D, 3.0F, 64.0F));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 2F));
    }

    //----------------------------------------------------------
    //  SOUNDS
    //----------------------------------------------------------
    protected SoundEvent getAmbientSound()                       { return SoundEvents.WITHER_SKELETON_AMBIENT; }
    protected SoundEvent getHurtSound(DamageSource damageSource) { return SoundEvents.WITHER_SKELETON_AMBIENT; }
    protected SoundEvent getDeathSound()                         { return SoundEvents.WITHER_SKELETON_AMBIENT; }
    protected float getSoundVolume()                             { return 0.2F; }

    //----------------------------------------------------------
    //  HELPERS
    //----------------------------------------------------------
    // List helpers
    //----------------------------------------------------------
    public static ArrayList<?> mobs_helping() {
        ArrayList<RegistryObject<?>> helping_mobs = new ArrayList<>();
        helping_mobs.add(CobrEntities.Reg.TERTEN_MERCENARY);
        return helping_mobs;
    }
    public static ArrayList<?> mobs_attacked() {
        ArrayList<EntityType> attacked_mobs = new ArrayList<>();
        attacked_mobs.add(EntityType.PLAYER);
        return attacked_mobs;
    }
}
