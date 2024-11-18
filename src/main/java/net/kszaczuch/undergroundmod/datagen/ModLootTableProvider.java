package net.kszaczuch.undergroundmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.kszaczuch.undergroundmod.block.ModBlocks;
import net.kszaczuch.undergroundmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CHLOROPHYTE_BLOCK);
        addDrop(ModBlocks.JUNGLE_SPORES);
        addDrop(ModBlocks.SKY_BLUE_FLOWER);
        addDrop(ModBlocks.LIFE_FRUIT);

        addDrop(ModBlocks.CHLOROPHYTE_ORE, chlorophyteOreDrops(ModBlocks.CHLOROPHYTE_ORE, ModItems.RAW_CHLOROPHYTE));
        addDrop(ModBlocks.DEEPSLATE_CHLOROPHYTE_ORE, chlorophyteOreDrops(ModBlocks.DEEPSLATE_CHLOROPHYTE_ORE, ModItems.RAW_CHLOROPHYTE));

    }
    public LootTable.Builder chlorophyteOreDrops(Block drop, Item item) {
		return dropsWithSilkTouch(
			drop,
			(LootPoolEntry.Builder<?>)this.applyExplosionDecay(
				drop,
				ItemEntry.builder(item)
					.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
					.apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
			)
		);
	}
}
