package toma400.cobr.world.features.trees;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;
import toma400.cobr.world.features.CobrConfigurableFeatures;

import java.util.Random;

public class LaisTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random pRandom, boolean pLargeHive) {
        return CobrConfigurableFeatures.LAIS_TREE;
    }
}
