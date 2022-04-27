package toma400.cobr.core.datagen;

import net.minecraft.block.Block;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.data.DataGenerator;
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

public class ItemsGen extends ItemModelProvider {

    public ItemsGen(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, Cobr.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        //ItemRegistrar(CobrItems.ITEMS.getEntries());
        //BlockRegistrar(CobrBlocks.BLOCKS.getEntries());
    }

    //--------------------------------------------------------------------
    // ITEM MODELS REGISTRY
    //--------------------------------------------------------------------
    public void ItemRegistrar(Collection<RegistryObject<Item>> items) {
        for (RegistryObject<Item> item : items) {
            String name = item.getId().getPath();
            ModelFile modelType = getExistingFile(mcLoc("item/generated"));
            if (item.get() instanceof TieredItem) {
                modelType = getExistingFile(mcLoc("item/handheld"));
            }
            this.getBuilder(name).parent(modelType).texture("layer0", ITEM_FOLDER + "/" + name);
        }
    }

    //--------------------------------------------------------------------
    // BLOCK ITEM MODELS REGISTRY
    //--------------------------------------------------------------------
    public void BlockRegistrar(Collection<RegistryObject<Block>> blocks) {
        for (RegistryObject<Block> block : blocks) {
            String name = block.getId().getPath();
            //--------------------------------------------------------
            // DEFAULT VALUE
            // Default value is 'else', so 'if' value here is placeholder
            // and will get changed when first custom model will be
            // needed. It will need to use some sort of list then.
            //--------------------------------------------------------
            if (block.get() instanceof FurnaceBlock) {
                withExistingParent(name, new ResourceLocation(Cobr.MOD_ID, "block/" + name));
            } else {
                withExistingParent(name, new ResourceLocation(Cobr.MOD_ID, "block/" + name));
            }
        }
    }

    //--------------------------------------------------------------------
    // CUSTOM MODELS FOR BLOCKS
    // If there's ever need for custom block redirection of models
    // (texture instead of tilted block), it will be added to this
    // collection.
    //--------------------------------------------------------------------
    public void customBlocks (Collection<Block> blockProvided) {
        CobrBlocks.BRIGHT_DUNE_SAND.get();
    }
}
