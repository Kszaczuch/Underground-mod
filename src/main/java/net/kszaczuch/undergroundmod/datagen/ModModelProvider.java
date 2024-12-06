package net.kszaczuch.undergroundmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kszaczuch.undergroundmod.block.ModBlocks;
import net.kszaczuch.undergroundmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHLOROPHYTE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SHROOMITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LUMINITE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHLOROPHYTE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LUMINITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_CHLOROPHYTE_ORE);
        blockStateModelGenerator.registerTintableCross(ModBlocks.BLUE_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.STINGER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHLOROPHYTE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_CHLOROPHYTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHROOMITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHROOMITE_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LUMINITE_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LUMINITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_LUMINITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAST_PRISM, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOLAR_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARDUST_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.NEBULA_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.VORTEX_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.LUMINITE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.LUMINITE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LUMINITE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.LUMINITE_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.JUNGLE_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNDERGROUND_JUNGLE_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNDERGROUND_DESERT_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNDERGROUND_ICE_MUSIC_DISC, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHLOROPHYTE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHLOROPHYTE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHLOROPHYTE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHLOROPHYTE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CHLOROPHYTE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHROOMITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHROOMITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHROOMITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHROOMITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHROOMITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LUMINITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LUMINITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LUMINITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LUMINITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LUMINITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SOLAR_HOE, Models.HANDHELD);


        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CHLOROPHYTE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CHLOROPHYTE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CHLOROPHYTE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CHLOROPHYTE_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SHROOMITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SHROOMITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SHROOMITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SHROOMITE_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SOLAR_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SOLAR_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SOLAR_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SOLAR_BOOTS));
    }
}
