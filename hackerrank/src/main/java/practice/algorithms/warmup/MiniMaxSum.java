package practice.algorithms.warmup;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class MiniMaxSum {
    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long[] result = miniMaxSum1(arr);
        System.out.println(String.format("%d %d", result[0], result[1]));
    }

    static long[] miniMaxSum1(int[] arr) {
        Arrays.sort(arr);

        long min = 0;
        for(int i = 0; i < 4; i++) {
            min += arr[i];
        }

        long max = 0;
        for(int i = 1; i < 5; i++) {
            max += arr[i];
        }

        long[] ret = {min, max};
        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }

    @Test
    public void test_WhenBasicTestCaseIsGiven_SolutionWillReturnRightAnswer() {
        // GIVEN
        int[] arr = {1, 2, 3, 4, 5};

        long[] ret = miniMaxSum1(arr);
        assertEquals(10, ret[0]);
        assertEquals(14, ret[1]);
    }

    @Test
    public void test_WhenAnotherTestCaseIsGiven_SolutionWillReturnSameAnswer() {
        // GIVEN
        int[] arr = {1, 1, 1, 1, 1};

        long[] ret = miniMaxSum1(arr);
        assertEquals(4, ret[0]);
        assertEquals(4, ret[1]);
    }

    @Test
    public void test_WhenNonOrderedTestCaseIsGiven_SolutionWillReturnRightAnswer() {
        // GIVEN
        int[] arr = {3, 5, 2, 4, 1};

        long[] ret = miniMaxSum1(arr);
        assertEquals(10, ret[0]);
        assertEquals(14, ret[1]);
    }

    @Test
    public void test_WhenLongTypeTestCaseIsGiven_SolutionWillReturnRightAnswer() {
        // GIVEN
        int[] arr = {900000000, 900000000, 900000000, 900000000, 900000000};

        long[] ret = miniMaxSum1(arr);
        assertEquals(3600000000L, ret[0]);
        assertEquals(3600000000L, ret[1]);
    }
}
