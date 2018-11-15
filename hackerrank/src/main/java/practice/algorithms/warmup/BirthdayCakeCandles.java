package practice.algorithms.warmup;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class BirthdayCakeCandles {
    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {
        int max = -1;
        int count = 0;
        for(int candle : ar) {
            if(candle > max) {
                max = candle;
                count = 1;
            } else if(candle == max) {
                count += 1;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    @Test
    public void test_whenBasicTestIsGiven_SolutionWillReturnRightAnswer() {

        // GIVEN
        final int[] candles = {3, 2, 1, 3};
        final int rightAnswer = 2;

        assertEquals(rightAnswer, birthdayCakeCandles(candles));
    }

    @Test
    public void test_whenAnotherTestIsGiven_SolutionWillReturnRightAnswer() {

        // GIVEN
        final int[] candles = {3, 2, 1, 3, 4};
        final int rightAnswer = 1;

        assertEquals(rightAnswer, birthdayCakeCandles(candles));
    }
}
