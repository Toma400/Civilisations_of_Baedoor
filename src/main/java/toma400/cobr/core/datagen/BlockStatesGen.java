package toma400.cobr.core.datagen;

import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.elements.blocks.templated.Base;
import toma400.cobr.elements.blocks.templated.FlammableBlocks;

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

            if(block.get() instanceof Base.EachSideHorizontalBlock) {
                horizontalBlock(block.get(), modelProvider(block.get(), ""));
            }
            else if(Helpers.isBlockHorizontal(block.get())) {
                simpleBlock(block.get(), modelProvider(block.get(), ""));
            }
            else if(block.get() instanceof FlammableBlocks.LogBlocks) {
                axisBlock((RotatedPillarBlock) block.get(), modelProvider(block.get(), ""), modelProvider(block.get(), "_horizontal"));
            }
            else if(block.get() instanceof StairsBlock) {
                stairsBlock((StairsBlock) block.get(), modelProvider(block.get(), ""), modelProvider(block.get(), "_inner"), modelProvider(block.get(), "_outer"));
            }
            else if(block.get() instanceof SlabBlock) {
                String doubleVariant = Helpers.slabDoubleVariant(block.get());
                slabBlock((SlabBlock) block.get(), modelProvider(block.get(), ""), modelProvider(block.get(), "_top"), customModelProvider(block.get(), doubleVariant));
            }
            else if(block.get() instanceof TrapDoorBlock) {
                trapdoorBlock((TrapDoorBlock) block.get(), modelProvider(block.get(), "_bottom"), modelProvider(block.get(), "_top"), modelProvider(block.get(), "_open"), true);
            }
            else if(block.get() instanceof DoorBlock) {
                doorBlock((DoorBlock) block.get(), modelProvider(block.get(), "_bottom"), modelProvider(block.get(), "_bottom_hinge"), modelProvider(block.get(), "_top"), modelProvider(block.get(), "_top_hinge"));
            }
            else if(block.get() instanceof FenceBlock) {
                String switcher = Helpers.fenceTypesNamingModifierBlockStates(block.get());
                fenceBlock((FenceBlock) block.get(), Helpers.BlockPathRef("", switcher));
            }
            else if(block.get() instanceof FenceGateBlock) {
                fenceGateBlock((FenceGateBlock) block.get(), modelProvider(block.get(), ""), modelProvider(block.get(), "_open"), modelProvider(block.get(), "_wall"), modelProvider(block.get(), "_wall_open"));
            }
            else {
                if(!(Helpers.isBlockSidelined(block.get()))) {
                    simpleBlock(block.get(), modelProvider(block.get(), ""));
                }
            }
        }
    }

    public ModelFile modelProvider (Block resourceGiven, String modelVariant) {
        //----------------------------------------------------------------------------------------------------------------------
        // modelVariant should be default as "", as it directs us precisely to file named after block
        // though if we want to add some variation (for example "_horizontal" suffix), it will be used under that string
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
