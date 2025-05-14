package net.bearster.learningmod.datagen.paintings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Scanner;

public class ModPaintingGenerator {
    private static String lastPaintingFileName;

    public static void writeToFile(String fileName, int height, int width, String paintingTitle, String paintingAuthor) {
        try {
            FileWriter myWriter = new FileWriter("D:\\Codeing\\Java\\Minecraft\\forge-1.21-tutorial-mod\\src\\main\\resources\\data\\learningmod\\painting_variant\\"+fileName+".json");
            myWriter.write("{\n  \"asset_id\":\"learningmod:"+fileName+"\",\n  \"height\":"+height+",\n  \"width\":"+width+"\n}");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        if (lastPaintingFileName.equals(fileName)) {
            insertIntoFile(fileName, "D:\\Codeing\\Java\\Minecraft\\forge-1.21-tutorial-mod\\src\\main\\resources\\data\\minecraft\\tags\\painting_variant\\placeable.json", 4,
                    "    \"learningmod:" + fileName + "\"\n",
                    "    \"learningmod:" + fileName + "\",",
                    "    \"learningmod:" + fileName + "\"");
        } else {
            insertIntoFile(fileName, "D:\\Codeing\\Java\\Minecraft\\forge-1.21-tutorial-mod\\src\\main\\resources\\data\\minecraft\\tags\\painting_variant\\placeable.json", 4,
                    "    \"learningmod:" + fileName + "\",\n",
                    "    \"learningmod:" + fileName + "\",",
                    "    \"learningmod:" + fileName + "\"");
        }
        insertIntoFile(fileName, "D:\\Codeing\\Java\\Minecraft\\forge-1.21-tutorial-mod\\src\\main\\resources\\assets\\learningmod\\lang\\en_us.json", 3,
                ",\n  \n  \"painting.learningmod."+fileName+".title\":\""+paintingTitle+"\"",
                "  \"painting.learningmod."+fileName+".title\":\""+paintingTitle+"\",",
                "  \"painting.learningmod."+fileName+".title\":\""+paintingTitle+"\"");
        insertIntoFile(fileName, "D:\\Codeing\\Java\\Minecraft\\forge-1.21-tutorial-mod\\src\\main\\resources\\assets\\learningmod\\lang\\en_us.json", 3,
                ",\n  \"painting.learningmod."+fileName+".author\":\""+paintingAuthor+"\"",
                "  \"painting.learningmod."+fileName+".author\":\""+paintingAuthor+"\",",
                "  \"painting.learningmod."+fileName+".author\":\""+paintingAuthor+"\""
        );
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

    public static void insertIntoFile(String paintingName, String fileName, int amountBack, String insertedText, String readableInsertion, String secondReadableInsertion) {
        Path filePath = Paths.get(fileName);
        String textToInsert = insertedText;
        int insertPosition = countCharacters(fileName) - amountBack; // Position in characters

        if (readFile(fileName,readableInsertion,secondReadableInsertion)) {
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
    }

    public static int countCharacters(String fileName) {
        String filePath = fileName; // Replace with your file path
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

    public static boolean readFile(String fileName, String insertedLine, String secondInsertedLine) {
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals(insertedLine) || data.equals(secondInsertedLine)) {
                    return false;
                }
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return true;
    }

    public static void createPaintings() {
        lastPaintingFileName = "world";

        writeToFile("jojo_botw",4,8, "J0J0Jetz in BOTW","J0J0Jetz");
        writeToFile("jojo_knight",6,8, "J0J0Jetz getting knighted","HobbyBox");
        writeToFile("shrimp", 1, 2, "Shrimp","NanoAttack");
        writeToFile("saw_them", 2, 2, "Saw Them","NanoAttack");
        writeToFile("wanderer", 2, 1, "Wanderer","PlatinumG17");

        writeToFile("world",2,2, "World","NanoAttack");

        //"painting.learningmod.wanderer.title": "Wanderer",
        //  "painting.learningmod.wanderer.author": "PlatinumG17",
    }
}
