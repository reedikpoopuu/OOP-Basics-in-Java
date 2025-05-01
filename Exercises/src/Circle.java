public class Circle extends Shape {
    private double radius;
    public Circle( String name, String color, double radius) {
        super(name, color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    public String toString() {
        return super.toString() + "\nRadius: " + getRadius()
                + "\nArea: " + area()
                + "\nPerimeter: " + perimeter();
    }
}
