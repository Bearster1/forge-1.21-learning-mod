package net.bearster.learningmod.datagen;

import com.google.gson.JsonElement;
import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.block.ModBlocks;
import net.bearster.learningmod.block.custom.AzuriteLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModBlockStateProvider extends BlockStateProvider {

    static MultiVariantGenerator createSimpleBlock(Block pBlock, ResourceLocation pModelLocation) {
        return MultiVariantGenerator.multiVariant(pBlock, Variant.variant().with(VariantProperties.MODEL, pModelLocation));
    }

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, LearningMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.AZURITE_BLOCK);

        blockWithItem(ModBlocks.AZURITE_ORE);
        blockWithItem(ModBlocks.AZURITE_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.AZURITE_END_ORE);
        blockWithItem(ModBlocks.AZURITE_NETHER_ORE);

        blockWithItem(ModBlocks.MAGIC_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.AZURITE_STAIRS.get()), blockTexture(ModBlocks.AZURITE_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.AZURITE_SLAB.get()), blockTexture(ModBlocks.AZURITE_BLOCK.get()), blockTexture(ModBlocks.AZURITE_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.AZURITE_BUTTON.get()), blockTexture(ModBlocks.AZURITE_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.AZURITE_PRESSURE_PLATE.get()), blockTexture(ModBlocks.AZURITE_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.AZURITE_FENCE.get()),blockTexture(ModBlocks.AZURITE_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.AZURITE_FENCE_GATE.get()),blockTexture(ModBlocks.AZURITE_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.AZURITE_WALL.get()),blockTexture(ModBlocks.AZURITE_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.AZURITE_DOOR.get()), modLoc("block/azurite_door_bottom"), modLoc("block/azurite_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.AZURITE_TRAPDOOR.get()), modLoc("block/azurite_trapdoor"), true, "cutout");

        blockItem(ModBlocks.AZURITE_STAIRS);
        blockItem(ModBlocks.AZURITE_SLAB);
        blockItem(ModBlocks.AZURITE_PRESSURE_PLATE);
        blockItem(ModBlocks.AZURITE_FENCE_GATE);
        blockItem(ModBlocks.AZURITE_TRAPDOOR, "_bottom");

        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.AZURITE_LAMP.get()).forAllStates(state -> {
            if (state.getValue(AzuriteLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("azurite_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "block/" + "azurite_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("azurite_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "block/" + "azurite_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.AZURITE_LAMP.get(), models().cubeAll("azurite_lamp_on",
                ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "block/" + "azurite_lamp_on")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("learningmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("learningmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

}
