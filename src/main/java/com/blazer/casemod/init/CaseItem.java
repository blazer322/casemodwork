package com.blazer.casemod.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Random;

public class CaseItem extends Item {
    private final SoundEvent openSound;
    private final List<Item> rewardPool;

    public CaseItem(List<Item> rewardPool, SoundEvent sound) {
        super(new Item.Properties().stacksTo(1));
        this.openSound = sound;
        this.rewardPool = rewardPool;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (!level.isClientSide()) {
            Player player = context.getPlayer();
            if (player != null) {
                level.playSound(null, player.blockPosition(), openSound, SoundSource.PLAYERS, 1.0f, 1.0f);

                Item reward = getRandomReward();
                player.addItem(new ItemStack(reward));

                context.getItemInHand().shrink(1);
            }
        }
        return InteractionResult.SUCCESS;
    }

    private Item getRandomReward() {
        return rewardPool.get(new Random().nextInt(rewardPool.size()));
    }
}
