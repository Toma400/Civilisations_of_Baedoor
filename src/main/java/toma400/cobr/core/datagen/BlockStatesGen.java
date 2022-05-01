package toma400.cobr.core.datagen;

import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.elements.blocks.templated.DataGenHelper;
import toma400.cobr.elements.blocks.templated.FlammableBlocks;
import toma400.cobr.elements.blocks.templated.LogBlocks;

import java.io.File;
import java.util.Collection;

public class BlockStatesGen extends BlockStateProvider {

    public BlockStatesGen(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, Cobr.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        iterator(CobrBlocks.BLOCKS.getEntries());
    }

    public void iterator(Collection<RegistryObject<Block>> blocks) {
        for (RegistryObject<Block> block : blocks) {
            String pathage = block.get().getRegistryName().getPath();

            if(block.get() instanceof DataGenHelper.EachSideHorizontalBlock) {
                horizontalBlock(block.get(), modelProvider(block.get(), ""));
            }
            else if(block.get() instanceof FlammableBlocks.FlammableStone) {
                simpleBlock(block.get(), modelProvider(block.get(), ""));
            }
            else if(block.get() instanceof LogBlocks) {
                axisBlock((RotatedPillarBlock) block.get(), modelProvider(block.get(), ""), modelProvider(block.get(), "_horizontal"));
            }
            else if(block.get() instanceof StairBlock) {
                stairsBlock((StairBlock) block.get(), modelProviderAdv(block.get(), ""), modelProviderAdv(block.get(), "_inner"), modelProviderAdv(block.get(), "_outer"));
            }
            //if(block.get() instanceof SlabBlock) {
            //    String doubleVariant = block.get().getRegistryName().getPath().replace("_slab", "");;
            //    if(block.get() instanceof FlammableBlocks.Slab) {  // for logs
            //        if(block.get() == CobrBlocks.EOTIC_BAMBOO_SLAB.get()) {
            //            doubleVariant = block.get().getRegistryName().getPath().replace("_slab", "_block");
            //        }
            //        else {
            //            doubleVariant = block.get().getRegistryName().getPath().replace("_slab", "_planks");
            //        }
            //    }
            //    slabBlock((SlabBlock) block.get(), modelProvider(block.get(), ""), customModelProvider(block.get(), ""), modelProvider(block.get(), "_top"));
            //}
        }
    }

    public ModelFile modelProvider (Block resourceGiven, String modelVariant) {
        //----------------------------------------------------------------------------------------------------------------------
        // modelVariant should be default as "", as it directs us precisely to file named after block
        // though if we want to add some variation (for example "_horizontal" suffix), it will be used under that string
        //----------------------------------------------------------------------------------------------------------------------
        ResourceLocation locationWorkedOn = new ResourceLocation(Cobr.MOD_ID + ":block/" + resourceGiven.getRegistryName().getPath() + modelVariant);
        ModelFile modelWorkedOn = models().withExistingParent(resourceGiven.getRegistryName().getPath(), locationWorkedOn);
        return modelWorkedOn;
    }

    public ModelFile modelProviderAdv (Block resourceGiven, String modelVariant) {
        //----------------------------------------------------------------------------------------------------------------------
        // Advanced provider, adding `modelVariant` string as nested (required for some blockstates, such as slabs)
        //----------------------------------------------------------------------------------------------------------------------
        ResourceLocation locationWorkedOn = new ResourceLocation(Cobr.MOD_ID + ":block/" + resourceGiven.getRegistryName().getPath() + modelVariant);
        ModelFile modelWorkedOn = models().withExistingParent(resourceGiven.getRegistryName().getPath() + modelVariant, locationWorkedOn);
        return modelWorkedOn;
    }

    public ModelFile customModelProvider (Block resourceGiven, String modelVariant) {
        //----------------------------------------------------------------------------------------------------------------------
        // modelVariant should be default as "", as it directs us precisely to file named after block
        // though if we want to add some variation (for example "_horizontal" suffix), it will be used under that string
        //----------------------------------------------------------------------------------------------------------------------
        ResourceLocation locationWorkedOn = new ResourceLocation(Cobr.MOD_ID + ":block/" + modelVariant);
        ModelFile modelWorkedOn = models().withExistingParent(resourceGiven.getRegistryName().getPath(), locationWorkedOn);
        return modelWorkedOn;
    }

}