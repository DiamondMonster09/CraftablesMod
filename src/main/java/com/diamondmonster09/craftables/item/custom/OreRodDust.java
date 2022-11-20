package com.diamondmonster09.craftables.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;


public class OreRodDust extends Item {
    public OreRodDust(Settings settings){
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld().isClient()){
            BlockPos posClick = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean found = false;
            for(int i = 0; i <= posClick.getY(); i++){
                Block blockBelow = context.getWorld().getBlockState(posClick.down(i)).getBlock();
                if (isMetal(blockBelow)){
                    outputValuableCoordinates(posClick.down(i), player, blockBelow);
                    found = true;
                    break;
                }
            }
            if (!found){
                player.sendMessage(Text.literal("No Ores There!"));
            }
        }
        context.getStack().damage(1, context.getPlayer(), (player) -> player.sendToolBreakStatus(player.getActiveHand()));
        return super.useOnBlock(context);
    }
    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block blockBelow){
        player.sendMessage(Text.literal("Found " + blockBelow.asItem().getName().getString() + "at " + "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getX() + ")"));
    }
    private boolean isMetal(Block block){
        return block == Blocks.COAL_ORE || block == Blocks.REDSTONE_ORE;
    }
}
