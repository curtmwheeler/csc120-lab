import java.util.Scanner;

/**
 * Practice for Week 5 Lab 4: reads four real numbers and reports which input is the maximum.
 */
public class Practice {

    /**
     * Entry point: reads four numbers and prints which one is the max (Input 1–4).
     *
     * @param args command-line arguments (unused).
     */
    public static void main(String[] args) {
        TUI tui = new TUI(100);
        Scanner in = new Scanner(System.in);

        // Program Header
        tui.programHeader("WEEK 5 - LAB 4 PRACTICE");

        // Variable initializations
        double input1, input2, input3, input4;

        System.out.print("Enter four real numbers: ");
        input1 = in.nextDouble();
        input2 = in.nextDouble();
        input3 = in.nextDouble();
        input4 = in.nextDouble();

        in.close();

        showRanking(input1, input2, input3, input4);
    } // end of main method

    /**
     * Determines which of the four values is largest and prints "Input N is the max."
     *
     * @param input1 first value.
     * @param input2 second value.
     * @param input3 third value.
     * @param input4 fourth value.
     */
    public static void showRanking(
        double input1,
        double input2,
        double input3,
        double input4
    ) {
        double maxValue = Math.max(
            Math.max(input1, input2),
            Math.max(input3, input4)
        );

        if (maxValue == input1) {
            System.out.println("Input 1 is the max.");
        } else if (maxValue == input2) {
            System.out.println("Input 2 is the max.");
        } else if (maxValue == input3) {
            System.out.println("Input 3 is the max.");
        } else {
            System.out.println("Input 4 is the max.");
        }
    } // end of showRanking
} // end of Practice class
