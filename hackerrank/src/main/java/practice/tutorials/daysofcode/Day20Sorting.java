package practice.tutorials.daysofcode;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Day20Sorting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        // Write Your Code Here
        print(sort(a));
    }

    private static void print(int[] arr) {
        System.out.println(String.format("Array is sorted in %d swaps.", arr[0]));
        System.out.println(String.format("First Element: %d", arr[1]));
        System.out.println(String.format("Last Element: %d", arr[2]));
    }


    @Test
    public void testSampleCase() {
        int[] given = {3, 2, 1};
        int[] result = sort(given);
        assertEquals(3, result[0]);
        assertEquals(1, result[1]);
        assertEquals(3, result[2]);
    }

    private static int[] sort(int[] given) {
        int numOfSwaps = 0;

        for(int i = 0; i < given.length; i++) {
            for(int j = 0; j < given.length - 1; j++) {
                if( given[j] > given [j + 1] ) {
                    swap(given, j, j + 1);
                    numOfSwaps += 1;
                }
            }

            if(numOfSwaps == 0) {
                break;
            }
        }

        int[] result = {numOfSwaps, given[1], given[ given.length -1 ]};

        return result;
    }

    private static void swap(int[] given, int j, int i) {
        int temp = given[j];
        given[j] = given[i];
        given[i] = temp;
    }
}
