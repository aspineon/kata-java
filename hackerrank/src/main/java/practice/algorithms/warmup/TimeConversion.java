package practice.algorithms.warmup;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {

        final String ampm = s.substring(s.length()-2);
        int hh = Integer.parseInt(s.substring(0, 2));
        final int mm = Integer.parseInt(s.substring(3, 5));
        final int ss = Integer.parseInt(s.substring(6, 8));

        if("PM".equals(ampm)) {
            if(hh != 12) {
                hh += 12;
            }
        } else if(hh == 12) {
            hh = 0;
        }
        return String.format("%02d:%02d:%02d", hh, mm, ss);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }

    @Test
    public void whenBasicTestCaseIsGiven_SolutionWillReturnRightAnswer() {
        // GIVEN
        final String given = "07:05:45PM";
        final String expected = "19:05:45";

        assertEquals(expected, timeConversion(given));
    }

    @Test
    public void whenAmTestCaseIsGiven_SolutionWillReturnRightAnswer() {
        // GIVEN
        final String given = "06:05:45AM";
        final String expected = "06:05:45";

        assertEquals(expected, timeConversion(given));
    }

    @Test
    public void whenAM12hTestCaseIsGiven_SolutionWillReturnRightAnswer() {
        // GIVEN
        final String given = "12:05:45AM";
        final String expected = "00:05:45";

        assertEquals(expected, timeConversion(given));
    }

    @Test
    public void whenPM12hTestCaseIsGiven_SolutionWillReturnRightAnswer() {
        // GIVEN
        final String given = "12:05:45PM";
        final String expected = "12:05:45";

        assertEquals(expected, timeConversion(given));
    }

    @Test
    public void test_padding_0_string_format() {
        int hh = 1;
        int mm = 2;
        int ss = 3;

        final String expected = "01:02:03";

        assertEquals(expected, String.format("%02d:%02d:%02d", hh, mm, ss));
    }

}
