package toma400.cobr.core;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CobrTab {
    public static final ItemGroup COBR_TAB = new ItemGroup ("cobr_tab") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CobrItems.EOTIC_BAMBOO.get());
        }
    };
    public static final ItemGroup COBR_ENTITY_TAB = new ItemGroup ("cobr_entity_tab") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CobrItems.TERTEN_CARAVAN_MERCENARY_SPAWN_EGG.get());
        }
    };
}