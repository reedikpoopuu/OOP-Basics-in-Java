public class Triangle extends Shape {
    private double side1, side2, side3;

    public Triangle(String name, String color, double side1, double side2, double side3) {
        super(name, color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    @Override
    public double area() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFirst side: " + side1 + "\nSecond side: "
                + side2 + "\nThird side: " + side3 + "\nArea: " + area()
                + "\nPerimeter: " + perimeter();
    }
}