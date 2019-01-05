package practice.tutorials.daysofcode;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Day10Binary {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println(maxConsecutive(n));
        scanner.close();
    }

    private static int maxConsecutive(int given) {
        String binary = Integer.toBinaryString(given);

        int max = 0;
        int current = 0;

        for(int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i) == '1') {
                current += 1;
            } else {
                current = 0;
            }
            if(current > max) {
                max = current;
            }
        }

        return max;
    }

    @Test
    public void when5IsGiven_thenReturn1() {
        int given = 5;
        assertEquals(1, maxConsecutive(given));
    }

    @Test
    public void when13IsGiven_thenReturn2() {
        int given = 13;
        assertEquals(2, maxConsecutive(given));
    }

    @Test
    public void when0IsGiven_thenReturn0() {
        int given = 0;
        assertEquals(0, maxConsecutive(given));
    }
}
