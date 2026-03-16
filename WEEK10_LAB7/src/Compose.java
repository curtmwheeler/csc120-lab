import java.util.Scanner;

/**
 * Converts prime-factorization expressions (e.g., "2^3 * 5 * 7^2") to their
 * numeric value. Accepts user input in a loop until the user enters "\q".
 */
public class Compose {

    /** TUI helper for formatted program headers. */
    private static final TUI tui = new TUI(100);

    /**
     * Returns whether the given integer is prime.
     *
     * @param n the integer to check (must be &gt;= 1 for a true result).
     * @return true if n is prime, false otherwise.
     */
    public static boolean isPrime(int n) {
        if (n < 1) return false;
        for (int d = 2; d * d <= n; d++) {
            if (n % d == 0) return false;
        }
        return true;
    } // end of isPrime method

    /**
     * Parses a prime-factorization expression and returns its product.
     * Expects bases to be prime, in ascending order, with optional exponents (e.g., "2^3 * 5").
     *
     * @param w the expression string (e.g., "2 ** 3 * 5" or "2^3 * 5").
     * @return the computed value of the expression.
     * @throws IllegalArgumentException if the expression is invalid (non-prime base, bad exponent, or wrong order).
     */
    public static long convert(String w) {
        long result = 1;
        String operator;
        int exponent,
            baseInteger,
            prevBase = 1;

        w = w.replace("**", "^").replace("*", " * ").replace("^", " ^ ");
        StringBuilder sb = new StringBuilder(w);
        sb.append(" *");

        Scanner in = new Scanner(sb.toString());

        while (in.hasNext()) {
            baseInteger = in.nextInt();
            operator = in.next();

            if (operator.equals("^")) {
                exponent = in.nextInt();
                operator = in.next();
            } else if (operator.equals("*")) {
                exponent = 1;
            } else {
                throw new IllegalArgumentException(
                    String.format("Invalid operation: \"%s\"", operator)
                );
            }

            if (
                !isPrime(baseInteger) || exponent < 1 || prevBase > baseInteger
            ) {
                throw new IllegalArgumentException(
                    String.format("Invalid input: \"%s\"", baseInteger)
                );
            }

            result *= Math.pow(baseInteger, exponent);

            prevBase = baseInteger;
        }
        return result;
    } // end of convert method

    /**
     * Prompts the user for an expression and returns the next line of input.
     *
     * @return the line entered by the user (e.g., a prime factorization or "\q" to exit).
     */
    public static String getUserInput() {
        Scanner in = new Scanner(System.in);

        System.out.printf("Enter an expression (\\q to exit): ");
        String expression = in.nextLine();

        return expression;
    } // end of getUserInput method

    /**
     * Entry point: prints a header, then repeatedly reads expressions and prints their numeric value until "\q".
     *
     * @param args command-line arguments (unused).
     */
    public static void main(String[] args) {
        tui.programHeader("Week 10 - Lab 7 : Compose");

        String expression = getUserInput();
        while (!expression.equals("\\q")) {
            System.out.printf("%s = %d%n", expression, convert(expression));
            expression = getUserInput();
        }
    } // end of main method
} // end of Compose class
