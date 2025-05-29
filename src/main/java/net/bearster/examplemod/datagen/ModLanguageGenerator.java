package net.bearster.examplemod.datagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.logging.LogUtils;
import net.bearster.examplemod.ExampleMod;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static net.bearster.examplemod.ExampleMod.MOD_ID;

public class ModLanguageGenerator {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public void addTranslation(String objectIdentifier, String objectName) {

        en_us.put(objectIdentifier, objectName);

        // Path for translation file
        Path translationPath = Paths.get(translationDataPath, "en_us.json");

        try {
            Files.createDirectories(translationPath.getParent());
            try (BufferedWriter writer = Files.newBufferedWriter(translationPath)) {
                GSON.toJson(en_us, writer);
            }
            LOGGER.info("Wrote en_us JSON to: {}", translationPath);
        } catch (IOException e) {
            LOGGER.error("Failed to write en_us JSON: {}", e.getMessage(), e);
        }
    }

    private String translationDataPath = "D:\\Codeing\\Java\\Minecraft\\forge-1.21.1-example-mod\\src\\main\\resources\\assets\\"+MOD_ID+"\\lang"; // Change this line. You want to change the path

    public Map<Object, Object> en_us = new LinkedHashMap<>();

    public void registerTranslations() {
        LOGGER.info("Registering translations...");

        /*

        addTranslation("item."+MOD_ID+".azurite", "Azurite");
        addTranslation("item."+MOD_ID+".raw_azurite", "Raw Azurite");
        addTranslation("item." + MOD_ID + ".chainsaw", "Chainsaw");
        addTranslation("item." + MOD_ID + ".lightsaber", "Lightsaber");
        addTranslation("item." + MOD_ID + ".onion", "Onion");
        addTranslation("item." + MOD_ID + ".aurora_ashes", "Aurora Ashes");

        addTranslation("item." + MOD_ID + ".azurite_sword", "Azurite Sword");
        addTranslation("item." + MOD_ID + ".azurite_pickaxe", "Azurite Pickaxe");
        addTranslation("item." + MOD_ID + ".azurite_shovel", "Azurite Shovel");
        addTranslation("item." + MOD_ID + ".azurite_axe", "Azurite Axe");
        addTranslation("item." + MOD_ID + ".azurite_hoe", "Azurite Hoe");

        addTranslation("item." + MOD_ID + ".azurite_paxel", "Azurite Paxel");
        addTranslation("item." + MOD_ID + ".azurite_hammer", "Azurite Hammer");

        addTranslation("item." + MOD_ID + ".azurite_helmet", "Azurite Helmet");
        addTranslation("item." + MOD_ID + ".azurite_chestplate", "Azurite Chestplate");
        addTranslation("item." + MOD_ID + ".azurite_leggings", "Azurite Leggings");
        addTranslation("item." + MOD_ID + ".azurite_boots", "Azurite Boots");

        addTranslation("item." + MOD_ID + ".azurite_horse_armor", "Azurite Horse Armor");
        addTranslation("item." + MOD_ID + ".kaupen_armor_trim_smithing_template", "Kaupen Trim Template");

        addTranslation("item." + MOD_ID + ".metal_detector", "Metal Detector");
        addTranslation("item." + MOD_ID + ".data_tablet", "Data Tablet");

        addTranslation("item." + MOD_ID + ".azurite_bow", "Azurite Bow");
        addTranslation("item." + MOD_ID + ".onion_seeds", "Onion Seeds");

        addTranslation("item." + MOD_ID + ".bar_brawl_music_disc", "Bar Brawl Music Disc");
        addTranslation("item." + MOD_ID + ".bar_brawl_music_disc.desc", "Bryan Tech - Bar Brawl (CC0)");
        addTranslation("item." + MOD_ID + ".j0j0jetz_club_music_disc", "J0J0Jetz Club Music Disc");
        addTranslation("item." + MOD_ID + ".j0j0jetz_club_music_disc.desc", "J0J0Jetz - J0J0Jetz Club");

        addTranslation("item." + MOD_ID + ".spectre_staff", "Spectre Staff");
        addTranslation("item." + MOD_ID + ".radiation_staff", "Radiation Staff");
        addTranslation("item." + MOD_ID + ".sword", "Sword");

        addTranslation("item." + MOD_ID + ".capybara_spawn_egg", "Capybara Spawn Egg");
        addTranslation("item." + MOD_ID + ".firefighter_spawn_egg", "Firefighter Spawn Egg");
        addTranslation("item." + MOD_ID + ".giraffe_spawn_egg", "Giraffe Spawn Egg");
        addTranslation("item." + MOD_ID + ".fire_truck_spawn_egg", "Fire Truck Spawn Egg");

        addTranslation("item.minecraft.potion.effect.slimey_potion", "Slimey Potion");
        addTranslation("item.minecraft.splash_potion.effect.slimey_potion", "Slimey Splash Potion");
        addTranslation("item.minecraft.lingering_potion.effect.slimey_potion", "Slimey Lingering Potion");

        addTranslation("item." + MOD_ID + ".azurite_water_bucket", "Azurite Water Bucket");
        addTranslation("fluid_type." + MOD_ID + ".azurite_water_fluid", "Azurite Water");

        addTranslation("block." + MOD_ID + ".azurite_block", "Block of Azurite");
        addTranslation("block." + MOD_ID + ".azurite_ore", "Azurite Ore");
        addTranslation("block." + MOD_ID + ".azurite_deepslate_ore", "Azurite Deepslate Ore");
        addTranslation("block." + MOD_ID + ".azurite_nether_ore", "Azurite Nether Ore");
        addTranslation("block." + MOD_ID + ".azurite_end_ore", "Azurite End Ore");

        addTranslation("block." + MOD_ID + ".magic_block", "Magic Block");

        addTranslation("block." + MOD_ID + ".azurite_stairs", "Azurite Stairs");
        addTranslation("block." + MOD_ID + ".azurite_slab", "Azurite Slab");
        addTranslation("block." + MOD_ID + ".azurite_button", "Azurite Button");
        addTranslation("block." + MOD_ID + ".azurite_pressure_plate", "Azurite Pressure Plate");
        addTranslation("block." + MOD_ID + ".azurite_fence", "Azurite Fence");
        addTranslation("block." + MOD_ID + ".azurite_fence_gate", "Azurite Fence Gate");
        addTranslation("block." + MOD_ID + ".azurite_wall", "Azurite Wall");
        addTranslation("block." + MOD_ID + ".azurite_door", "Azurite Door");
        addTranslation("block." + MOD_ID + ".azurite_trapdoor", "Azurite Trapdoor");

        addTranslation("block." + MOD_ID + ".azurite_lamp", "Azurite Lamp");
        addTranslation("block." + MOD_ID + ".onion_crop", "Onion Crop");

        addTranslation("block." + MOD_ID + ".catmint", "Catmint");
        addTranslation("block." + MOD_ID + ".potted_catmint", "Potted Catmint");

        addTranslation("block." + MOD_ID + ".colored_leaves", "Colored Leaves");
        addTranslation("block." + MOD_ID + ".pedestal", "Pedestal");
        addTranslation("block." + MOD_ID + ".triforce", "Triforce");

        addTranslation("block." + MOD_ID + ".crystallizer", "Crystallizer");

        addTranslation("block." + MOD_ID + ".balsa_log", "Balsa Log");
        addTranslation("block." + MOD_ID + ".balsa_wood", "Balsa Wood");
        addTranslation("block." + MOD_ID + ".stripped_balsa_log", "Stripped Balsa Log");
        addTranslation("block." + MOD_ID + ".stripped_balsa_wood", "Stripped Balsa Wood");
        addTranslation("block." + MOD_ID + ".balsa_planks", "Balsa Planks");
        addTranslation("block." + MOD_ID + ".balsa_leaves", "Balsa Leaves");
        addTranslation("block." + MOD_ID + ".balsa_sapling", "Balsa Sapling");

        addTranslation("block." + MOD_ID + ".coal_generator", "Coal Generator");

        addTranslation("effect." + MOD_ID + ".slimey", "Slimey");

        addTranslation("painting." + MOD_ID + ".world.title", "World");
        addTranslation("painting." + MOD_ID + ".world.author", "NanoAttack");
        addTranslation("painting." + MOD_ID + ".shrimp.title", "Shrimp");
        addTranslation("painting." + MOD_ID + ".shrimp.author", "NanoAttack");
        addTranslation("painting." + MOD_ID + ".saw_them.title", "Saw Them");
        addTranslation("painting." + MOD_ID + ".saw_them.author", "NanoAttack");
        addTranslation("painting." + MOD_ID + ".wanderer.title", "Wanderer");
        addTranslation("painting." + MOD_ID + ".wanderer.author", "PlatinumG17");

        addTranslation("painting." + MOD_ID + ".jojo_botw.title", "J0J0Jetz in BOTW");
        addTranslation("painting." + MOD_ID + ".jojo_botw.author", "J0J0Jetz");
        addTranslation("painting." + MOD_ID + ".jojo_knight.title", "J0J0Jetz Getting Knighted");
        addTranslation("painting." + MOD_ID + ".jojo_knight.author", "HobbyBox");

        addTranslation("creativetab." + MOD_ID + ".azurite_items", "Azurite Items");
        addTranslation("creativetab." + MOD_ID + ".azurite_blocks", "Azurite Blocks");
        addTranslation("creativetab." + MOD_ID + ".custom", "Custom Tab");

        addTranslation("trim_pattern." + MOD_ID + ".kaupen", "Kaupen Armor Trim");
        addTranslation("trim_material." + MOD_ID + ".azurite", "Azurite Material");

        addTranslation("entity.minecraft.villager." + MOD_ID + ".kaupenger", "Kaupenger");

        addTranslation("enchantment." + MOD_ID + ".lightning_striker", "Lightning Striker");

        addTranslation("sounds." + MOD_ID + ".chainsaw_cut", "Chainsaw Sounds");
        addTranslation("sounds." + MOD_ID + ".chainsaw_pull", "Pull Chainsaw Sounds");
        addTranslation("sounds." + MOD_ID + ".firefighter", "Firefighter Sounds");

        addTranslation("tooltip." + MOD_ID + ".chainsaw.tooltip.shift", "Press §eshift§r for more information!");
        addTranslation("tooltip." + MOD_ID + ".chainsaw.tooltip.1", "This Chainsaw will cut down trees fast!");
        addTranslation("tooltip." + MOD_ID + ".chainsaw.tooltip.2", "§oChainsaw go vroom!§r");

        addTranslation("tooltip." + MOD_ID + ".lightsaber.tooltip.1", "May The Fourth Be With You");
        addTranslation("tooltip." + MOD_ID + ".onion.tooltip.1", "Tastes Great, for an onion!");
        addTranslation("tooltip." + MOD_ID + ".magic_block.tooltip.1", "This Block is §9MAGICAL§r");

        addTranslation("item." + MOD_ID + ".metal_detector.no_valuables", "No Valuables Found!");

        addTranslation("name." + MOD_ID + ".pedestal_be", "Pedestal");
        addTranslation("name." + MOD_ID + ".crystallizer", "Crystallizer");

        addTranslation("entity." + MOD_ID + ".giraffe", "Giraffe");
        addTranslation("entity." + MOD_ID + ".fire_truck", "Fire Truck");

         */


    }
}
