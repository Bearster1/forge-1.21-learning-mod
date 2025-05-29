package net.bearster.examplemod.event;

import net.bearster.examplemod.ExampleMod;
import net.bearster.examplemod.entity.ModEntities;
import net.bearster.examplemod.entity.client.*;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {

        /*

        event.registerLayerDefinition(ModModelLayers.CAPYBARA, CapybaraModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.FIREFIGHTER, FirefighterModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.GIRAFFE, GiraffeModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.FIRE_TRUCK, FireTruckModel::createBodyLayer);

         */
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {

        /*

        event.put(ModEntities.CAPYBARA.get(), CapybaraEntity.createAttributes().build());
        event.put(ModEntities.FIREFIGHTER.get(), FirefighterEntity.createAttributes().build());
        event.put(ModEntities.GIRAFFE.get(), GiraffeEntity.createAttributes().build());
        event.put(ModEntities.FIRE_TRUCK.get(), FireTruckEntity.createAttributes().build());

         */
    }

    @SubscribeEvent
    public static void registerSpawnPlacement(SpawnPlacementRegisterEvent event) {

        /*

        event.register(ModEntities.CAPYBARA.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);

        event.register(ModEntities.GIRAFFE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);

         */
    }

}
