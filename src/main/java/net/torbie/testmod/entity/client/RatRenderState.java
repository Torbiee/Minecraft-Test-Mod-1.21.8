package net.torbie.testmod.entity.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;
import net.minecraft.item.ItemStack;
import net.torbie.testmod.entity.custom.RatVariant;

@Environment(EnvType.CLIENT)
public class RatRenderState extends LivingEntityRenderState {
    //public RatVariant color = RatVariant.DEFAULT;
    public RatVariant variant;
    public final AnimationState walkingAnimationState = new AnimationState();
    public final AnimationState idlingAnimationState = new AnimationState();
}

