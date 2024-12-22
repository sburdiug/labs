package tests;

import processors.Resize;
import config.ResizeConfig;


import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ResizeTest {
    @Test
    void testResizeProcess1() {
        // Підготовка
        ResizeConfig config = new ResizeConfig(500, 500);
        Resize resizeProcessor = new Resize(config);
        String testImagePath = "D:/java labs/labs/lab4/cobatary_Arc.jpg";

        // Виконання
        resizeProcessor.process(testImagePath);

        // Перевірка результату (перевіряємо, чи файл створений)
        File outputFile = new File("resized_cobatary_Arc.jpg");
        assertTrue(outputFile.exists(), "Resized file should exist after processing.");
        outputFile.delete();
    }
    @Test
    void testResizeProcess2() {
        // Підготовка
        ResizeConfig config = new ResizeConfig(400, 233);
        Resize resizeProcessor = new Resize(config);
        String testImagePath = "D:/java labs/labs/lab4/cobatary_Arc.jpg";

        // Виконання
        resizeProcessor.process(testImagePath);

        // Перевірка результату (перевіряємо, чи файл створений)
        File outputFile = new File("resized_cobatary_Arc.jpg");
        assertTrue(outputFile.exists(), "Resized file should exist after processing.");
        outputFile.delete();
    }
}
