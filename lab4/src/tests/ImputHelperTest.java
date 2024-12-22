package tests;

import client.InputHelper;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputHelperTest {
    @Test
    void testGetInt() {
        // Імітуємо ввід користувача
        String simulatedInput = "42\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        InputHelper inputHelper = new InputHelper();


        int result = inputHelper.getInt("Enter a number:");

        assertEquals(42, result, "InputHelper should correctly parse integer input.");
    }
    @Test
    void testGetString() {
        // Імітуємо ввід тексту користувачем
        String simulatedInput = "Hello, World!\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        InputHelper inputHelper = new InputHelper();

        // Виконання
        String result = inputHelper.getString("Enter a string:");

        // Перевірка
        assertEquals("Hello, World!", result, "InputHelper should correctly parse string input.");
    }
    @Test
    void testCloseScanner() {
        InputHelper inputHelper = new InputHelper();
        inputHelper.close();

        // Перевіряємо, чи Scanner закритий
        assertThrows(IllegalStateException.class, () -> inputHelper.getInt("Test Scanner:"));
    }


}
