package com.diamondmonster09.craftables;

import com.diamondmonster09.craftables.item.ModItems;
import com.diamondmonster09.craftables.item.client.OreRodMetalRenderer;
import net.fabricmc.api.ClientModInitializer;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class CraftablesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        GeoItemRenderer.registerItemRenderer(ModItems.ORESTICKMETAL, new OreRodMetalRenderer());
    }
}
