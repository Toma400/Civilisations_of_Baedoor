package toma400.cobr;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.core.CobrItems;
import toma400.cobr.elements.behaviours.Composting;
import toma400.cobr.elements.behaviours.Stripping;
import toma400.cobr.core.CobrPaintings;
import toma400.cobr.render.registrars.RenderTypeRegistry;

import static toma400.cobr.Cobr.MOD_ID;

@Mod(MOD_ID)
public class Cobr
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "cobr";

    public Cobr() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CobrItems.register(eventBus);
        CobrBlocks.register(eventBus);
        CobrPaintings.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::setupClient);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setupClient(final FMLCommonSetupEvent event) {
        RenderTypeRegistry.globalBlockRenderingRegistrar(CobrBlocks.BLOCKS.getEntries());
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(Stripping::strippingRegistry);
        event.enqueueWork(Composting::CompostingRegistry);
    }
}
