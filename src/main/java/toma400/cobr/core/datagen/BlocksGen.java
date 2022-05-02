package toma400.cobr.core.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.*;
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
            else if(block.get() instanceof FlammableBlocks.FlammableStone  || block.get() == CobrBlocks.EOTIC_BAMBOO_BLOCK.get() || block.get() == CobrBlocks.DUNE_SANDSTONE.get() || block.get() == CobrBlocks.DUNE_SANDSTONE_BRICKS.get() || block.get() == CobrBlocks.ESRAH_PLANKS.get() || block.get() == CobrBlocks.LAIS_PLANKS.get()) {
                cubeAll(pathage, Helpers.BlockPathRef("", pathage));
                sign(pathage, Helpers.BlockPathRef("", pathage));
            }
            else if(block.get() instanceof RotatedPillarBlock){
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
            else if(block.get() instanceof StairBlock) {
                String pathage2 = Helpers.stairNamingModifier(block.get(), pathage);
                stairs(pathage,
                        Helpers.BlockPathRef("", Helpers.sandstoneNaming(block.get(), pathage2, 1)),
                        Helpers.BlockPathRef("", Helpers.sandstoneNaming(block.get(), pathage2, 2)),
                        Helpers.BlockPathRef("", Helpers.sandstoneNaming(block.get(), pathage2, 3)));
                stairsInner(pathage + "_inner",
                        Helpers.BlockPathRef("", Helpers.sandstoneNaming(block.get(), pathage2, 1)),
                        Helpers.BlockPathRef("", Helpers.sandstoneNaming(block.get(), pathage2, 2)),
                        Helpers.BlockPathRef("", Helpers.sandstoneNaming(block.get(), pathage2, 3)));
                stairsOuter(pathage + "_outer",
                        Helpers.BlockPathRef("", Helpers.sandstoneNaming(block.get(), pathage2, 1)),
                        Helpers.BlockPathRef("", Helpers.sandstoneNaming(block.get(), pathage2, 2)),
                        Helpers.BlockPathRef("", Helpers.sandstoneNaming(block.get(), pathage2, 3)));
            }
            else if(block.get() instanceof SlabBlock) {
                String pathage2 = Helpers.slabNamingModifier(block.get(), pathage);
                slab(pathage,
                        Helpers.BlockPathRef("", Helpers.sandstoneNaming(block.get(), pathage2, 1)),
                        Helpers.BlockPathRef("", Helpers.sandstoneNaming(block.get(), pathage2, 2)),
                        Helpers.BlockPathRef("", Helpers.sandstoneNaming(block.get(), pathage2, 3)));
                slabTop(pathage + "_top",
                        Helpers.BlockPathRef("", Helpers.sandstoneNaming(block.get(), pathage2, 1)),
                        Helpers.BlockPathRef("", Helpers.sandstoneNaming(block.get(), pathage2, 2)),
                        Helpers.BlockPathRef("", Helpers.sandstoneNaming(block.get(), pathage2, 3)));
            }
            else if(block.get() instanceof DoorBlock) {
                doorBottomLeft(pathage + "_bottom",
                        Helpers.BlockPathRef("", pathage + "_bottom"),
                        Helpers.BlockPathRef("", pathage + "_top"));
                doorBottomRight(pathage + "_bottom_hinge",
                        Helpers.BlockPathRef("", pathage + "_bottom"),
                        Helpers.BlockPathRef("", pathage + "_top"));
                doorTopLeft(pathage + "_top",
                        Helpers.BlockPathRef("", pathage + "_bottom"),
                        Helpers.BlockPathRef("", pathage + "_top"));
                doorTopRight(pathage + "_top_hinge",
                        Helpers.BlockPathRef("", pathage + "_bottom"),
                        Helpers.BlockPathRef("", pathage + "_top"));
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
