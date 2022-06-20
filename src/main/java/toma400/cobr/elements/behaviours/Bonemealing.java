package toma400.cobr.elements.behaviours;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import toma400.cobr.core.CobrBlocks;

import java.util.Map;

public class Bonemealing {

    public static Map<Block, Block> BONEMEALABLE = (new ImmutableMap.Builder<Block, Block>())
            .put(CobrBlocks.LAIS_LEAVES.get(), CobrBlocks.BLOOMING_LAIS_LEAVES.get()).build();
}
