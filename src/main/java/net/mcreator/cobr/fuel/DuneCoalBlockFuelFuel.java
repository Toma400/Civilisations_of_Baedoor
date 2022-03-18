
package net.mcreator.cobr.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.mcreator.cobr.block.DuneCoalBlockBlock;

@Mod.EventBusSubscriber
public class DuneCoalBlockFuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == DuneCoalBlockBlock.block.asItem())
			event.setBurnTime(18000);
	}
}
