import java.util.*;

public class Main {

    //------ dimension constants
    public static final int ROWNUM = 6;
    public static final int COLNUM = 7;
    public static final int LENGTH = 4;

    //------- character constants for the pieces
    public static final char CHAR_OPEN = ' ';
    public static final char CHAR_P1 = 'O';
    public static final char CHAR_P2 = 'X';
    public static char[] CHAR_LIST = new char[] { CHAR_OPEN, CHAR_P1, CHAR_P2 };

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
    }

    private static Board theBoard;

    /**
     * play
     */
    public static void oneGame(Scanner keyboard) {
        board = new Board();
        System.out.println(
            "Let’s play Connect Four.\nPick the intelligence level\n0: You play the opponent too\n1: The program plays randomly\n2: The program does not miss a winning play\n3: The program additionally avoids a losing play"
        );
        System.out.print("Enter your choice > ");
        int level;

        if (keyboard.hasNextInt()) {
            level = keyboard.nextInt();
            if (level < 0 || level > 3) level = 1;
        } else {
            keyboard.next();
            level = 1;
        }

        int player = 1;

        while (true) {
            board.print();
            if (player == 1 || (level == 0 && player == 2)) {
                System.out.print("Enter your move > ");
                if (keyboard.hasNextInt()) {
                    int col = keyboard.nextInt();
                    if (col < 0 || col > 6) {
                        System.out.println("Invalid column.");
                        continue;
                    }
                    if (!board.add(col, player)) {
                        System.out.println("Column is full.");
                        continue;
                    }
                } else {
                    keyboard.next();
                    continue;
                }
            } else if (player == 2) {
                int col;
                int winCol = -1,
                    blockCol = -1;

                while (true) {
                    // Default column selection
                    col = (int) (Math.random() * COLNUM); // Range: [0, 6]

                    // More advanced column selection for levels 2 -> 3
                    if (level >= 2) {
                        for (int i = 0; i < COLNUM; i++) {
                            if (!board.isOpen(i)) continue;
                            Board boardCloneComputer = board.clone();
                            boardCloneComputer.add(i, 2);
                            if (boardCloneComputer.isWinner(2)) {
                                col = i;
                                break;
                            }
                            if (level == 3) {
                                Board boardClonePlayer = board.clone();
                                boardClonePlayer.add(i, 1);
                                if (boardClonePlayer.isWinner(1)) {
                                    col = i;
                                    break;
                                }
                            }
                        }
                    }
                    System.out.printf("Computer > %d%n", col);
                    if (board.add(col, 2)) break;
                }
            }

            // Check if there is a winner
            if (board.isWinner(player)) {
                board.print();
                System.out.println("Player " + player + " wins!");
                return;
            }

            // Coerces flipping from 1 -> 2 on each iteration (Ex: Start: 1 -> 3 - 1 = 2 -> 3 - 2 = 1)
            player = 3 - player;
        }
    }
}
