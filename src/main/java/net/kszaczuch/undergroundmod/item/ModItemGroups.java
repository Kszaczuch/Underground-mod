package net.kszaczuch.undergroundmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kszaczuch.undergroundmod.UndergroundMod;
import net.kszaczuch.undergroundmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MOD_ITEMS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(UndergroundMod.MOD_ID, "items"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.items"))
                    .icon(() -> new ItemStack(ModBlocks.LIFE_FRUIT)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.LIFE_FRUIT);
                        entries.add(ModBlocks.SKY_BLUE_FLOWER);
                        entries.add(ModBlocks.JUNGLE_SPORES);
                        entries.add(ModItems.STINGER);

                    }).build());

    public static final ItemGroup MOD_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(UndergroundMod.MOD_ID, "blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.blocks"))
                    .icon(() -> new ItemStack(ModBlocks.CHLOROPHYTE_BLOCK)).entries(((displayContext, entries) -> {

                        entries.add(ModBlocks.CHLOROPHYTE_BLOCK);
                        entries.add(ModBlocks.CHLOROPHYTE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_CHLOROPHYTE_ORE);

                    })).build());


    public static void registerItemGroups() {
        UndergroundMod.LOGGER.info("Registering item groups for " + UndergroundMod.MOD_ID);
    }
}
