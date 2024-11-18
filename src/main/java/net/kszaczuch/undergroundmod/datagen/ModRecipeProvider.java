package net.kszaczuch.undergroundmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kszaczuch.undergroundmod.block.ModBlocks;
import net.kszaczuch.undergroundmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> CHLOROPHYTE_SMELTABLES = List.of(
            ModItems.RAW_CHLOROPHYTE, ModBlocks.CHLOROPHYTE_ORE, ModBlocks.DEEPSLATE_CHLOROPHYTE_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        offerSmelting(consumer, CHLOROPHYTE_SMELTABLES, RecipeCategory.MISC, ModItems.CHLOROPHYTE_INGOT, 1.0f, 200, "chlorophyte");
        offerBlasting(consumer, CHLOROPHYTE_SMELTABLES, RecipeCategory.MISC, ModItems.CHLOROPHYTE_INGOT, 1.0f, 100, "chlorophyte");
        offerReversibleCompactingRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.CHLOROPHYTE_INGOT, RecipeCategory.DECORATIONS, ModBlocks.CHLOROPHYTE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHLOROPHYTE_PICKAXE, 1)
                .pattern("SSS")
                .pattern(" R ")
                .pattern(" R ")
                .input('S', ModItems.CHLOROPHYTE_INGOT)
                .input('R', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.CHLOROPHYTE_INGOT), conditionsFromItem(ModItems.CHLOROPHYTE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.CHLOROPHYTE_PICKAXE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHLOROPHYTE_AXE, 1)
                .pattern("SS")
                .pattern("SR")
                .pattern(" R")
                .input('S', ModItems.CHLOROPHYTE_INGOT)
                .input('R', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.CHLOROPHYTE_INGOT), conditionsFromItem(ModItems.CHLOROPHYTE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.CHLOROPHYTE_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHLOROPHYTE_SWORD, 1)
                .pattern("S")
                .pattern("S")
                .pattern("R")
                .input('S', ModItems.CHLOROPHYTE_INGOT)
                .input('R', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.CHLOROPHYTE_INGOT), conditionsFromItem(ModItems.CHLOROPHYTE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.CHLOROPHYTE_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHLOROPHYTE_SHOVEL, 1)
                .pattern("S")
                .pattern("R")
                .pattern("R")
                .input('S', ModItems.CHLOROPHYTE_INGOT)
                .input('R', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.CHLOROPHYTE_INGOT), conditionsFromItem(ModItems.CHLOROPHYTE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.CHLOROPHYTE_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHLOROPHYTE_HOE, 1)
                .pattern("SS")
                .pattern(" R")
                .pattern(" R")
                .input('S', ModItems.CHLOROPHYTE_INGOT)
                .input('R', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.CHLOROPHYTE_INGOT), conditionsFromItem(ModItems.CHLOROPHYTE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.CHLOROPHYTE_HOE)));
    }
}
