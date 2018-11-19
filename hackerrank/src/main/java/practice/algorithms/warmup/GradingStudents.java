package practice.algorithms.warmup;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GradingStudents {

    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades) {
        int[] actual = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            actual[i] = (5-grades[i]%5) < 3 ? (grades[i] >= 38 ? (grades[i] + (5-grades[i]%5)) : grades[i]): grades[i];
        }


        return actual;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }

    @Test
    public void whenBasicTestCaseIsGiven_solutionWillReturnRightAnswer() {
        int[] given = {73, 67, 38, 33};
        int[] expected = {75, 67, 40, 33};

        org.junit.Assert.assertArrayEquals(expected, gradingStudents(given));
    }

    @Test
    public void whenAnotherTestCaseIsGiven_solutionWillReturnRightAnswer() {
        int[] given = {52, 67, 40, 33};
        int[] expected = {52, 67, 40, 33};

        org.junit.Assert.assertArrayEquals(expected, gradingStudents(given));
    }
}
