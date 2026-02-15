
/* Завдання 3 */
class User {
    int id;
    int age;
    String name;
    String surname;
    double weight;
    double height;

    public User(int id, int age, String name, String surname, double weight, double height) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.weight = weight;
        this.height = height;
    }
}

/* Завдання 4 */
class Car {
    int horsePower;
    double engineVolume;

    String brand;
    String model;
    int year;
    boolean isElectric;
    double price;

    public Car(int horsePower, double engineVolume, String brand, String model, int year, boolean isElectric,
            double price) {
        this.horsePower = horsePower;
        this.engineVolume = engineVolume;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.isElectric = isElectric;
        this.price = price;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        soloveTask1();
        soloveTask2();
        soloveTask3();
        soloveTask4();
        soloveTask5();
    }

    public static void soloveTask1() {
        System.out.println("\n------------------------------------");
        System.out.println("Завдання 1");
        System.out.println("------------------------------------");
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

    public static void soloveTask2() {
        System.out.println("\n------------------------------------");
        System.out.println("Завдання 2");
        System.out.println("------------------------------------");

        String word1 = "Вивчення";
        String word2 = "мови";
        String word3 = "Java";
        String word4 = "допомагає";
        String word5 = "створювати";
        String word6 = "потужні";
        String word7 = "та";
        String word8 = "сучасні";
        String word9 = "програмні";
        String word10 = "продукти";
        String word11 = ".";

        String sentence = word1 + " " + word2 + " " + word3 + " " + word4 + " " +
                word5 + " " + word6 + " " + word7 + " " + word8 + " " +
                word9 + " " + word10 + word11;

        System.out.println(sentence);
    }

    public static void soloveTask3() {
        System.out.println("\n------------------------------------");
        System.out.println("Завдання 3");
        System.out.println("------------------------------------");

        User[] users = new User[10];

        users[0] = new User(1, 25, "Ivan", "Petrov", 70.5, 175);
        users[1] = new User(2, 30, "Oleg", "Ivanov", 85.0, 182);
        users[2] = new User(3, 18, "Anna", "Sidorova", 55.2, 165);
        users[3] = new User(4, 45, "Petro", "Koval", 90.0, 178);
        users[4] = new User(5, 22, "Maria", "Bondar", 60.0, 170);
        users[5] = new User(6, 35, "Alex", "Shevchenko", 78.4, 180);
        users[6] = new User(7, 50, "Olga", "Tkach", 65.5, 168);
        users[7] = new User(8, 29, "Dmytro", "Melnyk", 82.1, 185);
        users[8] = new User(9, 40, "Yulia", "Boyko", 58.9, 164);
        users[9] = new User(10, 27, "Sergiy", "Kravchuk", 75.0, 177);

        int totalAge = 0;
        double totalWeight = 0;
        double totalHeight = 0;

        for (User user : users) {
            totalAge += user.age;
            totalWeight += user.weight;
            totalHeight += user.height;
        }

        System.out.println("Сума віку всіх юзерів: " + totalAge);
        System.out.println("Сума ваги всіх юзерів: " + totalWeight);
        System.out.println("Сума зросту всіх юзерів: " + totalHeight);
        System.out.println();
    }

    public static void soloveTask4() {
        System.out.println("\n------------------------------------");
        System.out.println("Завдання 4");
        System.out.println("------------------------------------");

        Car[] cars = new Car[10];

        cars[0] = new Car(150, 2.0, "Toyota", "Camry", 2020, false, 25000);
        cars[1] = new Car(300, 3.5, "BMW", "X5", 2022, false, 60000);
        cars[2] = new Car(100, 1.4, "Ford", "Fiesta", 2018, false, 12000);
        cars[3] = new Car(450, 0.0, "Tesla", "Model S", 2023, true, 80000);
        cars[4] = new Car(180, 2.5, "Mazda", "6", 2021, false, 28000);
        cars[5] = new Car(250, 2.0, "Audi", "A4", 2019, false, 35000);
        cars[6] = new Car(130, 1.6, "Hyundai", "Elantra", 2020, false, 18000);
        cars[7] = new Car(500, 4.0, "Mercedes", "AMG", 2023, false, 95000);
        cars[8] = new Car(110, 1.5, "Renault", "Megane", 2017, false, 10000);
        cars[9] = new Car(200, 2.4, "Honda", "Accord", 2021, false, 30000);

        double totalEngineVolume = 0;
        int totalHorsePower = 0;

        for (Car car : cars) {
            totalEngineVolume += car.engineVolume;
            totalHorsePower += car.horsePower;
        }

        System.out.println("Сумарний об'єм двигунів: " + totalEngineVolume);
        System.out.println("Сумарна потужність (к.с.): " + totalHorsePower);
        System.out.println();
    }

    public static void soloveTask5() {
        System.out.println("\n------------------------------------");
        System.out.println("Завдання 5");
        System.out.println("------------------------------------");

        int number = 412;
        System.out.println("Початкове число: " + number);

        int digit1 = number % 10;
        int digit2 = (number / 10) % 10;
        int digit3 = number / 100;

        int reversedNumber = (digit1 * 100) + (digit2 * 10) + digit3;

        System.out.println("Реверснуте число: " + reversedNumber);
    }
}
