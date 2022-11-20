package com.diamondmonster09.craftables;


import com.diamondmonster09.craftables.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class CraftablesMod implements ModInitializer {

	public static final String MODID = "craftables";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		GeckoLib.initialize();
	}
}
