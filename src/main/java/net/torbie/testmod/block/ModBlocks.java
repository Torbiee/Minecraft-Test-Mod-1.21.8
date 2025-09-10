package net.torbie.testmod.block;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.torbie.testmod.TestMod;
import net.torbie.testmod.block.custom.CheeseFlowerBlock;
import net.torbie.testmod.block.custom.CheeseLampBlock;
import net.torbie.testmod.world.tree.ModSaplingGenerators;

import java.util.function.Function;

import static net.minecraft.entity.effect.StatusEffects.HASTE;

public class ModBlocks {
    public static void initialize() {}

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
            true);

    public static final Block CHEESE_ORE = registerBlock(
            "cheese_ore",
            settings -> new ExperienceDroppingBlock(UniformIntProvider.create(2,5), settings),
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.STONE)
                    .strength(2f)
                    .requiresTool(),
            true);

    public static final Block DEEPSLATE_CHEESE_ORE = registerBlock(
            "deepslate_cheese_ore",
            settings -> new ExperienceDroppingBlock(UniformIntProvider.create(3,6), settings),
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.DEEPSLATE)
                    .strength(3f)
                    .requiresTool(),
            true);

    public static final Block CHEESE_LAMP = registerBlock(
            "cheese_lamp",
             settings -> new CheeseLampBlock(settings.strength(1f).requiresTool().luminance(state -> state.get(CheeseLampBlock.CLICKED)? 15 : 0)),
            AbstractBlock.Settings.create(),
            true);

    public static final Block CHEESE_WOOD_LOG = registerBlock(
            "cheese_wood_log",
            PillarBlock::new,
            AbstractBlock.Settings.copy(Blocks.OAK_LOG)
                    .sounds(BlockSoundGroup.WOOD),
            true);
    public static final Block CHEESE_WOOD_WOOD = registerBlock(
            "cheese_wood_wood",
            PillarBlock::new,
            AbstractBlock.Settings.copy(Blocks.OAK_WOOD)
                    .sounds(BlockSoundGroup.WOOD),
            true);

    public static final Block STRIPPED_CHEESE_WOOD_LOG = registerBlock(
            "stripped_cheese_wood_log",
            PillarBlock::new,
            AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)
                    .sounds(BlockSoundGroup.WOOD),
            true);
    public static final Block STRIPPED_CHEESE_WOOD_WOOD = registerBlock(
            "stripped_cheese_wood_wood",
            PillarBlock::new,
            AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)
                    .sounds(BlockSoundGroup.WOOD),
            true);


    public static final Block CHEESE_WOOD_PLANKS = registerBlock(
            "cheese_wood_planks",
            PillarBlock::new,
            AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    .sounds(BlockSoundGroup.WOOD),
            true);
    public static final Block CHEESE_WOOD_LEAVES = registerBlock(
            "cheese_wood_leaves",
            settings -> new TintedParticleLeavesBlock(0.01f, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).sounds(BlockSoundGroup.AZALEA_LEAVES).nonOpaque().ticksRandomly(), true);



    public static final Block CHEESE_WOOD_SAPLING = registerBlock(
            "cheese_wood_sapling",
            settings -> new SaplingBlock(ModSaplingGenerators.CHEESE_WOOD, settings), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING), true);

    public static final Block CHEESE_FLOWER = registerBlock(
            "cheese_flower",
//            CheeseFlowerBlock::new,
//            AbstractBlock.Settings.copy(Blocks.POPPY), true);
            settings -> new CheeseFlowerBlock(HASTE, 5.0f, settings), AbstractBlock.Settings.copy(Blocks.POPPY), true);
//            settings -> new FlowerBlock(StatusEffects.HASTE, 5.0f, settings),
//            AbstractBlock.Settings.copy(Blocks.POPPY), true);

    public static final Block POTTED_CHEESE_FLOWER = registerBlock(
            "potted_cheese_flower",
            settings -> new FlowerPotBlock(CHEESE_FLOWER, settings),
            AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY), true);
}

