package net.bearster.learningmod.event;

import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.entity.ModEntities;
import net.bearster.learningmod.entity.client.CapybaraModel;
import net.bearster.learningmod.entity.client.FirefighterModel;
import net.bearster.learningmod.entity.client.ModModelLayers;
import net.bearster.learningmod.entity.custom.CapybaraEntity;
import net.bearster.learningmod.entity.custom.FirefighterEntity;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LearningMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.CAPYBARA, CapybaraModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.FIREFIGHTER, FirefighterModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CAPYBARA.get(), CapybaraEntity.createAttributes().build());
        event.put(ModEntities.FIREFIGHTER.get(), FirefighterEntity.createAttributes().build());
    }

}
