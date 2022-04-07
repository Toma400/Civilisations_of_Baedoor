package toma400.cobr.core.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.elements.blocks.templated.DataGenHelper;
import toma400.cobr.elements.blocks.templated.FlammableBlocks;
import toma400.cobr.elements.blocks.templated.LogBlocks;

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
                sign(pathage, Helpers.BlockPathRef("", pathage + "_side"));
            }
            if(block.get() instanceof FlammableBlocks.FlammableStone) {
                cubeAll(pathage, Helpers.BlockPathRef("", pathage));
                sign(pathage, Helpers.BlockPathRef("", pathage));
            }
            if(block.get() instanceof LogBlocks){
                String pathage2 = pathage;
                if(pathage.contains("wood")) {
                    pathage2 = pathage.replace("wood", "log");
                }
                cubeColumn(pathage,
                        Helpers.BlockPathRef("", pathage2 + "_side"),
                        Helpers.BlockPathRef("", pathage2 + "_top"));
                cubeColumnHorizontal(pathage + "_horizontal",
                        Helpers.BlockPathRef("", pathage2 + "_side"),
                        Helpers.BlockPathRef("", pathage2 + "_top"));
                sign(pathage, Helpers.BlockPathRef("", pathage2 + "_side"));
            }
            //---------------------------------------------------------------------
            // SKIPPED
            // Here are all blockstates that are added manually.
            // If placed in case I will change my mind and switch them to datagen.
            //---------------------------------------------------------------------
            //if(block.get() instanceof OreBlock){}
        }
    }
}
