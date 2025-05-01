import java.util.Scanner;

public class ShapeDemo {
    public static void main(String[] args) {
        Shape shapes[] = new Shape[5];
        Scanner scanner = new Scanner(System.in);
        int shpIdx = 0;
        while (true) {
            System.out.println("Press 1 to add a Circle," +
                    "\n2 to add a Rectangle," +
                    "\n3 to add a Triangle," +
                    "\n4 to display all shapes," +
                    "\n any other key to exit.");
            String userAction = scanner.nextLine();
            if (userAction.equals("1")) {
                if (shpIdx == 5) {
                    System.out.println("5 shapes added already. " +
                            "\nCannot add any more shapes!");
                    continue;
                }
                System.out.println("Enter the name of the Circle: ");
                String tmpName = scanner.nextLine();
                System.out.println("Enter the color of the Circle: ");
                String tmpColor = scanner.nextLine();
                System.out.println("Enter the radius of the Circle: ");
                double tmpRadius = Double.parseDouble(scanner.nextLine());
                Circle cTmp = new Circle(tmpName, tmpColor, tmpRadius);
                shapes[shpIdx++] = cTmp;
            } else if (userAction.equals("2")) {
                if (shpIdx == 5) {
                    System.out.println("5 shapes added already. " +
                            "\nCannot add any more shapes!");
                    continue;
                }
                System.out.println("Enter the name of the Rectangle: ");
                String tmpName = scanner.nextLine();
                System.out.println("Enter the color of the Rectangle: ");
                String tmpColor = scanner.nextLine();
                System.out.println("Enter the length of the Rectangle: ");
                double tmpLength = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter the width of the Rectangle: ");
                double tmpWidth = Double.parseDouble(scanner.nextLine());
                Rectangle rTmp = new Rectangle(tmpName, tmpColor, tmpLength, tmpWidth);
                shapes[shpIdx++] = rTmp;
            } else if (userAction.equals("3")) {
                if (shpIdx == 5) {
                    System.out.println("5 shapes added already. " +
                            "\nCannot add any more shapes!");
                    continue;
                }
                System.out.println("Enter the name of the Triangle: ");
                String tmpName = scanner.nextLine();
                System.out.println("Enter the color of the Triangle: ");
                String tmpColor = scanner.nextLine();
                System.out.println("Enter the length of the first side: ");
                double tmpSide1 = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter the length of the second side: ");
                double tmpSide2 = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter the length of the third side: ");
                double tmpSide3 = Double.parseDouble(scanner.nextLine());
                Triangle tTmp = new Triangle(tmpName, tmpColor, tmpSide1, tmpSide2, tmpSide3);
                shapes[shpIdx++] = tTmp;
            } else if (userAction.equals("4")) {
                for (int i = 0; i < shapes.length; i++) {
                    if (shapes[i] != null) {
                        System.out.println(shapes[i]);
                    }
                }
            } else {
                break;
            }
        }
    }
}
