package toma400.cobr.core.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;

public class CobrBlockModelsGen extends BlockModelProvider {

    public CobrBlockModelsGen(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, Cobr.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        /* TYPE: cubeAll */

        //UTIL BLOCKS
        cubeAll(CobrBlocks.HARDENED_SAND.get().getRegistryName().getPath(), modLoc("block/hardened_sand"));
        cubeAll(CobrBlocks.DUNE_COAL_BLOCK.get().getRegistryName().getPath(), modLoc("block/dune_coal_block"));

        /* TYPE: log-like */

        //UTIL BLOCKS
        cubeColumn(CobrBlocks.PACK_OF_EOTIC_BAMBOO.get().getRegistryName().getPath(), modLoc("block/pack_of_eotic_bamboo_side"), modLoc("block/pack_of_eotic_bamboo_top"));
        cubeColumnHorizontal(CobrBlocks.PACK_OF_EOTIC_BAMBOO.get().getRegistryName().getPath(), modLoc("block/pack_of_eotic_bamboo_side"), modLoc("block/pack_of_eotic_bamboo_top"));
    }
}
