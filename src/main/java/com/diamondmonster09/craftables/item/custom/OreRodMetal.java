package com.diamondmonster09.craftables.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.network.GeckoLibNetwork;
import software.bernie.geckolib3.network.ISyncable;
import software.bernie.geckolib3.util.GeckoLibUtil;


public class OreRodMetal extends Item implements IAnimatable, ISyncable {
    private static final int ANIM_SPIN = 0;
    public AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public OreRodMetal(Settings settings){

        super(settings);
        GeckoLibNetwork.registerSyncable(this);
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
        return block == Blocks.COPPER_ORE || block == Blocks.GOLD_ORE || block == Blocks.IRON_ORE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller", 20, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
    private <E extends Item & IAnimatable> PlayState predicate(AnimationEvent<E> event){
        return PlayState.CONTINUE;
    }


    @Override
    public void onAnimationSync(int id, int state) {
        if (state == ANIM_SPIN){
            @SuppressWarnings("rawtypes")
            final AnimationController controller = GeckoLibUtil.getControllerForID(this.factory, id, "controller");
        }
    }
}
