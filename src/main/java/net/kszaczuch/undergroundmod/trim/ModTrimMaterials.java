package net.kszaczuch.undergroundmod.trim;

import net.kszaczuch.undergroundmod.UndergroundMod;
import net.kszaczuch.undergroundmod.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.item.trim.ArmorTrimMaterials;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class ModTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial>  CHLOROPHYTE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(UndergroundMod.MOD_ID, "chlorophyte"));
    public static final RegistryKey<ArmorTrimMaterial>  SHROOMITE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(UndergroundMod.MOD_ID, "shroomite"));
    public static final RegistryKey<ArmorTrimMaterial>  LAST_PRISM = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(UndergroundMod.MOD_ID, "last_prism"));
    public static final RegistryKey<ArmorTrimMaterial>  LUMINITE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(UndergroundMod.MOD_ID, "luminite"));
    public static final RegistryKey<ArmorTrimMaterial>  SOLAR = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(UndergroundMod.MOD_ID, "solar"));
    public static final RegistryKey<ArmorTrimMaterial>  STARDUST = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(UndergroundMod.MOD_ID, "stardust"));
    public static final RegistryKey<ArmorTrimMaterial>  NEBULA = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(UndergroundMod.MOD_ID, "nebula"));
    public static final RegistryKey<ArmorTrimMaterial>  VORTEX = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(UndergroundMod.MOD_ID, "vortex"));

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable) {
        register(registerable, CHLOROPHYTE, Registries.ITEM.getEntry(ModItems.CHLOROPHYTE_INGOT),
                Style.EMPTY.withColor(TextColor.parse("#5dbe08")), 0.7f);
        register(registerable, SHROOMITE, Registries.ITEM.getEntry(ModItems.SHROOMITE_INGOT),
                Style.EMPTY.withColor(TextColor.parse("#2c1ae9")), 0.9f);
        register(registerable, LAST_PRISM, Registries.ITEM.getEntry(ModItems.LAST_PRISM),
                Style.EMPTY.withColor(TextColor.parse("#e1cee3")), 0.1f);
        register(registerable, LUMINITE, Registries.ITEM.getEntry(ModItems.LUMINITE_INGOT),
                Style.EMPTY.withColor(TextColor.parse("#45a777")), 0.7f);
        register(registerable, SOLAR, Registries.ITEM.getEntry(ModItems.SOLAR_FRAGMENT),
                Style.EMPTY.withColor(TextColor.parse("#f99b22")), 0.6f);
        register(registerable, STARDUST, Registries.ITEM.getEntry(ModItems.STARDUST_FRAGMENT),
                Style.EMPTY.withColor(TextColor.parse("#09a6ff")), 0.9f);
        register(registerable, NEBULA, Registries.ITEM.getEntry(ModItems.NEBULA_FRAGMENT),
                Style.EMPTY.withColor(TextColor.parse("#ff36ff")), 1.0f);
        register(registerable, VORTEX, Registries.ITEM.getEntry(ModItems.VORTEX_FRAGMENT),
                Style.EMPTY.withColor(TextColor.parse("#22dd97")), 0.8f);
    }


    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimKey,
                                 RegistryEntry<Item> item, Style style, float itemModelIndex) {
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(armorTrimKey.getValue().getPath(), item, itemModelIndex, Map.of(),
                Text.translatable(Util.createTranslationKey("trim_material", armorTrimKey.getValue())).fillStyle(style));

        registerable.register(armorTrimKey, trimMaterial);
    }
}
