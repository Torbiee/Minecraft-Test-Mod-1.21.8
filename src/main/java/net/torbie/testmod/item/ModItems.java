package net.torbie.testmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.torbie.testmod.TestMod;
import net.torbie.testmod.armor.CheeseArmorMaterial;

import java.util.function.Function;


public class ModItems {

    public static void initialize() {
    }

    
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {

        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TestMod.MOD_ID, name));


        Item item = itemFactory.apply(settings.registryKey(itemKey));


        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }


    public static final Item RAW_CHEESE = register(
            "raw_cheese",
            Item::new,
            new Item.Settings()
                    .food(new FoodComponent.Builder()
                    .nutrition(4)
                    .saturationModifier(0.3f)
                    .build()));
    public static final Item CHEESE = register(
            "cheese",
            Item::new,
            new Item.Settings()
                    .food(new FoodComponent.Builder()
                    .nutrition(8)
                    .saturationModifier(0.6f)
                    .build()));

    public static final Item CHEESE_SWORD = register(
            "cheese_sword",
            Item::new,
            new Item.Settings().sword(ModToolMaterials.CHEESE, 3.0f, -2.4f)
    );

    //    public static final Item CHEESE_HELMET = register(
//            "cheese_helmet",
//            Item::new,
//            new Item.Settings().armor()
//    );

    public static final Item CHEESE_HELMET = register(
            "cheese_helmet",
            Item::new,
            new Item.Settings().armor(CheeseArmorMaterial.INSTANCE, EquipmentType.HELMET).maxDamage(EquipmentType.HELMET.getMaxDamage(CheeseArmorMaterial.BASE_DURABILITY))
    );
    public static final Item CHEESE_CHESTPLATE = register(
            "cheese_chestplate",
            Item::new,
            new Item.Settings().armor(CheeseArmorMaterial.INSTANCE, EquipmentType.CHESTPLATE).maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(CheeseArmorMaterial.BASE_DURABILITY))
);
    public static final Item CHEESE_LEGGINGS = register(
            "cheese_leggings",
            Item::new,
            new Item.Settings().armor(CheeseArmorMaterial.INSTANCE, EquipmentType.LEGGINGS).maxDamage(EquipmentType.LEGGINGS.getMaxDamage(CheeseArmorMaterial.BASE_DURABILITY))
    );
    public static final Item CHEESE_BOOTS = register(
            "cheese_boots",
            Item::new,
            new Item.Settings().armor(CheeseArmorMaterial.INSTANCE, EquipmentType.BOOTS).maxDamage(EquipmentType.BOOTS.getMaxDamage(CheeseArmorMaterial.BASE_DURABILITY))
    );

}
