package net.torbie.testmod;

import net.fabricmc.api.ModInitializer;

import net.torbie.testmod.block.ModBlocks;
import net.torbie.testmod.item.ModItemGroups;
import net.torbie.testmod.item.ModItems;
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


	}

}