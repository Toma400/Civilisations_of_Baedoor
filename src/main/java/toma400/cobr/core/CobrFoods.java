package toma400.cobr.core;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CobrFoods {
    public static final FoodProperties RAW_LIZARD_MEAT = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).meat().build();
    public static final FoodProperties LIZARD_STEW = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.6F).meat().build();
    public static final FoodProperties COOKED_LIZARD_MEAT = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).meat().build();

    //Class used for regular food with custom properties
    public static class FoodItem extends Item {
        public FoodItem(Item.Properties pProperties) {
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
    //Class used for SoupItem/BowlFoodItem
    public static class SoupItem extends BowlFoodItem {
        public SoupItem(Item.Properties pProperties) {
            super(pProperties);
        }
    }
}
