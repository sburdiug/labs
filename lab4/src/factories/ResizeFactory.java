package factories;

import interfaces.ImageProcessor;
import interfaces.ImageProcessorFactory;
import processors.Resize;

public class ResizeFactory implements ImageProcessorFactory {
    @Override
    public ImageProcessor createProcessor() {
        return new Resize();
    }
}
