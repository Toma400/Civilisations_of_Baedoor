package toma400.cobr.core.datagen;

import net.minecraft.block.Block;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.TieredItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.core.CobrItems;

import java.util.Collection;
import java.util.Collections;

public class ItemsGen extends ItemModelProvider {

    public ItemsGen(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, Cobr.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        ItemRegistrar(CobrItems.ITEMS.getEntries());
        //BlockRegistrar(CobrBlocks.BLOCKS.getEntries());
    }

    //--------------------------------------------------------------------
    // ITEM MODELS REGISTRY
    //--------------------------------------------------------------------
    public void ItemRegistrar(Collection<RegistryObject<Item>> items) {
        for (RegistryObject<Item> item : items) {
            if (!(item.get() instanceof BlockItem)) { // delegates all possible blockItems to another builder
                String name = item.getId().getPath();
                ModelFile modelType = getExistingFile(mcLoc("item/generated"));
                if (item.get() instanceof TieredItem) {
                    modelType = getExistingFile(mcLoc("item/handheld"));
                }
                this.getBuilder(name).parent(modelType).texture("layer0", ITEM_FOLDER + "/" + name);
            }
        }
    }

    //--------------------------------------------------------------------
    // BLOCK ITEM MODELS REGISTRY
    //--------------------------------------------------------------------
    public void BlockRegistrar(Collection<RegistryObject<Block>> blocks) {
        for (RegistryObject<Block> block : blocks) {
            String name = block.getId().getPath();
            //--------------------------------------------------------
            Collection<Block> lister = Collections.EMPTY_LIST;
            //--------------------------------------------------------
            // DEFAULT VALUE
            // Default value is 'else', 'if' using items from `lister`
            // Collection above (if you want to append new items,
            // remove emptyList() and replace with some sort of list
            //--------------------------------------------------------
            if (lister.contains(block.get())) {
                withExistingParent(name, new ResourceLocation(Cobr.MOD_ID, "item/" + name));
            } else {
                withExistingParent(name, new ResourceLocation(Cobr.MOD_ID, "block/" + name));
            }
        }
    }
}
