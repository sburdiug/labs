package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtils {

    // Універсальний метод для збереження зображення
    public static void saveImage(BufferedImage image, String originalPath, String prefix) {
        try {
            String outputFilePath = prefix + "_" + new File(originalPath).getName();
            File outputFile = new File(outputFilePath);
            ImageIO.write(image, "jpg", outputFile);
            System.out.println("Image saved successfully to: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error saving the image: " + e.getMessage());
        }
    }

    // Універсальний метод для зчитування зображення
    public static BufferedImage readImage(String imagePath) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            if (image == null) {
                System.out.println("Invalid image file. Please provide a valid image.");
            }
            return image;
        } catch (IOException e) {
            System.out.println("Error reading the image: " + e.getMessage());
            return null;
        }
    }
}
