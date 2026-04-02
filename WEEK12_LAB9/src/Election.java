import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Election {

    private static final Scanner in = new Scanner(System.in);
    private static final TUI tui = new TUI(100);
    private static String[] names = new String[0];
    private static int[] counts = new int[0];

    private static int find(String[] names, String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(name)) return i;
        }
        return -1;
    } // End of find method

    private static String[] addName(String[] names, String name) {
        String[] newNames = new String[names.length + 1];

        for (int i = 0; i < names.length; i++) {
            newNames[i] = names[i];
        }

        newNames[names.length] = name;
        return newNames;
    } // End of addName method

    private static int[] addNewCount(int[] counts) {
        int[] newCounts = new int[counts.length + 1];

        for (int i = 0; i < counts.length; i++) {
            newCounts[i] = counts[i];
        }

        newCounts[counts.length] = 1;
        return newCounts;
    } // End of addNewCount method

    private static void findWinner(String[] names, int[] counts) {
        tui.sectionHeader("Election Results");

        int maxCount = 0,
            theWinner = 0;

        for (int i = 0; i < counts.length; i++) {
            printNameWithVotes(names[i], counts[i]);
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                theWinner = i;
            }
        }

        printWinner(names[theWinner]);
    } // End of findWinner method

    // Helper Functions

    private static void printNameWithVotes(String name, int votes) {
        System.out.printf("%s recieved %d votes%n", name, votes);
    } // End of printNameWithVotes method

    private static void printWinner(String name) {
        System.out.printf("The winner is %s!%n", name);
    } // End of printWinner method

    private static boolean useFile() {
        System.out.print("Use a file? [Y/n] > ");
        String response = in.nextLine();
        return response.toLowerCase().startsWith("y") ? true : false;
    } // End of useFile method

    private static String promptFileName() {
        System.out.print("Enter the file path > ");
        String filename = in.nextLine();
        return filename;
    } // End of promptFileName method

    private static void getVotesFromFile(String filename) {
        File file = new File(filename);

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();

                if (line.isEmpty()) continue;

                if (find(names, line) == -1) {
                    names = addName(names, line);
                    counts = addNewCount(counts);
                } else {
                    counts[find(names, line)]++;
                }
            }

            findWinner(names, counts);
        } catch (FileNotFoundException e) {
            System.out.printf("ERROR: Could not read file \"%s\"%n", filename);
        }
    } // End of getVotesFromFile method

    private static void getVotesFromUser() {
        tui.sectionHeader("Enter the votes, one vote per line.");

        while (in.hasNextLine()) {
            String line = in.nextLine().trim();

            if (line.isEmpty()) {
                break;
            }

            int index = find(names, line);

            if (index == -1) {
                names = addName(names, line);
                counts = addNewCount(counts);
            } else {
                counts[index]++;
            }
        }

        if (names.length > 0) {
            findWinner(names, counts);
        } else {
            System.out.println("No votes entered.");
        }
    } // End of getVotesFromUser method

    public static void main(String[] args) {
        tui.programHeader("Week 12 & 13 - Lab 9");

        if (useFile()) {
            getVotesFromFile(promptFileName());
        } else {
            getVotesFromUser();
        }
    } // End of main method
} // End of Election class
