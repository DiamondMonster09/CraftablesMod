package com.diamondmonster09.craftables.item;

import com.diamondmonster09.craftables.CraftablesMod;
import com.diamondmonster09.craftables.item.custom.OreRodDiamond;
import com.diamondmonster09.craftables.item.custom.OreRodDust;
import com.diamondmonster09.craftables.item.custom.OreRodMetal;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item ORESTICKMETAL = registerItem("orerodmetal", new OreRodMetal(new FabricItemSettings().group(ModItemGroup.CRAFTABLES)));
    public static final Item ORESTICKDIAMOND = registerItem("ore_stick_diamond", new OreRodDiamond(new FabricItemSettings().group(ModItemGroup.CRAFTABLES)));
    public static final Item ORESTICKDUST = registerItem("ore_stick_dust", new OreRodDust(new FabricItemSettings().group(ModItemGroup.CRAFTABLES)));
    //public static final Item DIAMONDSCYTHE = registerItem("scythe_diamond", new HoeItem());
    public static final Item ESS = registerItem("essence", new Item(new FabricItemSettings().group(ModItemGroup.CRAFTABLES)));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(CraftablesMod.MODID, name), item);
    }
    public static void registerModItems(){
        CraftablesMod.LOGGER.info("registering Items");
    }

}
