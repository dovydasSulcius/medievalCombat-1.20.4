package net.agedsquirrel.medievalcombat;

import net.fabricmc.api.ModInitializer;

import net.agedsquirrel.medievalcombat.block.ModBlocks;
import net.agedsquirrel.medievalcombat.item.ModItemGroups;
import net.agedsquirrel.medievalcombat.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MedievalCombat implements ModInitializer {
	public static final String MOD_ID = "medievalcombat";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}