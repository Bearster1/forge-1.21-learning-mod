package net.bearster.learningmod.entity.client;

import net.bearster.learningmod.LearningMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation CAPYBARA = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "capybara"), "main");

    public static final ModelLayerLocation FIREFIGHTER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "firefighter"), "main");
}
