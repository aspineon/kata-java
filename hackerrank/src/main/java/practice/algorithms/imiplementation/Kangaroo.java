package practice.algorithms.imiplementation;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Kangaroo {


    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        if( (x1 >= x2 && v1 >= v2) || (x1 <= x2 && v1 <= v2) ) {
            return Result.NO.name();
        } else {

            long d1 = x1;
            long d2 = x2;

            while (d1 <= Long.MAX_VALUE && d2 <= Long.MAX_VALUE) {
                d1 += v1;
                d2 += v2;

                if (d1 == d2) {
                    return Result.YES.name();
                } else if ((d1 < d2 && v1 <= v2) || (d1 > d2 && v1 >= v2) ){
                    return Result.NO.name();
                }
            }

            return Result.NO.name();
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    @Test
    public void whenSampleIsGiven_SolutionWillReturnYES() {
        int x1 = 0, v1 = 3;
        int x2 = 4, v2 = 2;

        String expected = "YES";


        assertEquals(expected, kangaroo(x1, v1, x2, v2));
    }
    @Test
    public void whenBasicCaseIsGiven_solutionWillReturnNO() {
        int x1 = 0, v1 = 2;
        int x2 = 5, v2 = 3;

        String expected = "NO";


        assertEquals(expected, kangaroo(x1, v1, x2, v2));
    }

    @Test
    public void whenReversalCaseIsGiven_solutionWillReturnNO() {
        int x1 = 1, v1 = 7;
        int x2 = 2, v2 = 3;

        String expected = "NO";


        assertEquals(expected, kangaroo(x1, v1, x2, v2));
    }

    enum Result {
        YES, NO
    }
}
