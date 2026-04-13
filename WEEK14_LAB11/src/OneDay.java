public class OneDay implements OneDayInt {

    private int year, month, day;
    private double amount;

    public OneDay() {
        throw new IllegalArgumentException(
            "No-argument constructor not allowed"
        );
    }

    public OneDay(int year, int month, int day, double amount) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public String toString() {
        return String.format(
            "%f on %d-%d-%d",
            this.amount,
            this.year,
            this.month,
            this.day
        );
    }
}
