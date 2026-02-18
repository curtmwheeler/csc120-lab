import java.util.Arrays;
import java.util.Scanner;

public class CatchThief {

    private static final int VIEWPORT_WIDTH = 100;
    private static TUI tui = new TUI(VIEWPORT_WIDTH);
    private static Scanner in = new Scanner(System.in);

    private static int thiefRow = 5;
    private static int thiefColumn = 5;
    private static final int policeStartCorner = randomInt(0, 3);
    private static int policeRow = (policeStartCorner < 2) ? 1 : 10;
    private static int policeColumn = (policeStartCorner % 2 == 0) ? 1 : 10;
    private static boolean caught = false;
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

    private static String present() {
        StringBuilder sb = new StringBuilder(GRID_STRING);

        int thiefPosition = gridPosition(thiefRow, thiefColumn);
        sb.replace(thiefPosition, thiefPosition + 1, "T");

        int policePosition = gridPosition(policeRow, policeColumn);
        sb.replace(policePosition, policePosition + 1, "P");

        return sb.toString();
    } // End of present method

    private static void moveThief() {
        thiefRow += randomInt(-1, 1);
        thiefColumn += randomInt(-1, 1);
    } // End of moveThief method

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

    private static int gridPosition(int row, int column) {
        return 13 * row + column;
    } // End of gridPosition method

    private static int randomInt(int a, int b) {
        return (int) (Math.random() * (b - a + 1)) + a;
    } // End of randomInt method

    private static void isCaught() {
        caught = (Math.abs(thiefRow - policeRow) +
                Math.abs(thiefColumn - policeColumn) ==
            1)
            ? true
            : false;
    } // End of isCaught method

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

    private static String getCoordinatePositionsAsString() {
        return String.format(
            "Police: (%d, %d)%nThief: (%d, %d)",
            policeRow,
            policeColumn,
            thiefRow,
            thiefColumn
        );
    } // End of getCoordinatePositionsAsString method

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
