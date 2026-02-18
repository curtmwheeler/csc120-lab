import java.util.Scanner;

/**
 * The `BallReach` class calculates the trajectory of a projectile (ball) launched at a certain
 * angle and speed from a given height, considering different gravitational forces (Earth and Moon).
 * It provides a command-line interface for users to input parameters and displays computed values
 * such as horizontal distance, total time, and various velocity components and distances.
 */
public class BallReach {

    // TUI Constants
    /** The width of the terminal viewport for formatting output. */
    private static final int TERMINAL_VIEWPORT = 100;
    /** A string representing the primary divider used in the terminal output. */
    private static final String PRIMARY_DIVIDER = "=".repeat(TERMINAL_VIEWPORT);
    /** A string representing the secondary divider used in the terminal output. */
    private static final String SECONDARY_DIVIDER = "-".repeat(
        TERMINAL_VIEWPORT
    );

    // Calculation Constants
    /** The acceleration due to gravity on Earth in meters per second squared. */
    private static final double EARTH_GRAVITY = 9.81;
    /** The acceleration due to gravity on the Moon in meters per second squared. */
    private static final double MOON_GRAVITY = 1.62;
    /** The initial height from which the ball is launched in meters. */
    private static double height;
    /** The launch angle of the ball in degrees. */
    private static double angle;
    /** The launch angle of the ball in radians. */
    private static double rad;
    /** The initial speed of the ball in meters per second. */
    private static double speed;
    /** The horizontal component of the ball's initial speed in meters per second. */
    private static double horizontal_speed;
    /** The vertical component of the ball's initial speed in meters per second. */
    private static double vertical_speed;
    /** The current gravitational acceleration being used for calculations (Earth or Moon). */
    private static double gravity;
    /** The time taken for the ball to reach its apex from the launch height in seconds. */
    private static double upward_time;
    /** The vertical distance covered by the ball during its upward trajectory from the launch height in meters. */
    private static double upward_distance;
    /** The time taken for the ball to fall from its apex to the ground in seconds. */
    private static double downward_time;
    /** The vertical distance the ball falls from its apex to the ground in meters. */
    private static double downward_distance;
    /** The total horizontal distance covered by the ball during its flight in meters. */
    private static double horizontal_distance;
    /** The total time of flight for the ball in seconds. */
    private static double total_time;

    // Calculations
    /**
     * Calculates the duration of the upward vertical component of the ball's flight.
     *
     * @return The time in seconds the ball takes to reach its maximum height from the launch point.
     */
    private static double calculateUpwardVelocityComponentDuration() {
        return vertical_speed / gravity;
    }

    /**
     * Calculates the duration of the downward vertical component of the ball's flight.
     *
     * @return The time in seconds the ball takes to fall from its maximum height to the ground.
     */
    private static double calculateDownwardVelocityComponentDuration() {
        return Math.sqrt((2 * downward_distance) / gravity);
    }

    /**
     * Calculates the total duration of the ball's flight.
     *
     * @return The total time in seconds the ball is in the air.
     */
    private static double calculateTotalDuration() {
        return upward_time + downward_time;
    }

    /**
     * Calculates the total vertical distance the ball falls from its apex. This includes the initial
     * height plus the additional height gained during the upward trajectory.
     *
     * @return The total downward vertical distance in meters.
     */
    private static double calculateDownwardComponentDistance() {
        return height + (gravity * upward_time * upward_time) / 2;
    }

    /**
     * Calculates the vertical distance gained by the ball during its upward trajectory from the launch height.
     *
     * @return The upward vertical distance in meters.
     */
    private static double calculateUpwardComponentDistance() {
        return downward_distance - height;
    }

    /**
     * Calculates the initial vertical component of the ball's velocity.
     *
     * @return The initial vertical velocity in meters per second.
     */
    private static double calculateYVelocityComponent() {
        return speed * Math.sin(rad);
    }

    /**
     * Calculates the initial horizontal component of the ball's velocity.
     *
     * @return The initial horizontal velocity in meters per second.
     */
    private static double calculateXVelocityComponent() {
        return speed * Math.cos(rad);
    }

    /**
     * Calculates the total horizontal displacement of the ball.
     *
     * @return The total horizontal distance covered in meters.
     */
    private static double calculateXDisplacement() {
        return horizontal_speed * total_time;
    }

    /**
     * Computes all the derived kinematic values for the ball's trajectory based on initial parameters.
     * This method updates the static variables: {@code vertical_speed}, {@code horizontal_speed},
     * {@code downward_distance}, {@code upward_time}, {@code upward_distance},
     * {@code downward_time}, {@code total_time}, and {@code horizontal_distance}.
     */
    private static void compute() {
        vertical_speed = calculateYVelocityComponent();
        horizontal_speed = calculateXVelocityComponent();
        upward_time = calculateUpwardVelocityComponentDuration();
        downward_distance = calculateDownwardComponentDistance();
        upward_distance = calculateUpwardComponentDistance();
        downward_time = calculateDownwardVelocityComponentDuration();
        total_time = calculateTotalDuration();
        horizontal_distance = calculateXDisplacement();
    }

    // TUI helpers

    /**
     * Displays a formatted program header in the terminal.
     *
     * @param title The title of the program or section to display.
     */
    private static void programHeader(String title) {
        title = " ".repeat((TERMINAL_VIEWPORT - title.length()) / 2) + title;
        System.out.printf(
            "%s%n%s%n%s%n",
            PRIMARY_DIVIDER,
            title,
            PRIMARY_DIVIDER
        );
    }

    /**
     * Displays a formatted section header in the terminal.
     *
     * @param title The title of the section to display.
     */
    private static void sectionHeader(String title) {
        String divider = "-".repeat(
            (TERMINAL_VIEWPORT - title.length()) / 2 - 1
        );
        System.out.printf("%s %s %s%n", divider, title, divider);
    }

    /**
     * Prints a named double value with its unit in a formatted manner to the console.
     *
     * @param name The name of the value (e.g., "Height of Cliff").
     * @param value The double value to print.
     * @param unit The unit of the value (e.g., "m", "m/s").
     */
    public static void myPrint(String name, double value, String unit) {
        System.out.printf("%30s:%14.4f (%s)%n", name, value, unit);
    }

    /**
     * Prompts the user to enter the ball's initial angle, speed, and launch height.
     * The inputs are normalized to ensure valid values (angle between 0-90, speed and height non-negative).
     * It uses a {@code Scanner} to read input from the console.
     */
    private static void getUserParameters() {
        Scanner in = new Scanner(System.in);

        sectionHeader("Distance Calculation");

        // Prompts
        System.out.printf("Enter angle (degree): ");

        // Angle input normalization
        angle = Math.max(Math.min(in.nextDouble(), 90), 0);

        rad = Math.toRadians(angle);

        System.out.printf("Enter speed (m/s): ");

        speed = Math.max(in.nextDouble(), 0);

        System.out.printf("Enter height (m): ");
        height = Math.max(in.nextDouble(), 0);

        in.close();
    }

    /**
     * Displays all the computed kinematic values for the ball's trajectory for a given location.
     * It first calls {@code compute()} to ensure all values are up-to-date.
     *
     * @param location The name of the location (e.g., "On the Earth", "On the Moon") for which values are displayed.
     */
    private static void displayComputedValues(String location) {
        sectionHeader(location);
        compute();
        myPrint("Height of Cliff", height, "m");
        myPrint("Horizontal Speed", horizontal_speed, "m/s");
        myPrint("Initial Vertical Speed", vertical_speed, "m/s");
        myPrint("Gravity", gravity, "m/s^2");
        myPrint("Upward Time", upward_time, "s");
        myPrint("Upward Distance", upward_distance, "m");
        myPrint("Downward Time", downward_time, "s");
        myPrint("Downward Distance", downward_distance, "m");
        myPrint("Total Time", total_time, "s");
        myPrint("Horizontal Distance", horizontal_distance, "m");
    }

    /**
     * The main method of the `BallReach` program.
     * It initializes the program header, prompts the user for input, and then calculates and
     * displays the ball's trajectory on Earth and on the Moon.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        programHeader("WEEK 4 - LAB 3: BALL REACH");

        // Earth
        getUserParameters();
        gravity = EARTH_GRAVITY;
        displayComputedValues("On the Earth");

        // Moon
        gravity = MOON_GRAVITY;
        displayComputedValues("On the Moon");
    }
}
