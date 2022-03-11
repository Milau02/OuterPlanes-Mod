package ml.milau.outerplanes.world.feature;

import com.google.common.collect.ImmutableList;
import ml.milau.outerplanes.block.ModBlocks;
import ml.milau.outerplanes.world.feature.tree.decorators.RootedDecorator;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.DarkOakFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;

import java.util.OptionalInt;

public class ModConfiguredFeatures {
    public static final Holder<ConfiguredFeature<TreeConfiguration,?>> SOULTREE_TREE =
            FeatureUtils.register("soultree_tree", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.SOULTREE_LOG.get()),
                    new DarkOakTrunkPlacer(6,2,1),
                    BlockStateProvider.simple(ModBlocks.SOULTREE_LEAVES.get()),
                    new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),
                    new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())
                    ).decorators(ImmutableList.of(new RootedDecorator(BlockStateProvider.simple(ModBlocks.SOULTREE_ROOT.get())))).build()
            );
    public static final Holder<? extends ConfiguredFeature<?,?>> ASTRAL_TREE = FeatureUtils.register("astral_tree", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.ASTRAL_LOG.get()),
                    new DarkOakTrunkPlacer(6,2,1),
                    BlockStateProvider.simple(ModBlocks.ASTRAL_LEAVES.get()),
                    new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),
                    new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())
            ).decorators(ImmutableList.of(new RootedDecorator(BlockStateProvider.simple(ModBlocks.ASTRAL_ROOT.get())))).build()
    );
}
