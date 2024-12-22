package tests;

import interfaces.ImageProcessorFactory;
import factories.ColorCorrectionFactory;
import factories.ResizeFactory;
import factories.FilterApplicationFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryIntegrationTest {
    @Test
    void testFactoryIntegration() {
        // Тест ColorCorrectionFactory
        ImageProcessorFactory colorCorrectionFactory = new ColorCorrectionFactory();
        assertNotNull(colorCorrectionFactory.createProcessor(), "ColorCorrectionFactory should create a processor.");

        // Тест ColorCorrectionFactory
        ImageProcessorFactory filterApplicationFactory = new FilterApplicationFactory();
        assertNotNull(filterApplicationFactory.createProcessor(), "FilterApplicationFactory should create a processor.");

        // Тест ResizeFactory
        ImageProcessorFactory resizeFactory = new ResizeFactory(300, 300);
        assertNotNull(resizeFactory.createProcessor(), "ResizeFactory should create a processor.");
    }
}
