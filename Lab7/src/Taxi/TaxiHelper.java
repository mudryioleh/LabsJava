package Taxi;
import java.util.Random;

public class TaxiHelper {
    public static Car pickRandomCar(Car[] cars) {
        if (cars == null || cars.length == 0) {
            throw new IllegalArgumentException("Cars array must not be empty");
        }
        return cars[new Random().nextInt(cars.length)];
    }

    public static void callTaxi(Car[] cars) {
        Car car = pickRandomCar(cars);
        System.out.printf(
                "Автомобіль марки %s з водієм %s виїхав за вами%n",
                car.getModel(),
                car.getDriver().getName()
        );
        driverArrived(car);
    }

    public static void driverArrived(Car car) {
        System.out.printf("Водій %s прибув на місце%n", car.getDriver().getName());
    }
}
