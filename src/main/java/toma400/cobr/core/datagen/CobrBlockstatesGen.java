package toma400.cobr.core.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;

public class CobrBlockstatesGen extends BlockStateProvider {

    public CobrBlockstatesGen(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, Cobr.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        /* SIMPLE BLOCKS
        Used for all blocks with single face/one texture */

        //UTIL BLOCKS
        simpleBlock(CobrBlocks.HARDENED_SAND.get());
        simpleBlock(CobrBlocks.DUNE_COAL_BLOCK.get());

        //____________________________________________________________________//
        /* HORIZONTAL BLOCKS
        Used for all log-like blocks with side and top/bottom parts specified */

        //UTIL BLOCKS
        horizontalBlock(CobrBlocks.PACK_OF_EOTIC_BAMBOO.get(), modLoc("cobr:block/pack_of_eotic_bamboo"), modLoc("cobr:block/pack_of_eotic_bamboo_horizontal"), modLoc("cobr:block/pack_of_eotic_bamboo_horizontal"));
    }
}
