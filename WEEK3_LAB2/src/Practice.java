public class Practice {

    public static void main(String[] args) {
        System.out.println("WEEK 3 - LAB 2 PRACTICE");

        //        System.out.println(123/10);
        //        System.out.println(123/100);
        //        System.out.println(123%10);

        double subtotal = 58.50;
        System.out.printf("Subtotal: $%f\n", subtotal);

        int dollars = (int) subtotal;
        System.out.printf("Dollars: $%d\n", dollars);

        int cents = (int) ((subtotal * 100) % 100);
        System.out.printf("Cents: %d\n", cents);
    }
}
