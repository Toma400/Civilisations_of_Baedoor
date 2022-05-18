package toma400.cobr.core.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.item.Item;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.ValidationTracker;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.core.CobrItems;
import toma400.cobr.elements.blocks.templated.FlammableBlocks;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LootTablesGen {

    public static class LootTablesRedirector extends LootTableProvider {
        public LootTablesRedirector(DataGenerator pGenerator) {
            super(pGenerator);
        }

        @Override
        protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
            return ImmutableList.of(
                    Pair.of(CobrBlockLootTables::new, LootParameterSets.BLOCK)
            );
        }

        @Override
        protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationTracker) {
        }
    }

    //-----------------------------------------------------
    // BLOCK LOOT TABLES
    //-----------------------------------------------------

    public static class CobrBlockLootTables extends BlockLootTables {

        @Override
        protected void addTables() {
            blockIterator(CobrBlocks.BLOCKS.getEntries());
        }

        public void blockIterator(Collection<RegistryObject<Block>> blocks) {
            for (RegistryObject<Block> block : blocks) {

                //-------------------------------------------------
                // LEAVES
                //-------------------------------------------------
                if(block.get() instanceof FlammableBlocks.Leaves) {
                    String namingConvention = block.get().getRegistryName().getPath();
                    Block saplingProvided = Blocks.AIR;
                    if (namingConvention.contains("lais")) {
                        saplingProvided = CobrBlocks.LAIS_SAPLING.get();}
                    else if (namingConvention.contains("esrah")) {
                        saplingProvided = CobrBlocks.ESRAH_SAPLING.get();}
                    leavesGen(block.get(), saplingProvided, valuesReferenced.NORMAL_LEAVES_SAPLING_CHANCES);}
                //-------------------------------------------------
                // ORES
                //-------------------------------------------------
                else if (block.get() instanceof OreBlock) {
                    String namingConvention = block.get().getRegistryName().getPath();
                    Item itemProvided = block.get().asItem();
                    // -------------------------------------------------
                    // CUSTOM ORE DROPS
                    // If custom drop is not chosen, block will get
                    // silk-touched anyway (like pre-1.17 iron ore)
                    // -------------------------------------------------
                    if (namingConvention.contains("gold")) {
                        itemProvided = CobrItems.RAW_DUNE_GOLD.get();
                    } else if (namingConvention.contains("coal")) {
                        itemProvided = CobrItems.DUNE_COAL.get();
                    }
                    //-------------------------------------------------
                    oresGen(block.get(), itemProvided);}
                //-------------------------------------------------
                // DOORS
                //-------------------------------------------------
                else if (block.get() instanceof DoorBlock) {
                    add(block.get(), BlockLootTables::createDoorTable);
                }
                //-------------------------------------------------
                // REGULAR BLOCKS (DROP ITSELF)
                //-------------------------------------------------
                else {
                    dropSelf(block.get());
                }
            }
        }

        public static class valuesReferenced {
            public static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
        }

        //--------------------------------------------------------------------------------------------------------
        // GENERATION ACTORS
        // Used to simplify some unnecessary code spaghetti in methods above
        //--------------------------------------------------------------------------------------------------------
        public void leavesGen(Block blockProvided, Block saplingProvided, float[] dropChances) {
            this.add(blockProvided, (sTouch) -> {
                return createLeavesDrops(blockProvided, saplingProvided, valuesReferenced.NORMAL_LEAVES_SAPLING_CHANCES);});}
        public void oresGen(Block blockProvided, Item itemProvided) {
            this.add(blockProvided, (sTouch) -> {
                return createOreDrop(blockProvided, itemProvided);});}

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return ForgeRegistries.BLOCKS.getValues().stream().filter(b -> Objects.requireNonNull(b.getRegistryName()).getNamespace().equals(Cobr.MOD_ID)).collect(Collectors.toList());
        }
    }
}
