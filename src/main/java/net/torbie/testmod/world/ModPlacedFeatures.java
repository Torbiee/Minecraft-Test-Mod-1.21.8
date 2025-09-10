package net.torbie.testmod.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.torbie.testmod.TestMod;
import net.torbie.testmod.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> CHEESE_ORE_PLACE_KEY = registryKey("cheese_ore_placed");
    public static final RegistryKey<PlacedFeature> CHEESE_WOOD_PLACED_KEY = registryKey("cheese_wood_placed");
    public static final RegistryKey<PlacedFeature> CHEESE_FLOWER_PLACED_KEY = registryKey("cheese_flower_placed");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, CHEESE_ORE_PLACE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CHEESE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

        register(context, CHEESE_WOOD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CHEESE_WOOD_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), ModBlocks.CHEESE_WOOD_SAPLING));

        register(context, CHEESE_FLOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CHEESE_FLOWER_KEY),
                List.of(
                        RarityFilterPlacementModifier.of(2),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        SquarePlacementModifier.of(),
                        BiomePlacementModifier.of()
                ));
    }

    public static RegistryKey<PlacedFeature> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(TestMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }



}
