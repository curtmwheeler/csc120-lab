import java.util.Scanner;

/**
 * Computes the prime factorization of positive integers and prints them in
 * "base^exponent" form (e.g., "2^3 * 5"). Runs in a loop until the user enters -1.
 */
public class Factor {

    /** TUI helper for formatted program headers. */
    private static final TUI tui = new TUI(100);
    /** Exponent of the current prime divisor in the factorization. */
    private static int exponent,
        /** Current prime divisor used when factoring. */
        divisor = 2;

    /**
     * Returns the prime factorization of the given integer as a string (e.g., "2^2 * 3").
     *
     * @param input the positive integer to factor.
     * @return factorization string with bases and optional exponents, or empty if input &lt;= 1.
     */
    public static String factoring(int input) {
        StringBuilder sb = new StringBuilder();
        int needToFactor = input;

        while (needToFactor > 1) {
            if (needToFactor % divisor == 0) {
                sb.append(divisor);
                exponent = 0;

                while (needToFactor % divisor == 0) {
                    needToFactor /= divisor;
                    exponent++;
                }

                if (exponent > 1) sb.append("^").append(exponent);
                if (needToFactor > 1) sb.append(" * ");
            }
            divisor++;
        }

        return sb.toString();
    } // end of factoring method

    /**
     * Prompts the user for an integer and keeps prompting until a valid int is entered.
     *
     * @return the integer entered by the user (-1 to signal exit).
     */
    public static int getUserInput() {
        Scanner in = new Scanner(System.in);
        int input = 0;
        System.out.printf("Enter an integer (-1 to exit): ");

        while (true) {
            if (in.hasNextInt()) {
                input = in.nextInt();
                break;
            } else {
                System.out.print(
                    "Please enter a valid integer. Enter an integer (-1 to exit): "
                );
                in.next();
            }
        }
        return input;
    } // end of getUserInput method

    /**
     * Entry point: prints a header, then repeatedly reads integers and prints their prime factorization until -1.
     *
     * @param args command-line arguments (unused).
     */
    public static void main(String[] args) {
        tui.programHeader("Week 10 - Lab 7 : Factoring");

        int input = getUserInput();
        while (input != -1) {
            System.out.printf(
                "%d: %s%n",
                input,
                factoring(input).equals("") ? "No Factors" : factoring(input)
            );
            input = getUserInput();
        }
    } // end of main method
} // end of Factor class
