import java.util.Scanner;

public class AndreaBakery {

    public static void main(String[] args) {
        // Program Header
        System.out.println("WEEK 3 - LAB 2, PART 2");

        // Constants
        final double PRICE_CREAM_PUFF = 2.5,
            PRICE_ECLAIR = 5.5,
            PRICE_MACARON = 2,
            PRICE_CROISSANT = 3.5,
            TAX_RATE = 0.07;

        // Variable Declarations
        int numberCreamPuff, numberEclair, numberMacaron, numberCroissant;
        double subtotal, tax, total;

        Scanner input = new Scanner(System.in);

        // Program Welcome Message
        System.out.println(
            "Welcome to Andrea's Bakery!\nHere is our menu:\n\t-  Cream puff: 2 dollars and 50 cents\n\t-  Eclair: 5 dollars and 50 cents \n\t- Macaron: 2 dollars\n\t- Croissant: 3 dollars and 50 cents"
        );

        // Print prompt and get next integer token in sequence
        System.out.print("How many Cream Puffs? ");
        numberCreamPuff = input.nextInt();

        System.out.print("How many Eclair? ");
        numberEclair = input.nextInt();

        System.out.print("How many Macaron? ");
        numberMacaron = input.nextInt();

        System.out.print("How many Croissant? ");
        numberCroissant = input.nextInt();

        // Close Scanner
        input.close();

        // Compute subtotal, tax, and total
        subtotal =
            (PRICE_CREAM_PUFF * numberCreamPuff) +
            (PRICE_ECLAIR * numberEclair) +
            (PRICE_MACARON * numberMacaron) +
            (PRICE_CROISSANT * numberCroissant);
        tax = TAX_RATE * subtotal;
        total = subtotal + tax;

        // Formatted program output.
        System.out.printf(
            "Subtotal: %d dollars and %d cents\n",
            (int) subtotal,
            (int) ((subtotal * 100) % 100)
        );
        System.out.printf(
            "Tax: %d dollars and %d cents\n",
            (int) tax,
            (int) ((tax * 100) % 100)
        );
        System.out.printf(
            "Total: %d dollars and %d cents\n",
            (int) total,
            (int) ((total * 100) % 100)
        );
    }
}
