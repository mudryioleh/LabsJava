package services;

public class MathTaskService {
    // Завдання 1: Квадратне рівняння
    public void solveQuadraticEquation(double a, double b, double c) {
        System.out.println("\n--- Завдання 1: Квадратне рівняння ---");
        if (a == 0) {
            System.out.println("Це не квадратне рівняння (a = 0).");
            return;
        }

        double d = b * b - 4 * a * c;
        if (d > 0) {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.printf("D > 0. Два корені: x1 = %.2f, x2 = %.2f\n", x1, x2);
        } else if (d == 0) {
            double x = -b / (2 * a);
            System.out.printf("D = 0. Один корінь: x = %.2f\n", x);
        } else {
            System.out.println("D < 0. Дійсних коренів немає.");
        }
    }

    // Завдання 4.1: Обчислення f(x) (Варіант 7)
    public void calculateFactorial(double x) {
        System.out.println("\n--- Завдання 4.1: Обчислення f(x) ---");
        double result;

        if (x < 0) {
            result = Math.abs(x + 7);
        } else if (x >= 0 && x <= 5) {
            result = Math.sqrt(x) + Math.pow(x - 1, 0.25);
        } else {
            result = Math.log(x);
        }

        System.out.printf("При x = %.2f, f(x) = %.4f\n", x, result);
    }
}
