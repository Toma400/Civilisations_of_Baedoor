package toma400.cobr.core;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SoupItem;

public class CobrFoods {
    public static final Food RAW_LIZARD_MEAT = (new Food.Builder().nutrition(1).saturationMod(0.1F).meat().build());
    public static final Food LIZARD_STEW = (new Food.Builder()).nutrition(10).saturationMod(0.6F).meat().build();
    public static final Food COOKED_LIZARD_MEAT = (new Food.Builder()).nutrition(3).saturationMod(0.1F).meat().build();

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
    public static class SoupItems extends SoupItem {
        public SoupItems(Item.Properties pProperties) {
            super(pProperties);
        }
    }
}
