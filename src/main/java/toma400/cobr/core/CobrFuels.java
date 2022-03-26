package toma400.cobr.core;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class CobrFuels extends Item {
    public CobrFuels(Properties pProperties) {
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
