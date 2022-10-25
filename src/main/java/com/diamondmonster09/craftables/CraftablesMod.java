package com.diamondmonster09.craftables;

import com.diamondmonster09.craftables.block.ModBlocks;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CraftablesMod implements ModInitializer {

	public static final String MODID = "craftables";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
	}
}
