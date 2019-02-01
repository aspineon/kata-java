package practice.tutorials.daysofcode;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class Day25Complexity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        while(N-- > 0) {
            int number = sc.nextInt();
            System.out.println(checkPrime(number));
        }

        sc.close();
    }

    private static String checkPrime(int number) {
        boolean isPrime = true;

        if(number == 1) {
            return "Not prime";
        }
        if(number%2 == 0) {
            if(number == 2) {
                isPrime = true;
            } else {
                isPrime = false;
            }
        } else {
            for(int i = 3; i < number; i += 2) {
                if(number%i == 0) {
                    System.out.println("Not Prime! => "+ i + " / " + number);
                    isPrime = false;
                    break;
                }
            }
        }

        return isPrime?"Prime":"Not prime";
    }

    @Test
    public void testPrime_Even() {
        int given = 2;
        assertThat(checkPrime(given)).isEqualTo("Prime");
    }
    @Test
    public void testPrime_MaximumEven() {
        int given = Integer.MAX_VALUE-1;
        System.out.println(given);
        assertThat(checkPrime(given)).isEqualTo("Not prime");
    }
    @Test
    public void testPrime_Odd() {
        int given = 17;
        assertThat(checkPrime(given)).isEqualTo("Prime");
    }
    @Test
    public void testPrime_PrimeSmallerThan10000() {
        int given = 1223;
        assertThat(checkPrime(given)).isEqualTo("Prime");
    }
    @Ignore
    @Test
    public void testPrime_MaximumOdd() {
        int given = Integer.MAX_VALUE;
        System.out.println(given);
        assertThat(checkPrime(given)).isEqualTo("Not prime");
    }
    @Test
    public void testcase() {
        int[] given =  {1,
                4,
                9,
                16,
                25,
                36,
                49,
                64,
                81,
                100,
                121,
                144,
                169,
                196,
                225,
                256,
                289,
                324,
                361,
                400,
                441,
                484,
                529,
                576,
                625,
                676,
                729,
                784,
                841,
                907};

        for(int i = 0; i < given.length-1; i++) {
            /*
            assertThat(checkPrime(given[i])).isEqualTo("Not prime")
                    .as("check %d is not prime", given[i])
                    .withFailMessage(String.format("%d seems to be prime", given[i]));
                    */
            assertEquals("" + given[i] +" is prime!", "Not Prime", checkPrime(given[i]));
        }
        assertThat(checkPrime(given[29])).isEqualTo("Prime");
    }
}
