package toma400.cobr.core;

import net.minecraft.world.food.FoodProperties;

public class CobrFoods {
    public static final FoodProperties RAW_LIZARD_MEAT = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).meat().build();
    public static final FoodProperties LIZARD_STEW = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.6F).meat().build();

    //Some foods are stored in toma400.cobr.elements.items.CustomCobrFoods class, if they needed to override some properties
    //Done that because CobrFoods class don't extend Item class due to various classes being used
    //So that doesn't overwrite stackability of stews for example (it needs BowlFoodItem class being used for FD compat)
}
