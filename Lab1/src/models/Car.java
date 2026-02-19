package models;

/* Завдання 4 */
public class Car {
    private int horsePower;
    private double engineVolume;

    private String brand;
    private String model;
    private int year;
    private boolean isElectric;
    private double price;

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

    public int getHorsePower() {
        return horsePower;
    }

    public double getEngineVolume() {
        return engineVolume;
    }
}
