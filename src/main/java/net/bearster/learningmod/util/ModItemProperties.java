package net.bearster.learningmod.util;

import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.component.ModDataComponentTypes;
import net.bearster.learningmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.DATA_TABLET.get(), ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "on"),
                (itemStack, clientLevel, livingEntity, i) -> itemStack.get(ModDataComponentTypes.FOUND_BLOCK.get()) != null ? 1f : 0f);

    }
}
