package net.torbie.testmod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationDefinition;
import net.minecraft.client.render.entity.animation.CamelAnimations;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.torbie.testmod.TestMod;
import net.torbie.testmod.entity.custom.RatEntity;

public class RatModel extends EntityModel<RatRenderState> {
    public static final EntityModelLayer RAT = new EntityModelLayer(Identifier.of(TestMod.MOD_ID, "rat"), "main");
        private final ModelPart rat;
        private final ModelPart head;
        private final Animation walkingAnimation;
        private final Animation idlingAnimation;

        public RatModel( ModelPart root) {
            super(root);
            this.rat = root.getChild("rat");
            this.head = this.rat.getChild("head");
            this.walkingAnimation = RatAnimations.RAT_WALKING.createAnimation(root);
            this.idlingAnimation = RatAnimations.RAT_IDLE.createAnimation(root);

        }
        public static TexturedModelData getTexturedModelData() {
            ModelData modelData = new ModelData();
            ModelPartData modelPartData = modelData.getRoot();
            ModelPartData rat = modelPartData.addChild("rat", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 24.0F, 0.0F));

            ModelPartData head = rat.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -20.0F, 0.0F));

            ModelPartData rightEar = head.addChild("rightEar", ModelPartBuilder.create().uv(24, 0).cuboid(-4.0F, -7.0F, -2.0F, 3.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 0.0F, 0.0F));

            ModelPartData leftEar = head.addChild("leftEar", ModelPartBuilder.create().uv(24, 0).mirrored().cuboid(1.0F, -7.0F, -2.0F, 3.0F, 4.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.origin(0.0F, 0.0F, 0.0F));

            ModelPartData Nose = head.addChild("Nose", ModelPartBuilder.create().uv(26, 24).cuboid(-1.0F, -1.0F, 1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                    .uv(44, 6).cuboid(-1.0F, -1.0F, 2.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                    .uv(3, 2).cuboid(0.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                    .uv(2, 2).cuboid(-1.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 2.0F, -7.0F));

            ModelPartData Neck = rat.addChild("Neck", ModelPartBuilder.create().uv(4, 2).cuboid(-2.0F, -17.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 0.0F, 0.0F));

            ModelPartData body = rat.addChild("body", ModelPartBuilder.create().uv(0, 16).cuboid(-3.0F, 4.0F, -3.0F, 6.0F, 12.0F, 6.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -20.0F, 0.0F));

            ModelPartData RightArm = body.addChild("RightArm", ModelPartBuilder.create().uv(29, 38).cuboid(-5.0F, 6.0F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 0.0F, 0.0F));

            ModelPartData cube_r1 = RightArm.addChild("cube_r1", ModelPartBuilder.create().uv(19, 39).cuboid(-3.0F, -2.0F, 0.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 8.0F, -1.0F, 0.0F, -0.8727F, 0.0F));

            ModelPartData LeftArm = body.addChild("LeftArm", ModelPartBuilder.create().uv(29, 38).mirrored().cuboid(3.0F, 6.0F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.origin(0.0F, 0.0F, 0.0F));

            ModelPartData cube_r2 = LeftArm.addChild("cube_r2", ModelPartBuilder.create().uv(19, 39).mirrored().cuboid(-1.0F, -2.0F, 0.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(5.0F, 8.0F, -1.0F, 0.0F, 0.8727F, 0.0F));

            ModelPartData tail = rat.addChild("tail", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 4.0F, 0.0F));

            ModelPartData tail1_r1 = tail.addChild("tail1_r1", ModelPartBuilder.create().uv(40, 26).cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -11.0F, 3.0F, 0.3927F, -0.3927F, 0.3927F));

            ModelPartData LeftLeg = rat.addChild("LeftLeg", ModelPartBuilder.create().uv(12, 35).cuboid(2.0F, -3.0F, -1.0F, 1.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(-1.0F, -2.0F, 0.0F));

            ModelPartData RightLeg = rat.addChild("RightLeg", ModelPartBuilder.create().uv(12, 35).cuboid(-1.0F, -3.0F, -1.0F, 1.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(-1.0F, -2.0F, 0.0F));
            return TexturedModelData.of(modelData, 64, 64);

        }
    @Override
    public void setAngles(RatRenderState ratRenderState) {
        super.setAngles(ratRenderState);
        this.setHeadAngles(ratRenderState.relativeHeadYaw, ratRenderState.pitch);
        this.walkingAnimation.applyWalking(ratRenderState.limbSwingAnimationProgress, ratRenderState.limbSwingAmplitude, 2.0F, 2.5F);
        this.idlingAnimation.apply(ratRenderState.idlingAnimationState, ratRenderState.age, 0.5f);
    }




//        @Override
//        public void setAngles(RatEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//            this.getPart().traverse().forEach(ModelPart::resetTransform);
//            this.setHeadAngles(netHeadYaw, headPitch);
//
//
//
//        }

        private void setHeadAngles(float headYaw, float headPitch) {
            headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
            headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

            this.head.yaw = headYaw * 0.017453292F;
            this.head.pitch = headPitch * 0.017453292F;
        }
}