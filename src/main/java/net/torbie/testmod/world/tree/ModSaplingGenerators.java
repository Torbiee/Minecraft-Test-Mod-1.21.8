package net.torbie.testmod.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.torbie.testmod.TestMod;
import net.torbie.testmod.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator CHEESE_WOOD = new SaplingGenerator(TestMod.MOD_ID + "cheese_wood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.CHEESE_WOOD_KEY), Optional.empty());
}
