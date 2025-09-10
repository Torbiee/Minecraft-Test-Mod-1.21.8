package net.torbie.testmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.FireBlock;
import net.torbie.testmod.block.ModBlocks;
import net.torbie.testmod.item.ModItemGroups;
import net.torbie.testmod.item.ModItems;
import net.torbie.testmod.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "testmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.initialize();
        ModBlocks.initialize();
        ModItemGroups.initialize();
        ModWorldGeneration.generateModWorldGen();


        StrippableBlockRegistry.register(ModBlocks.CHEESE_WOOD_LOG, ModBlocks.STRIPPED_CHEESE_WOOD_LOG);
        StrippableBlockRegistry.register(ModBlocks.CHEESE_WOOD_WOOD, ModBlocks.STRIPPED_CHEESE_WOOD_WOOD);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHEESE_WOOD_LOG, 5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHEESE_WOOD_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CHEESE_WOOD_LOG,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_CHEESE_WOOD_WOOD,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHEESE_WOOD_PLANKS, 5,20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CHEESE_WOOD_LEAVES,30,60);

	}

}