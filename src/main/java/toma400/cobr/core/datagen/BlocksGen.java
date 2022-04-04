package toma400.cobr.core.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.elements.blocks.templated.DataGenHelper;

import java.util.Collection;

public class BlocksGen extends BlockModelProvider {

    public BlocksGen(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, Cobr.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        iterator(CobrBlocks.BLOCKS.getEntries());
    }

    public void iterator(Collection<RegistryObject<Block>> blocks) {
        for (RegistryObject<Block> block : blocks) {
            String pathage = block.get().getRegistryName().getPath();

            if(block.get() instanceof DataGenHelper.EachSideHorizontalBlock) {
                cube(pathage,
                        Helpers.BlockPathRef("", pathage + "_side"),
                        Helpers.BlockPathRef("", pathage + "_top"),
                        Helpers.BlockPathRef("", pathage + "_back"),
                        Helpers.BlockPathRef("", pathage + "_front"),
                        Helpers.BlockPathRef("", pathage + "_side"),
                        Helpers.BlockPathRef("", pathage + "_side"));
            }
        }
    }
}
