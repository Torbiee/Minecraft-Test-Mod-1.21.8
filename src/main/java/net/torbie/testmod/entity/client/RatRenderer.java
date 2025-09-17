package net.torbie.testmod.entity.client;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.AgeableMobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.torbie.testmod.TestMod;
import net.torbie.testmod.entity.custom.RatEntity;
import net.torbie.testmod.entity.custom.RatVariant;

import java.util.Map;



public class RatRenderer extends MobEntityRenderer<RatEntity, RatRenderState, RatModel> {
    private static final Map<RatVariant, Identifier> TEXTURES =
            Util.make(Maps.newEnumMap(RatVariant.class), map -> {
                map.put(RatVariant.DEFAULT,
                        Identifier.of(TestMod.MOD_ID,"textures/entity/rat/rat.png"));
                map.put(RatVariant.ALBINO,
                        Identifier.of(TestMod.MOD_ID,"textures/entity/rat/rat_albino.png"));
            });


//            Maps.newEnumMap(
//            Map.of( RatVariant.DEFAULT, Identifier.ofVanilla("textures/entity/rat/rat.png"),
//                    RatVariant.ALBINO, Identifier.ofVanilla("textures/entity/rat/rat_albino")
//            ));


    public RatRenderer(EntityRendererFactory.Context context) {
        super(context, new RatModel(context.getPart(RatModel.RAT)), 0.7f);
    }

    @Override
    public Identifier getTexture(RatRenderState state) {
        return (Identifier)  TEXTURES.get(state.variant);
        //return Identifier.of(TestMod.MOD_ID, "textures/entity/rat/rat.png");
    }

    @Override
    public void render(RatRenderState state, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (state.baby) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(state, matrixStack, vertexConsumerProvider, i);
    }
    @Override
    public RatRenderState createRenderState() { return new RatRenderState(); }

    public void updateRenderState(RatEntity ratEntity, RatRenderState ratRenderState, float f) {
        super.updateRenderState(ratEntity, ratRenderState, f);
        ratRenderState.idlingAnimationState.copyFrom(ratEntity.idleAnimationState);
        ratRenderState.variant = ratEntity.getVariant();

    }
}
