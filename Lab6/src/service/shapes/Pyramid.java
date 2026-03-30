package service.shapes;

public class Pyramid extends Shape {
    private double side;
    private double height;

    public Pyramid(double side, double height) {
        super();
        this.side = side;
        this.height = height;
    }

    public double getSide() {
        return side;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getVolume() {
        return (side * side * height) / 3.0;
    }
}
