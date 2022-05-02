package toma400.cobr.core.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
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
                horizontalBlock(block.get(), modelProviderAdv(block.get(), ""));
            }
            else if(block.get() instanceof FlammableBlocks.FlammableStone  || block.get() == CobrBlocks.EOTIC_BAMBOO_BLOCK.get() || block.get() == CobrBlocks.DUNE_SANDSTONE.get() || block.get() == CobrBlocks.DUNE_SANDSTONE_BRICKS.get() || block.get() == CobrBlocks.ESRAH_PLANKS.get() || block.get() == CobrBlocks.LAIS_PLANKS.get()) {
                simpleBlock(block.get(), modelProviderAdv(block.get(), ""));
            }
            else if(block.get() instanceof LogBlocks) {
                axisBlock((RotatedPillarBlock) block.get(), modelProviderAdv(block.get(), ""), modelProvider(block.get(), "_horizontal"));
            }
            else if(block.get() instanceof StairBlock) {
                stairsBlock((StairBlock) block.get(), modelProviderAdv(block.get(), ""), modelProviderAdv(block.get(), "_inner"), modelProviderAdv(block.get(), "_outer"));
            }
            else if(block.get() instanceof SlabBlock) {
                String doubleVariant = Helpers.slabDoubleVariant(block.get());
                slabBlock((SlabBlock) block.get(), modelProvider(block.get(), ""), modelProviderAdv(block.get(), "_top"), customModelProvider(block.get(), doubleVariant));
            }
            else if(block.get() instanceof DoorBlock) {
                doorBlock((DoorBlock) block.get(), modelProviderAdv(block.get(), "_bottom"), modelProviderAdv(block.get(), "_bottom_hinge"), modelProviderAdv(block.get(), "_top"), modelProviderAdv(block.get(), "_top_hinge"));
            }
        }
    }

    @Deprecated
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
        ModelFile modelWorkedOn = models().withExistingParent(modelVariant, locationWorkedOn);
        return modelWorkedOn;
    }

}