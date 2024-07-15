import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Area Calculator");
        System.out.println("circle : Circle\nsquare : Square\nrectangle : Rectangle");
        System.out.print("Enter the name of the shape: ");
        String choice = scanner.nextLine().toLowerCase(); // Convert input to lowercase

        boolean userInput = true;

        while (userInput) {
            switch (choice) {
                case "circle" -> {
                    System.out.print("Enter the radius of the circle: ");
                    double circleRadius = scanner.nextDouble();
                    Circle circle = new Circle(circleRadius);
                    double circleArea = circle.calculatedArea();
                    printArea("Circle", circleArea);
                    userInput = false; // Exit the loop after calculating area
                }
                case "square" -> {
                    System.out.print("Enter the side length of the square: ");
                    double sideLength = scanner.nextDouble();
                    Square square = new Square(sideLength);
                    double squareArea = square.calculatedArea();
                    printArea("Square", squareArea);
                    userInput = false; // Exit the loop after calculating area
                }
                case "rectangle" -> {
                    System.out.print("Enter the length of the rectangle: ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter the width of the rectangle: ");
                    double width = scanner.nextDouble();
                    Rectangle rectangle = new Rectangle(length, width);
                    double rectangleArea = rectangle.calculatedArea();
                    printArea("Rectangle", rectangleArea);
                    userInput = false; // Exit the loop after calculating area
                }
                default -> {
                    System.out.println("Invalid Input. Please enter 'circle', 'square', or 'rectangle'.");
                    System.out.print("Enter the name of the shape: ");
                    choice = scanner.nextLine().toLowerCase(); // Prompt user again for correct input
                }
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
