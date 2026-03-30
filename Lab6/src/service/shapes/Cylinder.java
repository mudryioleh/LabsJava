package service.shapes;

public class Cylinder extends SolidOfRevolution {
    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getVolume() {
        return Math.PI * getRadius() * getRadius() * height;
    }
}
