package services;

import java.util.Scanner;

public class InputHelper {

    public static int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Невірний ввід. Будь ласка, введіть ціле число.");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }

    public static double readDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out
                    .println("Невірний ввід. Будь ласка, введіть число (використовуйте крапку для дробової частини).");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextDouble();
    }
}
