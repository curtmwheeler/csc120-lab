import java.util.Scanner;

public class Main {

    private static final TUI tui = new TUI(100);
    private static Scanner in = new Scanner(System.in);

    private static int getNumberRectangles() {
        int numberRectangles = -1;
        System.out.print("How many rectangles (no more than 10) > ");
        if (in.hasNextInt()) {
            numberRectangles = in.nextInt();
        }

        if (numberRectangles < 1 || numberRectangles > 10) {
            numberRectangles = -1;
        }
        return numberRectangles;
    } // End of getNumberRectangles()

    private static int radomInteger(int a, int b) {
        return (int) (Math.random() * (b - a)) + a;
    } // End of radomInteger()

    private static Rectangle[] rectangles(int n) {
        Rectangle[] rectangles = new Rectangle[n];
        for (int i = 0; i < n; i++) {
            rectangles[i] = new Rectangle(
                new Interval(radomInteger(0, 99), radomInteger(0, 99)),
                new Interval(radomInteger(0, 99), radomInteger(0, 99))
            );
        }
        return rectangles;
    } // End of rectangles()

    private static void displayRectangleComparison(Rectangle[] rectangles) {
        StringBuilder tableHeader = new StringBuilder("");

        tableHeader.append(" ".repeat(29));
        for (int i = 0; i < rectangles.length; i++) {
            tableHeader.append(String.format("| %d ", i));
        }
        tableHeader.append("\n").append("-".repeat(29 + 4 * rectangles.length));
        System.out.println(tableHeader.toString());

        for (int i = 0; i < rectangles.length; i++) {
            String[] relations = new String[rectangles.length];
            for (int j = 0; j < rectangles.length; j++) {
                relations[j] = Relation
                    .PATTERN[rectangles[i].getRelation(rectangles[j])];
            }
            printRow(i, rectangles[i].toString(), relations);
        }
    } // End of displayRectangleComparison()

    private static void printRow(
        int rowNumber,
        String rectangleData,
        String[] relations
    ) {
        StringBuilder relationString = new StringBuilder("");
        for (String relation : relations) {
            relationString.append(String.format("| %s ", relation));
        }

        System.out.printf(
            " %02d %s %s%n",
            rowNumber,
            rectangleData,
            relationString.toString()
        );
    } // End of printRow()

    public static void main(String[] args) {
        tui.programHeader("Week 13 - Lab 10: Rectangles");

        while (true) {
            int numberRectangles = getNumberRectangles();
            if (numberRectangles == -1) break;
            displayRectangleComparison(rectangles(numberRectangles));
        }
    } // End of main()
} // End of Main class
