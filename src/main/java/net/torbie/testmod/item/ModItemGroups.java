package net.torbie.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.torbie.testmod.TestMod;
import net.torbie.testmod.block.ModBlocks;


public class ModItemGroups {

    public static void initialize() {

        //Registering Custom Item Groups
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.CHEESE);
            itemGroup.add(ModItems.RAW_CHEESE);
            itemGroup.add(ModItems.CHEESE_SWORD);
            itemGroup.add(ModItems.CHEESE_PICKAXE);
            itemGroup.add(ModItems.CHEESE_AXE);
            itemGroup.add(ModItems.CHEESE_SHOVEL);
            itemGroup.add(ModItems.CHEESE_HOE);
            itemGroup.add(ModItems.CHEESE_HELMET);
            itemGroup.add(ModItems.CHEESE_CHESTPLATE);
            itemGroup.add(ModItems.CHEESE_LEGGINGS);
            itemGroup.add(ModItems.CHEESE_BOOTS);
            itemGroup.add(ModItems.RAT_SPAWN_EGG);
            itemGroup.add(ModItems.MOUSE_SPAWN_EGG);
        });

        // Registering Custom Block Group
        Registry.register(Registries.ITEM_GROUP, CUSTOM_BLOCK_GROUP_KEY, CUSTOM_BLOCK_GROUP);

        ItemGroupEvents.modifyEntriesEvent(CUSTOM_BLOCK_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModBlocks.CHEESE_ORE);
            itemGroup.add(ModBlocks.CHEESE_BLOCK);
            itemGroup.add(ModBlocks.DEEPSLATE_CHEESE_ORE);

            itemGroup.add(ModBlocks.CHEESE_LAMP);

            itemGroup.add(ModBlocks.CHEESE_WOOD_LOG);
            itemGroup.add(ModBlocks.CHEESE_WOOD_WOOD);
            itemGroup.add(ModBlocks.STRIPPED_CHEESE_WOOD_LOG);
            itemGroup.add(ModBlocks.STRIPPED_CHEESE_WOOD_WOOD);
            itemGroup.add(ModBlocks.CHEESE_WOOD_PLANKS);
            itemGroup.add(ModBlocks.CHEESE_WOOD_LEAVES);
            itemGroup.add(ModBlocks.CHEESE_WOOD_SAPLING);

            itemGroup.add(ModBlocks.CHEESE_FLOWER);
        });
    }
    // Creating an item class to store the item group and registry key for it
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY =
            RegistryKey.of(Registries.ITEM_GROUP.getKey(),
            Identifier.of(TestMod.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.CHEESE))
            .displayName(Text.translatable("itemGroup.cheese_items"))
            .build();

    public static final RegistryKey<ItemGroup> CUSTOM_BLOCK_GROUP_KEY =
            RegistryKey.of(Registries.ITEM_GROUP.getKey(),
                    Identifier.of(TestMod.MOD_ID, "block_group"));
    public static final ItemGroup CUSTOM_BLOCK_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.CHEESE_ORE))
            .displayName(Text.translatable("itemGroup.cheese_blocks"))
            .build();
}
