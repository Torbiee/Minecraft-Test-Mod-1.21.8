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

import java.util.function.Function;

import static net.minecraft.util.math.intprovider.UniformIntProvider.*;

public class ModBlocks {

    public static void initialize() {
    }

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> blockFactory,AbstractBlock.Settings settings,boolean shouldRegisterItem) {
        // Create Registry Key for block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        //Create Block Instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        //Fail-safe incase don't want to register an item for the block
        if (shouldRegisterItem) {
            //registered items need to be a different key but ID can be the same
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(TestMod.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TestMod.MOD_ID, name));
    }

    public static final Block CHEESE_BLOCK = registerBlock(
            "cheese_block",
            Block::new,
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.MUD)
                    .strength(3f, 4f)
                    .requiresTool(),
            true
    );
    public static final Block CHEESE_ORE = registerBlock(
            "cheese_ore",
            settings -> new ExperienceDroppingBlock(UniformIntProvider.create(2,5), settings),
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.STONE)
                    .strength(2f)
                    .requiresTool(),
            true
    );
    public static final Block DEEPSLATE_CHEESE_ORE = registerBlock(
            "deepslate_cheese_ore",
            settings -> new ExperienceDroppingBlock(UniformIntProvider.create(3,6), settings),
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.DEEPSLATE)
                    .strength(3f)
                    .requiresTool(),
            true
    );


}

