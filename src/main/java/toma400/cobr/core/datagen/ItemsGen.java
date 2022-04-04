package toma400.cobr.core.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.core.CobrItems;

import java.util.Collection;
import java.util.Objects;

public class ItemsGen extends ItemModelProvider {

    public ItemsGen(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, Cobr.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        ItemRegistrar(CobrItems.ITEMS.getEntries());
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

    public void ItemRegistrar(Collection<RegistryObject<Item>> items) {
        for (RegistryObject<Item> item : items) {
            String name = item.getId().getPath();
            Item getItem = item.get();

            ResourceLocation datagenLoc = new ResourceLocation(Cobr.MOD_ID, "item/" + name);

            ModelFile modelType = getItem instanceof Item || getItem instanceof SwordItem ?
                    Helpers.ItemModelTypes.HANDHELD_FILE : Helpers.ItemModelTypes.GENERATED_FILE;

            if (!existingFileHelper.exists(datagenLoc, TEXTURE) || existingFileHelper.exists(datagenLoc, MODEL))
                continue;

            this.getBuilder(name).parent(modelType).texture("layer0", ITEM_FOLDER + "/" + name);
            Cobr.LOGGER.info("Generate Item Successful: " + item.getId());
        }
    }
}
