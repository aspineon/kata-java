package practice.algorithms.warmup;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class DiagonalDifference {

        // Complete the diagonalDifference function below.
        static int diagonalDifference(int[][] arr) {
            int left = 0;
            int right = 0;
            for(int i = 0; i < arr.length; i++) {
                left += arr[i][i];
                right += arr[i][arr.length-1-i];
            }
            return Math.abs(left - right);
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] arrRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int arrItem = Integer.parseInt(arrRowItems[j]);
                    arr[i][j] = arrItem;
                }
            }

            int result = diagonalDifference(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }

        @Test
        public void givenTestCase() {
            final int[][] arr = { {11, 2, 4}
                                , {4, 5, 6}
                                , {10, 8, -12} }; // |4 - 19| = 15
            final int expected = 15;
            final int actual = diagonalDifference(arr);

            assertEquals(expected, actual);
        }

        @Test
        public void anotherTestCase() {
            final int[][] arr = { {10, 2, -4}
                                , {4, 5, 6}
                                , {10, 8, 12} }; // |27 - 11| = 26
            final int expected = 16;
            final int actual = diagonalDifference(arr);

            assertEquals(expected, actual);
        }


    }
