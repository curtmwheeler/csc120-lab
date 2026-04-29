import java.util.Scanner;

public class SimpleMain {

    //------ dimension constants
    public static final int ROWNUM = 6;
    public static final int COLNUM = 7;
    public static final int LENGTH = 4;

    //------- character constants for the pieces
    public static final char CHAR_OPEN = ' ';
    public static final char CHAR_P1 = 'O';
    public static final char CHAR_P2 = 'X';

    private static Board board;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String input;

        do {
            oneGame(keyboard);
            System.out.printf("%nDo you want to play another game > ");
            input = keyboard.next();
        } while (input.toLowerCase().startsWith("y"));
        System.out.println("Goodbye.");
    } // end of main method

    private static void oneGame(Scanner keyboard) {
        board = new Board();

        int level = -1;
        int player = 1;

        System.out.println(
            "Let’s play Connect Four.\nPick the intelligence level\n0: You play the opponent too\n1: The program plays randomly\n2: The program does not miss a winning play\n3: The program additionally avoids a losing play"
        );
        while (level < 0 || level > 3) {
            System.out.print("Enter your choice > ");
            if (keyboard.hasNextInt()) {
                level = keyboard.nextInt();
                if (level < 0 || level > 3) System.out.print(
                    "Invalid selection. "
                );
            } else {
                System.out.print("Invalid selection. ");
                keyboard.next();
            }
        }

        boolean gameOver = false;

        while (!gameOver) {
            board.print();

            int col = -1;

            if (board.isAllFull()) {
                System.out.println("Draw");
                gameOver = true;
                break;
            } else {
                // Input validation for selected column
                if (level == 0) {
                    while (col < 0 || col >= COLNUM || !board.isOpen(col)) {
                        System.out.printf(
                            "(Player %d) Enter a column (0-%d) > ",
                            player,
                            COLNUM - 1
                        );
                        if (keyboard.hasNextInt()) {
                            col = keyboard.nextInt();
                            if (col < 0 || col >= COLNUM) System.out.print(
                                "Invalid column. Try again: "
                            );
                            else if (!board.isOpen(col)) System.out.print(
                                "Column is full. Try another column: "
                            );
                        } else {
                            System.out.print("Not a number. Try again: ");
                            keyboard.next();
                            continue;
                        }
                    }
                } else {
                    System.out.println("NOT IMPLEMENTED.");
                    gameOver = true;
                    break;
                }

                if (board.add(col, player)) {
                    if (board.isWinner(player)) {
                        board.print();
                        System.out.printf("Player %d wins!%n", player);
                        gameOver = true;
                    } else {
                        // player = 3 - player;
                        player = player == 1 ? 2 : 1;
                    }
                } else {
                    System.out.println("Invalid move.");
                }
            }
        }
    } // end of oneGame method
} // end of SimpleMain class
