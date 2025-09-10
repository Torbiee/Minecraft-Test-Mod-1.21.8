package net.torbie.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.torbie.testmod.block.ModBlocks;
import net.torbie.testmod.item.ModItems;
import net.torbie.testmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
//Ingredients
        valueLookupBuilder(ModTags.Items.CHEESE_REPAIR_ITEMS)
                .add(ModItems.CHEESE)
                .add(ModItems.RAW_CHEESE);
//Armor
        valueLookupBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.CHEESE_HELMET);
        valueLookupBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.CHEESE_CHESTPLATE);
        valueLookupBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.CHEESE_LEGGINGS);
        valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.CHEESE_BOOTS);
// Items
        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.CHEESE_SWORD);
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.CHEESE_PICKAXE);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.CHEESE_SHOVEL);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.CHEESE_AXE);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.CHEESE_HOE);
// Blocks

        valueLookupBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.CHEESE_WOOD_LOG.asItem())
                .add(ModBlocks.CHEESE_WOOD_WOOD.asItem())
                .add(ModBlocks.STRIPPED_CHEESE_WOOD_LOG.asItem())
                .add(ModBlocks.STRIPPED_CHEESE_WOOD_WOOD.asItem());

        valueLookupBuilder(ItemTags.PLANKS)
                .add(ModBlocks.CHEESE_WOOD_PLANKS.asItem());

        valueLookupBuilder(ItemTags.FLOWERS)
                .add(ModBlocks.CHEESE_FLOWER.asItem());
    }
}
