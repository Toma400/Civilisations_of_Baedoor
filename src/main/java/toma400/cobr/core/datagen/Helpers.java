package toma400.cobr.core.datagen;

import net.minecraft.block.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.elements.blocks.templated.FlammableBlocks;
import toma400.cobr.elements.blocks.templated.TravellerStoneBlocks;

import java.util.ArrayList;
import java.util.Collection;
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
        if (block instanceof FlammableBlocks.Slab) {
            if (block == CobrBlocks.EOTIC_BAMBOO_SLAB.get()) {
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
            if (block == CobrBlocks.EOTIC_BAMBOO_SLAB.get()) {
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
    // HORIZONTAL BLOCKS
    // Naming for horizontal blocks
    // --------------------------------------------
    public static String horizontalBlocksNamingModifier(Block block, String variant) {
        String outcome = block.getRegistryName().getPath();
        // "_side" variant by default takes regular naming value
        if (outcome.contains("traveller_stone")) {
            if (!(variant == "_side")) {
                // for blocks using same bottom and top values
                outcome = "sandstone_top";
            }
        } else {
            if (!(variant == "_side")) {
                outcome = horizontalStringOperator(block, variant);
            }
        }
        return outcome;
    }

    public static String horizontalStringOperator(Block block, String variant) {
        String name_entry = block.getRegistryName().getPath();
        String name_outry = name_entry;
        if (name_entry.contains("dune_sandstone")) { name_outry = "dune_sandstone"; }
        else if (name_entry.contains("sandstone")) { name_outry = "sandstone"; }
        return name_outry + variant;
    }
    // --------------------------------------------
    // GENERAL
    // Naming convention for various blocks (for each type of texture)
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
    public static String blockItemsGenNaming(Block block) {
        String evaluation = "";
        if (block instanceof TrapDoorBlock) {
            evaluation = "_bottom";
        } else if (block instanceof FenceBlock) {
            evaluation = "_inventory";
        }
        return evaluation;
    }
    // --------------------------------------------
    // LISTS
    // --------------------------------------------
    // Used to list all blocks that have manually put models/blockstates
    public static Boolean isBlockSidelined(Block block) {
        ArrayList<Block> custom_blocks = new ArrayList<>();
        custom_blocks.add(CobrBlocks.EOTIC_BAMBOO_MAT.get());
        return (custom_blocks.contains(block));
    }

    // Used to list all blocks being horizontal
    public static Boolean isBlockHorizontal(Block block) {
        ArrayList<Block> horizontal_blocks = new ArrayList<>();
        // Adding entries to arraylist from instancing
        for (RegistryObject<Block> block_iterated : CobrBlocks.BLOCKS.getEntries()) {
            if (block_iterated.get() instanceof OreBlock ||
                block_iterated.get() instanceof TravellerStoneBlocks) {
                horizontal_blocks.add(block_iterated.get());
            }
        }
        // Adding entries to arraylist via manual entries
        horizontal_blocks.add(CobrBlocks.DUNE_SANDSTONE.get());
        return (horizontal_blocks.contains(block));
    }

    // System checking if block has sandstone texturing rules (different top, bottom and double)
    public static Boolean isSandstone(Block block) {
        ArrayList<Block> sandstone_blocks = new ArrayList<>();
        sandstone_blocks.add(CobrBlocks.DUNE_SANDSTONE.get());
        sandstone_blocks.add(CobrBlocks.DUNE_SANDSTONE_SLAB.get());
        sandstone_blocks.add(CobrBlocks.DUNE_SANDSTONE_STAIRS.get());
        return (sandstone_blocks.contains(block));
    }

    //BLOCK GENERATION
    public static final ResourceLocation BlockPathRef(String namespace, String item) {
        ResourceLocation Block = new ResourceLocation(Cobr.MOD_ID + ":block/" + item);
        if (namespace != "" && namespace != "mod") {
            Block = new ResourceLocation(namespace + ":block/" + item);
        }
        return Block;
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
