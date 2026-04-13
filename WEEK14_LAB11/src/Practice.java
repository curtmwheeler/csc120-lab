import java.io.FileNotFoundException;

public class Practice {

    public static void main(String[] args) throws FileNotFoundException {
        TUI tui = new TUI(100);
        tui.programHeader("Week 14: Lab 11 (PRACTICE)");

        int[][] myArray = new int[2][3];

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                myArray[i][j] = (int) (Math.random() * 100);
            }
        }

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
