package toma400.cobr.core;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CobrTab {
    public static final CreativeModeTab COBR_TAB = new CreativeModeTab("cobr_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CobrItems.EOTIC_BAMBOO.get());
        }
    };
    public static final CreativeModeTab COBR_ENTITY_TAB = new CreativeModeTab("cobr_entity_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CobrItems.TERTEN_CARAVAN_MERCENARY_SPAWN_EGG.get());
        }
    };
}
