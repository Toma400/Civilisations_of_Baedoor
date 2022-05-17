package toma400.cobr.core.datagen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Debug;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.core.CobrItems;
import toma400.cobr.elements.blocks.templated.FlammableBlocks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Helpers {

    // --------------------------------------------
    // NAME MODIFIERS
    // --------------------------------------------
    // STAIRS
    // Basic system for stairs naming
    // --------------------------------------------
    public static String stairNamingModifier(Block block, String pathage) {
        String pathage2 = pathage.replace("_stairs", "");
        if (block instanceof FlammableBlocks.Stairs) {
            if (block == CobrBlocks.EOTIC_BAMBOO_STAIRS.get()) {
                pathage2 = pathage.replace("_stairs", "_block");
            } else {
                pathage2 = pathage.replace("_stairs", "_planks");
            }
        }
        return pathage2;
    }
    // --------------------------------------------
    // SLABS
    // Basic system for stairs naming
    // --------------------------------------------
    public static String slabNamingModifier(Block block, String pathage) {
        String pathage2 = pathage.replace("_slab", "");
        if(block instanceof FlammableBlocks.Slab) {  // for logs
            if(block == CobrBlocks.EOTIC_BAMBOO_SLAB.get()) {
                pathage2 = pathage.replace("_slab", "_block");
            } else {
                pathage2 = pathage.replace("_slab", "_planks");
            }
        }
        return pathage2;
    }
    public static String slabDoubleVariant(Block block){
        String doubleVariant = block.getRegistryName().getPath().replace("_slab", "");
        if(block instanceof FlammableBlocks.Slab) {  // for logs
            if(block == CobrBlocks.EOTIC_BAMBOO_SLAB.get()) {
                doubleVariant = block.getRegistryName().getPath().replace("_slab", "_block");
            }
            else {
                doubleVariant = block.getRegistryName().getPath().replace("_slab", "_planks");
            }
        }
        return doubleVariant;
    }
    // --------------------------------------------
    // FENCES & FENCE GATES
    // Basic system for fence-related blocks naming
    // --------------------------------------------
    public static String fenceTypesNamingModifier(Block block, String pathage) {
        String isItFenceOrFenceGate = "fence";
        if (block instanceof FenceGateBlock) {
            isItFenceOrFenceGate = "fence_gate";
        }
        String pathage2;
        if(block instanceof FlammableBlocks.FenceGate || block instanceof FlammableBlocks.Fence) {
            pathage2 = pathage.replace(isItFenceOrFenceGate, "planks");
        } else {
            pathage2 = pathage.replace(isItFenceOrFenceGate, "bricks");
        }
        return pathage2;
    }
    // Special class for BlockStates
    public static String fenceTypesNamingModifierBlockStates(Block block) {
        String switcher = block.getRegistryName().getPath().replace("fence", "bricks");
        if (block instanceof FlammableBlocks.Fence) {
            switcher = block.getRegistryName().getPath().replace("fence", "planks");
        }
        return switcher;
    }
    // --------------------------------------------
    // GENERAL
    // Naming convention for sandstone blocks (for each type of texture)
    // --------------------------------------------
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

    // --------------------------------------------
    // LISTS
    // --------------------------------------------
    // System checking if block has sandstone texturing rules (different top, bottom and double)
    public static Boolean isBlockSidelined(Block block) {
        ArrayList<Block> custom_blocks = new ArrayList<>();
        return (custom_blocks.contains(block));
    }
    public static Boolean isBlockSimplified(Block block) {
        ArrayList<Block> simplified_blocks = new ArrayList<>();
        simplified_blocks.add(CobrBlocks.EOTIC_BAMBOO_BLOCK.get());
        simplified_blocks.add(CobrBlocks.DUNE_SANDSTONE_BRICKS.get());
        simplified_blocks.add(CobrBlocks.DUNE_SANDSTONE.get()); // TO FIX!

        simplified_blocks.add(CobrBlocks.CHISELED_DUNE_SANDSTONE_BRICKS.get());
        simplified_blocks.add(CobrBlocks.BLOCK_OF_DUNE_GOLD.get());
        simplified_blocks.add(CobrBlocks.BRIGHT_DUNE_SAND.get());
        simplified_blocks.add(CobrBlocks.DUNE_SAND.get());
        simplified_blocks.add(CobrBlocks.EOTIC_BAMBOO_LAMP.get());
        simplified_blocks.add(CobrBlocks.HARDENED_DUNE_SAND.get());
        simplified_blocks.add(CobrBlocks.HARDENED_SAND.get());
        simplified_blocks.add(CobrBlocks.RAW_DUNE_GOLD_BLOCK.get());
        simplified_blocks.add(CobrBlocks.WET_DUNE_SAND.get());
        return (simplified_blocks.contains(block));
    }
    public static Boolean isSandstone(Block block) {
        ArrayList<Block> sandstone_blocks = new ArrayList<>();
        sandstone_blocks.add(CobrBlocks.DUNE_SANDSTONE.get());
        sandstone_blocks.add(CobrBlocks.DUNE_SANDSTONE_SLAB.get());
        sandstone_blocks.add(CobrBlocks.DUNE_SANDSTONE_STAIRS.get());
        return (sandstone_blocks.contains(block));
    }

    // BLOCK GENERATION
    public static final ResourceLocation BlockPathRef(String namespace, String item) {
        ResourceLocation Block = new ResourceLocation(Cobr.MOD_ID + ":block/" + item);
        if (namespace != "" && namespace != "mod") {
            Block = new ResourceLocation(namespace + ":block/" + item);
        }
        return Block;
    }

    // ITEM GENERATION
    @Deprecated
    public static final ResourceLocation ItemPathRef(String namespace, String item) {
        ResourceLocation Item = new ResourceLocation(Cobr.MOD_ID + ":item/" + item);
        if (namespace != "" && namespace != "mod") {
            Item = new ResourceLocation(namespace + ":item/" + item);
        }
        return Item;
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
