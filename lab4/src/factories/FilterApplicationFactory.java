package factories;

import interfaces.ImageProcessor;
import interfaces.ImageProcessorFactory;
import processors.FilterApplication;

// Фабрика для створення FilterApplication
public class FilterApplicationFactory implements ImageProcessorFactory {
    @Override
    public ImageProcessor createProcessor() {
        return new FilterApplication();
    }
}
