package net.torbie.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.torbie.testmod.item.ModToolMaterials;

import net.minecraft.util.Identifier;
import net.torbie.testmod.TestMod;
import net.torbie.testmod.util.ModTags;

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
//            settings -> new SwordItem(ModToolMaterials.CHEESE, 3, -2.4f, settings),
//            new Item.Settings()
            Item::new,
            new Item.Settings().sword(ModToolMaterials.CHEESE, 3.0f, -2.4f)
    );




}
//OLD CODE
//public class ModItems {
//    public static Item RAW_CHEESE;
//    public static Item CHEESE;
//
//
//    private static Item registerItem(String name) {
//        Identifier id = Identifier.of(TestMod.MOD_ID, name);
//        Item.Settings settings = new Item.Settings()
//                .registryKey(RegistryKey.of(RegistryKeys.ITEM, id));
//        return Registry.register(Registries.ITEM, id, new Item(settings));
//
//    }
//
//    public static void registerModItems() {
//        TestMod.LOGGER.info("Registering Mod Items for " + TestMod.MOD_ID);
//
//        RAW_CHEESE = registerItem("raw_cheese");
//        CHEESE = registerItem("cheese");
//
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
//            entries.add(RAW_CHEESE);
//            entries.add(CHEESE);
//        });
//    }
//}
