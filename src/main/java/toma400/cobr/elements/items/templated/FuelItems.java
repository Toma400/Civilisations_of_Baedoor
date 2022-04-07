package toma400.cobr.elements.items.templated;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import toma400.cobr.core.CobrItems;

import javax.annotation.Nullable;

public class FuelItems extends Item {
    public FuelItems(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        int FuelTime;
        if (itemStack.getItem() == CobrItems.DUNE_COAL.get()) {
            FuelTime = 2000;
        }
        else {
            FuelTime = 0;
        }
        return FuelTime;
    }
}
