package tests;


import factories.FilterApplicationFactory;
import interfaces.ImageProcessor;
import org.junit.jupiter.api.Test;
import processors.FilterApplication;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class FilterApplicationFactoryTest {
    @Test
    void testFilterApplicationFactoryCreatesResizeProcessor() {
        // Підготовка
        FilterApplicationFactory factory = new FilterApplicationFactory();

        // Виконання
        ImageProcessor processor = factory.createProcessor();

        // Перевірка
        assertNotNull(processor, "Factory should create a processor.");
        assertInstanceOf(FilterApplication.class, processor, "Processor should be an instance of FilterApplication.");
    }
}
