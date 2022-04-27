package toma400.cobr;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.item.AxeItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.core.CobrItems;
import toma400.cobr.elements.paintings.CobrPaintings;
import static toma400.cobr.Cobr.MOD_ID;

// The value here should match an entry in the META-INF/mods.toml file
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

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            // stripping of the wood
            AxeItem.STRIPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPABLES)
                    .put(CobrBlocks.ESRAH_LOG.get(), CobrBlocks.STRIPPED_ESRAH_LOG.get())
                    .put(CobrBlocks.ESRAH_WOOD.get(), CobrBlocks.STRIPPED_ESRAH_WOOD.get())
                    .put(CobrBlocks.LAIS_LOG.get(), CobrBlocks.STRIPPED_LAIS_LOG.get())
                    .put(CobrBlocks.LAIS_WOOD.get(), CobrBlocks.STRIPPED_LAIS_WOOD.get())
                    .build();
        });
    }
}
