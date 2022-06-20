package toma400.cobr.elements.behaviours;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import toma400.cobr.core.CobrBlocks;

import java.util.Map;

public class Carving {

    /** Map for all blocks that can be carved with pickaxe. Key is base block, value is block pickaxe will convert base block to.
    *
    */
    public static Map<Block, Block> CARVABLES = (new ImmutableMap.Builder<Block, Block>())
            .put(Blocks.SANDSTONE, CobrBlocks.SAND_PATH.get()).build();

}
