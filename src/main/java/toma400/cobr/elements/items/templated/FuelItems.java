package toma400.cobr.elements.items.templated;

import net.minecraft.item.Item;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import toma400.cobr.core.CobrItems;

public class FuelItems extends Item {
    public FuelItems(Properties pProperties) {
        super(pProperties);
    }

    @SubscribeEvent
    public static void setBurnTime(FurnaceFuelBurnTimeEvent event) {
        if(event.getItemStack().getItem() == CobrItems.DUNE_COAL.get()) {
            event.setBurnTime(2000);
        }
    }
}
