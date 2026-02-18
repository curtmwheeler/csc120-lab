import java.util.Scanner;

/**
 * A program to compare and rank four individuals based on their height, weight, and BMI.
 *
 * <p>This class contains the main logic for running the comparison. It prompts the user to enter
 * the name, height, and weight for four people. It then calculates the BMI for each person and
 * displays a ranked list for height, weight, and BMI, from highest to lowest.
 */
public class BMIComparison {

    /**
     * Finds and ranks the highest of four values, then delegates to find the subsequent ranks.
     *
     * <p>This method identifies the maximum value among the four provided candidates. It reports this
     * candidate as rank 1 and then calls {@code find2nd} with the remaining three candidates to
     * continue the ranking process.
     *
     * @param candidate_value1 The value for the first candidate.
     * @param candidate_value2 The value for the second candidate.
     * @param candidate_value3 The value for the third candidate.
     * @param candidate_value4 The value for the fourth candidate.
     * @param candidate_name1 The name of the first candidate.
     * @param candidate_name2 The name of the second candidate.
     * @param candidate_name3 The name of the third candidate.
     * @param candidate_name4 The name of the fourth candidate.
     */
    public static void find1st(
        double candidate_value1,
        double candidate_value2,
        double candidate_value3,
        double candidate_value4,
        String candidate_name1,
        String candidate_name2,
        String candidate_name3,
        String candidate_name4
    ) {
        double maxValue = Math.max(
            Math.max(candidate_value1, candidate_value2),
            Math.max(candidate_value3, candidate_value4)
        );

        if (maxValue == candidate_value1) {
            report(1, candidate_name1, candidate_value1);
            find2nd(
                candidate_value2,
                candidate_value3,
                candidate_value4,
                candidate_name2,
                candidate_name3,
                candidate_name4
            );
        } else if (maxValue == candidate_value2) {
            report(1, candidate_name2, candidate_value2);
            find2nd(
                candidate_value1,
                candidate_value3,
                candidate_value4,
                candidate_name1,
                candidate_name3,
                candidate_name4
            );
        } else if (maxValue == candidate_value3) {
            report(1, candidate_name3, candidate_value3);
            find2nd(
                candidate_value1,
                candidate_value2,
                candidate_value4,
                candidate_name1,
                candidate_name2,
                candidate_name4
            );
        } else {
            report(1, candidate_name4, candidate_value4);
            find2nd(
                candidate_value1,
                candidate_value2,
                candidate_value3,
                candidate_name1,
                candidate_name2,
                candidate_name3
            );
        }
    } // end of find1st method

    /**
     * Finds and ranks the highest of three values, then delegates to find the final two ranks.
     *
     * <p>This method is called after the first-ranked candidate has been determined. It identifies
     * the maximum value among the three remaining candidates, reports it as rank 2, and then calls
     * {@code findLastTwo} with the remaining two candidates.
     *
     * @param candidate_value1 The value for the first remaining candidate.
     * @param candidate_value2 The value for the second remaining candidate.
     * @param candidate_value3 The value for the third remaining candidate.
     * @param candidate_name1 The name of the first remaining candidate.
     * @param candidate_name2 The name of the second remaining candidate.
     * @param candidate_name3 The name of the third remaining candidate.
     */
    public static void find2nd(
        double candidate_value1,
        double candidate_value2,
        double candidate_value3,
        String candidate_name1,
        String candidate_name2,
        String candidate_name3
    ) {
        double maxValue = Math.max(
            Math.max(candidate_value1, candidate_value2),
            candidate_value3
        );

        if (maxValue == candidate_value1) {
            report(2, candidate_name1, candidate_value1);
            findLastTwo(
                candidate_value2,
                candidate_value3,
                candidate_name2,
                candidate_name3
            );
        } else if (maxValue == candidate_value2) {
            report(2, candidate_name2, candidate_value2);
            findLastTwo(
                candidate_value1,
                candidate_value3,
                candidate_name1,
                candidate_name3
            );
        } else {
            report(2, candidate_name3, candidate_value3);
            findLastTwo(
                candidate_value1,
                candidate_value2,
                candidate_name1,
                candidate_name2
            );
        }
    } // end of find2nd method

    /**
     * Finds and ranks the final two values.
     *
     * <p>This method is called after the first and second-ranked candidates have been determined. It
     * compares the last two candidates, reports the higher value as rank 3, and the lower value as
     * rank 4, completing the ranking process.
     *
     * @param candidate_value1 The value for the first of the last two candidates.
     * @param candidate_value2 The value for the second of the last two candidates.
     * @param candidate_name1 The name of the first of the last two candidates.
     * @param candidate_name2 The name of the second of the last two candidates.
     */
    public static void findLastTwo(
        double candidate_value1,
        double candidate_value2,
        String candidate_name1,
        String candidate_name2
    ) {
        double maxValue = Math.max(candidate_value1, candidate_value2);

        if (maxValue == candidate_value1) {
            report(3, candidate_name1, candidate_value1);
            report(4, candidate_name2, candidate_value2);
        } else {
            report(3, candidate_name2, candidate_value2);
            report(4, candidate_name1, candidate_value1);
        }
    } // end of findLastTwo method

    /**
     * Prints a formatted report for a single ranked candidate.
     *
     * @param rank The candidate's rank (e.g., 1 for 1st).
     * @param name The name of the candidate.
     * @param value The value based on which the candidate was ranked.
     */
    public static void report(int rank, String name, double value) {
        System.out.printf(
            "Rank %d is %s, with a value of %.2f%n",
            rank,
            name,
            value
        );
    } // end of report method

    /**
     * The main entry point for the BMI Comparison program.
     *
     * <p>It orchestrates the process of gathering user input for four people, calculating their
     * individual BMIs, and then printing ranked reports for height, weight, and BMI.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TUI tui = new TUI(100);
        Scanner in = new Scanner(System.in);

        // Program Header
        tui.programHeader("WEEK 5 - LAB 4: BMI COMPARISON PROGRAM");

        // Variable initialization
        String name1, name2, name3, name4;
        double height1, height2, height3, height4;
        double weight1, weight2, weight3, weight4;
        double bmi1, bmi2, bmi3, bmi4;

        // BMI Calculator initialization
        BMICalculator bmi = new BMICalculator();

        // Getting user input for each of the four people
        // Person 1
        System.out.printf("Enter Name, Height, and Weight for Person %d: ", 1);
        name1 = in.next();
        height1 = in.nextDouble();
        weight1 = in.nextDouble();

        // Person 2
        System.out.printf("Enter Name, Height, and Weight for Person %d: ", 2);
        name2 = in.next();
        height2 = in.nextDouble();
        weight2 = in.nextDouble();

        // Person 3
        System.out.printf("Enter Name, Height, and Weight for Person %d: ", 3);
        name3 = in.next();
        height3 = in.nextDouble();
        weight3 = in.nextDouble();

        // Person 4
        System.out.printf("Enter Name, Height, and Weight for Person %d: ", 4);
        name4 = in.next();
        height4 = in.nextDouble();
        weight4 = in.nextDouble();

        // Close input
        in.close();

        // BMI Calculation for each person
        bmi1 = bmi.calculateBMI(weight1, height1); // Person 1
        bmi2 = bmi.calculateBMI(weight2, height2); // Person 2
        bmi3 = bmi.calculateBMI(weight3, height3); // Person 3
        bmi4 = bmi.calculateBMI(weight4, height4); // Person 4

        // Ranking by Height
        tui.sectionHeader("Ranking by Height");
        find1st(height1, height2, height3, height4, name1, name2, name3, name4);

        // Ranking by Weight
        tui.sectionHeader("Ranking by Weight");
        find1st(weight1, weight2, weight3, weight4, name1, name2, name3, name4);

        // Ranking by BMI
        tui.sectionHeader("Ranking by BMI");
        find1st(bmi1, bmi2, bmi3, bmi4, name1, name2, name3, name4);
    } // end of the main method
} // end of BMIComparison class
