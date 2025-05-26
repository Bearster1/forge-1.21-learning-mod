package net.bearster.learningmod.entity;

import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.entity.custom.CapybaraEntity;
import net.bearster.learningmod.entity.custom.FirefighterEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, LearningMod.MOD_ID);

    public static final RegistryObject<EntityType<CapybaraEntity>> CAPYBARA =
            ENTITY_TYPES.register("capybara", () -> EntityType.Builder.of(CapybaraEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.4f).build("capybara"));

    public static final RegistryObject<EntityType<FirefighterEntity>> FIREFIGHTER =
            ENTITY_TYPES.register("firefighter", () -> EntityType.Builder.of(FirefighterEntity::new, MobCategory.CREATURE)
                    .sized(0.75f, 1.8f).build("firefighter"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
