package practice.tutorials.daysofcode;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class Day3IntroToConditionalStatements {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String WEIRD = "Weird";
    public static final String NOT_WEIRD = "Not Weird";

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println(solve(N));
        scanner.close();
    }

    @Test
    public void whenNIsOdd_thenPrintWeird() {
        int input = 3;
        assertEquals("Weird", solve(input));
    }

    @Test
    public void whenNIsEvenAndInclusive2to5_thenPrintNotWeird() {
        int input = 2;
        assertEquals("Not Weird", solve(input));
    }
    @Test
    public void whenNIsEvenAndInclusive6to20_thenPrintWeird() {
        int input = 2;
        assertEquals("Not Weird", solve(input));
    }
    @Test
    public void whenNIsEvenAndGreaterThan20_thenPrintNotWeird() {
        int input = 2;
        assertEquals("Not Weird", solve(input));
    }

    private static String solve(int input) {
        if(input%2 == 0) {
            if(input >= 2 && input <= 5) {
                return NOT_WEIRD;
            } else if(input >= 6 && input <= 20) {
                return WEIRD;
            } else {
                return NOT_WEIRD;

            }
        } else {
            return WEIRD;
        }
    }
}
