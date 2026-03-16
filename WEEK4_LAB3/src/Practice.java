import java.util.Scanner;

/**
 * Practice for Week 4 Lab 3: reads a circle radius and prints its area using
 * a helper method and formatted output.
 */
class Practice {

    /**
     * Entry point: reads radius, then prints circle area via myPrint and other formats.
     *
     * @param args command-line arguments (unused).
     */
    public static void main(String[] args) {
        System.out.println("WEEK 4 - LAB 3 PRACTICE");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter circle radius: ");
        double radius = in.nextDouble();
        in.close();

        myPrint("Circle Area", calculateCircleArea(radius), "m");

        System.out.println(
            "The area of the circle is: " + calculateCircleArea(radius)
        );

        System.out.printf(
            "The area of the circle is %.2f%n",
            calculateCircleArea(radius)
        );
    } // End of main method

    /**
     * Prints a named value with unit in a fixed-width format.
     *
     * @param name  label for the value (e.g., "Circle Area").
     * @param value the numeric value.
     * @param unit  unit string (e.g., "m").
     */
    public static void myPrint(String name, double value, String unit) {
        System.out.printf("%30s:%14.4f (%s)%n", name, value, unit);
    } // End of myPrint method

    /**
     * Computes the area of a circle given its radius.
     *
     * @param radius the radius of the circle.
     * @return the area (π * radius²).
     */
    public static double calculateCircleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    } // End of calculateCircleArea method
} // End of Practice Class
