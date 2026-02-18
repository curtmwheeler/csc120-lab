import java.util.Scanner;

class Practice {

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

    public static void myPrint(String name, double value, String unit) {
        System.out.printf("%30s:%14.4f (%s)%n", name, value, unit);
    } // End of myPrint method

    public static double calculateCircleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    } // End of calculateCircleArea method
} // End of Practice Class
