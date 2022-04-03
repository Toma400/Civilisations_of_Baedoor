package toma400.cobr;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import toma400.cobr.render.registrars.RenderTypeRegistry;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.core.CobrItems;
import toma400.cobr.elements.behaviours.Composting;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Cobr.MOD_ID)
public class Cobr
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "cobr";

    public Cobr() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CobrItems.register(eventBus);
        CobrBlocks.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::setupClient);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setupClient(final FMLCommonSetupEvent event) {
        RenderTypeRegistry.GlobalRenderingRegistrar();
    }

    public void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(Composting::CompostingRegistry);
    }
}
