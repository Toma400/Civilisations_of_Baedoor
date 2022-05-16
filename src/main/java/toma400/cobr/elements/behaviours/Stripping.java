package toma400.cobr.elements.behaviours;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import toma400.cobr.core.CobrBlocks;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.AXIS;

public class Stripping {

    public static BlockState strippageRegistry(BlockState state, ItemStack stack) {
        BlockState final_value = null;
        if(state.is(CobrBlocks.ESRAH_LOG.get())) {
            final_value = CobrBlocks.STRIPPED_ESRAH_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
        }
        if(state.is(CobrBlocks.ESRAH_WOOD.get())) {
            final_value = CobrBlocks.STRIPPED_ESRAH_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
        }
        if(state.is(CobrBlocks.LAIS_LOG.get())) {
            final_value = CobrBlocks.STRIPPED_LAIS_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
        }
        if(state.is(CobrBlocks.LAIS_WOOD.get())) {
            final_value = CobrBlocks.STRIPPED_LAIS_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
        }
        return final_value;
    }

}
