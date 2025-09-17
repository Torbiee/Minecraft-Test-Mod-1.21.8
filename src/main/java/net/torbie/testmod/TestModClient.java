package net.torbie.testmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;
import net.torbie.testmod.block.ModBlocks;
import net.torbie.testmod.entity.ModEntities;
import net.torbie.testmod.entity.client.MouseRenderer;
import net.torbie.testmod.entity.client.RatModel;
import net.torbie.testmod.entity.client.RatRenderer;

public class TestModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.putBlock(ModBlocks.CHEESE_WOOD_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.CHEESE_FLOWER, BlockRenderLayer.CUTOUT);

        EntityModelLayerRegistry.registerModelLayer(RatModel.RAT, RatModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.RAT, RatRenderer::new);


        EntityRendererRegistry.register(ModEntities.MOUSE, MouseRenderer::new);
        //ResourceChecker.checkResources();
    }
}
