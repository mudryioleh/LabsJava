package service.shapes;

public class Shape {
    private double volume;

    public Shape() {
        this.volume = 0.0;
    }

    public Shape(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    protected void setVolume(double volume) {
        this.volume = volume;
    }
}
