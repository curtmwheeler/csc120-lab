public class Rectangle {

    private Interval xInterval, yInterval;

    public Rectangle() {
        this.xInterval = new Interval();
        this.yInterval = new Interval();
    } // End of default constructor

    public Rectangle(Interval xInterval, Interval yInterval) {
        this.xInterval = xInterval;
        this.yInterval = yInterval;
    } // End of constructor

    public Interval getXInterval() {
        return this.xInterval;
    } // End of getXInterval()

    public Interval getYInterval() {
        return this.yInterval;
    } // End of getYInterval()

    public String toString() {
        return String.format(
            "x: [%02d, %02d], y: [%02d, %02d]",
            this.xInterval.getLow(),
            this.xInterval.getHigh(),
            this.yInterval.getLow(),
            this.yInterval.getHigh()
        );
    }

    public int getRelation(Rectangle rectangle) {
        int xRelation = this.getXInterval().getRelation(
            rectangle.getXInterval()
        );
        int yRelation = this.getYInterval().getRelation(
            rectangle.getYInterval()
        );

        if (
            xRelation == Relation.EQUALS && yRelation == Relation.EQUALS
        ) return Relation.EQUALS;
        else if (
            xRelation == Relation.SEPARATE || yRelation == Relation.SEPARATE
        ) return Relation.SEPARATE;
        else if (
            xRelation == Relation.PARTOF && yRelation == Relation.PARTOF
        ) return Relation.PARTOF;
        else if (
            xRelation == Relation.CONTAINS && yRelation == Relation.CONTAINS
        ) return Relation.CONTAINS;
        else if (
            xRelation == Relation.TOUCHES || yRelation == Relation.TOUCHES
        ) return Relation.TOUCHES;
        else return Relation.INTERSECTS;
    } // End of getRelation()
} // End of Rectangle class
