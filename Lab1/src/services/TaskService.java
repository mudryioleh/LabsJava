package services;

import models.User;
import models.Car;

public class TaskService {

    public void solveTask1() {
        printHeader(1);
        int[] numbers = { 100000, 50, 20, 10, 5, 4, 2, 2, 1, 5 };

        int sum = numbers[0];
        int difference = numbers[0];
        long product = numbers[0];
        int quotient = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            sum = sum + numbers[i];
            difference = difference - numbers[i];
            product = product * numbers[i];
            quotient = quotient / numbers[i];
        }

        System.out.println("--- Результати обчислень (Масив) ---");
        System.out.print("Масив чисел: ");

        for (int n : numbers) {
            System.out.print(n + " ");
        }

        System.out.println("\n------------------------------------");
        System.out.println("Сума (+): " + sum);
        System.out.println("Різниця (-): " + difference);
        System.out.println("Добуток (*): " + product);
        System.out.println("Частка (/): " + quotient);
    }

    public void solveTask2() {
        printHeader(2);

        String[] words = { "Вивчення", "мови", "Java", "допомагає", "створювати", "потужні", "та", "сучасні",
                "програмні", "продукти", "." };

        StringBuilder sentence = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sentence.append(words[i]);
            if (i < words.length - 1 && !words[i + 1].equals(".")) {
                sentence.append(" ");
            }
        }
        System.out.println(sentence);
    }

    public void solveTask3() {
        printHeader(3);

        User[] users = {
                new User(1, 25, "Ivan", "Petrov", 70.5, 175),
                new User(2, 30, "Oleg", "Ivanov", 85.0, 182),
                new User(3, 18, "Anna", "Sidorova", 55.2, 165),
                new User(4, 45, "Petro", "Koval", 90.0, 178),
                new User(5, 22, "Maria", "Bondar", 60.0, 170),
                new User(6, 35, "Alex", "Shevchenko", 78.4, 180),
                new User(7, 50, "Olga", "Tkach", 65.5, 168),
                new User(8, 29, "Dmytro", "Melnyk", 82.1, 185),
                new User(9, 40, "Yulia", "Boyko", 58.9, 164),
                new User(10, 27, "Sergiy", "Kravchuk", 75.0, 177),
        };

        int totalAge = 0;
        double totalWeight = 0;
        double totalHeight = 0;

        for (User user : users) {
            totalAge += user.getAge();
            totalWeight += user.getWeight();
            totalHeight += user.getHeight();
        }

        System.out.println("Сума віку всіх юзерів: " + totalAge);
        System.out.println("Сума ваги всіх юзерів: " + totalWeight);
        System.out.println("Сума зросту всіх юзерів: " + totalHeight);
        System.out.println();
    }

    public void solveTask4() {
        printHeader(4);

        Car[] cars = {
                new Car(150, 2.0, "Toyota", "Camry", 2020, false, 25000),
                new Car(300, 3.5, "BMW", "X5", 2022, false, 60000),
                new Car(100, 1.4, "Ford", "Fiesta", 2018, false, 12000),
                new Car(450, 0.0, "Tesla", "Model S", 2023, true, 80000),
                new Car(180, 2.5, "Mazda", "6", 2021, false, 28000),
                new Car(250, 2.0, "Audi", "A4", 2019, false, 35000),
                new Car(130, 1.6, "Hyundai", "Elantra", 2020, false, 18000),
                new Car(500, 4.0, "Mercedes", "AMG", 2023, false, 95000),
                new Car(110, 1.5, "Renault", "Megane", 2017, false, 10000),
                new Car(200, 2.4, "Honda", "Accord", 2021, false, 30000),
        };

        double totalEngineVolume = 0;
        int totalHorsePower = 0;

        for (Car car : cars) {
            totalEngineVolume += car.getEngineVolume();
            totalHorsePower += car.getHorsePower();
        }

        System.out.println("Сумарний об'єм двигунів: " + totalEngineVolume);
        System.out.println("Сумарна потужність (к.с.): " + totalHorsePower);
        System.out.println();
    }

    public void solveTask5() {
        printHeader(5);

        int number = 412;
        System.out.println("Початкове число: " + number);

        int digit1 = number % 10;
        int digit2 = (number / 10) % 10;
        int digit3 = number / 100;

        int reversedNumber = (digit1 * 100) + (digit2 * 10) + digit3;

        System.out.println("Реверснуте число: " + reversedNumber);
    }

    private void printHeader(int taskNumber) {
        System.out.println("\n------------------------------------");
        System.out.println("Завдання " + taskNumber);
        System.out.println("------------------------------------");
    }
}
