package com.diamondmonster09.craftables.item;

import com.diamondmonster09.craftables.CraftablesMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup CRAFTABLES = FabricItemGroupBuilder.build(new Identifier(CraftablesMod.MODID, "craftables_tab", ), () -> new ItemStack())
}
