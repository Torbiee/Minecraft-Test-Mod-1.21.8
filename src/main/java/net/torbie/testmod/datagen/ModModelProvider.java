package net.torbie.testmod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.torbie.testmod.TestMod;
import net.torbie.testmod.block.ModBlocks;
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
