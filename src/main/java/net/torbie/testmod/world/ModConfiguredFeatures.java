package net.torbie.testmod.world;

import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.torbie.testmod.TestMod;
import net.torbie.testmod.block.ModBlocks;

import java.util.List;

import static net.minecraft.util.math.intprovider.UniformIntProvider.create;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> CHEESE_ORE_KEY = registerKey("cheese_ore");

    public static final RegistryKey<ConfiguredFeature<?,?>> CHEESE_WOOD_KEY = registerKey("cheese_wood");

    public static final RegistryKey<ConfiguredFeature<?,?>> CHEESE_FLOWER_KEY = registerKey("cheese_flower");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldCheeseOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.CHEESE_ORE.getDefaultState()),
                    OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_CHEESE_ORE.getDefaultState()));

        register(context, CHEESE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldCheeseOres, 7));

        register(context, CHEESE_FLOWER_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(
                64,6,2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CHEESE_FLOWER)))));

        register(context, CHEESE_WOOD_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.CHEESE_WOOD_LOG),
                new CherryTrunkPlacer(
                        7,
                        1,
                        0,
                        new WeightedListIntProvider(
                                Pool.<IntProvider>builder()
                                        .add(ConstantIntProvider.create(1), 1)
                                        .add(ConstantIntProvider.create(2), 1)
                                        .add(ConstantIntProvider.create(3), 1)
                                        .build()
                        ),
                        create(2, 4),
                        create(-4, -3),
                        create(-1, 0)
                ),
                BlockStateProvider.of(ModBlocks.CHEESE_WOOD_LEAVES),
                new CherryFoliagePlacer(
                        ConstantIntProvider.create(4),  // radius
                        ConstantIntProvider.create(0),  // offset
                        ConstantIntProvider.create(5),  // trunk height
                        0.25F, 0.5F, 0.16666667F, 0.33333334F
                ),
                new TwoLayersFeatureSize(1, 0, 2)
        ).build());
    }
    
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(TestMod.MOD_ID, name));

    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
