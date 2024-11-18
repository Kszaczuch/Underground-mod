package net.kszaczuch.undergroundmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kszaczuch.undergroundmod.block.ModBlocks;
import net.kszaczuch.undergroundmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHLOROPHYTE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHLOROPHYTE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_CHLOROPHYTE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.STINGER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHLOROPHYTE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_CHLOROPHYTE, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHLOROPHYTE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHLOROPHYTE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHLOROPHYTE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHLOROPHYTE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHLOROPHYTE_HOE, Models.HANDHELD);
    }
}
