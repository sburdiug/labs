//package processors;
//
//import interfaces.ImageProcessor;
//
//public class FilterApplication implements ImageProcessor {
//    @Override
//    public void process(String image) {
//        System.out.println("Applying filter to: " + image);
//        System.out.println("Filter application completed.");
//    }
//}
package processors;

import interfaces.ImageProcessor;
import utils.ImageUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FilterApplication implements ImageProcessor {

    @Override
    public void process(String imagePath) {
        System.out.println("Converting to grayscale: " + imagePath);

        // Використання утилітного методу для зчитування зображення
        BufferedImage image = ImageUtils.readImage(imagePath);
        if (image == null) return;

        applyGrayscaleFilter(image);

        ImageUtils.saveImage(image, imagePath, "grayscale");
    }

    // Логіка чорно-білого фільтру
    private void applyGrayscaleFilter(BufferedImage image) {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int pixel = image.getRGB(x, y);
                Color color = new Color(pixel, true);

                // Обчислення середнього значення для градації сірого
                int gray = (int) (0.3 * color.getRed() + 0.59 * color.getGreen() + 0.11 * color.getBlue());

                Color newColor = new Color(gray, gray, gray, color.getAlpha());
                image.setRGB(x, y, newColor.getRGB());
            }
        }
    }
}


