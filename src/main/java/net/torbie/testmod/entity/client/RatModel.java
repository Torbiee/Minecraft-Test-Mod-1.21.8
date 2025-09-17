package net.torbie.testmod.entity.client;

import net.minecraft.util.Identifier;
import net.torbie.testmod.TestMod;
import net.torbie.testmod.entity.custom.RatEntity;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class RatModel extends DefaultedEntityGeoModel<RatEntity> {
        public RatModel() {
            super(Identifier.of(TestMod.MOD_ID, "rat"));
        }
}