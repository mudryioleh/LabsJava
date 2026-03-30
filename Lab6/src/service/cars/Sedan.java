package service.cars;

public class Sedan extends Car {
    public Sedan(String model, String color, int maxSpeed) {
        super(model, color, maxSpeed);
    }

    @Override
    public String brake() {
        return "Седан " + getModel() + " гальмує плавно.";
    }
}