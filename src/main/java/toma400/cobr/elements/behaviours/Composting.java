package toma400.cobr.elements.behaviours;

import net.minecraft.world.level.block.ComposterBlock;
import toma400.cobr.core.CobrBlocks;

public class Composting {

    public static void compostingRegistry() {
        ComposterBlock.COMPOSTABLES.put(CobrBlocks.ESRAH_SAPLING.get().asItem(), 0.2f);
        ComposterBlock.COMPOSTABLES.put(CobrBlocks.LAIS_SAPLING.get().asItem(), 0.2f);
        ComposterBlock.COMPOSTABLES.put(CobrBlocks.ESRAH_LEAVES.get().asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(CobrBlocks.LAIS_LEAVES.get().asItem(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(CobrBlocks.BLOOMING_LAIS_LEAVES.get().asItem(), 0.3f);
    }

}
