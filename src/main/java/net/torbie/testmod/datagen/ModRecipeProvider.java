package net.torbie.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.torbie.testmod.block.ModBlocks;
import net.torbie.testmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {

                List<ItemConvertible> CHEESE_SMELTABLES = List.of(ModItems.RAW_CHEESE, ModBlocks.CHEESE_ORE, ModBlocks.DEEPSLATE_CHEESE_ORE);
                offerSmelting(CHEESE_SMELTABLES, RecipeCategory.MISC, ModItems.CHEESE, 1.0f, 200, "cheese");
                offerBlasting(CHEESE_SMELTABLES, RecipeCategory.MISC, ModItems.CHEESE, 1.0f, 100, "cheese");

                createShaped(RecipeCategory.MISC, ModBlocks.CHEESE_BLOCK, 1)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', ModItems.CHEESE)
                        .criterion(hasItem(ModItems.CHEESE), conditionsFromItem(ModItems.CHEESE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModBlocks.CHEESE_LAMP, 1)
                        .pattern("RRR")
                        .pattern("RAR")
                        .pattern("RRR")
                        .input('R', ModItems.CHEESE)
                        .input('A', Items.REDSTONE)
                        .criterion(hasItem(ModItems.CHEESE), conditionsFromItem(ModItems.CHEESE))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModItems.CHEESE, 9)
                        .input(ModBlocks.CHEESE_BLOCK)
                        .criterion(hasItem(ModBlocks.CHEESE_BLOCK), conditionsFromItem(ModBlocks.CHEESE_BLOCK))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, Items.ORANGE_DYE, 1)
                        .input(ModBlocks.CHEESE_FLOWER)
                                .criterion(hasItem(ModBlocks.CHEESE_FLOWER), conditionsFromItem(ModBlocks.CHEESE_FLOWER))
                                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.CHEESE_PICKAXE, 1)
                        .pattern("CCC")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('C', ModItems.CHEESE)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.CHEESE), conditionsFromItem(ModItems.CHEESE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.CHEESE_SWORD, 1)
                        .pattern(" C ")
                        .pattern(" C ")
                        .pattern(" S ")
                        .input('C', ModItems.CHEESE)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.CHEESE), conditionsFromItem(ModItems.CHEESE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.CHEESE_AXE, 1)
                        .pattern("CC ")
                        .pattern("CS ")
                        .pattern(" S ")
                        .input('C', ModItems.CHEESE)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.CHEESE), conditionsFromItem(ModItems.CHEESE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.CHEESE_SHOVEL, 1)
                        .pattern(" C ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('C', ModItems.CHEESE)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.CHEESE), conditionsFromItem(ModItems.CHEESE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.CHEESE_HOE, 1)
                        .pattern("CC ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('C', ModItems.CHEESE)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.CHEESE), conditionsFromItem(ModItems.CHEESE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.CHEESE_HELMET, 1)
                        .pattern("CCC")
                        .pattern("C C")
                        .pattern("   ")
                        .input('C', ModItems.CHEESE)
                        .criterion(hasItem(ModItems.CHEESE), conditionsFromItem(ModItems.CHEESE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.CHEESE_CHESTPLATE, 1)
                        .pattern("C C")
                        .pattern("CCC")
                        .pattern("CCC")
                        .input('C', ModItems.CHEESE)
                        .criterion(hasItem(ModItems.CHEESE), conditionsFromItem(ModItems.CHEESE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.CHEESE_LEGGINGS, 1)
                        .pattern("CCC")
                        .pattern("C C")
                        .pattern("C C")
                        .input('C', ModItems.CHEESE)
                        .criterion(hasItem(ModItems.CHEESE), conditionsFromItem(ModItems.CHEESE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.CHEESE_BOOTS, 1)
                        .pattern("   ")
                        .pattern("C C")
                        .pattern("C C")
                        .input('C', ModItems.CHEESE)
                        .criterion(hasItem(ModItems.CHEESE), conditionsFromItem(ModItems.CHEESE))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "TestMod Recipes";
    }
}
