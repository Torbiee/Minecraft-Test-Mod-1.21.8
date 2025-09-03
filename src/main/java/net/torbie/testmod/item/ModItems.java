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
    public static Item RAW_CHEESE;
    public static Item CHEESE;


    private static Item registerItem(String name) {
        Identifier id = Identifier.of(TestMod.MOD_ID, name);
        Item.Settings settings = new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, id));
        return Registry.register(Registries.ITEM, id, new Item(settings));

    }

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items for " + TestMod.MOD_ID);

        RAW_CHEESE = registerItem("raw_cheese");
        CHEESE = registerItem("cheese");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_CHEESE);
            entries.add(CHEESE);
        });
    }
}
