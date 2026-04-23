import java.util.ArrayList;

import PhoneBook.PhoneBookProgram;
import Taxi.Car;
import Taxi.Driver;
import Taxi.TaxiHelper;

public class App {
    public static void main(String[] args) throws Exception {
        runTaxi();
        PhoneBookProgram.run();
    }

    private static void runTaxi() {
        System.out.println("---- Taxi ----");

        ArrayList<Car> cars = new ArrayList<>();

        cars.add(new Car("Toyota Camry", 181, new Driver("Олег", 30, 7), 15500, 2016));
        cars.add(new Car("Skoda Octavia", 150, new Driver("Іван", 26, 4), 13200, 2015));
        cars.add(new Car("Volkswagen Passat", 170, new Driver("Андрій", 41, 15), 14900, 2014));
        cars.add(new Car("Renault Megane", 120, new Driver("Микола", 24, 3), 9800, 2012));
        cars.add(new Car("Ford Focus", 125, new Driver("Петро", 28, 2), 10500, 2013));
        cars.add(new Car("Hyundai Elantra", 128, new Driver("Сергій", 33, 9), 11900, 2017));
        cars.add(new Car("Kia Ceed", 110, new Driver("Юрій", 27, 5), 9900, 2011));
        cars.add(new Car("Nissan Leaf", 109, new Driver("Марія", 29, 6), 14300, 2018));
        cars.add(new Car("Honda Civic", 140, new Driver("Олена", 31, 4), 12700, 2015));
        cars.add(new Car("Mazda 3", 165, new Driver("Віктор", 36, 12), 14100, 2016));
        cars.add(new Car("Audi A4", 190, new Driver("Роман", 34, 8), 17800, 2013));
        cars.add(new Car("BMW 320", 184, new Driver("Тарас", 27, 3), 19900, 2014));

        int halfFleet = cars.size() / 2;
        for (int i = 0; i < halfFleet; i++) {
            Car car = cars.get(i);
            car.increaseEnginePowerByPercent(10);
            car.setDriver(new Driver("Новий_водій_" + (i + 1), 26 + (i % 10), 1 + (i % 7)));
        }

        for (int i = 0; i < cars.size(); i += 2) {
            Car car = cars.get(i);
            car.increaseEnginePowerByPercent(10);
            car.increasePriceByPercent(5);
        }

        for (Car car : cars) {
            Driver driver = car.getDriver();
            if (driver.getExperienceYears() < 5 && driver.getAge() > 25) {
                driver.addExperienceYears(1);
            }
        }

        TaxiHelper.callTaxi(cars.toArray(new Car[0]));
    }
}
