package net.torbie.testmod.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.torbie.testmod.util.ModTags;

//public enum ModToolMaterials implements ToolMaterial {
//    CHEESE(1561,8.0f,3.0f,10,15);
//
//    private final int durability;
//    private final float miningSpeed;
//    private final float attackDamage;
//    private final int miningLevel;
//    private final int enchantability;
//
//    ModToolMaterials(int durability, float miningSpeed, float attackDamage, int miningLevel, int enchantability) {
//        this.durability = durability;
//        this.miningSpeed = miningSpeed;
//        this.attackDamage = attackDamage;
//        this.miningLevel = miningLevel;
//        this.enchantability = enchantability;
//    }
//    @Override
//    public int getDurability() { return durability; }
//
//    @Override
//    public float getMiningSpeedMultiplier() { return miningSpeed; }
//
//    @Override
//    public float getAttackDamage() { return attackDamage; }
//
//    @Override
//    public int getMiningLevel() { return miningLevel; }
//
//    @Override
//    public int getEnchantability() { return enchantability; }
//
//    @Override
//    public Ingredient getRepairIngredient() {
//        return Ingredient.ofItems(ModItems.CHEESE);
//
//}











public class ModToolMaterials {
    public static ToolMaterial CHEESE = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_CHEESE_TOOL,
            1561,
            8.0f,
            3.0f,
            10,
            ModTags.Items.CHEESE_REPAIR_ITEMS);
}

