package net.kszaczuch.undergroundmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kszaczuch.undergroundmod.UndergroundMod;
import net.kszaczuch.undergroundmod.block.ModBlocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item STINGER = registerItem("stinger", new Item(new FabricItemSettings()));
    public static final Item CHLOROPHYTE_INGOT = registerItem("chlorophyte_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_CHLOROPHYTE = registerItem("raw_chlorophyte", new Item(new FabricItemSettings()));

    public static final Item CHLOROPHYTE_PICKAXE = registerItem("chlorophyte_pickaxe",
            new PickaxeItem(ModToolMaterial.CHLOROPHYTE, 2, 0.5f, new FabricItemSettings()));
    public static final Item CHLOROPHYTE_SWORD = registerItem("chlorophyte_sword",
            new SwordItem(ModToolMaterial.CHLOROPHYTE, 7, 1.6f, new FabricItemSettings()));
    public static final Item CHLOROPHYTE_SHOVEL = registerItem("chlorophyte_shovel",
            new ShovelItem(ModToolMaterial.CHLOROPHYTE, 3, 0.5f, new FabricItemSettings()));
    public static final Item CHLOROPHYTE_HOE = registerItem("chlorophyte_hoe",
            new HoeItem(ModToolMaterial.CHLOROPHYTE, 1, 1.0f, new FabricItemSettings()));
    public static final Item CHLOROPHYTE_AXE = registerItem("chlorophyte_axe",
            new AxeItem(ModToolMaterial.CHLOROPHYTE, 9, 0.5f, new FabricItemSettings()));

    public static final Item CHLOROPHYTE_HELMET = registerItem("chlorophyte_helmet",
            new ArmorItem(ModArmorMaterials.CHLOROPHYTE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item CHLOROPHYTE_CHESTPLATE = registerItem("chlorophyte_chestplate",
            new ArmorItem(ModArmorMaterials.CHLOROPHYTE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item CHLOROPHYTE_LEGGINGS = registerItem("chlorophyte_leggings",
            new ArmorItem(ModArmorMaterials.CHLOROPHYTE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item CHLOROPHYTE_BOOTS = registerItem("chlorophyte_boots",
            new ArmorItem(ModArmorMaterials.CHLOROPHYTE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

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
