package net.torbie.testmod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.torbie.testmod.TestMod;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> INCORRECT_FOR_CHEESE_TOOL = createTag("incorrect_for_cheese_tool");
        public static final TagKey<Block> NEEDS_CHEESE_TOOL = createTag("needs_cheese_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TestMod.MOD_ID, name));
        }
    }
    public static class Items {

        public static final TagKey<Item> CHEESE_REPAIR_ITEMS = createTag("cheese_repair_items");
        public static final TagKey<Item> CHEESE_TOOLS = createTag("cheese_tools");
        public static final TagKey<Item> CHEESE_ARMOR = createTag("cheese_armor");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TestMod.MOD_ID, name));
        }
    }



}
