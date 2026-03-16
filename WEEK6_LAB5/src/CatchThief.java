import java.util.Arrays;
import java.util.Scanner;

/**
 * A simple grid game where the player (police "P") moves to catch a randomly moving thief ("T")
 * on a 10x10 grid. The game runs for up to 20 rounds or until the thief is caught.
 */
public class CatchThief {

    /** Width used for TUI formatting. */
    private static final int VIEWPORT_WIDTH = 100;
    /** TUI helper for headers and section titles. */
    private static TUI tui = new TUI(VIEWPORT_WIDTH);
    /** Scanner for reading user input. */
    private static Scanner in = new Scanner(System.in);

    /** Current row position of the thief (1–10). */
    private static int thiefRow = 5;
    /** Current column position of the thief (1–10). */
    private static int thiefColumn = 5;
    /** Random corner index used to place police at start. */
    private static final int policeStartCorner = randomInt(0, 3);
    /** Current row position of the police (1 or 10 at start). */
    private static int policeRow = (policeStartCorner < 2) ? 1 : 10;
    /** Current column position of the police (1 or 10 at start). */
    private static int policeColumn = (policeStartCorner % 2 == 0) ? 1 : 10;
    /** True when the police have caught the thief (adjacent cell). */
    private static boolean caught = false;
    /** Template for the 10x10 grid with borders (dots for cells). */
    private static String GRID_STRING =
        "+----------+\n" +
        "|..........|\n" +
        "|..........|\n" +
        "|..........|\n" +
        "|..........|\n" +
        "|..........|\n" +
        "|..........|\n" +
        "|..........|\n" +
        "|..........|\n" +
        "|..........|\n" +
        "|..........|\n" +
        "+----------+\n";

    /**
     * Builds the current grid string with 'T' at the thief position and 'P' at the police position.
     *
     * @return the grid as a multi-line string.
     */
    private static String present() {
        StringBuilder sb = new StringBuilder(GRID_STRING);

        int thiefPosition = gridPosition(thiefRow, thiefColumn);
        sb.replace(thiefPosition, thiefPosition + 1, "T");

        int policePosition = gridPosition(policeRow, policeColumn);
        sb.replace(policePosition, policePosition + 1, "P");

        return sb.toString();
    } // End of present method

    /** Moves the thief by one cell in a random direction (or stays). */
    private static void moveThief() {
        thiefRow += randomInt(-1, 1);
        thiefColumn += randomInt(-1, 1);
    } // End of moveThief method

    /**
     * Updates police position based on the given movement code (L, R, U, D, UL, UR, DL, DR, or - for stay).
     *
     * @param movement the direction string (e.g., "L", "UR").
     */
    private static void movePolice(String movement) {
        switch (movement) {
            case "L":
                policeColumn -= 1;
                break;
            case "R":
                policeColumn += 1;
                break;
            case "U":
                policeRow -= 1;
                break;
            case "D":
                policeRow += 1;
                break;
            case "UL":
                policeColumn -= 1;
                policeRow -= 1;
                break;
            case "UR":
                policeColumn += 1;
                policeRow -= 1;
                break;
            case "DL":
                policeColumn -= 1;
                policeRow += 1;
                break;
            case "DR":
                policeColumn += 1;
                policeRow += 1;
                break;
            default:
                policeColumn += 0;
                policeRow += 0;
        }
    } // End of getPolicePositionInput method

    /**
     * Converts (row, column) to the index in the grid string where that cell is drawn.
     *
     * @param row    grid row (0–10).
     * @param column grid column (0–11 for line length).
     * @return the character index in the grid string.
     */
    private static int gridPosition(int row, int column) {
        return 13 * row + column;
    } // End of gridPosition method

    /**
     * Returns a random integer in the range [a, b] (inclusive).
     *
     * @param a minimum value (inclusive).
     * @param b maximum value (inclusive).
     * @return a random int between a and b.
     */
    private static int randomInt(int a, int b) {
        return (int) (Math.random() * (b - a + 1)) + a;
    } // End of randomInt method

    /** Sets {@code caught} to true if the police and thief are in adjacent cells (Manhattan distance 1). */
    private static void isCaught() {
        caught = (Math.abs(thiefRow - policeRow) +
                Math.abs(thiefColumn - policeColumn) ==
            1)
            ? true
            : false;
    } // End of isCaught method

    /**
     * Prompts the user for a movement (L, R, U, D, UL, UR, DL, DR, or -) and returns the normalized choice.
     *
     * @return the user's choice in uppercase.
     */
    private static String getPolicePositionInput() {
        String userChoices = "L, R, U, D, UL, UR, DL, DR, - (stay)";
        String[] userChoicesArray = {
            "L",
            "R",
            "U",
            "D",
            "UL",
            "UR",
            "DL",
            "DR",
            "-",
        };

        System.out.printf("Your choices are %s: ", userChoices);
        String userChoice = in.next();

        while (
            !Arrays.asList(userChoicesArray).contains(userChoice.toUpperCase())
        ) {
            System.out.printf(
                "Invalid input \"%s\". Your choices are %s: ",
                userChoice,
                userChoices
            );
            userChoice = in.next();
        }
        return userChoice.toUpperCase();
    } // End of getPolicePositionInput method

    /**
     * Returns a string with current police and thief coordinates.
     *
     * @return a formatted string "Police: (r, c)\nThief: (r, c)".
     */
    private static String getCoordinatePositionsAsString() {
        return String.format(
            "Police: (%d, %d)%nThief: (%d, %d)",
            policeRow,
            policeColumn,
            thiefRow,
            thiefColumn
        );
    } // End of getCoordinatePositionsAsString method

    /**
     * Entry point: runs the Catch the Thief game for up to 20 rounds or until the thief is caught.
     *
     * @param args command-line arguments (unused).
     */
    public static void main(String[] args) {
        tui.programHeader("Catch the Thief");

        System.out.println(present());

        for (int i = 1; i <= 20; i++) {
            tui.sectionHeader(String.format("Round = %d", i));
            movePolice(getPolicePositionInput());
            moveThief();
            isCaught();
            if (caught) break;
            System.out.println(present());
            System.out.println(getCoordinatePositionsAsString());
        }

        tui.sectionHeader(String.format(" The Final Positions "));
        System.out.println(present());
        System.out.println(getCoordinatePositionsAsString());
    } // End of main method
} // End of CatchThief Class
