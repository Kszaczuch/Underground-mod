package net.kszaczuch.undergroundmod;

import net.fabricmc.api.ModInitializer;

import net.kszaczuch.undergroundmod.block.ModBlocks;
import net.kszaczuch.undergroundmod.item.ModItemGroups;
import net.kszaczuch.undergroundmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UndergroundMod implements ModInitializer {
	public static final String MOD_ID = "undergroundmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
	}
}