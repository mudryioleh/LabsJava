package service.cars;

public class Truck extends Car {
    public Truck(String model, String color, int maxSpeed) {
        super(model, color, maxSpeed);
    }

    @Override
    public String brake() {
        return "Грузовик " + getModel() + " гальмує інтенсивно.";
    }
}