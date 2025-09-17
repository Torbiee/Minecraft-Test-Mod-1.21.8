package net.torbie.testmod.entity.client;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import net.torbie.testmod.TestMod;
import net.torbie.testmod.entity.custom.MouseEntity;

import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class MouseModel extends DefaultedEntityGeoModel<MouseEntity> {
    public MouseModel() {
        super(Identifier.of(TestMod.MOD_ID, "mouse"));
    }
}
