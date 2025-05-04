package net.bearster.learningmod.datagen;

import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LearningMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.AZURITE.get());
        basicItem(ModItems.RAW_AZURITE.get());

        basicItem(ModItems.CHAINSAW.get());
        basicItem(ModItems.LIGHTSABER.get());
        basicItem(ModItems.AURORA_ASHES.get());
        basicItem(ModItems.ONION.get());

    }
}
