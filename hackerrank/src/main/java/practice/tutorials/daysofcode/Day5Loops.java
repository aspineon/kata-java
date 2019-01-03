package practice.tutorials.daysofcode;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Day5Loops {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        gugudan(n);

        scanner.close();
    }

    private static void gugudan(int n) {
        for(int i = 1; i <= 10; i++) {
            System.out.println(String.format("%d x %d = %d", n, i, mul(n, i)));
        }
    }

    @Test
    public void when2Multiply1_thenReturn2() {
        int n = 2;
        int i = 1;
        assertEquals(2, mul(n,i));
    }

    @Test
    public void when2Multiply2_thenReturn4() {
        int n = 2;
        int i = 2;
        assertEquals(4, mul(n,i));
    }

    private static int mul(int n, int i) {
        return n * i;
    }
}
