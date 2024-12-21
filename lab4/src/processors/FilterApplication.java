package processors;

import interfaces.ImageProcessor;

public class FilterApplication implements ImageProcessor {
    @Override
    public void process(String image) {
        System.out.println("Applying filter to: " + image);
        System.out.println("Filter application completed.");
    }
}
