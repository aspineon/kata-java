package practice.algorithms.implementation;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;

public class AppleAndOrange {

    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int[] result = countApplesAndOranges1(s, t, a, b, apples, oranges);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
    static int[] countApplesAndOranges1(int s, int t, int a, int b, int[] apples, int[] oranges) {

        int appleCount = 0;
        int orangeCount = 0;
        for(int apple : apples) {
            if(isFruitInTheHouse(a, apple, s, t)) {
                appleCount += 1;
            }
        }
        for(int orange : oranges) {
            if(isFruitInTheHouse(b, orange, s, t)) {
                orangeCount += 1;
            }
        }


        int[] result = {appleCount, orangeCount};

        return result;
    }

    private static boolean isFruitInTheHouse(int root, int distance, int leftOfHouse, int rightOfHouse) {
        if((root+distance) >= leftOfHouse && (root+distance) <= rightOfHouse) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] st = scanner.nextLine().split(" ");

        int s = Integer.parseInt(st[0]);

        int t = Integer.parseInt(st[1]);

        String[] ab = scanner.nextLine().split(" ");

        int a = Integer.parseInt(ab[0]);

        int b = Integer.parseInt(ab[1]);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        int[] apples = new int[m];

        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesItems[i]);
            apples[i] = applesItem;
        }

        int[] oranges = new int[n];

        String[] orangesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesItems[i]);
            oranges[i] = orangesItem;
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);

        scanner.close();
    }

    @Test
    public void whenBasicCaseIsGiven_SolutionWillReturnAnswer() {
        int s = 7, t =  11;
        int a =5, b = 15;
        int m = 3, n = 2;
        int[] apples = {-2, 2, 1};
        int[] oranges = {5, -6};

        final int[] expected = {1, 1};

        assertArrayEquals(expected, countApplesAndOranges1(s, t, a, b, apples, oranges));
    }

    @Test
    public void whenAnotherCaseIsGiven_SolutionWillReturnAnswer() {
        int s = 7, t =  11;
        int a =5, b = 15;
        int m = 3, n = 2;
        int[] apples = {-2, 2, 3};
        int[] oranges = {5, -6};

        final int[] expected = {2, 1};

        assertArrayEquals(expected, countApplesAndOranges1(s, t, a, b, apples, oranges));
    }
}
