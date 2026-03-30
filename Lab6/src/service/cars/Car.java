package service.cars;

public abstract class Car {
    private String model;
    private String color;
    private int maxSpeed;

    public Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public String gas() {
        return "Газуємо!";
    }

    public abstract String brake();

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}