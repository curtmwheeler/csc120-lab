/**
 * A utility class for creating formatted Text-based User Interface (TUI) elements.
 *
 * <p>This class provides methods to generate consistent program and section headers for a console
 * application, with a configurable viewport width.
 */
public class TUI {

    /** The width of the terminal viewport for formatting output. */
    private final int terminal_viewport;

    /** A string representing the primary divider, composed of '=' characters. */
    private final String primary_divider;

    /** A string representing the secondary divider, composed of '-' characters. */
    private final String secondary_divider;

    /**
     * Constructs a TUI helper with a specified viewport width.
     *
     * @param viewport_width The desired width of the terminal output in characters. Must be positive.
     * @throws IllegalArgumentException if viewport_width is not positive.
     */
    public TUI(int viewport_width) {
        if (viewport_width <= 0) {
            throw new IllegalArgumentException("Viewport width must be a positive number.");
        }
        this.terminal_viewport = viewport_width;
        this.primary_divider = "=".repeat(viewport_width);
        this.secondary_divider = "-".repeat(viewport_width);
    }

    /**
     * Displays a formatted program header in the terminal.
     *
     * <p>The header consists of the provided title centered horizontally, enclosed by primary
     * dividers (lines of '=' characters) above and below. If the title is wider than the viewport,
     * it will not be padded.
     *
     * @param title The title of the program to be displayed in the header.
     */
    public void programHeader(String title) {
        int padding = (terminal_viewport - title.length()) / 2;
        String centeredTitle = (padding > 0) ? " ".repeat(padding) + title : title;
        System.out.printf(
            "%s%n%s%n%s%n",
            this.primary_divider,
            centeredTitle,
            this.primary_divider
        );
    }

    /**
     * Displays a formatted section header in the terminal.
     *
     * <p>The header consists of the provided title centered, with secondary dividers ('-') on
     * either side to fill the remaining space on the line.
     *
     * @param title The title of the section to be displayed.
     */
    public void sectionHeader(String title) {
        int paddingLength = (terminal_viewport - title.length() - 2) / 2;
        if (paddingLength < 0) {
            paddingLength = 0;
        }
        String divider = "-".repeat(paddingLength);

        // Use a second divider calculation to handle odd/even title lengths gracefully.
        int rightPaddingLength = terminal_viewport - paddingLength - title.length() - 2;
         if (rightPaddingLength < 0) {
            rightPaddingLength = 0;
        }
        String rightDivider = "-".repeat(rightPaddingLength);

        System.out.printf("%s %s %s%n", divider, title, rightDivider);
    }
}
