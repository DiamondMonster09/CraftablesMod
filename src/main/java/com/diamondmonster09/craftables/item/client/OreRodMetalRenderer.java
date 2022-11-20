package com.diamondmonster09.craftables.item.client;

import com.diamondmonster09.craftables.item.custom.OreRodMetal;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class OreRodMetalRenderer extends GeoItemRenderer<OreRodMetal> {

    public OreRodMetalRenderer() {
        super(new OreRodMetalModel());
    }
}
