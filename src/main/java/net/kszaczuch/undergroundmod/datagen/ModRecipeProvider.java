package net.kszaczuch.undergroundmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kszaczuch.undergroundmod.block.ModBlocks;
import net.kszaczuch.undergroundmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;

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
    }
}
