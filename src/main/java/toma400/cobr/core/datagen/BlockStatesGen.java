package toma400.cobr.core.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.elements.blocks.templated.DataGenHelper;

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
                horizontalBlock(block.get(),
                        Helpers.BlockPathRef("", pathage),
                        Helpers.BlockPathRef("", pathage),
                        Helpers.BlockPathRef("", pathage));
            }
        }
    }
}