package net.bearster.examplemod.villager;

import com.google.common.collect.ImmutableSet;
import net.bearster.examplemod.ExampleMod;
import net.bearster.examplemod.block.ModBlocks;
import net.bearster.examplemod.sound.ModSounds;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, ExampleMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, ExampleMod.MOD_ID);

    /*

    public static final RegistryObject<PoiType> MAGIC_POI = POI_TYPES.register("magic_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.MAGIC_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> KAUPENGER =
            VILLAGER_PROFESSIONS.register("kaupenger", () -> new VillagerProfession("kaupenger",
                    holder -> holder.get() == MAGIC_POI.get(), holder -> holder.get() == MAGIC_POI.get(), ImmutableSet.of(),
                    ImmutableSet.of(), ModSoundsGenerator.MAGIC_BLOCK_PLACE.get()));

     */

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }

}
