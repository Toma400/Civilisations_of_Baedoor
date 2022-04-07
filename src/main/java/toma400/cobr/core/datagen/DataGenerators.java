package toma400.cobr.core.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import toma400.cobr.Cobr;

@Mod.EventBusSubscriber(modid = Cobr.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    //-----------------------------------------------------------------------------------
    // For some reason, BlockStates need to go first, even though they are basing
    // themselves on models generated in BlocksGen. Though after switching that to be
    // "correct", it tends to somehow overwrite models with simple parenting.
    // So, you should keep them unlogically, with BlockStates first.
    //-----------------------------------------------------------------------------------

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if(event.includeServer()) {
            generator.addProvider(new LootTablesGen.LootTablesRedirector(generator));
        }
        if(event.includeClient()) {
            generator.addProvider(new BlockStatesGen(generator, event.getExistingFileHelper()));
            generator.addProvider(new BlocksGen(generator, event.getExistingFileHelper()));
            //generator.addProvider(new ItemsGen(generator, event.getExistingFileHelper()));
        }

        //language + textures + recipes + tags alone
    }

}
