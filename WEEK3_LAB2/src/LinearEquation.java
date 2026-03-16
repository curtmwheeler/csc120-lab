import java.util.Scanner;

/**
 * Solves a 2x2 system of linear equations (ax + by = p, cx + dy = q) by reading
 * coefficients from the user and printing the solution (x, y).
 */
public class LinearEquation {

    /**
     * Entry point: prompts for coefficients a,b,p and c,d,q, then computes and prints (x, y).
     *
     * @param args command-line arguments (unused).
     */
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
