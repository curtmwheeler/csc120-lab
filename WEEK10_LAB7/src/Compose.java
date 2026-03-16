import java.util.Scanner;

public class Compose {

    private static final TUI tui = new TUI(100);

    public static boolean isPrime(int n) {
        if (n < 1) return false;
        for (int d = 2; d * d <= n; d++) {
            if (n % d == 0) return false;
        }
        return true;
    } // end of isPrime method

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

    public static String getUserInput() {
        Scanner in = new Scanner(System.in);

        System.out.printf("Enter an expression (\\q to exit): ");
        String expression = in.nextLine();

        return expression;
    } // end of getUserInput method

    public static void main(String[] args) {
        tui.programHeader("Week 10 - Lab 7 : Compose");

        String expression = getUserInput();
        while (!expression.equals("\\q")) {
            System.out.printf("%s = %d%n", expression, convert(expression));
            expression = getUserInput();
        }
    } // end of main method
} // end of Compose class
