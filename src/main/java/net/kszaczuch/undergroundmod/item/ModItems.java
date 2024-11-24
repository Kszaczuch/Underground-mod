package net.kszaczuch.undergroundmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kszaczuch.undergroundmod.UndergroundMod;
import net.kszaczuch.undergroundmod.block.ModBlocks;
import net.kszaczuch.undergroundmod.sound.ModSounds;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item STINGER = registerItem("stinger", new Item(new FabricItemSettings()));
    public static final Item CHLOROPHYTE_INGOT = registerItem("chlorophyte_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_CHLOROPHYTE = registerItem("raw_chlorophyte", new Item(new FabricItemSettings()));
    public static final Item SHROOMITE_INGOT = registerItem("shroomite_ingot", new Item(new FabricItemSettings()));
    public static final Item SHROOMITE_UPGRADE_SMITHING_TEMPLATE = registerItem("shroomite_upgrade_smithing_template", new Item(new FabricItemSettings()));

    public static final Item CHLOROPHYTE_PICKAXE = registerItem("chlorophyte_pickaxe",
            new PickaxeItem(ModToolMaterial.CHLOROPHYTE, 0, -2.6f, new FabricItemSettings()));
    public static final Item CHLOROPHYTE_SWORD = registerItem("chlorophyte_sword",
            new SwordItem(ModToolMaterial.CHLOROPHYTE, 3, -2.2f, new FabricItemSettings()));
    public static final Item CHLOROPHYTE_SHOVEL = registerItem("chlorophyte_shovel",
            new ShovelItem(ModToolMaterial.CHLOROPHYTE, 3, -2.8f, new FabricItemSettings()));
    public static final Item CHLOROPHYTE_HOE = registerItem("chlorophyte_hoe",
            new HoeItem(ModToolMaterial.CHLOROPHYTE, 1, 0.2f, new FabricItemSettings()));
    public static final Item CHLOROPHYTE_AXE = registerItem("chlorophyte_axe",
            new AxeItem(ModToolMaterial.CHLOROPHYTE, 4.5f, -2.8f, new FabricItemSettings()));
    public static final Item SHROOMITE_PICKAXE = registerItem("shroomite_pickaxe",
            new PickaxeItem(ModToolMaterial.SHROOMITE, 2, -2.6f, new FabricItemSettings()));
    public static final Item SHROOMITE_AXE = registerItem("shroomite_axe",
            new AxeItem(ModToolMaterial.SHROOMITE, 6.0f, -2.8f, new FabricItemSettings()));
    public static final Item SHROOMITE_SWORD = registerItem("shroomite_sword",
            new SwordItem(ModToolMaterial.SHROOMITE, 4, -2.2f, new FabricItemSettings()));
    public static final Item SHROOMITE_SHOVEL = registerItem("shroomite_shovel",
            new ShovelItem(ModToolMaterial.SHROOMITE, 2, -2.8f, new FabricItemSettings()));
    public static final Item SHROOMITE_HOE = registerItem("shroomite_hoe",
            new HoeItem(ModToolMaterial.SHROOMITE, -3, 0.2f, new FabricItemSettings()));

    public static final Item CHLOROPHYTE_HELMET = registerItem("chlorophyte_helmet",
            new ArmorItem(ModArmorMaterials.CHLOROPHYTE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item CHLOROPHYTE_CHESTPLATE = registerItem("chlorophyte_chestplate",
            new ArmorItem(ModArmorMaterials.CHLOROPHYTE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item CHLOROPHYTE_LEGGINGS = registerItem("chlorophyte_leggings",
            new ArmorItem(ModArmorMaterials.CHLOROPHYTE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item CHLOROPHYTE_BOOTS = registerItem("chlorophyte_boots",
            new ArmorItem(ModArmorMaterials.CHLOROPHYTE, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item SHROOMITE_HELMET = registerItem("shroomite_helmet",
            new ArmorItem(ModArmorMaterials.SHROOMITE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item SHROOMITE_CHESTPLATE = registerItem("shroomite_chestplate",
            new ArmorItem(ModArmorMaterials.SHROOMITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item SHROOMITE_LEGGINGS = registerItem("shroomite_leggings",
            new ArmorItem(ModArmorMaterials.SHROOMITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item SHROOMITE_BOOTS = registerItem("shroomite_boots",
            new ArmorItem(ModArmorMaterials.SHROOMITE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item JUNGLE_MUSIC_DISC = registerItem("jungle_music_disc",
            new MusicDiscItem(7, ModSounds.JUNGLE, new FabricItemSettings().maxCount(1), 164));
    public static final Item UNDERGROUND_JUNGLE_MUSIC_DISC = registerItem("underground_jungle_music_disc",
            new MusicDiscItem(7, ModSounds.UNDERGROUND_JUNGLE, new FabricItemSettings().maxCount(1), 108));
    public static final Item UNDERGROUND_ICE_MUSIC_DISC = registerItem("underground_ice_music_disc",
            new MusicDiscItem(7, ModSounds.UNDERGROUND_ICE, new FabricItemSettings().maxCount(1), 84));
    public static final Item UNDERGROUND_DESERT_MUSIC_DISC = registerItem("underground_desert_music_disc",
            new MusicDiscItem(7, ModSounds.UNDERGROUND_DESERT, new FabricItemSettings().maxCount(1), 121));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(STINGER);
        entries.add(ModBlocks.LIFE_FRUIT);
        entries.add(ModBlocks.SKY_BLUE_FLOWER);
        entries.add(ModBlocks.JUNGLE_SPORES);
        entries.add(RAW_CHLOROPHYTE);
        entries.add(CHLOROPHYTE_INGOT);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(UndergroundMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        UndergroundMod.LOGGER.info("Registering mod items for " + UndergroundMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
