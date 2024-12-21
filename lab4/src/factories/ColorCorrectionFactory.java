package factories;

import interfaces.ImageProcessor;
import interfaces.ImageProcessorFactory;
import processors.ColorCorrection;

public class ColorCorrectionFactory implements ImageProcessorFactory {
    @Override
    public ImageProcessor createProcessor() {
        return new ColorCorrection();
    }
}
