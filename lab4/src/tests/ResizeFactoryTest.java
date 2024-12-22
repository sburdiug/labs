package tests;

import factories.ResizeFactory;
import processors.Resize;
import interfaces.ImageProcessor;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class ResizeFactoryTest {
    @Test
    void testResizeFactoryCreatesResizeProcessor() {
        // Підготовка
        ResizeFactory factory = new ResizeFactory(800, 600);

        // Виконання
        ImageProcessor processor = factory.createProcessor();

        // Перевірка
        assertNotNull(processor, "Factory should create a processor.");
        assertInstanceOf(Resize.class, processor, "Processor should be an instance of Resize.");
    }
}
