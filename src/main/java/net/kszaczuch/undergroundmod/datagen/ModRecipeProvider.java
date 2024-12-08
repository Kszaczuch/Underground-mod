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
    private static final List<ItemConvertible> LUMINITE_SMELTABLES = List.of(
            ModItems.RAW_LUMINITE, ModBlocks.LUMINITE_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        offerSmelting(consumer, CHLOROPHYTE_SMELTABLES, RecipeCategory.MISC, ModItems.CHLOROPHYTE_INGOT, 1.0f, 200, "chlorophyte");
        offerBlasting(consumer, CHLOROPHYTE_SMELTABLES, RecipeCategory.MISC, ModItems.CHLOROPHYTE_INGOT, 1.0f, 100, "chlorophyte");
        offerSmelting(consumer, LUMINITE_SMELTABLES, RecipeCategory.MISC, ModItems.LUMINITE_INGOT, 2.0f, 200, "luminite");
        offerBlasting(consumer, LUMINITE_SMELTABLES, RecipeCategory.MISC, ModItems.LUMINITE_INGOT, 2.0f, 100, "luminite");
        offerReversibleCompactingRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.CHLOROPHYTE_INGOT, RecipeCategory.DECORATIONS, ModBlocks.CHLOROPHYTE_BLOCK);
        offerReversibleCompactingRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.SHROOMITE_INGOT, RecipeCategory.DECORATIONS, ModBlocks.SHROOMITE_BLOCK);
        offerReversibleCompactingRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.LUMINITE_INGOT, RecipeCategory.DECORATIONS, ModBlocks.LUMINITE_BRICKS);

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

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SOLAR_FRAGMENT)
                .input(Items.BLAZE_POWDER)
                .input(Items.NETHER_STAR)
                .criterion(hasItem(Items.BLAZE_POWDER), conditionsFromItem(Items.BLAZE_POWDER))
                .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                        .offerTo(consumer, new Identifier(getRecipeName(ModItems.SOLAR_FRAGMENT)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STARDUST_FRAGMENT)
                .input(Items.GLOW_INK_SAC)
                .input(Items.NETHER_STAR)
                .criterion(hasItem(Items.GLOW_INK_SAC), conditionsFromItem(Items.GLOW_INK_SAC))
                .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                        .offerTo(consumer, new Identifier(getRecipeName(ModItems.STARDUST_FRAGMENT)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NEBULA_FRAGMENT)
                .input(Items.AMETHYST_SHARD)
                .input(Items.NETHER_STAR)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                        .offerTo(consumer, new Identifier(getRecipeName(ModItems.NEBULA_FRAGMENT)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VORTEX_FRAGMENT)
                .input(Items.ENDER_PEARL)
                .input(Items.NETHER_STAR)
                .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                        .offerTo(consumer, new Identifier(getRecipeName(ModItems.VORTEX_FRAGMENT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAST_PRISM, 1)
                .pattern(" S ")
                .pattern("VLD")
                .pattern(" N ")
                .input('S', ModItems.SOLAR_FRAGMENT)
                .input('V', ModItems.VORTEX_FRAGMENT)
                .input('D', ModItems.STARDUST_FRAGMENT)
                .input('N', ModItems.NEBULA_FRAGMENT)
                .input('L', ModItems.LUMINITE_INGOT)
                .criterion(hasItem(ModItems.SOLAR_FRAGMENT), conditionsFromItem(ModItems.SOLAR_FRAGMENT))
                .criterion(hasItem(ModItems.VORTEX_FRAGMENT), conditionsFromItem(ModItems.VORTEX_FRAGMENT))
                .criterion(hasItem(ModItems.STARDUST_FRAGMENT), conditionsFromItem(ModItems.STARDUST_FRAGMENT))
                .criterion(hasItem(ModItems.NEBULA_FRAGMENT), conditionsFromItem(ModItems.NEBULA_FRAGMENT))
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.LAST_PRISM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE, 2)
                .pattern(" I ")
                .pattern("INI")
                .pattern(" I ")
                .input('I', ModItems.LUMINITE_INGOT)
                .input('N', ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE)
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .criterion(hasItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE))
                .offerTo(consumer, new Identifier("luminite_upgrade_template_from_duplicating"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE, 1)
                .pattern("ILI")
                .pattern("INI")
                .pattern("III")
                .input('L', ModItems.LAST_PRISM)
                .input('I', ModItems.LUMINITE_INGOT)
                .input('N', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .criterion(hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .criterion(hasItem(ModItems.LAST_PRISM), conditionsFromItem(ModItems.LAST_PRISM))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE)));

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


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LUMINITE_PICKAXE, 1)
                .pattern("SSS")
                .pattern(" R ")
                .pattern(" R ")
                .input('S', ModItems.LUMINITE_INGOT)
                .input('R', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.LUMINITE_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LUMINITE_AXE, 1)
                .pattern("SS")
                .pattern("SR")
                .pattern(" R")
                .input('S', ModItems.LUMINITE_INGOT)
                .input('R', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.LUMINITE_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LUMINITE_SWORD, 1)
                .pattern("S")
                .pattern("S")
                .pattern("R")
                .input('S', ModItems.LUMINITE_INGOT)
                .input('R', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.LUMINITE_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LUMINITE_SHOVEL, 1)
                .pattern("S")
                .pattern("R")
                .pattern("R")
                .input('S', ModItems.LUMINITE_INGOT)
                .input('R', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.LUMINITE_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LUMINITE_HOE, 1)
                .pattern("SS")
                .pattern(" R")
                .pattern(" R")
                .input('S', ModItems.LUMINITE_INGOT)
                .input('R', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.LUMINITE_HOE)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMINITE_HELMET, 1)
                .pattern("SSS")
                .pattern("S S")
                .input('S', ModItems.LUMINITE_INGOT)
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.LUMINITE_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMINITE_CHESTPLATE, 1)
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModItems.LUMINITE_INGOT)
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.LUMINITE_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMINITE_LEGGINGS, 1)
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .input('S', ModItems.LUMINITE_INGOT)
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.LUMINITE_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUMINITE_BOOTS, 1)
                .pattern("S S")
                .pattern("S S")
                .input('S', ModItems.LUMINITE_INGOT)
                .criterion(hasItem(ModItems.LUMINITE_INGOT), conditionsFromItem(ModItems.LUMINITE_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.LUMINITE_BOOTS)));



        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE ),
                Ingredient.ofItems(ModItems.CHLOROPHYTE_HELMET),
                Ingredient.ofItems(ModItems.SHROOMITE_INGOT),
                RecipeCategory.MISC,
                ModItems.SHROOMITE_HELMET
        ).criterion(hasItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.CHLOROPHYTE_HELMET), conditionsFromItem(ModItems.CHLOROPHYTE_HELMET))
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


        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE ),
                Ingredient.ofItems(ModItems.LUMINITE_HELMET),
                Ingredient.ofItems(ModItems.SOLAR_FRAGMENT),
                RecipeCategory.MISC,
                ModItems.SOLAR_HELMET
        ).criterion(hasItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.LUMINITE_HELMET), conditionsFromItem(ModItems.LUMINITE_HELMET))
                .criterion(hasItem(ModItems.SOLAR_FRAGMENT), conditionsFromItem(ModItems.SOLAR_FRAGMENT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SOLAR_HELMET)));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.LUMINITE_CHESTPLATE),
                Ingredient.ofItems(ModItems.SOLAR_FRAGMENT),
                RecipeCategory.MISC,
                ModItems.SOLAR_CHESTPLATE
        ).criterion(hasItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.LUMINITE_CHESTPLATE), conditionsFromItem(ModItems.LUMINITE_CHESTPLATE))
                .criterion(hasItem(ModItems.SOLAR_FRAGMENT), conditionsFromItem(ModItems.SOLAR_FRAGMENT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SOLAR_CHESTPLATE)));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.LUMINITE_LEGGINGS),
                Ingredient.ofItems(ModItems.SOLAR_FRAGMENT),
                RecipeCategory.MISC,
                ModItems.SOLAR_LEGGINGS
        ).criterion(hasItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.LUMINITE_LEGGINGS), conditionsFromItem(ModItems.LUMINITE_LEGGINGS))
                .criterion(hasItem(ModItems.SOLAR_FRAGMENT), conditionsFromItem(ModItems.SOLAR_FRAGMENT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SOLAR_LEGGINGS)));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.LUMINITE_BOOTS),
                Ingredient.ofItems(ModItems.SOLAR_FRAGMENT),
                RecipeCategory.MISC,
                ModItems.SOLAR_BOOTS
        ).criterion(hasItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.LUMINITE_BOOTS), conditionsFromItem(ModItems.LUMINITE_BOOTS))
                .criterion(hasItem(ModItems.SOLAR_FRAGMENT), conditionsFromItem(ModItems.SOLAR_FRAGMENT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SOLAR_BOOTS)));


        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.LUMINITE_AXE),
                Ingredient.ofItems(ModItems.SOLAR_FRAGMENT),
                RecipeCategory.MISC,
                ModItems.SOLAR_AXE
        ).criterion(hasItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.LUMINITE_AXE), conditionsFromItem(ModItems.LUMINITE_AXE))
                .criterion(hasItem(ModItems.SOLAR_FRAGMENT), conditionsFromItem(ModItems.SOLAR_FRAGMENT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SOLAR_AXE)));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.LUMINITE_SWORD),
                Ingredient.ofItems(ModItems.SOLAR_FRAGMENT),
                RecipeCategory.MISC,
                ModItems.SOLAR_SWORD
        ).criterion(hasItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.LUMINITE_SWORD), conditionsFromItem(ModItems.LUMINITE_SWORD))
                .criterion(hasItem(ModItems.SOLAR_FRAGMENT), conditionsFromItem(ModItems.SOLAR_FRAGMENT ))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SOLAR_SWORD)));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.LUMINITE_SHOVEL),
                Ingredient.ofItems(ModItems.SOLAR_FRAGMENT),
                RecipeCategory.MISC,
                ModItems.SOLAR_SHOVEL
        ).criterion(hasItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.LUMINITE_SHOVEL), conditionsFromItem(ModItems.LUMINITE_SHOVEL))
                .criterion(hasItem(ModItems.SOLAR_FRAGMENT), conditionsFromItem(ModItems.SOLAR_FRAGMENT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SOLAR_SHOVEL)));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.LUMINITE_PICKAXE),
                Ingredient.ofItems(ModItems.SOLAR_FRAGMENT),
                RecipeCategory.MISC,
                ModItems.SOLAR_PICKAXE
        ).criterion(hasItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.LUMINITE_PICKAXE), conditionsFromItem(ModItems.LUMINITE_PICKAXE))
                .criterion(hasItem(ModItems.SOLAR_FRAGMENT), conditionsFromItem(ModItems.SOLAR_FRAGMENT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SOLAR_PICKAXE)));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(ModItems.LUMINITE_HOE),
                Ingredient.ofItems(ModItems.SOLAR_FRAGMENT),
                RecipeCategory.MISC,
                ModItems.SOLAR_HOE
        ).criterion(hasItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE), conditionsFromItem(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.LUMINITE_HOE), conditionsFromItem(ModItems.LUMINITE_HOE))
                .criterion(hasItem(ModItems.SOLAR_FRAGMENT), conditionsFromItem(ModItems.SOLAR_FRAGMENT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.SOLAR_HOE)));
    }
}
