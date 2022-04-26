package toma400.cobr.elements.items.templated;

import net.minecraft.entity.Entity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;
import toma400.cobr.core.CobrItems;

public class SabreItems extends SwordItem {
    public SabreItems(IItemTier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
        super.inventoryTick(stack, world, entity, p_77663_4_, p_77663_5_);

        // Setting up Wastelands of Baedoor integration
        if (!stack.getOrCreateTag().getBoolean("is_NBT_set")) {
            stack.getOrCreateTag().putBoolean("is_NBT_set", true);

            if (stack.getItem() == CobrItems.BONE_SABRE.get()) {
                stack.getOrCreateTag().putDouble("sabre_defence", 10);
                stack.getOrCreateTag().putDouble("sabre_cooldown", 20);
            }
        }
    }
}