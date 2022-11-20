package com.diamondmonster09.craftables.item.client;

import com.diamondmonster09.craftables.CraftablesMod;
import com.diamondmonster09.craftables.item.custom.OreRodMetal;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class OreRodMetalModel extends AnimatedGeoModel<OreRodMetal> {

    @Override
    public Identifier getModelResource(OreRodMetal object) {
        return new Identifier(CraftablesMod.MODID, "geo/orerodmetal.geo.json");
    }

    @Override
    public Identifier getTextureResource(OreRodMetal object) {
        return new Identifier(CraftablesMod.MODID, "textures/item/orerodmetal_texture.png");
    }

    @Override
    public Identifier getAnimationResource(OreRodMetal animatable) {
        return new Identifier(CraftablesMod.MODID, "animations/orerodmetal.animation.json");
    }
}
