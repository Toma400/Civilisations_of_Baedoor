package toma400.cobr;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import toma400.cobr.core.CobrEntities;
import toma400.cobr.core.CobrPaintings;
import toma400.cobr.core.config.WorldConfig;
import toma400.cobr.render.registrars.RenderTypeRegistry;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.core.CobrItems;
import toma400.cobr.elements.behaviours.Composting;

import static toma400.cobr.Cobr.MOD_ID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MOD_ID)
public class Cobr
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "cobr";

    public Cobr() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, WorldConfig.WORLD_CONFIG);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CobrItems.register(eventBus);
        CobrBlocks.register(eventBus);
        CobrPaintings.register(eventBus);
        CobrEntities.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::setupClient);

        WorldConfig.loadConfigFile(WorldConfig.WORLD_CONFIG, WorldConfig.WORLD_CONFIG_PATH);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setupClient(final FMLCommonSetupEvent event) {
        RenderTypeRegistry.GlobalRenderingRegistrar(
                CobrBlocks.BLOCKS.getEntries(),
                CobrEntities.ENTITIES.getEntries());
    }

    public void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(Composting::compostingRegistry);
    }
}
