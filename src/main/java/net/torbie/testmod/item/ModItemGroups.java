package net.torbie.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.torbie.testmod.TestMod;
import net.torbie.testmod.block.ModBlocks;


public class ModItemGroups {

    public static final ItemGroup CHEESE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(TestMod.MOD_ID, "cheese_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CHEESE))
                    .displayName(Text.translatable("itemgroup.testmod.cheese_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_CHEESE);
                        entries.add(ModItems.CHEESE);
                    })

                    .build());
    public static final ItemGroup CHEESE_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(TestMod.MOD_ID, "cheese_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.CHEESE_ORE))
                    .displayName(Text.translatable("itemgroup.testmod.cheese_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.CHEESE_BLOCK);
                        entries.add(ModBlocks.CHEESE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_CHEESE_ORE);
                    })

                    .build());





    public static void registerItemGroups() {
        TestMod.LOGGER.info("Registering Item Groups for " + TestMod.MOD_ID);
    }
}
