package toma400.cobr.core.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.core.CobrItems;

import java.util.Objects;

public class ItemsGen extends ItemModelProvider {

    public ItemsGen(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, Cobr.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        /* PARENTED */

        //UTIL BLOCKS

        //withExistingParent(
        //        Helpers.ItemRegistryIterator().getRegistryName().getPath(),
        //        modLoc("item/" + Helpers.ItemRegistryIterator().getRegistryName()));

        //withExistingParent(CobrBlocks.PACK_OF_EOTIC_BAMBOO.get().asItem().getRegistryName().getPath(), modLoc("block/pack_of_eotic_bamboo"));
        //withExistingParent(CobrBlocks.HARDENED_SAND.get().asItem().getRegistryName().getPath(), modLoc("block/hardened_sand"));
        //withExistingParent(CobrBlocks.DUNE_COAL_BLOCK.get().asItem().getRegistryName().getPath(), modLoc("block/dune_coal_block"));

        /* CUSTOM */
    }
}
