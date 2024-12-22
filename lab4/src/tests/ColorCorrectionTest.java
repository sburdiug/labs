//package tests;
//
//
//import org.junit.jupiter.api.Test;
//import processors.ColorCorrection;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class ColorCorrectionTest {
//    @Test
//    void testColorCorrectionTest() {
//        // Підготовка
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStream));
//
//        ColorCorrection colorCorrection = new ColorCorrection();
//
//        // Виконання
//        String testImage = "test_image.jpg";
//        colorCorrection.process(testImage);
//
//        // Отримання результату виводу
//        String output = outputStream.toString();
//
//        // Перевірка результату
//        assertTrue(output.contains("Applying color correction to: " + testImage));
//        assertTrue(output.contains("Color correction completed."));
//
//    }
//
//}


package tests;

import org.junit.jupiter.api.Test;
import processors.ColorCorrection;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ColorCorrectionTest {

    @Test
    void testProcessValidImage() {
        // Вхідні дані
        String inputImagePath = "D:/java labs/labs/lab4/cobatary_Arc.jpg"; // Замініть на існуючий файл
        String outputImagePath = "red_filter_cobatary_Arc.jpg";

        // Запуск обробки
        ColorCorrection colorCorrection = new ColorCorrection();
        colorCorrection.process(inputImagePath);

        // Перевірка результату
        File outputFile = new File(outputImagePath);
        assertTrue(outputFile.exists(), "Output red filter image should be created.");
    }

    @Test
    void testProcessInvalidImage() {
        // Вхідні дані
        String inputImagePath = "invalid_image.jpg"; // Неправильний шлях до зображення

        // Запуск обробки
        ColorCorrection colorCorrection = new ColorCorrection();
        colorCorrection.process(inputImagePath);

        // Перевірка відсутності результату
        String outputImagePath = "red_filter_invalid_image.jpg";
        File outputFile = new File(outputImagePath);
        assertTrue(!outputFile.exists(), "Output file should not be created for an invalid image.");
    }
}
