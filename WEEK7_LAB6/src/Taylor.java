import java.util.Scanner;

/**
 * Computes Taylor series approximations for square root, cube root, and natural logarithm.
 * Prompts for base, delta, and number of terms (or delta/n for log), then prints term-by-term
 * approximations and compares with the expected value.
 */
public class Taylor {

    // Class Constants
    /** Width used for TUI formatting. */
    private static final int TERMINAL_VIEWPORT = 100;
    /** TUI helper for headers and section titles. */
    private static final TUI tui = new TUI(TERMINAL_VIEWPORT);
    /** Scanner for reading user input. */
    private static final Scanner in = new Scanner(System.in);
    /** Base point (a) for the series; delta (δ); current approximation; series coefficient, exponent, power terms. */
    private static double base, delta, approximation, coefficient, exponent, power, delta_power, expected;
    /** Running factorial used in series terms. */
    private static long factorial = 1;
    /** Number of terms to compute; current round/term index. */
    private static int num_terms,
        round = 1;

    /**
     * Computes the Taylor approximation of sqrt(base + delta) and prints each term and the final comparison.
     */
    private static void approximateSquareRoot() {
        coefficient = 1;
        delta_power = 1;
        exponent = 1.0 / 2.0;
        power = Math.pow(base, exponent);
        expected = Math.pow((base + delta), exponent);
        approximation = Math.pow(base, exponent);
        tui.sectionHeader(
            String.format("The Square Root of %.10f + %.10f", base, delta)
        );
        for (; round <= num_terms; round++) {
            coefficient *= exponent;
            exponent -= 1;
            power /= base;
            factorial *= round;
            delta_power *= delta;
            approximation += coefficient * power * (delta_power / factorial);
            computationOutput(round, approximation);
        }
        tui.sectionHeader("Computation");
        System.out.printf(
            "\tExpected = %.15f%n\tApproximation = %.15f%n",
            expected,
            approximation
        );
    } // End of approximateSquareRoot method

    /**
     * Computes the Taylor approximation of the cube root of (base + delta) and prints each term and the final comparison.
     */
    private static void approximateCubeRoot() {
        coefficient = 1;
        delta_power = 1;
        exponent = 1.0 / 3.0;
        power = Math.pow(base, exponent);
        expected = Math.pow((base + delta), exponent);
        approximation = Math.pow(base, exponent);
        tui.sectionHeader(
            String.format("The Cubic Root of %.10f + %.10f", base, delta)
        );
        for (; round <= num_terms; round++) {
            coefficient *= exponent;
            exponent -= 1;
            power /= base;
            factorial *= round;
            delta_power *= delta;
            approximation += coefficient * power * (delta_power / factorial);
            computationOutput(round, approximation);
        }
        tui.sectionHeader("Computation");
        System.out.printf(
            "\tExpected = %.15f%n\tApproximation = %.15f%n",
            expected,
            approximation
        );
    } // End of approximateCubeRoot method

    /**
     * Computes the Taylor approximation of ln(1 + delta) and prints each term and the final comparison.
     * Prompts for delta and number of terms inside this method.
     */
    private static void approximateLogarithm() {
        System.out.print("Enter the value of delta (δ): ");
        delta = in.nextDouble();
        System.out.print("Enter the number of terms (n): ");
        num_terms = in.nextInt();

        coefficient = 1;
        delta_power = 1;
        base = 1;
        round = 1;
        expected = Math.log(base + delta);
        approximation = 0;
        double term = 0;
        tui.sectionHeader(
            String.format("The Logarithm of %.10f + %.10f", base, delta)
        );
        for (; round <= num_terms; round++) {
            factorial *= round;
            delta_power *= delta / base;
            term = delta_power / factorial;
            approximation += (round % 2 == 0) ? -term : term;
            computationOutput(round, approximation);
        }
        tui.sectionHeader("Computation");
        System.out.printf(
            "\tExpected = %.15f%n\tApproximation = %.15f%n",
            expected,
            approximation
        );
    } // End of approximateLogarithm method

    /**
     * Displays a menu (Square Root, Cube Root, Logarithm) and returns the user's numeric choice (1–3).
     *
     * @return the user's choice (1, 2, or 3).
     */
    private static int menu() {
        tui.sectionHeader("Menu Options");
        System.out.println(
            "Which Taylor approximation do you want to compute."
        );
        System.out.println(" 1. Square Root\n 2. Cube Root\n 3. Logarithm");
        System.out.print("Enter your choice: ");
        int choice = in.nextInt();
        return choice;
    } // End of menu method

    /**
     * Prompts the user for base (a), delta (δ), and number of terms (n) and sets the static variables.
     */
    private static void getTaylorSeriesParameters() {
        System.out.print("Enter the value of base (a): ");
        base = in.nextDouble();
        System.out.print("Enter the value of delta (δ): ");
        delta = in.nextDouble();
        System.out.print("Enter the number of terms (n): ");
        num_terms = in.nextInt();
    }

    /**
     * Prints one line of computation output for a given round and approximation value.
     *
     * @param round the term index (round number).
     * @param approx the current approximation value.
     */
    private static void computationOutput(int round, double approx) {
        System.out.printf("Round=%03d, approx=%.15f%n", round, approx);
    }

    /**
     * Entry point: shows menu, then runs the chosen Taylor approximation (square root, cube root, or logarithm).
     *
     * @param args command-line arguments (unused).
     */
    public static void main(String[] args) {
        tui.programHeader("Week 7 Lab 6");
        int choice = menu();

        switch (choice) {
            case 1:
                getTaylorSeriesParameters();
                approximateSquareRoot();
                break;
            case 2:
                getTaylorSeriesParameters();
                approximateCubeRoot();
                break;
            case 3:
                approximateLogarithm();
                break;
            default:
                System.out.println("Invalid choice");
        }
    } // End of main method
} // End of Taylor class
