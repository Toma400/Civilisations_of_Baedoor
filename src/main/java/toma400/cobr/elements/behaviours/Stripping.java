package toma400.cobr.elements.behaviours;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.item.AxeItem;
import toma400.cobr.core.CobrBlocks;

public class Stripping {
    public static void StrippingRegistry() {
            AxeItem.STRIPABLES = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.STRIPABLES)
                    .put(CobrBlocks.ESRAH_LOG.get(), CobrBlocks.STRIPPED_ESRAH_LOG.get())
                    .put(CobrBlocks.ESRAH_WOOD.get(), CobrBlocks.STRIPPED_ESRAH_WOOD.get())
                    .put(CobrBlocks.LAIS_LOG.get(), CobrBlocks.STRIPPED_LAIS_LOG.get())
                    .put(CobrBlocks.LAIS_WOOD.get(), CobrBlocks.STRIPPED_LAIS_WOOD.get())
                    .build();
    }
}