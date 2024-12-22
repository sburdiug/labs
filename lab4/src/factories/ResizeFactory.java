/*
public class ResizeFactory implements ImageProcessorFactory {
    @Override
    public ImageProcessor createProcessor() {
        return new Resize();
    }
}
*/
package factories;

import config.ResizeConfig;
import interfaces.ImageProcessor;
import interfaces.ImageProcessorFactory;
import processors.Resize;

public class ResizeFactory implements ImageProcessorFactory {
    private final ResizeConfig config;

    public ResizeFactory(int targetWidth, int targetHeight) {
        this.config = new ResizeConfig(targetWidth, targetHeight);
    }

    @Override
    public ImageProcessor createProcessor() {
        return new Resize(config);
    }
}
