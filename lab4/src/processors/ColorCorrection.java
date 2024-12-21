package processors;

import interfaces.ImageProcessor;

public class ColorCorrection implements ImageProcessor {
    @Override
    public void process(String image) {
        System.out.println("Applying color correction to: " + image);
        System.out.println("Color correction completed.");
    }
}
