package net.torbie.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.torbie.testmod.block.ModBlocks;
import net.torbie.testmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Blocks.NEEDS_CHEESE_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CHEESE_ORE)
                .add(ModBlocks.DEEPSLATE_CHEESE_ORE)
                .add(ModBlocks.CHEESE_BLOCK);

        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CHEESE_ORE)
                .add(ModBlocks.DEEPSLATE_CHEESE_ORE);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(Blocks.OBSIDIAN);


        valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.CHEESE_WOOD_LOG)
                .add(ModBlocks.CHEESE_WOOD_WOOD)
                .add(ModBlocks.STRIPPED_CHEESE_WOOD_LOG)
                .add(ModBlocks.STRIPPED_CHEESE_WOOD_WOOD);

        valueLookupBuilder(BlockTags.FLOWERS)
                .add(ModBlocks.CHEESE_FLOWER);
        valueLookupBuilder(BlockTags.BEE_ATTRACTIVE)
                .add(ModBlocks.CHEESE_FLOWER);
    }
}
