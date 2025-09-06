package net.torbie.testmod.armor;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.torbie.testmod.TestMod;


import java.util.Map;

import static net.torbie.testmod.util.ModTags.Items.CHEESE_REPAIR_ITEMS;


public class CheeseArmorMaterial {

    public static final int BASE_DURABILITY = 37;

    public static final RegistryKey<EquipmentAsset> CHEESE_REPAIR_ITEMS_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(TestMod.MOD_ID,"cheese_armor2"));

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3
            ),
            10,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            2.0F,
            0.0F,
            CHEESE_REPAIR_ITEMS,
            CHEESE_REPAIR_ITEMS_KEY
    );
}
