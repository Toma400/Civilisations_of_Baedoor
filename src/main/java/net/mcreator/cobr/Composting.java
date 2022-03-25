/**
* Items that can be composted in composter
*/
package net.mcreator.cobr;

import net.mcreator.cobr.CobrModElements;
import net.mcreator.cobr.block.EsrahLeavesBlock;
import net.mcreator.cobr.block.LaisLeavesBlock;
import net.mcreator.cobr.block.BloomingLaisLeavesBlock;
import net.mcreator.cobr.block.EsrahSaplingBlock;
import net.mcreator.cobr.block.LaisSaplingBlock;
import net.minecraft.block.ComposterBlock;

import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.util.IItemProvider;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Composting {

	//public static void addingManager(final float chance, final IItemProvider item) {
	        //ComposterBlock.field_220299_b.put((Object)item.func_199767_j(), chance);
	    //}
	
	//private static class GlobalTrigger {

	//	@SubscribeEvent
	//	private void setup(final FMLCommonSetupEvent event) {
	//		event.enqueueWork(() -> {
	//			ComposterBlock.add(0.3f, EsrahLeavesBlock.block);
	//		});
	//	}


	//compostableItemsCoB();
	
	//}
	
    //public static void compostableItemsCoB() {
    //    addingManager(0.2f, (IItemProvider)EsrahLeavesBlock.block.get().asItem());
    //    addingManager(0.2f, (IItemProvider)LaisLeavesBlock.block.get().asItem());
    //    addingManager(0.2f, (IItemProvider)BloomingLaisLeavesBlock.block.get().asItem());
    //    addingManager(0.2f, (IItemProvider)EsrahSaplingBlock.block.get().asItem());
    //    addingManager(0.2f, (IItemProvider)LaisSaplingBlock.block.get().asItem());
    //}
	
}
