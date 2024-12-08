package net.kszaczuch.undergroundmod.world;

import net.kszaczuch.undergroundmod.UndergroundMod;
import net.kszaczuch.undergroundmod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> CHLOROPHYTE_ORE_KEY = registerKey("chlorophyte_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUMINITE_ORE_KEY = registerKey("luminite_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldChlorophyteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.CHLOROPHYTE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_CHLOROPHYTE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> LuminiteOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, ModBlocks.LUMINITE_ORE.getDefaultState()));

        register(context, CHLOROPHYTE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldChlorophyteOres, 6));
        register(context, LUMINITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(LuminiteOres, 5));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(UndergroundMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
