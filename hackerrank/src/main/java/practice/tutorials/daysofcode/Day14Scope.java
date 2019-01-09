package practice.tutorials.daysofcode;

import java.util.Scanner;

public class Day14Scope {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }

    private static class Difference {
        private final int[] elements;

        public int maximumDifference;

        public Difference(int[] elements) {
            this.elements = elements;
        }

        public void computeDifference() {
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < this.elements.length -1; i++) {
                for(int j = i+1; j < this.elements.length; j++) {
                    int current = diff(elements[i], elements[j]);
                    if(current > max) {
                        max = current;
                    }
                }
            }

            this.maximumDifference = max;
        }

        private int diff(int a, int b) {
            return (a-b) > 0 ? (a-b):(a-b)*(-1);
        }
    }
}
