
package net.mcreator.cobr.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.mcreator.cobr.item.DuneCoalItem;

@Mod.EventBusSubscriber
public class DuneCoalFuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == DuneCoalItem.block)
			event.setBurnTime(2000);
	}
}
