import java.util.Scanner;

public class LinearEquation {

    public static void main(String[] args) {
        // Program Header
        System.out.println("WEEK 3 - LAB 2, PART 1");

        // Variable declarations
        Scanner input = new Scanner(System.in);
        double a, b, p, c, d, q, x, y;

        // Program Header/Description
        System.out.println(
            "This program solves systems of linear equations.\n\t ex: ax + by = p, cx + dy = q"
        );

        // Get user input for Equation 1: ax + by = p
        System.out.print("Enter the values for a, b, and p > ");
        a = input.nextDouble();
        b = input.nextDouble();
        p = input.nextDouble();

        // Get user input for Equation 1: ax + by = p
        System.out.print("Enter the values for c, d, and q > ");
        c = input.nextDouble();
        d = input.nextDouble();
        q = input.nextDouble();

        // Close Scanner
        input.close();

        // Coordinate computation
        double determinant = (a * d - b * c);
        x = (d * p - b * q) / determinant;
        y = (a * q - c * p) / determinant;

        // Formatted program output
        System.out.printf(
            "The equations are:\n\t- %.2fx + %.2fy = %.2f\n\t- %.2fx + %.2fy = %.2f.\n",
            a,
            b,
            p,
            c,
            d,
            q
        );
        System.out.printf("The solution is (%.8f, %.8f).\n", x, y);
    }
}
