import java.util.Scanner;

public class Birthday {

    private static int[] generateRawResult(int nPeople, int nPlaces) {
        int[] rawResult = new int[nPlaces];

        for (int i = 0; i < nPeople; i++) {
            rawResult[(int) (Math.random() * nPlaces)]++;
        }

        return rawResult;
    } // end of generateRawResult method

    private static boolean hasDuplicate(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > 1) return true;
        }
        return false;
    } // end of hasDuplicate method

    private static double experiment(int nPeople, int nPlaces, int nReps) {
        int nDuplicates = 0;

        for (int i = 0; i < nReps; i++) {
            if (hasDuplicate(generateRawResult(nPeople, nPlaces))) {
                nDuplicates++;
            }
        }

        return (double) nDuplicates / nReps;
    } // end of experiment method

    public static void main(String[] args) {
        TUI tui = new TUI(100);
        Scanner in = new Scanner(System.in);
        String tryAgain;

        tui.programHeader("Week 11 Lab 8: Birthday Paradox");

        do {
            System.out.print("Enter the no. of people: ");
            int nPeople = in.nextInt();
            System.out.print("Enter the no. of places: ");
            int nPlaces = in.nextInt();
            System.out.print("Enter the no. of repetitions: ");
            int nReps = in.nextInt();
            double result = experiment(nPeople, nPlaces, nReps);
            System.out.println(
                "Probability of a duplicate birthday: " + result
            );
            System.out.print("Try again? (y/n): ");
            tryAgain = in.next();
        } while (tryAgain.toLowerCase().equals("y"));
    } // end of main method
} // end of Birthday class
