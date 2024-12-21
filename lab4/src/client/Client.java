package client;

import interfaces.ImageProcessorFactory;
import factories.ColorCorrectionFactory;
import factories.FilterApplicationFactory;
import factories.ResizeFactory;

import java.util.Scanner;

public class Client {
    public static void processImage(ImageProcessorFactory factory, String image) {
        // Виклик обробки через фабрику
        factory.createProcessor().process(image);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Симуляція зображення
        String image = "SampleImage.jpg";
        System.out.println("Image to process: " + image);

        // Меню для вибору операції
        System.out.println("Choose an operation:");
        System.out.println("1. Color Correction");
        System.out.println("2. Filter Application");
        System.out.println("3. Resize");

        int choice = scanner.nextInt();

        // Виклик потрібної фабрики
        switch (choice) {
            case 1:
                processImage(new ColorCorrectionFactory(), image);
                break;
            case 2:
                processImage(new FilterApplicationFactory(), image);
                break;
            case 3:
                processImage(new ResizeFactory(), image);
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
        }

        scanner.close();
    }
}
