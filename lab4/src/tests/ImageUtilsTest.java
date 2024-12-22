package tests;

import org.junit.jupiter.api.Test;
import utils.ImageUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ImageUtilsTest {

    private static final String TEST_IMAGE_PATH = "test_image.jpg";
    private static final String OUTPUT_IMAGE_PREFIX = "output";

    @Test
    void testReadImageValidFile() throws IOException {

        // Створення тестового зображення
        BufferedImage testImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        ImageIO.write(testImage, "jpg", new File(TEST_IMAGE_PATH));

        // Виклик методу readImage
        BufferedImage resultImage = ImageUtils.readImage(TEST_IMAGE_PATH);

        // Перевірка
        assertNotNull(resultImage, "Image should be read successfully.");

        // Видалення тестового файлу
        new File(TEST_IMAGE_PATH).delete();

    }

    @Test
    void testReadImageInvalidFile() {
        // Виклик методу readImage для неіснуючого файлу
        BufferedImage resultImage = ImageUtils.readImage("invalid_image.jpg");

        // Перевірка
        assertNull(resultImage, "Reading an invalid image should return null.");
    }

    @Test
    void testSaveImage() {

            // Створення тестового зображення
            BufferedImage testImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);

            // Виклик методу saveImage
            ImageUtils.saveImage(testImage, TEST_IMAGE_PATH, OUTPUT_IMAGE_PREFIX);

            // Перевірка, чи файл створений
            File outputFile = new File(OUTPUT_IMAGE_PREFIX + "_" + new File(TEST_IMAGE_PATH).getName());
            assertTrue(outputFile.exists(), "Saved image file should exist.");

            // Видалення тестового файлу
            outputFile.delete();

    }
}
