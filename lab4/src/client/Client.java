package client;


import factories.ColorCorrectionFactory;
import factories.FilterApplicationFactory;
import factories.ResizeFactory;

public class Client {
    public static void main(String[] args) {
        InputHelper inputHelper = new InputHelper();

        String image = inputHelper.getString("Enter the path to the image file:");


        new ColorCorrectionFactory().createProcessor().process(image);
        new FilterApplicationFactory().createProcessor().process(image);

        int width = inputHelper.getInt("Enter target width for Resize:");
        int height = inputHelper.getInt("Enter target height for Resize:");

        new ResizeFactory(width, height).createProcessor().process(image);

        inputHelper.close();
    }
}
