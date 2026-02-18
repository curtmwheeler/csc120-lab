/**
 * Represents a calculator for Body Mass Index (BMI).
 *
 * <p>This class provides methods to calculate BMI using either metric (kilograms and meters) or
 * imperial (pounds and inches) units. It can store user's weight and height or calculate BMI
 * directly from provided values.
 */
public class BMICalculator {

    /** The user's height, intended to be in meters for metric calculations. */
    double height;

    /** The user's weight, intended to be in kilograms for metric calculations. */
    double weight;

    /**
     * Constructs a BMICalculator with default values.
     *
     * <p>Initializes height and weight to 0. These values should be set using the setter methods
     * before calculation.
     */
    public BMICalculator() {
        this.height = 0;
        this.weight = 0;
    }

    /**
     * Constructs a BMICalculator with specified weight and height.
     *
     * @param weight the user's weight (e.g., in kilograms). Must be positive.
     * @param height the user's height (e.g., in meters). Must be positive.
     * @throws IllegalArgumentException if weight or height are not positive.
     */
    public BMICalculator(double weight, double height) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }

        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }

        this.height = height;
        this.weight = weight;
    }

    /**
     * Sets the height for the BMI calculation.
     *
     * @param height the user's height (e.g., in meters). Must be positive.
     * @throws IllegalArgumentException if height is not positive.
     */
    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }

        this.height = height;
    }

    /**
     * Sets the weight for the BMI calculation.
     *
     * @param weight the user's weight (e.g., in kilograms). Must be positive.
     * @throws IllegalArgumentException if weight is not positive.
     */
    public void setWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }

        this.weight = weight;
    }

    /**
     * Calculates BMI using the stored height and weight.
     *
     * <p>This method assumes the height is in meters and weight is in kilograms. The formula is:
     * {@code weight / (height^2)}.
     *
     * @return the calculated BMI value.
     */
    public double calculateBMI() {
        return this.weight / (Math.pow(this.height, 2));
    }

    /**
     * Calculates BMI using the provided weight and height in imperial units.
     *
     * <p>This method uses the standard formula for imperial units (pounds and inches):
     * {@code (703 * weight) / (height^2)}.
     *
     * @param userWeight the user's weight in pounds. Must be positive.
     * @param userHeight the user's height in inches. Must be positive.
     * @return the calculated BMI value.
     * @throws IllegalArgumentException if userWeight or userHeight are not positive.
     */
    public double calculateBMI(double userWeight, double userHeight) {
        if (userWeight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }

        if (userHeight <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }

        return (703.0 * userWeight) / (Math.pow(userHeight, 2));
    }
}
