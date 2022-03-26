package toma400.cobr.elements.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import toma400.cobr.core.CobrItems;

import java.util.logging.Level;

public class CustomCobrFoods extends Item {
    public static final FoodProperties COOKED_LIZARD_MEAT = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).meat().build();

    public CustomCobrFoods(Properties pProperties) {
        super(pProperties);
    }

    @Override
    //Used for custom speed of eating meals
    public int getUseDuration(ItemStack stack) {
        if(stack.getItem() == CobrItems.COOKED_LIZARD_MEAT.get()) {
            return 24;
        } else {
            return stack.getUseDuration();
        }
    }
}
