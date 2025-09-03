package net.torbie.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.torbie.testmod.TestMod;

public class ModItems {
    public static final Item CUT_CHEESE = registerItem( "cut_cheese");
    public static final Item RAW_CHEESE = registerItem("raw_cheese");


    private static Item registerItem(String name) {
        Item.Settings itemSettings = new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM,Identifier.of(TestMod.MOD_ID,name)));
        Item item = new Item(itemSettings);
        return Registry.register(Registries.ITEM, Identifier.of(TestMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items for " + TestMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(CUT_CHEESE);
            entries.add(RAW_CHEESE);
        });
    }
}
