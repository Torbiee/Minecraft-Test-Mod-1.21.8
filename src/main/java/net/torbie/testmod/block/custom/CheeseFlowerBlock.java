package net.torbie.testmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import net.torbie.testmod.block.ModBlocks;
import net.torbie.testmod.item.ModItems;

import javax.swing.*;

public class CheeseFlowerBlock extends FlowerBlock {

    public CheeseFlowerBlock(RegistryEntry<StatusEffect> stewEffect, float effectLengthInSeconds, Settings settings) {
        super(stewEffect, effectLengthInSeconds, settings);
    }

    //    @Override
//    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
//        return new ItemStack(ModItems.RAW_CHEESE);
//    }
    @Override
    public ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isOf(Items.SHEARS)) {
            dropStack(world, pos, new ItemStack(ModItems.RAW_CHEESE, 1));
            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0f, 0.8f);
            return ActionResult.PASS; //: super.onUseWithItem(stack, state, world, pos, player, hand, hit);
        } else {
            return ActionResult.SUCCESS;
        }

//        dropStack(world, pos, new ItemStack(ModItems.RAW_CHEESE, 1));
//        world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0f, 0.8f);
//        world.setBlockState(pos, state, CheeseFlowerBlock.NOTIFY_LISTENERS);
//        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, state));
//        return ActionResult.SUCCESS;
    }
}
