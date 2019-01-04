package practice.tutorials.daysofcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Day7Array {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        print(reverse(arr));

        scanner.close();
    }

    @Test
    public void whenNormalArrayIsGiven_thenReturnReversedArray() {
        int[] given = {1, 4, 3, 2};

        assertArrayEquals(new int[]{2, 3, 4, 1}, reverse(given));
    }

    @Test
    public void whenEmptyArrayIsGiven_thenReturnEmptyArray() {
        int[] given = {};

        assertArrayEquals(new int[]{}, reverse(given));
    }


    private static int[] reverse(int[] given) {
        int[] reversed = new int[given.length];

        for(int i = 0; i < given.length; i++) {
            reversed[i] = given[given.length - 1 -i];
        }

        return reversed;
    }

    private static void print(int[] arr) {
        String result = Arrays.stream(arr).mapToObj(n -> String.valueOf(n)).collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
