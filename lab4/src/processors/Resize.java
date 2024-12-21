package processors;

import interfaces.ImageProcessor;

public class Resize implements ImageProcessor {
    @Override
    public void process(String image) {
        System.out.println("Resizing image: " + image);
        System.out.println("Resize completed.");
    }
}
