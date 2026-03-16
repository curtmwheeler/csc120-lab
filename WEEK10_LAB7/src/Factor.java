import java.util.Scanner;

public class Factor {

    private static final TUI tui = new TUI(100);
    private static int exponent,
        divisor = 2;

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
