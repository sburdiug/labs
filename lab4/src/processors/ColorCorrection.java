/*package processors;

import interfaces.ImageProcessor;

public class ColorCorrection implements ImageProcessor {
    @Override
    public void process(String image) {
        System.out.println("Applying color correction to: " + image);
        System.out.println("Color correction completed.");
    }
}*/

package processors;

import interfaces.ImageProcessor;
import utils.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ColorCorrection implements ImageProcessor {

    @Override
    public void process(String imagePath) {
        System.out.println("Applying red color filter to: " + imagePath);

        BufferedImage image = ImageUtils.readImage(imagePath);
        if (image == null) return;

        applyRedFilter(image);

        ImageUtils.saveImage(image, imagePath, "red_filter");
    }

    // Логіка червоного фільтру
    private void applyRedFilter(BufferedImage image) {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int pixel = image.getRGB(x, y);
                Color color = new Color(pixel, true);

                int red = Math.min(255, (int) (color.getRed() * 1.5));
                int green = Math.min(255, (int) (color.getGreen() * 0.5));
                int blue = Math.min(255, (int) (color.getBlue() * 0.5));

                Color newColor = new Color(red, green, blue, color.getAlpha());
                image.setRGB(x, y, newColor.getRGB());
            }
        }
    }
}

