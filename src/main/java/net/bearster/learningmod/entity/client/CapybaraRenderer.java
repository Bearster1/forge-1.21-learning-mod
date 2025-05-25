package net.bearster.learningmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.entity.custom.CapybaraEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CapybaraRenderer extends MobRenderer<CapybaraEntity, CapybaraModel> {
    public CapybaraRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CapybaraModel(pContext.bakeLayer(ModModelLayers.CAPYBARA)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(CapybaraEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "textures/entity/capybara/capybara_brown.png");
    }

    @Override
    public void render(CapybaraEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
