package net.bearster.learningmod.datagen.paintings;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

public class ModPaintingGenerator {

        try {
            FileWriter myWriter = new FileWriter("D:\\Codeing\\Java\\Minecraft\\forge-1.21-tutorial-mod\\src\\main\\resources\\data\\learningmod\\painting_variant\\"+fileName+".json");
            myWriter.write("{\n  \"asset_id\":\"learningmod:"+fileName+"\",\n  \"height\":"+height+",\n  \"width\":"+width+"\n}");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void makeFolder(String folderName) {
        Path folderPath = Paths.get(folderName);
        try {
            Files.createDirectories(folderPath);
            System.out.println("Folder created successfully!");
        } catch (Exception e) {
            System.out.println("Failed to create the folder: " + e.getMessage());
        }
    }


            try {
                // Read the file content
                String content = new String(Files.readAllBytes(filePath));

                // Insert the text at the desired position
                String updatedContent = content.substring(0, insertPosition) + textToInsert + content.substring(insertPosition);

                // Write the updated content back to the file
                Files.write(filePath, updatedContent.getBytes());
                System.out.println("Text inserted successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int characterCount = 0;

        try {
            // Read the file content as a String
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Count the number of characters
            characterCount = content.length();

            System.out.println("Number of characters in the file: " + characterCount);

            return characterCount;
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        return characterCount;
    }

    public static void createPaintings() {
    }
}
