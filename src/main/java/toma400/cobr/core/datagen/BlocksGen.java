package toma400.cobr.core.datagen;

import javafx.scene.transform.Rotate;
import net.minecraft.block.Block;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.elements.blocks.templated.DataGenHelper;
import toma400.cobr.elements.blocks.templated.FlammableBlocks;

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
                //sign(pathage, Helpers.BlockPathRef("", pathage + "_side"));
            }
            else if(block.get() instanceof FlammableBlocks.FlammableStone) {
                cubeAll(pathage, Helpers.BlockPathRef("", pathage));
                //sign(pathage, Helpers.BlockPathRef("", pathage));
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
                //sign(pathage, Helpers.BlockPathRef("", pathage2 + "_side"));
            }
            else if(block.get() instanceof StairsBlock) {
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
            //---------------------------------------------------------------------
            // SKIPPED
            // Here are all blockstates that are added manually.
            // If placed in case I will change my mind and switch them to datagen.
            //---------------------------------------------------------------------
            //if(block.get() instanceof OreBlock){}
        }
    }
}
