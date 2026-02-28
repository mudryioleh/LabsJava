package services;

public class LogicTaskService {
    // Завдання 2: Квадрант координати
    public void findQuadrant(double x, double y) {
        System.out.println("\n--- Завдання 2: Квадрант координати ---");
        System.out.printf("Точка (%.1f, %.1f): ", x, y);

        if (x > 0 && y > 0)
            System.out.println("I квадрант");
        else if (x < 0 && y > 0)
            System.out.println("II квадрант");
        else if (x < 0 && y < 0)
            System.out.println("III квадрант");
        else if (x > 0 && y < 0)
            System.out.println("IV квадрант");
        else
            System.out.println("Лежить на осі або в центрі координат");
    }

    // Завдання 3: Перевірка числа (двозначне і парне)
    public void checkNumber(int number) {
        System.out.println("\n--- Завдання 3: Перевірка числа ---");
        int absNum = Math.abs(number);

        boolean isTwoDigit = absNum >= 10 && absNum <= 99;
        boolean isEven = number % 2 == 0;

        if (isTwoDigit && isEven) {
            System.out.println("Число " + number + " є двозначним І парним.");
        } else {
            System.out.println("Число " + number + " не відповідає умовам.");
        }
    }
}
