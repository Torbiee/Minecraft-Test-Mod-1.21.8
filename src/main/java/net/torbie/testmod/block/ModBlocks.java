package net.torbie.testmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.torbie.testmod.TestMod;

public class ModBlocks {

    public static Block CHEESE_BLOCK;
    public static Block CHEESE_ORE;
    public static Block DEEPSLATE_CHEESE_ORE;

    private static Block registerBlock(String name, Block block) {
        Identifier id = Identifier.of(TestMod.MOD_ID, name);
        Block registeredBlock = Registry.register(Registries.BLOCK, id, block);
        Item.Settings itemSettings = new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, id));
        Registry.register(Registries.ITEM, id, new BlockItem(registeredBlock, itemSettings));

        return registeredBlock;
    }

    public static void registerModBlocks() {
        TestMod.LOGGER.info("Registering Mod Blocks for " + TestMod.MOD_ID);


            CHEESE_BLOCK = registerBlock("cheese_block",
                    new Block(AbstractBlock.Settings.create()
                            .strength(3f,4f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.MUD)
                            .registryKey(RegistryKey.of(Registries.BLOCK.getKey(), Identifier.of(TestMod.MOD_ID, "cheese_block")))));

            CHEESE_ORE = registerBlock("cheese_ore",
                    new ExperienceDroppingBlock(
                            UniformIntProvider.create(2,5),
                            AbstractBlock.Settings.create()
                                    .strength(2f)
                                    .requiresTool()
                                    .sounds(BlockSoundGroup.STONE)
                                    .registryKey(RegistryKey.of(Registries.BLOCK.getKey(), Identifier.of(TestMod.MOD_ID, "cheese_ore")))));

            DEEPSLATE_CHEESE_ORE = registerBlock("deepslate_cheese_ore",
                    new ExperienceDroppingBlock(
                            UniformIntProvider.create(3,6),
                            AbstractBlock.Settings.create()
                                    .strength(3f)
                                    .requiresTool()
                                    .sounds(BlockSoundGroup.DEEPSLATE)
                                    .registryKey(RegistryKey.of(Registries.BLOCK.getKey(), Identifier.of(TestMod.MOD_ID, "deepslate_cheese_ore")))));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(CHEESE_BLOCK);
            entries.add(CHEESE_ORE);
            entries.add(DEEPSLATE_CHEESE_ORE);
        });
    }





    //    public static final Block CHEESE_BLOCK = registerBlock(
//            "cheese_block",
//            new Block(AbstractBlock.Settings.create()
//                    .strength(3f, 4f)
//                    .requiresTool()
//                    .sounds(BlockSoundGroup.MUD)));
//
//    public static final Block CHEESE_ORE = registerBlock(
//            "cheese_ore",
//            new ExperienceDroppingBlock(
//                    UniformIntProvider.create(2, 5),
//                    AbstractBlock.Settings.create()
//                            .strength(2f)
//                            .requiresTool()
//                            .sounds(BlockSoundGroup.MUD)));
//
//    public static final Block DEEPSLATE_CHEESE_ORE = registerBlock(
//            "deepslate_cheese_ore",
//            new ExperienceDroppingBlock(
//                    UniformIntProvider.create(0, 2),
//                    AbstractBlock.Settings.create()
//                            .strength(3f)
//                            .requiresTool()
//                            .sounds(BlockSoundGroup.MUD)));
//
//    private static Block registerBlock(String name, Block block) {
//        Identifier id = Identifier.of(TestMod.MOD_ID, name);
//        Registry.register(Registries.BLOCK, id, block);
//        registerBlockItem(id, block);
//        return block;
//    }
//
//    private static void registerBlockItem(Identifier id, Block block) {
//        BlockItem item = new BlockItem(block, new Item.Settings());
//        Registry.register(Registries.ITEM, id, item);
//    }
//
//
//
//
//
//    public static void registerModBlocks() {
//        TestMod.LOGGER.info("Registering Mod Blocks for " + TestMod.MOD_ID);
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
//            entries.add(CHEESE_BLOCK);
//            entries.add(CHEESE_ORE);
//            entries.add(DEEPSLATE_CHEESE_ORE);
//        });
//    };
}
