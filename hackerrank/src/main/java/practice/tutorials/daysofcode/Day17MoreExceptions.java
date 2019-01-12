package practice.tutorials.daysofcode;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Day17MoreExceptions {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {

            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        in.close();
    }

    private static class Calculator {

        public int power(int n, int p) throws Exception {
            if(n < 0 || p < 0) {
                throw new Exception("n and p should be non-negative");
            }
            if(p == 0) {
                return 1;
            }

            int result = 1;
            while(p-- > 0) {
                result *= n;
            }

            return result;
        }

    }

    @Test
    public void whenPIs0_thenReturn1() throws Exception {
        Calculator calc = new Calculator();
        int n = 3;
        int p = 0;

        assertEquals(1, calc.power(n, p));
    }

    @Test
    public void whenPIsGreaterThan0_thenReturnAnswer() throws Exception {
        Calculator calc = new Calculator();
        int n = 3;
        int p = 2;

        assertEquals(9, calc.power(n, p));
    }

    @Test(expected = Exception.class)
    public void whenPIsNegative_thenThrowException() throws Exception {
        Calculator calc = new Calculator();
        int n = 3;
        int p = -1;

        int wrong = calc.power(n, p);
        fail("wrong은 계산되면 안됨.");
    }

    @Test(expected = Exception.class)
    public void whenNIsNegative_thenThrowException() throws Exception {
        Calculator calc = new Calculator();
        int n = -3;
        int p = 3;

        int wrong = calc.power(n, p);
        fail("wrong은 계산되면 안됨.");
    }
    @Test(expected = Exception.class)
    public void whenPAndNIsNegative_thenThrowException() throws Exception {
        Calculator calc = new Calculator();
        int n = -3;
        int p = -1;

        int wrong = calc.power(n, p);
        fail("wrong은 계산되면 안됨.");
    }
}
