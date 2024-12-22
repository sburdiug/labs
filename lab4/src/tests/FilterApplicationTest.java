package tests;

import org.junit.jupiter.api.Test;
import processors.FilterApplication;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FilterApplicationTest {

    @Test
    void testProcessValidImage() {
        // Вхідні дані
        String inputImagePath = "D:/java labs/labs/lab4/cobatary_Arc.jpg"; // Замініть на існуючий файл
        String outputImagePath = "grayscale_cobatary_Arc.jpg";

        // Запуск обробки
        FilterApplication filterApplication = new FilterApplication();
        filterApplication.process(inputImagePath);

        // Перевірка результату
        File outputFile = new File(outputImagePath);
        assertTrue(outputFile.exists(), "Output grayscale image should be created.");
    }

    @Test
    void testProcessInvalidImage() {
        // Вхідні дані
        String inputImagePath = "invalid_image.jpg"; // Неправильний шлях до зображення

        // Запуск обробки
        FilterApplication filterApplication = new FilterApplication();
        filterApplication.process(inputImagePath);

        // Перевірка відсутності результату
        String outputImagePath = "grayscale_invalid_image.jpg";
        File outputFile = new File(outputImagePath);
        assertTrue(!outputFile.exists(), "Output file should not be created for an invalid image.");
    }
}
