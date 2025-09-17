package net.torbie.testmod.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.torbie.testmod.entity.custom.MouseEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class MouseRenderer extends GeoEntityRenderer<MouseEntity, MouseRenderState> {
    public MouseRenderer(EntityRendererFactory.Context context) {
        super(context, new MouseModel());

        this.shadowRadius = 0.2f;

    }
}
