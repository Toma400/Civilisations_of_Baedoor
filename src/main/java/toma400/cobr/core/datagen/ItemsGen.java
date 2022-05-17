package toma400.cobr.core.datagen;

import net.minecraft.block.*;
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
import toma400.cobr.elements.blocks.templated.FlammableBlocks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ItemsGen extends ItemModelProvider {

    public ItemsGen(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, Cobr.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        ItemRegistrar(CobrItems.ITEMS.getEntries());
        BlockRegistrar(CobrBlocks.BLOCKS.getEntries());
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
            String evaluation = Helpers.blockItemsGenNaming(block.get());
            //--------------------------------------------------------
            ArrayList<Block> lister = new ArrayList<>();
            for (RegistryObject<Block> block_iterated : CobrBlocks.BLOCKS.getEntries()) {
                if (block_iterated.get() instanceof DoorBlock) {
                    lister.add(block_iterated.get());
                }
            }
            //--------------------------------------------------------
            // DEFAULT VALUE
            // Default value is 'else', 'if' using items from `lister`
            // ArrayList above
            //--------------------------------------------------------
            if (lister.contains(block.get())) {
                this.getBuilder(name).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", ITEM_FOLDER + "/" + name);
            } else {
                withExistingParent(name, new ResourceLocation(Cobr.MOD_ID, "block/" + name + evaluation));
            }
        }
    }
}
