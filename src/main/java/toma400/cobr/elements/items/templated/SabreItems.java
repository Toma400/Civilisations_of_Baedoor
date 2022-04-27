package toma400.cobr.elements.items.templated;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import toma400.cobr.core.CobrItems;

public class SabreItems extends SwordItem {
    public SabreItems(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    //Sabre registry for Wastelands of Baedoor compat (adds NBTs to the sabre depending on its type)
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(!pStack.getOrCreateTag().getBoolean("is_NBT_set")) {
            pStack.getOrCreateTag().putBoolean("is_NBT_set", true);
            if(pStack.getItem() == CobrItems.BONE_SABRE.get()) {
                pStack.getOrCreateTag().putDouble("sabre_defence", 10);
                pStack.getOrCreateTag().putDouble("sabre_cooldown", 20);
            }
        }
    }
}
