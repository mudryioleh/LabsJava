import service.Person;
import service.Phone;
import service.Luggage;
import service.cars.Sedan;
import service.cars.Truck;
import service.shapes.Ball;
import service.shapes.Cylinder;
import service.shapes.Pyramid;
import service.shapes.Shape;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        runPerson();
        runPhone();
        runShapes();
        runCars();
        runLuggage();
    }

    private static void runPerson() {
        System.out.println("---- Person ----");

        Person person1 = new Person();
        Person person2 = new Person("Імʼя Прізвище", 20);

        System.out.println(person1.move());
        System.out.println(person1.talk());

        System.out.println(person2.move());
        System.out.println(person2.talk());
    }

    private static void runPhone() {
        System.out.println("---- Phone ----");

        Phone phone1 = new Phone("1234567890", "Model A", 150.5);
        Phone phone2 = new Phone("0987654321", "Model B");
        Phone phone3 = new Phone("5555555555", "Model C", 180.0);

        System.out.println("Phone 1: number=" + phone1.getNumber() + ", model=" + phone1.getModel() + ", weight="
                + phone1.getWeight());
        System.out.println("Phone 2: number=" + phone2.getNumber() + ", model=" + phone2.getModel() + ", weight="
                + phone2.getWeight());
        System.out.println("Phone 3: number=" + phone3.getNumber() + ", model=" + phone3.getModel() + ", weight="
                + phone3.getWeight());

        System.out.println(phone1.sendMessage("1234567890", "0987654321", "5555555555"));
        phone1.receiveCall("Олена");
        System.out.println("Номер: " + phone1.getNumber());

        phone1.receiveCall("Олена", "1234567890");
        System.out.println("Номер: " + phone1.getNumber());

        phone2.receiveCall("Петро");
        System.out.println("Номер: " + phone2.getNumber());

        phone3.receiveCall("Марія");
        System.out.println("Номер: " + phone3.getNumber());
    }

    private static void runShapes() {
        System.out.println("---- Shapes ----");

        Shape cylinder = new Cylinder(2.0, 5.0);
        Shape ball = new Ball(2.0);
        Shape pyramid = new Pyramid(3.0, 4.0);

        System.out.println("Cylinder volume: " + cylinder.getVolume());
        System.out.println("Ball volume: " + ball.getVolume());
        System.out.println("Pyramid volume: " + pyramid.getVolume());
    }

    private static void runCars() {
        System.out.println("---- Cars ----");

        Sedan sedan = new Sedan("Toyota Camry", "Black", 220);
        Truck truck = new Truck("Volvo FH", "White", 140);

        System.out.println(sedan.gas());
        System.out.println(sedan.brake());

        System.out.println(truck.gas());
        System.out.println(truck.brake());

    }

    private static void runLuggage() {
        System.out.println("---- Luggage ----");

        Scanner scanner = new Scanner(System.in);
        Luggage luggage = new Luggage();
        System.out.print("Введіть кількість речей: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Помилка: введіть ціле число: ");
            scanner.next();
        }
        int itemCount = scanner.nextInt();
        luggage.inputItemCount(itemCount);

        for (int i = 1; i <= itemCount; i++) {
            System.out.print("Вага речі " + i + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Помилка: введіть число (наприклад 2.5): ");
                scanner.next();
            }
            double weight = scanner.nextDouble();
            luggage.inputItemWeight(weight);
        }

        System.out.println(luggage.printTotalWeight());
    }
}
