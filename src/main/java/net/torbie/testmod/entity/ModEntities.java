package net.torbie.testmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.torbie.testmod.TestMod;
import net.torbie.testmod.entity.custom.MouseEntity;
import net.torbie.testmod.entity.custom.RatEntity;

public class ModEntities {

    public static void initialize() {}

    public static final EntityType<RatEntity> RAT = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(TestMod.MOD_ID, "rat"),
            EntityType.Builder.create(RatEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.5f, 0.5f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TestMod.MOD_ID, "rat"))));

    public static final EntityType<MouseEntity> MOUSE = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(TestMod.MOD_ID, "mouse"),
            EntityType.Builder.create(MouseEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.3f, 0.3f)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(TestMod.MOD_ID, "mouse"))));




    public static void registerModEntities() {

        TestMod.LOGGER.info("Registering Mod Entities");

        FabricDefaultAttributeRegistry.register(ModEntities.MOUSE, MouseEntity.createAttributes());

    }

}
