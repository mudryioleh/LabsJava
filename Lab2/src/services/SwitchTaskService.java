package services;

import java.util.Scanner;

public class SwitchTaskService {
    public void checkDayType(int day) {
        System.out.println("\n--- Завдання 4.2.1: Дні тижня ---");
        switch (day) {
            case 1, 2, 3, 4, 5 -> System.out.println("Це робочий день.");
            case 6, 7 -> System.out.println("Це вихідний день.");
            default -> System.out.println("Невірне число. Введіть число від 1 до 7.");
        }
    }

    public void checkMonthType(int month) {
        System.out.println("\n--- Завдання 4.2.2: Місяці року ---");
        switch (month) {
            case 12, 1, 2 -> System.out.println("Це зимовий місяць.");
            case 3, 4, 5 -> System.out.println("Це весняний місяць.");
            case 6, 7, 8 -> System.out.println("Це літній місяць.");
            case 9, 10, 11 -> System.out.println("Це осінній місяць.");
            default -> System.out.println("Невірне число. Введіть число від 1 до 12.");
        }
    }

    public void textMenu() {
        System.out.println("\n--- Завдання 4.2.3: Текстове меню ---");
        System.out.println("1 - Привітання");
        System.out.println("2 - Запрошення до роботи на комп'ютері");
        System.out.println("3 - Завершити роботу");

        int choice = InputHelper.readInt(new Scanner(System.in), "Ваш вибір: ");

        switch (choice) {
            case 1 -> System.out.println("Вітаємо у нашій програмі!");
            case 2 -> System.out.println("Запрошуємо до роботи на комп'ютері.");
            case 3 -> System.out.println("Пропонується завершити роботу.");
            default -> System.out.println("Невідомий пункт меню.");
        }
    }

    public void getSubject(int pairNumber) {
        System.out.println("\n--- Завдання 4.2.5: Розклад пар ---");
        switch (pairNumber) {
            case 1 -> System.out.println(pairNumber + " пара: Вища математика");
            case 2 -> System.out.println(pairNumber + " пара: Програмування (Java)");
            case 3 -> System.out.println(pairNumber + " пара: Фізика");
            case 4 -> System.out.println(pairNumber + " пара: Англійська мова");
            default -> System.out.println("У вас немає такої пари (введіть від 1 до 4)");
        }
    }

    public void getQuarterOfHour(int min) {
        System.out.println("\n--- Завдання 4.2.6: Чверть години ---");
        if (min < 0 || min > 59) {
            System.out.println("Помилка: хвилини мають бути від 0 до 59");
            return;
        }

        switch (min / 15) {
            case 0 -> System.out.println(min + " хв - це Перша чверть (0-14)");
            case 1 -> System.out.println(min + " хв - це Друга чверть (15-29)");
            case 2 -> System.out.println(min + " хв - це Третя чверть (30-44)");
            case 3 -> System.out.println(min + " хв - це Четверта чверть (45-59)");
        }
    }

    // Завдання 4.2: Текстове меню (Пункт 7)
    public void runMathMenu(Scanner scanner) {
        System.out.println("\n--- Завдання 4.2.7: Текстове меню калькулятора ---");
        System.out.println("1 - Знайти добуток (*)");
        System.out.println("2 - Знайти суму (+)");
        System.out.println("3 - Знайти різницю (-)");

        int choice;
        do {
            choice = InputHelper.readInt(scanner, "Оберіть пункт меню (1-3): ");
            if (choice < 1 || choice > 3) {
                System.out.println("Потрібно обрати пункт 1, 2 або 3.");
            }
        } while (choice < 1 || choice > 3);

        double num1 = InputHelper.readDouble(scanner, "Введіть перше число: ");
        double num2 = InputHelper.readDouble(scanner, "Введіть друге число: ");

        switch (choice) {
            case 1 -> System.out.printf("Добуток: %.2f\n", (num1 * num2));
            case 2 -> System.out.printf("Сума: %.2f\n", (num1 + num2));
            case 3 -> System.out.printf("Різниця: %.2f\n", (num1 - num2));
            default -> System.out.println("Помилка: такого пункту меню не існує.");
        }
    }
}
