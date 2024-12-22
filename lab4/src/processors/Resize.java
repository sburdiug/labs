
/*

public class Resize implements ImageProcessor {
    @Override
    public void process(String image) {
        System.out.println("Resizing image: " + image);
        System.out.println("Resize completed.");
    }
} */


package processors;

import config.ResizeConfig;
import interfaces.ImageProcessor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Resize implements ImageProcessor {
    private final ResizeConfig config;

    public Resize(ResizeConfig config) {
        this.config = config;
    }

    @Override
    public void process(String imagePath) {
        int targetWidth = config.targetWidth();
        int targetHeight = config.targetHeight();

        System.out.println("Resizing image: " + imagePath + " to " + targetWidth + "x" + targetHeight);

        try {
            File inputFile = new File(imagePath);
            BufferedImage inputImage = ImageIO.read(inputFile);

            BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, inputImage.getType());
            Graphics2D graphics = resizedImage.createGraphics();
            graphics.drawImage(inputImage, 0, 0, targetWidth, targetHeight, null);
            graphics.dispose();

            File outputFile = new File("resized_" + inputFile.getName());
            ImageIO.write(resizedImage, "jpg", outputFile);
            System.out.println("Resize completed. Saved to: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error resizing image: " + e.getMessage());
        }
    }
}


