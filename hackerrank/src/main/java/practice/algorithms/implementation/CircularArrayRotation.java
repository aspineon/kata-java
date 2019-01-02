package practice.algorithms.implementation;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CircularArrayRotation {

    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {

        k = k%a.length;

        int[] rotated = new int[a.length];

        for(int i = 0; i < k; i++) {
            rotated[i] = a[a.length-k+i];
        }
        for(int i = k; i < a.length; i++) {
            rotated[i] = a[i-k];
        }

        int[] result = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            result[i] = rotated[queries[i]];
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nkq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nkq[0]);

        int k = Integer.parseInt(nkq[1]);

        int q = Integer.parseInt(nkq[2]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] queries = new int[q];

        for (int i = 0; i < q; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        int[] result = circularArrayRotation(a, k, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    @Test
    public void whenBasicCaseIsGiven_solutionWillReturnGivenAnswer() {
        int[] a = {1, 2, 3};
        int k = 2;
        int[] queries = {0, 1, 2};

        int[] expected = {2, 3, 1};

        org.junit.Assert.assertArrayEquals(expected, circularArrayRotation(a, k, queries));
    }

    @Test
    public void whenBasicCaseWithOtherQueriesIsGiven_solutionWillReturnGivenAnswer() {
        int[] a = {1, 2, 3};
        int k = 2;
        int[] queries = {2, 1, 0};

        int[] expected = {1, 3, 2};

        org.junit.Assert.assertArrayEquals(expected, circularArrayRotation(a, k, queries));
    }
    @Test
    public void whenAnotherCaseIsGiven_solutionWillReturnGivenAnswer() {
        int[] a = {1, 2, 3, 4, 5};
        int k = 2;
        int[] queries = {0, 1, 2, 3, 4};

        int[] expected = {4, 5, 1, 2, 3};

        org.junit.Assert.assertArrayEquals(expected, circularArrayRotation(a, k, queries));
    }
    @Test
    public void whenAnotherCaseWithShortQueriesIsGiven_solutionWillReturnGivenAnswer() {
        int[] a = {1, 2, 3, 4, 5};
        int k = 2;
        int[] queries = {1, 3};

        int[] expected = {5, 2};

        org.junit.Assert.assertArrayEquals(expected, circularArrayRotation(a, k, queries));
    }
    @Test
    public void whenKIsZero_solutionWillReturnGivenAnswer() {
        int[] a = {1, 2, 3, 4, 5};
        int k = 0;
        int[] queries = {1, 3};

        int[] expected = {2, 4};

        org.junit.Assert.assertArrayEquals(expected, circularArrayRotation(a, k, queries));
    }
    @Test
    public void whenNEqualsK_solutionWillReturnGivenAnswer() {
        int[] a = {1, 2, 3, 4, 5};
        int k = 5;
        int[] queries = {1, 3};

        int[] expected = {2, 4};

        org.junit.Assert.assertArrayEquals(expected, circularArrayRotation(a, k, queries));
    }

    @Test
    public void whenQIsZero_solutionWillReturnGivenAnswer() {
        int[] a = {1, 2, 3, 4, 5};
        int k = 5;
        int[] queries = {1};

        int[] expected = {2};

        org.junit.Assert.assertArrayEquals(expected, circularArrayRotation(a, k, queries));
    }
    @Test
    public void whenNIs100000_solutionWillReturnGivenAnswer() {
        int[] a = new int[100000];
        for(int i = 0; i < a.length; i++) {
            a[i] = 100000;
        }
        int k = 5;
        int[] queries = {1};

        int[] expected = {100000};

        org.junit.Assert.assertArrayEquals(expected, circularArrayRotation(a, k, queries));
    }
}
