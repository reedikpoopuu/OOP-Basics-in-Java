public class Rectangle extends Shape{
    private double length, width;

    public Rectangle(String name, String color, double length, double width) {
        super(name, color);
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return super.toString() + "\nLength: " + length + "\nWidth: " + width
                 + "\nArea: " + area() + "\nPerimeter: " + perimeter();
    }
}
