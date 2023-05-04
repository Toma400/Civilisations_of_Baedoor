package toma400.cobr;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import toma400.cobr.core.CobrEntities;
import toma400.cobr.core.CobrPaintings;
import toma400.cobr.core.config.WorldConfig;
import toma400.cobr.render.registrars.RenderTypeRegistry;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.core.CobrItems;
import toma400.cobr.elements.behaviours.Composting;

import java.util.Map;

import static toma400.cobr.Cobr.MOD_ID;

@Mod(MOD_ID)
public class Cobr
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "cobr";

    public Cobr() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, WorldConfig.WORLD_CONFIG);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CobrItems.register(eventBus);
        CobrBlocks.register(eventBus);
        CobrPaintings.register(eventBus);
        CobrEntities.Reg.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::setupClient);
        eventBus.addListener(this::entityAttributes);
        eventBus.addListener(this::entityLayers);

        WorldConfig.loadConfigFile(WorldConfig.WORLD_CONFIG, WorldConfig.WORLD_CONFIG_PATH);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setupClient(final FMLCommonSetupEvent event) {
        RenderTypeRegistry.GlobalRenderingRegistrar(CobrBlocks.BLOCKS.getEntries());
        CobrEntities.Helper.globalEntityRenderingRegistrar(CobrEntities.Reg.ENTITIES.getEntries());
    }

    public void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(Composting::compostingRegistry);
    }

    public void entityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        CobrEntities.Helper.layersRegistry(event);
    }

    public void entityAttributes (EntityAttributeCreationEvent event) {
        for (Map.Entry<EntityType<? extends LivingEntity>, AttributeSupplier> entity : CobrEntities.Helper.entityRegistry.entrySet()) {
            event.put(entity.getKey(), entity.getValue());
        }
    }
}
