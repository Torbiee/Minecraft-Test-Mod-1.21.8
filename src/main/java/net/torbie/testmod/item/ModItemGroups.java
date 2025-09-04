package net.torbie.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
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
        });

        // Registering Custom Block Group
        Registry.register(Registries.ITEM_GROUP, CUSTOM_BLOCK_GROUP_KEY, CUSTOM_BLOCK_GROUP);

        ItemGroupEvents.modifyEntriesEvent(CUSTOM_BLOCK_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModBlocks.CHEESE_ORE);
            itemGroup.add(ModBlocks.CHEESE_BLOCK);
            itemGroup.add(ModBlocks.DEEPSLATE_CHEESE_ORE);
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
