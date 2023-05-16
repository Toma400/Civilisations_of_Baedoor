package toma400.cobr.core.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.core.CobrItems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

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
                if (item.get() instanceof SpawnEggItem) {
                    name = "spawn_egg";
                }
                ModelFile modelType = getExistingFile(mcLoc("item/generated"));
                if (item.get() instanceof TieredItem) {
                    modelType = getExistingFile(mcLoc("item/handheld"));
                }
                this.getBuilder(item.getId().getPath()).parent(modelType).texture("layer0", ITEM_FOLDER + "/" + name);
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
