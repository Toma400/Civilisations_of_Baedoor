package toma400.cobr.core.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import toma400.cobr.Cobr;
import toma400.cobr.core.CobrBlocks;
import toma400.cobr.elements.blocks.templated.DataGenHelper;
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
        protected @NotNull List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
            return ImmutableList.of(
                    Pair.of(BlockLootTables::new, LootContextParamSets.BLOCK)
            );
        }

        @Override
        protected void validate(@NotNull Map<ResourceLocation, LootTable> map, @NotNull ValidationContext validationContext) {
        }
    }

    public static class BlockLootTables extends BlockLoot {

        @Override
        protected void addTables() {
            blockIterator(CobrBlocks.BLOCKS.getEntries());
        }

        public void blockIterator(Collection<RegistryObject<Block>> blocks) {
            for (RegistryObject<Block> block : blocks) {
                if(block.get()
                        instanceof DataGenHelper.EachSideHorizontalBlock || block.get()
                        instanceof FlammableBlocks.FlammableStone) {
                    dropSelf(block.get());
                }
            }
        }

        @Override
        protected @NotNull Iterable<Block> getKnownBlocks() {
            return ForgeRegistries.BLOCKS.getValues().stream().filter(b -> Objects.requireNonNull(b.getRegistryName()).getNamespace().equals(Cobr.MOD_ID)).collect(Collectors.toList());
        }
    }
}