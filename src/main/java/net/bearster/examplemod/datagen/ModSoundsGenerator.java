package net.bearster.examplemod.datagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.logging.LogUtils;
import net.minecraft.core.HolderSet;
import net.minecraft.tags.BiomeTags;
import org.slf4j.Logger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static net.bearster.examplemod.ExampleMod.MOD_ID;

public class ModSoundsGenerator {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public void addSound(String soundName) {

        sounds.put(soundName, Map.of(
                "subtitle","sounds."+MOD_ID+"."+soundName,
                "sounds", List.of(
                        MOD_ID+":"+soundName)
        ));

        // Path for sound file
        Path soundPath = Paths.get(soundDataPath, "sounds.json");

        try {
            Files.createDirectories(soundPath.getParent());
            try (BufferedWriter writer = Files.newBufferedWriter(soundPath)) {
                GSON.toJson(sounds, writer);
            }
            LOGGER.info("Wrote sounds JSON to: {}", soundDataPath);
        } catch (IOException e) {
            LOGGER.error("Failed to write sounds JSON: {}", e.getMessage(), e);
        }
    }

    public void addJukeboxSound(String soundName, int comparatorOutput, int lengthInSeconds) {
        Map<Object, Object> song = new LinkedHashMap<>();

        song.put("comparator_output", comparatorOutput);
        song.put("description",Map.of(
                "translate", "item."+MOD_ID+"."+soundName+"_music_disc.desc"
                ));
        song.put("length_in_seconds",lengthInSeconds);
        song.put("sound_event",MOD_ID+"."+soundName);

        // Path for translation file
        Path songPath = Paths.get(songDataPath, soundName+".json");

        try {
            Files.createDirectories(songPath.getParent());
            try (BufferedWriter writer = Files.newBufferedWriter(songPath)) {
                GSON.toJson(song, writer);
            }
            LOGGER.info("Wrote sounds JSON to: {}", songDataPath);
        } catch (IOException e) {
            LOGGER.error("Failed to write sounds JSON: {}", e.getMessage(), e);
        }

    }

    private String soundDataPath = "D:\\Codeing\\Java\\Minecraft\\forge-1.21.1-example-mod\\src\\main\\resources\\assets\\"+MOD_ID; // Change this line. You want to change the path
    private String songDataPath = "D:\\Codeing\\Java\\Minecraft\\forge-1.21.1-example-mod\\src\\main\\resources\\data\\"+MOD_ID+"\\jukebox_song"; // Change this line. You want to change the path


    public Map<Object, Object> sounds = new LinkedHashMap<>();

    public void registerSounds() {
        LOGGER.info("Registering sounds...");

        /*

        addSound("chainsaw_cut");
        addSound("chainsaw_pull");
        addSound("magic_block_break");
        addSound("magic_block_step");
        addSound("magic_block_place");
        addSound("magic_block_hit");
        addSound("magic_block_fall");
        addSound("firefighter");
        addJukeboxSound("bar_brawl", 15, 162);
        addJukeboxSound("j0j0jetz_club", 15, 23);

         */

    }
}
