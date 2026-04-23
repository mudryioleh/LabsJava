package Taxi;
public class Car {
    private String model;
    private double enginePower;
    private Driver driver;
    private double price;
    private int year;

    public Car() {
    }

    public Car(String model, double enginePower, Driver driver, double price, int year) {
        this.model = model;
        this.enginePower = enginePower;
        this.driver = driver;
        this.price = price;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void increaseEnginePowerByPercent(double percent) {
        enginePower *= (1.0 + percent / 100.0);
    }

    public void increasePriceByPercent(double percent) {
        price *= (1.0 + percent / 100.0);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", enginePower=" + enginePower +
                ", driver=" + driver +
                ", price=" + price +
                ", year=" + year +
                '}';
    }
}
