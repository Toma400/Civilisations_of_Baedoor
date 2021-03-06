package toma400.cobr.core;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import toma400.cobr.Cobr;
import toma400.cobr.elements.blocks.CivilisationTableBlock;
import toma400.cobr.elements.blocks.templated.Base;
import toma400.cobr.elements.blocks.templated.FlammableBlocks;
import toma400.cobr.elements.blocks.templated.MatBlocks;
import toma400.cobr.elements.blocks.templated.TravellerStoneBlocks;
import toma400.cobr.world.environment.trees.EsrahTree;
import toma400.cobr.world.environment.trees.LaisTree;

import java.util.function.Supplier;

public class CobrBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Cobr.MOD_ID);

    //UTIL BLOCKS
    public static final RegistryObject<Block> PACK_OF_EOTIC_BAMBOO = registerBlock("pack_of_eotic_bamboo",
            () -> new FlammableBlocks.LogBlocks(Block.Properties.of(Material.BAMBOO).sound(SoundType.BAMBOO).strength(0.5f, 0.5f).harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> HARDENED_SAND = registerBlock("hardened_sand",
            () -> new Block(Block.Properties.of(Material.STONE).sound(SoundType.SAND).strength(2f, 1f).harvestTool(ToolType.SHOVEL)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> SAND_PATH = registerBlock("sand_path",
            () -> new Block(Block.Properties.of(Material.STONE).sound(SoundType.SAND).strength(2f, 6f).harvestTool(ToolType.PICKAXE)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> SAND_PATH_SLAB = registerBlock("sand_path_slab",
            () -> new SlabBlock(Block.Properties.of(Material.STONE).sound(SoundType.SAND).strength(2f, 6f).harvestTool(ToolType.PICKAXE)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> SAND_PATH_STAIRS = registerBlock("sand_path_stairs",
            () -> new StairsBlock(() -> CobrBlocks.SAND_PATH.get().defaultBlockState(), Block.Properties.of(Material.STONE).sound(SoundType.SAND).strength(2f, 6f).harvestTool(ToolType.PICKAXE)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> DUNE_COAL_BLOCK = registerBlock("dune_coal_block",
            () -> new FlammableBlocks.FlammableStone(Block.Properties.of(Material.WOOD).sound(SoundType.STONE).strength(6f, 8f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(0)), CobrTab.COBR_TAB, 18000);
    public static final RegistryObject<Block> RAW_DUNE_GOLD_BLOCK = registerBlock("raw_dune_gold_block",
            () -> new Block(Block.Properties.of(Material.METAL).sound(SoundType.METAL).strength(4f, 4f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(0)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> BLOCK_OF_DUNE_GOLD = registerBlock("block_of_dune_gold",
            () -> new Block(Block.Properties.of(Material.METAL).sound(SoundType.METAL).strength(12f, 8f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(0)), CobrTab.COBR_TAB, 0);
    //EOTIC BAMBOO + VARIANTS
    public static final RegistryObject<Block> EOTIC_BAMBOO_BLOCK = registerBlock("eotic_bamboo_block",
            () -> new FlammableBlocks.Planks(Block.Properties.of(Material.BAMBOO).sound(SoundType.BAMBOO).strength(1f, 2f).harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> EOTIC_BAMBOO_STAIRS = registerBlock("eotic_bamboo_stairs",
            () -> new FlammableBlocks.Stairs(() -> CobrBlocks.EOTIC_BAMBOO_BLOCK.get().defaultBlockState(), Block.Properties.of(Material.BAMBOO).sound(SoundType.BAMBOO).strength(1f, 2f).harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> EOTIC_BAMBOO_SLAB = registerBlock("eotic_bamboo_slab",
            () -> new FlammableBlocks.Slab(Block.Properties.of(Material.BAMBOO).sound(SoundType.BAMBOO).strength(1f, 2f).harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> EOTIC_BAMBOO_MAT = registerBlock("eotic_bamboo_mat",
            () -> new MatBlocks(Block.Properties.of(Material.BAMBOO).sound(SoundType.BAMBOO).strength(0.5f, 0.5f).noOcclusion().harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> EOTIC_BAMBOO_LAMP = registerBlock("eotic_bamboo_lamp",
            () -> new FlammableBlocks.Planks(Block.Properties.of(Material.BAMBOO).sound(SoundType.BAMBOO).strength(1f, 2f).lightLevel(s -> 15).harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 0);
    //TRAVELLER STONES
    public static final RegistryObject<Block> EMPTY_TRAVELLER_STONE = registerBlock("empty_traveller_stone",
            () -> new TravellerStoneBlocks(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(0.8f,0.8f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(1)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> DUNE_TRAVELLER_STONE = registerBlock("dune_traveller_stone",
            () -> new TravellerStoneBlocks(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(0.8f,0.8f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(1)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> PERMAFROST_TRAVELLER_STONE = registerBlock("permafrost_traveller_stone",
            () -> new TravellerStoneBlocks(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(0.8f,0.8f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(1)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> RAINFOREST_ISLANDS_TRAVELLER_STONE = registerBlock("rainforest_islands_traveller_stone",
            () -> new TravellerStoneBlocks(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(0.8f,0.8f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(1)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> EVERGREEN_DEPTHS_TRAVELLER_STONE = registerBlock("evergreen_depths_traveller_stone",
            () -> new TravellerStoneBlocks(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(0.8f,0.8f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(1)), CobrTab.COBR_TAB, 0);
    //GENERATION BLOCKS
    public static final RegistryObject<Block> DUNE_SANDSTONE_COAL_ORE = registerBlock("dune_sandstone_coal_ore",
            () -> new OreBlock(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.2f,1.2f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(0)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> DUNE_SANDSTONE_IRON_ORE = registerBlock("dune_sandstone_iron_ore",
            () -> new OreBlock(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.2f,1.2f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(1)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> DUNE_SANDSTONE_GOLD_ORE = registerBlock("dune_sandstone_gold_ore",
            () -> new OreBlock(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.2f,1.2f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(1)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> SANDSTONE_COAL_ORE = registerBlock("sandstone_coal_ore",
            () -> new OreBlock(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.2f,1.2f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(0)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> SANDSTONE_IRON_ORE = registerBlock("sandstone_iron_ore",
            () -> new OreBlock(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.2f,1.2f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(1)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> SANDSTONE_GOLD_ORE = registerBlock("sandstone_gold_ore",
            () -> new OreBlock(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.2f,1.2f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(1)), CobrTab.COBR_TAB, 0);
    //DUNE SAND
    public static final RegistryObject<Block> DUNE_SAND = registerBlock("dune_sand",
            () -> new Block(Block.Properties.of(Material.SAND).sound(SoundType.SAND).strength(0.7f, 1f).harvestTool(ToolType.SHOVEL)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> HARDENED_DUNE_SAND = registerBlock("hardened_dune_sand",
            () -> new Block(Block.Properties.of(Material.STONE).sound(SoundType.SAND).strength(2f, 1f).harvestTool(ToolType.SHOVEL)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> WET_DUNE_SAND = registerBlock("wet_dune_sand",
            () -> new Block(Block.Properties.of(Material.STONE).sound(SoundType.SAND).strength(1f, 1f).harvestTool(ToolType.SHOVEL)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> BRIGHT_DUNE_SAND = registerBlock("bright_dune_sand",
            () -> new Block(Block.Properties.of(Material.STONE).sound(SoundType.SAND).strength(0.7f, 1f).harvestTool(ToolType.SHOVEL)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> DUNE_SANDSTONE = registerBlock("dune_sandstone",
            () -> new Block(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(0.8f, 0.8f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(0)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> DUNE_SANDSTONE_SLAB = registerBlock("dune_sandstone_slab",
            () -> new SlabBlock(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(0.8f, 0.8f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(0)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> DUNE_SANDSTONE_STAIRS = registerBlock("dune_sandstone_stairs",
            () -> new StairsBlock(() -> CobrBlocks.DUNE_SANDSTONE.get().defaultBlockState(), Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(0.8f, 0.8f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(0)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> DUNE_SANDSTONE_BRICKS = registerBlock("dune_sandstone_bricks",
            () -> new Block(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(6f, 6f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(0)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> DUNE_SANDSTONE_BRICKS_SLAB = registerBlock("dune_sandstone_bricks_slab",
            () -> new SlabBlock(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(6f, 6f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(0)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> DUNE_SANDSTONE_BRICKS_STAIRS = registerBlock("dune_sandstone_bricks_stairs",
            () -> new StairsBlock(() -> CobrBlocks.DUNE_SANDSTONE_BRICKS.get().defaultBlockState(), Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(6f, 6f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(0)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> CHISELED_DUNE_SANDSTONE_BRICKS = registerBlock("chiseled_dune_sandstone_bricks",
            () -> new Block(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(6f, 6f).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(0)), CobrTab.COBR_TAB, 0);
    //WOODS
    //[LOGS - WOODS - PLANKS]
    public static final RegistryObject<Block> ESRAH_LOG = registerBlock("esrah_log",
            () -> new FlammableBlocks.LogBlocks(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 2f).harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 300);
    public static final RegistryObject<Block> STRIPPED_ESRAH_LOG = registerBlock("stripped_esrah_log",
            () -> new FlammableBlocks.LogBlocks(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 2f).harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 300);
    public static final RegistryObject<Block> ESRAH_WOOD = registerBlock("esrah_wood",
            () -> new FlammableBlocks.LogBlocks(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 2f).harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 300);
    public static final RegistryObject<Block> STRIPPED_ESRAH_WOOD = registerBlock("stripped_esrah_wood",
            () -> new FlammableBlocks.LogBlocks(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 2f).harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 300);
    public static final RegistryObject<Block> ESRAH_PLANKS = registerBlock("esrah_planks",
            () -> new FlammableBlocks.Planks(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f).harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 300);
    public static final RegistryObject<Block> LAIS_LOG = registerBlock("lais_log",
            () -> new FlammableBlocks.LogBlocks(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 2f).harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 300);
    public static final RegistryObject<Block> STRIPPED_LAIS_LOG = registerBlock("stripped_lais_log",
            () -> new FlammableBlocks.LogBlocks(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 2f).harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 300);
    public static final RegistryObject<Block> LAIS_WOOD = registerBlock("lais_wood",
            () -> new FlammableBlocks.LogBlocks(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 2f).harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 300);
    public static final RegistryObject<Block> STRIPPED_LAIS_WOOD = registerBlock("stripped_lais_wood",
            () -> new FlammableBlocks.LogBlocks(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 2f).harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 300);
    public static final RegistryObject<Block> LAIS_PLANKS = registerBlock("lais_planks",
            () -> new FlammableBlocks.Planks(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f).harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 300);
    //WOOD VARIANTS
    //[STAIRS - SLABS - TRAPDOORS - DOORS - FENCES - FENCE GATES]
    public static final RegistryObject<Block> ESRAH_STAIRS = registerBlock("esrah_stairs",
            () -> new FlammableBlocks.Stairs(() -> CobrBlocks.ESRAH_PLANKS.get().defaultBlockState(), Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f).noOcclusion().harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 300);
    public static final RegistryObject<Block> ESRAH_SLAB = registerBlock("esrah_slab",
            () -> new FlammableBlocks.Slab(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f).noOcclusion().harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 150);
    public static final RegistryObject<Block> ESRAH_TRAPDOOR = registerBlock("esrah_trapdoor",
            () -> new FlammableBlocks.Trapdoor(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f).noOcclusion().harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 300);
    public static final RegistryObject<Block> ESRAH_DOOR = registerBlock("esrah_door",
            () -> new FlammableBlocks.Door(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f).noOcclusion().harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 200);
    public static final RegistryObject<Block> ESRAH_FENCE = registerBlock("esrah_fence",
            () -> new FlammableBlocks.Fence(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f).noOcclusion().harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 300);
    public static final RegistryObject<Block> ESRAH_FENCE_GATE = registerBlock("esrah_fence_gate",
            () -> new FlammableBlocks.FenceGate(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f).noOcclusion().harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 300);
    public static final RegistryObject<Block> LAIS_STAIRS = registerBlock("lais_stairs",
            () -> new FlammableBlocks.Stairs(() -> CobrBlocks.LAIS_PLANKS.get().defaultBlockState(), Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f).noOcclusion().harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 300);
    public static final RegistryObject<Block> LAIS_SLAB = registerBlock("lais_slab",
            () -> new FlammableBlocks.Slab(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f).noOcclusion().harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 150);
    public static final RegistryObject<Block> LAIS_TRAPDOOR = registerBlock("lais_trapdoor",
            () -> new FlammableBlocks.Trapdoor(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f).noOcclusion().harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 300);
    public static final RegistryObject<Block> LAIS_DOOR = registerBlock("lais_door",
            () -> new FlammableBlocks.Door(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f).noOcclusion().harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 200);
    public static final RegistryObject<Block> LAIS_FENCE = registerBlock("lais_fence",
            () -> new FlammableBlocks.Fence(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f).noOcclusion().harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 300);
    public static final RegistryObject<Block> LAIS_FENCE_GATE = registerBlock("lais_fence_gate",
            () -> new FlammableBlocks.FenceGate(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f).noOcclusion().harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 300);
    //WOOD UTILS
    //[BUTTONS - PRESSURE PLATES - SIGNS]

    //TREE THINGIES
    //[LEAVES - SAPLINGS]
    public static final RegistryObject<Block> ESRAH_LEAVES = registerBlock("esrah_leaves",
            () -> new FlammableBlocks.Leaves(Block.Properties.of(Material.LEAVES).sound(SoundType.GRASS).strength(0.2f, 0.2f).noOcclusion().requiresCorrectToolForDrops().harvestTool(ToolType.HOE)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> ESRAH_SAPLING = registerBlock("esrah_sapling",
            () -> new Base.SaplingBlock(EsrahTree::new, AbstractBlock.Properties.copy(Blocks.ACACIA_SAPLING).noOcclusion()), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> LAIS_LEAVES = registerBlock("lais_leaves",
            () -> new FlammableBlocks.Leaves(Block.Properties.of(Material.LEAVES).sound(SoundType.GRASS).strength(0.2f, 0.2f).noOcclusion().requiresCorrectToolForDrops().harvestTool(ToolType.HOE)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> BLOOMING_LAIS_LEAVES = registerBlock("blooming_lais_leaves",
            () -> new FlammableBlocks.Leaves(Block.Properties.of(Material.LEAVES).sound(SoundType.GRASS).strength(0.2f, 0.2f).noOcclusion().requiresCorrectToolForDrops().harvestTool(ToolType.HOE)), CobrTab.COBR_TAB, 0);
    public static final RegistryObject<Block> LAIS_SAPLING = registerBlock("lais_sapling",
            () -> new Base.SaplingBlock(LaisTree::new, AbstractBlock.Properties.copy(Blocks.ACACIA_SAPLING).noOcclusion()), CobrTab.COBR_TAB, 0);

    //EMPIRE-RELATED
    public static final RegistryObject<Block> CIVILISATION_TABLE = registerBlock("civilisation_table",
            () -> new CivilisationTableBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 50f).harvestTool(ToolType.AXE)), CobrTab.COBR_TAB, 0);



    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, ItemGroup tab, int FuelTime) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, FuelTime);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, ItemGroup tab, int FuelTime) {
        return CobrItems.ITEMS.register (name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)) {
            @SubscribeEvent
            public void setBurnTime(FurnaceFuelBurnTimeEvent event) {
                event.setBurnTime(FuelTime);
            }
        });
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
