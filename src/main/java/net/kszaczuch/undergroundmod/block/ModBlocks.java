package net.kszaczuch.undergroundmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kszaczuch.undergroundmod.UndergroundMod;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;

public class ModBlocks {
    public static final Block CHLOROPHYTE_ORE = registerBlock("chlorophyte_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE), UniformIntProvider.create(4, 7)));
    public static final Block DEEPSLATE_CHLOROPHYTE_ORE = registerBlock("deepslate_chlorophyte_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE), UniformIntProvider.create(4, 7)));
    public static final Block LUMINITE_ORE = registerBlock("luminite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE), UniformIntProvider.create(5, 8)));

    public static final Block CHLOROPHYTE_BLOCK = registerBlock("chlorophyte_block",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
    public static final Block LUMINITE_BRICKS = registerBlock("luminite_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));
    public static final Block SHROOMITE_BLOCK = registerBlock("shroomite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.NETHERITE)));
    public static final Block BLUE_MUSHROOM = registerBlock("blue_mushroom",
            new MushroomPlantBlock(FabricBlockSettings.copyOf(Blocks.BROWN_MUSHROOM), TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM));

    public static final Block LIFE_FRUIT = registerBlock("life_fruit",
            new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.PEONY).nonOpaque().noCollision()));

    public static final Block SKY_BLUE_FLOWER = registerBlock("sky_blue_flower",
            new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.PEONY).nonOpaque().noCollision()));

    public static final Block JUNGLE_SPORES = registerBlock("jungle_spores",
            new PlantBlock(FabricBlockSettings.copyOf(Blocks.GRASS).nonOpaque().noCollision()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(UndergroundMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(UndergroundMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        UndergroundMod.LOGGER.info("Registering mod blocks for " + UndergroundMod.MOD_ID);
    }

}
