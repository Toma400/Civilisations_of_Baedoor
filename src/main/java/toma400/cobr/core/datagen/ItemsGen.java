package toma400.cobr.core.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.TieredItem;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrItems;

import java.util.Collection;

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
            String name = item.getId().getPath();
            ModelFile modelType = getExistingFile(mcLoc("item/generated"));
            if (item.get() instanceof TieredItem) {
                modelType = getExistingFile(mcLoc("item/handheld"));
            }
            this.getBuilder(name).parent(modelType).texture("layer0", ITEM_FOLDER + "/" + name);
        }
    }
}
