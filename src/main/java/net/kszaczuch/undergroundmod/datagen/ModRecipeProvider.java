package net.kszaczuch.undergroundmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kszaczuch.undergroundmod.block.ModBlocks;
import net.kszaczuch.undergroundmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
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
        offerReversibleCompactingRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.SHROOMITE_INGOT, RecipeCategory.DECORATIONS, ModBlocks.SHROOMITE_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BLUE_MUSHROOM)
                .input(Items.DIAMOND)
                .input(Items.BROWN_MUSHROOM)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.BROWN_MUSHROOM), conditionsFromItem(Items.BROWN_MUSHROOM))
                        .offerTo(consumer, new Identifier(getRecipeName(ModBlocks.BLUE_MUSHROOM)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE)
                .input(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .input(ModBlocks.BLUE_MUSHROOM)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModBlocks.BLUE_MUSHROOM), conditionsFromItem(ModBlocks.BLUE_MUSHROOM))
                        .offerTo(consumer, new Identifier(getRecipeName(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SHROOMITE_INGOT)
                .input(Items.DIAMOND)
                .input(Items.BROWN_MUSHROOM)
                .input(ModItems.CHLOROPHYTE_INGOT)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.BROWN_MUSHROOM), conditionsFromItem(Items.BROWN_MUSHROOM))
                .criterion(hasItem(ModItems.CHLOROPHYTE_INGOT), conditionsFromItem(ModItems.CHLOROPHYTE_INGOT))
                .offerTo(consumer, new Identifier("shroomite_ingot_from_items"));

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


        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CHLOROPHYTE_HELMET, 1)
                .pattern("SSS")
                .pattern("S S")
                .input('S', ModItems.CHLOROPHYTE_INGOT)
                .criterion(hasItem(ModItems.CHLOROPHYTE_INGOT), conditionsFromItem(ModItems.CHLOROPHYTE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.CHLOROPHYTE_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CHLOROPHYTE_CHESTPLATE, 1)
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModItems.CHLOROPHYTE_INGOT)
                .criterion(hasItem(ModItems.CHLOROPHYTE_INGOT), conditionsFromItem(ModItems.CHLOROPHYTE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.CHLOROPHYTE_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CHLOROPHYTE_LEGGINGS, 1)
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .input('S', ModItems.CHLOROPHYTE_INGOT)
                .criterion(hasItem(ModItems.CHLOROPHYTE_INGOT), conditionsFromItem(ModItems.CHLOROPHYTE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.CHLOROPHYTE_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CHLOROPHYTE_BOOTS, 1)
                .pattern("S S")
                .pattern("S S")
                .input('S', ModItems.CHLOROPHYTE_INGOT)
                .criterion(hasItem(ModItems.CHLOROPHYTE_INGOT), conditionsFromItem(ModItems.CHLOROPHYTE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.CHLOROPHYTE_BOOTS)));


        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE ),
                Ingredient.ofItems(ModItems.CHLOROPHYTE_HELMET),
                Ingredient.ofItems(ModItems.SHROOMITE_INGOT),
                RecipeCategory.MISC,
                ModItems.SHROOMITE_HELMET
        ).criterion(hasItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.CHLOROPHYTE_HELMET), conditionsFromItem(ModItems.CHLOROPHYTE_CHESTPLATE))
                .criterion(hasItem(ModItems.SHROOMITE_INGOT), conditionsFromItem(ModItems.SHROOMITE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SHROOMITE_HELMET)));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE ),
                Ingredient.ofItems(ModItems.CHLOROPHYTE_CHESTPLATE),
                Ingredient.ofItems(ModItems.SHROOMITE_INGOT),
                RecipeCategory.MISC,
                ModItems.SHROOMITE_CHESTPLATE
        ).criterion(hasItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.CHLOROPHYTE_CHESTPLATE), conditionsFromItem(ModItems.CHLOROPHYTE_CHESTPLATE))
                .criterion(hasItem(ModItems.SHROOMITE_INGOT), conditionsFromItem(ModItems.SHROOMITE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SHROOMITE_CHESTPLATE)));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE ),
                Ingredient.ofItems(ModItems.CHLOROPHYTE_LEGGINGS),
                Ingredient.ofItems(ModItems.SHROOMITE_INGOT),
                RecipeCategory.MISC,
                ModItems.SHROOMITE_LEGGINGS
        ).criterion(hasItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.CHLOROPHYTE_LEGGINGS), conditionsFromItem(ModItems.CHLOROPHYTE_LEGGINGS))
                .criterion(hasItem(ModItems.SHROOMITE_INGOT), conditionsFromItem(ModItems.SHROOMITE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SHROOMITE_LEGGINGS)));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE ),
                Ingredient.ofItems(ModItems.CHLOROPHYTE_BOOTS),
                Ingredient.ofItems(ModItems.SHROOMITE_INGOT),
                RecipeCategory.MISC,
                ModItems.SHROOMITE_BOOTS
        ).criterion(hasItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.CHLOROPHYTE_BOOTS), conditionsFromItem(ModItems.CHLOROPHYTE_BOOTS))
                .criterion(hasItem(ModItems.SHROOMITE_INGOT), conditionsFromItem(ModItems.SHROOMITE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SHROOMITE_BOOTS)));


        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE ),
                Ingredient.ofItems(ModItems.CHLOROPHYTE_AXE),
                Ingredient.ofItems(ModItems.SHROOMITE_INGOT),
                RecipeCategory.MISC,
                ModItems.SHROOMITE_AXE
        ).criterion(hasItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.CHLOROPHYTE_AXE), conditionsFromItem(ModItems.CHLOROPHYTE_AXE))
                .criterion(hasItem(ModItems.SHROOMITE_INGOT), conditionsFromItem(ModItems.SHROOMITE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SHROOMITE_AXE)));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE ),
                Ingredient.ofItems(ModItems.CHLOROPHYTE_SWORD),
                Ingredient.ofItems(ModItems.SHROOMITE_INGOT),
                RecipeCategory.MISC,
                ModItems.SHROOMITE_SWORD
        ).criterion(hasItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.CHLOROPHYTE_SWORD), conditionsFromItem(ModItems.CHLOROPHYTE_SWORD))
                .criterion(hasItem(ModItems.SHROOMITE_INGOT), conditionsFromItem(ModItems.SHROOMITE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SHROOMITE_SWORD)));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE ),
                Ingredient.ofItems(ModItems.CHLOROPHYTE_SHOVEL),
                Ingredient.ofItems(ModItems.SHROOMITE_INGOT),
                RecipeCategory.MISC,
                ModItems.SHROOMITE_SHOVEL
        ).criterion(hasItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.CHLOROPHYTE_SHOVEL), conditionsFromItem(ModItems.CHLOROPHYTE_SHOVEL))
                .criterion(hasItem(ModItems.SHROOMITE_INGOT), conditionsFromItem(ModItems.SHROOMITE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SHROOMITE_SHOVEL)));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE ),
                Ingredient.ofItems(ModItems.CHLOROPHYTE_PICKAXE),
                Ingredient.ofItems(ModItems.SHROOMITE_INGOT),
                RecipeCategory.MISC,
                ModItems.SHROOMITE_PICKAXE
        ).criterion(hasItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.CHLOROPHYTE_PICKAXE), conditionsFromItem(ModItems.CHLOROPHYTE_PICKAXE))
                .criterion(hasItem(ModItems.SHROOMITE_INGOT), conditionsFromItem(ModItems.SHROOMITE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SHROOMITE_PICKAXE)));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE ),
                Ingredient.ofItems(ModItems.CHLOROPHYTE_HOE),
                Ingredient.ofItems(ModItems.SHROOMITE_INGOT),
                RecipeCategory.MISC,
                ModItems.SHROOMITE_HOE
        ).criterion(hasItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.CHLOROPHYTE_HOE), conditionsFromItem(ModItems.CHLOROPHYTE_HOE))
                .criterion(hasItem(ModItems.SHROOMITE_INGOT), conditionsFromItem(ModItems.SHROOMITE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SHROOMITE_HOE)));
    }
}
