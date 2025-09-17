package net.torbie.testmod.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.torbie.testmod.entity.custom.RatEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RatRenderer extends GeoEntityRenderer<RatEntity, RatRenderState> {
    public RatRenderer(EntityRendererFactory.Context context) {
        super(context, new RatModel());

        this.shadowRadius = 0.3f;
    }

}
