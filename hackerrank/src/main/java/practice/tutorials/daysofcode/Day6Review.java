package practice.tutorials.daysofcode;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static org.junit.Assert.assertEquals;

public class Day6Review {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());

        while (N-- > 0) {
            String input = reader.readLine();
            writer.write(String.format("%s\n", separate(input)));
        }

        writer.close();
        reader.close();
    }

    @Test
    public void testSeparate() {

        String given = "Hacker";
        String expected = "Hce akr";

        assertEquals(expected, separate(given));
    }

    @Test
    public void testSeparate2() {

        String given = "Rank";
        String expected = "Rn ak";

        assertEquals(expected, separate(given));
    }

    private static String separate(String given) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        for(int i = 0; i < given.length(); i++) {
            if(i%2 ==0 ) {
                even.append(given.charAt(i));
            } else {
                odd.append(given.charAt(i));
            }
        }

        return String.format("%s %s", even.toString(), odd.toString());
    }
}
