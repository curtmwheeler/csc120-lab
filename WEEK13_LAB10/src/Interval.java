public class Interval {

    private int low, high;

    public Interval() {
        this.low = 0;
        this.high = 1;
    } // End of default constructor

    public Interval(int low, int high) {
        if (low == high) high++;
        this.low = low > high ? high : low;
        this.high = high < low ? low : high;
    } // End of constructor

    public int getLow() {
        return this.low;
    } // End of getLow()

    public int getHigh() {
        return this.high;
    } // End of getHigh()

    public boolean equals(Object o) {
        if (o == this) return true;

        if (!(o instanceof Interval)) return false;

        Interval i = (Interval) o;

        return this.low == i.getLow() && this.high == i.getHigh();
    } // End of equals()

    public int getRelation(Interval i) {
        if (this.equals(i)) return Relation.EQUALS;
        else if (
            this.low == i.getHigh() || this.high == i.getLow()
        ) return Relation.TOUCHES;
        else if (
            this.low >= i.getLow() && this.high <= i.getHigh()
        ) return Relation.PARTOF;
        else if (
            this.low <= i.getLow() && this.high >= i.getHigh()
        ) return Relation.CONTAINS;
        else if (
            (this.low > i.getHigh()) || (this.high < i.getLow())
        ) return Relation.SEPARATE;
        else return Relation.INTERSECTS;
    } // End of getRelation()
} // End of Interval class
