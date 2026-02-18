import java.util.Scanner;

/**
 * The `BallUpSlope` class simulates a physical scenario by solving a quadratic equation
 * of the form {@code alpha * t^2 + beta * t + gamma = 0} to determine a 'travel time'.
 * The coefficients alpha, beta, and gamma are derived from user-provided inputs: initial height,
 * initial speed, and an angle, and also incorporates gravitational acceleration.
 * The program calculates and displays the time taken and horizontal distance covered for
 * a ball's trajectory under both Earth and Moon gravity. It provides a command-line interface
 * for user interaction and output display.
 */
public class BallUpSlope {

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

    /** Initial vertical position from which the ball is considered to start. (meters) */
    private static double height;
    /** Initial magnitude of the ball's velocity. (meters/second) */
    private static double speed;
    /** The angle, in degrees, used in calculations, potentially representing a launch angle or slope angle. */
    private static double angle;
    /** The {@code angle} converted to radians. */
    private static double rad;
    /** The coefficient for the {@code t^2} term in the quadratic equation {@code alpha * t^2 + beta * t + gamma = 0}, calculated as {@code gravity / 2}. */
    private static double alpha;
    /** The coefficient for the {@code t} term in the quadratic equation {@code alpha * t^2 + beta * t + gamma = 0}, calculated as {@code speed * Math.tan(rad)}. */
    private static double beta;
    /** The constant term in the quadratic equation {@code alpha * t^2 + beta * t + gamma = 0}, representing the initial {@code height}. */
    private static double gamma;
    /** The gravitational acceleration to be used in calculations (either Earth or Moon). (meters/second^2) */
    private static double gravity;
    /** The positive solution for 't' (time) from the quadratic equation. (seconds) */
    private static double travel_time;
    /** The calculated horizontal distance, obtained by multiplying {@code speed} and {@code travel_time}. (meters) */
    private static double distance;

    // Calculations
    /**
     * Calculates the {@code alpha} coefficient for the quadratic equation, which is {@code gravity / 2}.
     * @return The calculated alpha coefficient.
     */
    private static double calculateAlpha() {
        return gravity / 2;
    }

    /**
     * Calculates the {@code beta} coefficient for the quadratic equation, which is {@code speed * Math.tan(rad)}.
     * @return The calculated beta coefficient.
     */
    private static double calculateBeta() {
        return speed * Math.tan(rad);
    }

    /**
     * Solves the quadratic equation {@code alpha * t^2 + beta * t + gamma = 0} for 't'
     * using the quadratic formula, returning the positive root that represents the 'travel time'.
     * @return The calculated travel time in seconds.
     */
    private static double calculateTravelTime() {
        return (
            (-beta + Math.sqrt(beta * beta + 4 * alpha * gamma)) / (alpha * 2.0)
        );
    }

    /**
     * Calculates the horizontal distance traveled by multiplying the {@code speed} and {@code travel_time}.
     * Note: This calculation assumes 'speed' represents the horizontal component of velocity.
     * @return The calculated horizontal distance in meters.
     */
    private static double calculateDistance() {
        return speed * travel_time;
    }

    /**
     * Orchestrates the calculation of all intermediate coefficients (alpha, beta, gamma),
     * travel time, and total horizontal distance based on the current global parameter values.
     */
    private static void compute() {
        alpha = calculateAlpha();
        beta = calculateBeta();
        gamma = height;
        travel_time = calculateTravelTime();
        distance = calculateDistance();
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
     * Displays the calculated kinematic values for a given gravitational environment.
     * It first calls {@code compute()} to ensure all values are up-to-date.
     *
     * @param location A string specifying the gravitational environment (e.g., "On the Earth", "On the Moon").
     */
    private static void displayComputedValues(String location) {
        sectionHeader(location);
        compute();
        myPrint("Height of Cliff", gamma, "m");
        myPrint("Speed", speed, "m/s");
        myPrint("Gravity", gravity, "m/s^2");
        myPrint("Alpha", alpha, "-");
        myPrint("Beta", beta, "-");
        myPrint("Gamma", gamma, "-");
        myPrint("Travel Time", travel_time, "s");
        myPrint("Distance", distance, "m");
    }

    /**
     * The entry point for the `BallUpSlope` application.
     * It sets up the program, prompts the user for initial conditions, then calculates
     * and displays the trajectory results for both Earth's and the Moon's gravitational forces.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        programHeader("WEEK 4 - LAB 3: BALL UP SLOPE");

        // Earth
        getUserParameters();
        gravity = EARTH_GRAVITY;
        displayComputedValues("On the Earth");

        // Moon
        gravity = MOON_GRAVITY;
        displayComputedValues("On the Moon");
    }
}
