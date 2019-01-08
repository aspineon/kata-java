package practice.tutorials.daysofcode;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Day11Arrays {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        System.out.println(solve(arr));

        scanner.close();
    }

    @Test
    public void testSampleCase() {
        int[][] given = {{1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}};

        assertEquals(19, solve(given));
    }

    @Test
    public void testSampleCase2() {
        int[][] given ={{1, 1, 1, 0, 0, 0},
                        {0, 1, 0, 1, 1, 5},
                        {1, 1, 1, 0, 10, 0},
                        {0, 0, 2, 4, 4, 1},
                        {0, 0, 0, 2, 0, 0},
                        {0, 0, 1, 2, 4, 0}};

        assertEquals(26, solve(given));
    }

    private static int solve(int[][] given) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < given.length -2; i++) {
            for(int j = 0; j < given[i].length -2; j++) {
                int current = calc(given, i, j);
                max = current > max ? current : max;
            }
        }
        return max;
    }

    private static int calc(int[][] given, int i, int j) {
        return given[i][j] + given[i][j+1] + given[i][j+2]
                + given[i+1][j+1]
                + given[i+2][j] + given[i+2][j+1] + given[i+2][j+2];
    }
}
