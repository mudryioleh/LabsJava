package servece;

public class TaskService {
    public void printWithFor() {
        System.out.println("Виведення фрази за допомогою циклу for:");
        String phrase = "Програмування на Java";
        for (int i = 0; i < 50; i++) {
            System.out.println(phrase);
        }
    }

    public void printWithWhile() {
        System.out.println("Виведення фрази за допомогою циклу while:");
        String phrase = "Програмування на Java";
        int count = 0;
        while (count < 50) {
            System.out.println(phrase);
            count++;
        }
    }

    public void printHoursFor() {
        System.out.println("Час за допомогою циклу for (г і хв):");
        for (int h = 0; h <= 2; h++) {
            for (int m = 0; m < 60; m++) {
                System.out.println(h + " h " + m + " min");
            }
        }
    }

    public void printHoursWhile() {
        System.out.println("Час за допомогою циклу while (г і хв):");
        int h = 0;
        while (h <= 2) {
            int m = 0;
            while (m < 60) {
                System.out.println(h + " h " + m + " min");
                m++;
            }
            h++;
        }
    }

    public void printHoursMinutesSeconds() {
        System.out.println("Час за допомогою циклу (г, хв, сек):");
        for (int h = 0; h <= 2; h++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s < 60; s++) {
                    System.out.println(h + " h " + m + " min " + s + " sec");
                }
            }
        }
    }

    public void tabulateWithFor(double lowerBound, double upperBound) {
        System.out.println("Табуляція з циклом for (x від -1 до 2 крок 0.2):");
        int countInRange = 0;
        for (double x = -1.0; x <= 2.0 + 1e-9; x += 0.2) {
            double fx = Math.pow(x, 5) - x + 1.8;
            System.out.printf("x=%.1f, f(x)=%.4f\n", x, fx);
            if (fx >= lowerBound && fx <= upperBound) {
                countInRange++;
            }
        }
        if (countInRange > 0) {
            System.out.println("Значень у заданому діапазоні: " + countInRange);
        } else {
            System.out.println("Значення у вказаному діапазоні відсутні");
        }
    }

    public void tabulateWithWhile(double lowerBound, double upperBound) {
        System.out.println("Табуляція з циклом while (x від -1 до 2 крок 0.2):");
        int countInRange = 0;
        double x = -1.0;
        while (x <= 2.0 + 1e-9) {
            double fx = Math.pow(x, 5) - x + 1.8;
            System.out.printf("x=%.1f, f(x)=%.4f\n", x, fx);
            if (fx >= lowerBound && fx <= upperBound) {
                countInRange++;
            }
            x += 0.2;
        }
        if (countInRange > 0) {
            System.out.println("Значень у заданому діапазоні: " + countInRange);
        } else {
            System.out.println("Значення у вказаному діапазоні відсутні");
        }
    }
}
