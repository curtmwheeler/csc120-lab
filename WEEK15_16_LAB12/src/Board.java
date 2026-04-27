/**
 * Connect Four Board Class
 */
public class Board {

    //------ dimension constants
    public static final int ROWNUM = 6;
    public static final int COLNUM = 7;
    public static final int LENGTH = 4;

    //------ colors
    public static final int P1_FORE_COLOR = 0xc3; // 0xc3;
    public static final int P1_BACK_COLOR = 0xa4;
    public static final int P2_FORE_COLOR = 0xc3; // 0xc3;
    public static final int P2_BACK_COLOR = 0x8e;

    //------- character constants for the pieces
    public static final char CHAR_OPEN = ' ';
    public static final char CHAR_P1 = 'O';
    public static final char CHAR_P2 = 'X';
    public static char[] CHAR_LIST = new char[] { CHAR_OPEN, CHAR_P1, CHAR_P2 };

    //------- string constants for the pieces
    public static final String STRING_OPEN = String.valueOf(CHAR_OPEN);

    //----- P1 color choice
    public static final String STRING_P1 = String.format(
        "\033[38;5;%dm" + // setting a foreground color
            "\033[48;5;%dm" + // setting a background color
            CHAR_P1 + // the string for player 1
            "\033[0;0m", // resetting
        P1_FORE_COLOR,
        P1_BACK_COLOR
    );

    //----- P2 color choice
    public static final String STRING_P2 = String.format(
        "\033[38;5;%dm" + // setting a foreground color
            "\033[48;5;%dm" + // setting a background color
            CHAR_P2 + // the string for player 2
            "\033[0;0m", // resetting
        P2_FORE_COLOR,
        P2_BACK_COLOR
    );

    public static String[] STRING_LIST = new String[] {
        STRING_OPEN,
        STRING_P1,
        STRING_P2,
    };

    //////////////////////////////////////////////////////
    //--- instance variables
    //////////////////////////////////////////////////////
    public int[][] table;
    public int[] height;

    /**
     * Constructor
     */
    public Board() {
        table = new int[COLNUM][ROWNUM];
        height = new int[COLNUM];
    }

    /**
     * Return a clone
     */
    public Board clone() {
        Board copied = new Board();
        for (int col = 0; col < COLNUM; col++) {
            copied.height[col] = this.height[col];
            for (int row = 0; row < ROWNUM; row++) {
                copied.table[col][row] = table[col][row];
            }
        }
        return copied;
    }

    /**
     * @return the piece; -1 if non-existing
     * @param	col	the column index
     * @param	row	the row index
     */
    public int getPiece(int col, int row) {
        if (col < 0 || col >= COLNUM || row < 0 || row >= ROWNUM) return -1;
        return table[col][row];
    }

    /**
     * @return the next pos
     * @param	col	the column index
     */
    public int getHeight(int col) {
        if (col < 0 || col >= COLNUM) return -1;
        return height[col];
    }

    /**
     * @return if a piece can be placed in a column
     * @param	col	the column index
     */
    public boolean isOpen(int col) {
        if (col < 0 || col >= COLNUM) return false;
        return height[col] < ROWNUM;
    }

    /**
     * add a piece to a column
     * @param	col	the column index
     * @param	player	the player index
     * @return	whether the remove was successful
     */
    public boolean add(int col, int player) {
        if (!isOpen(col)) {
            return false;
        }
        table[col][getHeight(col)] = player;
        height[col]++;
        return true;
    }

    /**
     * @return	the top piece
     * @param	col	the column index
     */
    public int getTop(int col) {
        if (col < 0 || col >= COLNUM || getHeight(col) == 0) return -1;
        return table[col][getHeight(col) - 1];
    }

    /**
     * @return if the board is full
     */
    public boolean isAllFull() {
        for (int i = 0; i < COLNUM; i++) {
            if (getHeight(i) < ROWNUM) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        System.out.println("+-+-+-+-+-+-+-+");
        for (int i = ROWNUM - 1; i >= 0; i--) {
            System.out.print("|");
            for (int y = 0; y < COLNUM; y++) {
                System.out.print(STRING_LIST[table[y][i]] + "|");
            }
            System.out.println("\n+-+-+-+-+-+-+-+");
        }
        System.out.println(" 0 1 2 3 4 5 6");
    }

    /**
     * Check if a player has won
     * @param	player	the index to the player
     *		the value must be 1 or 2
     * @return	true if the player has won; false otherwise
     */
    public boolean isWinner(int player) {
        int[][] directions = {
            { 1, 0 }, // horizontal
            { 0, 1 }, // vertical
            { 1, 1 }, // diagonal down-right
            { -1, 1 }, // diagonal down-left
        };

        // Column-major iteration
        // Iterates over every column and each row 'within' the column
        for (int col = 0; col < COLNUM; col++) {
            for (int row = 0; row < ROWNUM; row++) {
                // Checks for every specified direction for a win
                for (int[] direction : directions) {
                    // Incrementation definition
                    int deltaColumn = direction[0],
                        deltaRow = direction[1];

                    boolean allMatch = true;

                    for (int i = 0; i < LENGTH; i++) {
                        // for each piece on the board check within a range of LENGTH for a the other player's piece
                        // if the other player's piece occurs within the range of LENGTH then that direction for the
                        // piece is not a winning match
                        if (
                            getPiece(
                                col + i * deltaColumn,
                                row + i * deltaRow
                            ) !=
                            player
                        ) {
                            allMatch = false;
                            break;
                        }
                    }
                    if (allMatch) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
