public class Practice {

    public static void main(String[] args) {
        TUI tui = new TUI(100);
        tui.programHeader("Week 11 Lab 8");

        int[] array = new int[100];

        tui.sectionHeader("Initialized Array: int[] array = new int[100];");
        System.out.print("{ ");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.printf("%d, ", array[i]);
        }
        System.out.printf("%d }%n", array[array.length - 1]);

        tui.sectionHeader("Updated Array:");
        for (int i = 0; i < array.length; i++) {
            array[(int) (Math.random() * (array.length - 1))]++;
        }
        System.out.print("{ ");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.printf("%d, ", array[i]);
        }
        System.out.printf("%d }%n", array[array.length - 1]);
    }
}
