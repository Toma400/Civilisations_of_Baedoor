package toma400.cobr;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import toma400.cobr.core.CobrBlocks;
import toma400.cobr.core.CobrItems;

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
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.ESRAH_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.ESRAH_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.ESRAH_FENCE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.ESRAH_FENCE_GATE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.LAIS_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.LAIS_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.LAIS_FENCE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.LAIS_FENCE_GATE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.ESRAH_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.LAIS_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.ESRAH_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CobrBlocks.LAIS_SAPLING.get(), RenderType.cutout());
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(CobrBlocks.ESRAH_SAPLING.get().asItem(), 0.2f);
            ComposterBlock.COMPOSTABLES.put(CobrBlocks.LAIS_SAPLING.get().asItem(), 0.2f);
            ComposterBlock.COMPOSTABLES.put(CobrBlocks.ESRAH_LEAVES.get().asItem(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(CobrBlocks.LAIS_LEAVES.get().asItem(), 0.3f);
        });
    }
}
