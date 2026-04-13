import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Historical {

    private File file;
    private Scanner in;
    private OneDay[][][] data;

    public Historical() throws FileNotFoundException {
        this.file = new File(Const.FILE_NAME);
        this.in = new Scanner(file);
        this.data = new OneDay[Const.LENGTH][12][31];

        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[i].length; j++) {
                int year = in.nextInt(),
                    month = in.nextInt();

                for (int k = 0; k < this.data[i][j].length; k++) {
                    this.data[i][j][k] = new OneDay(
                        year,
                        month,
                        k + 1,
                        in.nextDouble()
                    );
                }
            }
        }
        in.close();
    }

    public void explore(
        int yLow,
        int yHigh,
        int mLow,
        int mHigh,
        int dLow,
        int dHigh
    ) {
        if (yLow < Const.FIRST_YEAR || yHigh > Const.LAST_YEAR) {
            throw new IllegalArgumentException("Year range out of bounds");
        }

        int count = 0;
        double sum = 0;
        OneDay theMax = null,
            theMin = null;

        for (
            int i = yLow - Const.FIRST_YEAR;
            i < yHigh - Const.FIRST_YEAR + 1;
            i++
        ) {
            for (int j = mLow - 1; j < mHigh; j++) {
                for (int k = dLow - 1; k < dHigh; k++) {
                    OneDay od = this.data[i][j][k];
                    if (od.getAmount() != Const.NODATA) {
                        if (
                            theMax == null ||
                            od.getAmount() > theMax.getAmount()
                        ) {
                            theMax = od;
                        }
                        if (
                            theMin == null ||
                            od.getAmount() < theMin.getAmount()
                        ) {
                            theMin = od;
                        }
                        count++;
                        sum += od.getAmount();
                    }
                }
            }
        }

        System.out.printf(
            "Count %d%nSum %.4f%n%s%n%s%n",
            count,
            sum,
            String.format("Maximum %s", theMax.toString()),
            String.format("Minimum %s", theMin.toString())
        );
    }
}
