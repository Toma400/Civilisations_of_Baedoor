package toma400.cobr.entities.list.tertens;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.FollowMobGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import toma400.cobr.core.CobrEntities;
import toma400.cobr.entities.properties.Resistances;

import java.util.ArrayList;

public class TertenMercenary extends CreatureEntity {

    public TertenMercenary(EntityType<? extends CreatureEntity> entity, World world) {
        super(entity, world);
    }

    //----------------------------------------------------------
    //  GENERAL ATTRIBUTES
    //----------------------------------------------------------
    // Basic modifiers
    public static AttributeModifierMap setAttributes() {
        return CreatureEntity.createMobAttributes()
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
        this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 2F));
    }

    //----------------------------------------------------------
    //  SOUNDS
    //----------------------------------------------------------
    protected SoundEvent getAmbientSound() {
        return SoundEvents.WITHER_SKELETON_AMBIENT;
    }
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.WITHER_SKELETON_AMBIENT;
    }
    protected SoundEvent getDeathSound() {
        return SoundEvents.WITHER_SKELETON_AMBIENT;
    }
    protected float getSoundVolume() {
        return 0.2F;
    }

    //----------------------------------------------------------
    //  HELPERS
    //----------------------------------------------------------
    // List helpers
    //----------------------------------------------------------
    public static ArrayList<?> mobs_helping() {
        ArrayList<RegistryObject<?>> helping_mobs = new ArrayList<>();
        helping_mobs.add(CobrEntities.TERTEN_MERCENARY);
        return helping_mobs;
    }
    public static ArrayList<?> mobs_attacked() {
        ArrayList<EntityType> attacked_mobs = new ArrayList<>();
        attacked_mobs.add(EntityType.PLAYER);
        return attacked_mobs;
    }
}