package net.kszaczuch.undergroundmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kszaczuch.undergroundmod.UndergroundMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item STINGER = registerItem("stinger", new Item(new FabricItemSettings()));
    public static final Item LIFE_FRUIT_ITEM = registerItem("life_fruit_item", new Item(new FabricItemSettings()));
    public static final Item JUNGLE_SPORES_ITEM = registerItem("jungle_spores_item", new Item(new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(STINGER);
        entries.add(LIFE_FRUIT_ITEM);
        entries.add(JUNGLE_SPORES_ITEM);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(UndergroundMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        UndergroundMod.LOGGER.info("Registering mod items for " + UndergroundMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
