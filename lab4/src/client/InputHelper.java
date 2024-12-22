package client;

import java.util.Scanner;

public class InputHelper {
    private final Scanner scanner;

    // Конструктор ініціалізує Scanner
    public InputHelper() {
        this.scanner = new Scanner(System.in);
    }

    // Зчитування цілого числа
    public int getInt(String prompt) {
        System.out.println(prompt);
        return scanner.nextInt();
    }

    // Зчитування рядка
    public String getString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    // Закриття Scanner
    public void close() {
        scanner.close();
    }
}
