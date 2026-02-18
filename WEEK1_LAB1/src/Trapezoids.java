public class Trapezoids {
    public static void main(String[] args) {
        // Variable declaration
        int heightOne, bottomOne, topOne, areaOne;
        double heightTwo, bottomTwo, topTwo, areaTwo;

        // Variable initialization
        heightOne = 7;
        bottomOne = 6;
        topOne = 3;
        areaOne =  (topOne + bottomOne) * heightOne / 2;

        heightTwo = 7;
        bottomTwo = 6;
        topTwo = 3;
        areaTwo = (topTwo + bottomTwo) * heightTwo / 2;

        System.out.println("-".repeat(50));
        System.out.printf(" HEIGHT = %d\n", heightOne);
        System.out.printf(" BOTTOM = %d\n", bottomOne);
        System.out.printf(" TOP = %d\n", topOne);
        System.out.printf(" AREA = %d\n", areaOne);

        System.out.println("-".repeat(50));
        System.out.printf(" HEIGHT = %.2f\n", heightTwo);
        System.out.printf(" BOTTOM = %.2f\n", bottomTwo);
        System.out.printf(" TOP = %.2f\n", topTwo);
        System.out.printf(" AREA = %.2f\n", areaTwo);
    }
}
