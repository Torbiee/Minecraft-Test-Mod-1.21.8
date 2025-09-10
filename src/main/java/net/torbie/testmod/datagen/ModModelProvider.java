package net.torbie.testmod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.torbie.testmod.TestMod;
import net.torbie.testmod.block.ModBlocks;
import net.torbie.testmod.block.custom.CheeseLampBlock;
import net.torbie.testmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHEESE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHEESE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_CHEESE_ORE);
        WeightedVariant offVariant = BlockStateModelGenerator.createWeightedVariant(
                TexturedModel.CUBE_ALL.upload(ModBlocks.CHEESE_LAMP, blockStateModelGenerator.modelCollector)
        );
        WeightedVariant onVariant = BlockStateModelGenerator.createWeightedVariant(
                blockStateModelGenerator.createSubModel(ModBlocks.CHEESE_LAMP,
                        "_on", Models.CUBE_ALL, TextureMap::all)
        );

        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockModelDefinitionCreator
                        .of(ModBlocks.CHEESE_LAMP)
                        .with(BlockStateModelGenerator.createBooleanModelMap(CheeseLampBlock.CLICKED, onVariant, offVariant))
        );

        blockStateModelGenerator.createLogTexturePool(ModBlocks.CHEESE_WOOD_LOG)
                .log(ModBlocks.CHEESE_WOOD_LOG)
                .wood(ModBlocks.CHEESE_WOOD_WOOD);

        blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_CHEESE_WOOD_LOG)
                .log(ModBlocks.STRIPPED_CHEESE_WOOD_LOG)
                .wood(ModBlocks.STRIPPED_CHEESE_WOOD_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHEESE_WOOD_PLANKS);
        blockStateModelGenerator.registerSingleton(ModBlocks.CHEESE_WOOD_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.CHEESE_WOOD_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.CHEESE_FLOWER, BlockStateModelGenerator.CrossType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_CHEESE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHEESE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHEESE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHEESE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHEESE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHEESE_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(ModItems.CHEESE_HELMET, RegistryKey.of(
                RegistryKey.ofRegistry((Identifier.ofVanilla("equipment_asset"))
                ), Identifier.of(TestMod.MOD_ID, "cheese")), ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.CHEESE_CHESTPLATE, RegistryKey.of(
                RegistryKey.ofRegistry((Identifier.ofVanilla("equipment_asset"))
                ), Identifier.of(TestMod.MOD_ID, "cheese")), ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.CHEESE_LEGGINGS, RegistryKey.of(
                RegistryKey.ofRegistry((Identifier.ofVanilla("equipment_asset"))
                ), Identifier.of(TestMod.MOD_ID, "cheese")), ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.CHEESE_BOOTS, RegistryKey.of(
                RegistryKey.ofRegistry((Identifier.ofVanilla("equipment_asset"))
                ), Identifier.of(TestMod.MOD_ID, "cheese")), ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
    }
}
