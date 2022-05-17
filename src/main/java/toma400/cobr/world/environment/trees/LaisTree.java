package toma400.cobr.world.environment.trees;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import toma400.cobr.core.CobrBlocks;

import javax.annotation.Nullable;
import java.util.Random;

public class LaisTree extends Tree {

    private static final int BASE_HEIGHT = 3;
    private static final int FIRST_RANDOM_HEIGHT = 3;
    private static final int SECOND_RANDOM_HEIGHT = 5;

    private static final int LEAVE_RADIUS = 4;
    private static final int LEAVE_OFFSET = 3;
    private static final int LEAVE_HEIGHT = 3;

    public static final BaseTreeFeatureConfig LAIS_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(CobrBlocks.LAIS_LOG.get().defaultBlockState()),
            new SimpleBlockStateProvider(CobrBlocks.LAIS_LEAVES.get().defaultBlockState()),
            new BlobFoliagePlacer(FeatureSpread.fixed(LEAVE_RADIUS), FeatureSpread.fixed(LEAVE_OFFSET), LEAVE_HEIGHT),
            new StraightTrunkPlacer(BASE_HEIGHT, FIRST_RANDOM_HEIGHT, SECOND_RANDOM_HEIGHT),
            new TwoLayerFeature(1, 0, 1))
    ).build();

    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(Random random, boolean largeHive) {
        return Feature.TREE.configured(LAIS_TREE_CONFIG);
    }
}
