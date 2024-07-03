import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Area Calculator");
        System.out.println("1 : Circle\n2 : Square\n3 : Rectangle");
        System.out.print("Enter the number of the shape: ");
        String choice = scanner.nextLine().toLowerCase(); // Converting input to lower case

        boolean userInput = true;

        while (userInput) {
            switch (choice) {
                case "circle":
                    System.out.print("Enter the radius of the circle: ");
                    double circleRadius = scanner.nextDouble();
                    Circle circle = new Circle(circleRadius);
                    double circleArea = circle.calculatedArea();
                    printArea("Circle", circleArea);
                    userInput = false; // Exit the loop after calculating area
                    break;

                case "square":
                    System.out.print("Enter the side length of the square: ");
                    double sideLength = scanner.nextDouble();
                    Square square = new Square(sideLength);
                    double squareArea = square.calculatedArea();
                    printArea("Square", squareArea);
                    userInput = false; // Exit the loop after calculating area
                    break;

                case "rectangle":
                    System.out.print("Enter the length of the rectangle: ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter the width of the rectangle: ");
                    double width = scanner.nextDouble();
                    Rectangle rectangle = new Rectangle(length, width);
                    double rectangleArea = rectangle.calculatedArea();
                    printArea("Rectangle", rectangleArea);
                    userInput = false; // Exit the loop after calculating area
                    break;

                default:
                    System.out.println("Invalid Input. Please enter 'circle', 'square', or 'rectangle'.");
                    System.out.print("Enter the number of the shape: ");
                    choice = scanner.nextLine().toLowerCase(); // Prompt user again for correct input

                    break;
            }
        }

        scanner.close();
    }

    // Reusable method to print the area of a shape
    private static void printArea(String shapeName, double area) {
        System.out.println("Shape: " + shapeName);
        System.out.println("The area of the " + shapeName.toLowerCase() + " is: " + area);
    }
}
