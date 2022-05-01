package toma400.cobr.core.datagen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.core.CobrItems;
import toma400.cobr.elements.blocks.templated.FlammableBlocks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Helpers {

    // ITEM GENERATION
    public static final ResourceLocation ItemPathRef(String namespace, String item) {
        ResourceLocation Item = new ResourceLocation(Cobr.MOD_ID + ":item/" + item);
        if (namespace != "" && namespace != "mod") {
            Item = new ResourceLocation(namespace + ":item/" + item);
        }
        return Item;
    }

    // BLOCK GENERATION
    public static final ResourceLocation BlockPathRef(String namespace, String item) {
        ResourceLocation Block = new ResourceLocation(Cobr.MOD_ID + ":block/" + item);
        if (namespace != "" && namespace != "mod") {
            Block = new ResourceLocation(namespace + ":block/" + item);
        }
        return Block;
    }

    // --------------------------------------------
    // NAME MODIFIERS
    // --------------------------------------------
    // Basic system for stairs naming
    public static String stairNamingModifier(Block block, String pathage) {
        String pathage2 = pathage.replace("_stairs", "");
        if (block instanceof FlammableBlocks.Stairs && !(block == CobrBlocks.EOTIC_BAMBOO_STAIRS.get())) {
            pathage2 = pathage.replace("_stairs", "_planks");
        }
        return pathage2;
    }
    // Naming convention for sandstone blocks (for each type of texture)
    public static String sandstoneNaming(Block block, String pathage2, Integer blockSet) {
        if (isSandstone(block) && blockSet == 1) {
            pathage2 = pathage2 + "_double";
        }
        else if (isSandstone(block) && blockSet == 2) {
            pathage2 = pathage2 + "_bottom";
        }
        else if (isSandstone(block) && blockSet == 3) {
            pathage2 = pathage2 + "_top";
        }
        return pathage2;
    }

    // System checking if block has sandstone texturing rules (different top, bottom and double)
    public static Boolean isSandstone(Block block) {
        ArrayList<Block> sandstone_blocks = new ArrayList<>();
        sandstone_blocks.add(CobrBlocks.DUNE_SANDSTONE.get());
        sandstone_blocks.add(CobrBlocks.DUNE_SANDSTONE_SLAB.get());
        sandstone_blocks.add(CobrBlocks.DUNE_SANDSTONE_STAIRS.get());
        return (sandstone_blocks.contains(block));
    }
    @Deprecated
    public void leafThingForTomi(Collection<RegistryObject<Block>> blocks) {
        for (RegistryObject<Block> block : blocks) {
            for (Block output : ForgeRegistries.BLOCKS.getValues().stream().filter(b -> b.getRegistryName().getNamespace().equals(Cobr.MOD_ID)).collect(Collectors.toList())) {

                String regName = block.get().getRegistryName().getPath();
                String[] split = regName.split("_");
                if (split[split.length - 1].equals("leaves")) {
                    continue;
                }

                String outName = output.getRegistryName().getPath();
                String[] outSplit = outName.split("_");
                if (outSplit[outSplit.length - 1].equals("sapling")) {
                    if (outSplit[outSplit.length - 2].equals(split[split.length - 2])) {
                        //createLeavesDrops(block.get(), output);
                    }
                }
            }
        }
    }
}
