package toma400.cobr.core.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import toma400.cobr.Cobr;

@Mod.EventBusSubscriber(modid = Cobr.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if(event.includeServer()) {
            //generator.addProvider(new CobrLootTablesGen(generator));
        }
        if(event.includeClient()) {
            //generator.addProvider(new CobrBlockstatesGen(generator, event.getExistingFileHelper()));
            //generator.addProvider(new CobrBlockModelsGen(generator, event.getExistingFileHelper()));
            generator.addProvider(new ItemsGen(generator, event.getExistingFileHelper()));
        }

        //language + textures + recipes + tags alone
    }

}
