package practice.tutorials.daysofcode;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Day18StacksAndQueues {

    private char[] stackData;
    private int stackCurrent;
    private char[] queueData;
    private int queueCurrent;
    private int dequeueCurrent;

    private char dequeueCharacter() {
        return this.queueData[this.dequeueCurrent++];
    }

    private void enqueueCharacter(char c) {
        initializeQueueStorage();

        if(this.queueCurrent == this.queueData.length) {
            increaseQueueStorage();
        }

        this.queueData[this.queueCurrent++] = c;
    }

    private void increaseQueueStorage() {
        char[] newArr = new char[this.queueData.length*2];

        for(int i = 0; i < this.queueData.length; i++)
            newArr[i] = this.queueData[i];

        this.queueData = newArr;
    }

    private void initializeQueueStorage() {
        if(this.queueData == null) {
            this.queueData = new char[10];
            this.dequeueCurrent = 0;
            this.queueCurrent = 0;
        }
    }

    private char popCharacter() {
        return this.stackData[--this.stackCurrent];
    }

    private void pushCharacter(char c) {
        initializeStackStorage();

        if(this.stackCurrent == this.stackData.length) {
            increaseStackStorage();
        }

        this.stackData[this.stackCurrent++] = c;
    }

    private void initializeStackStorage() {
        if(this.stackData == null) {
            this.stackData = new char[10];
            this.stackCurrent = 0;
        }
    }

    private void increaseStackStorage() {
        char[] newArr = new char[this.stackData.length*2];

        copyStackStorage(newArr);
    }

    private void copyStackStorage(char[] newArr) {
        for(int i = 0; i < this.stackData.length; i++) {
            newArr[i] = this.stackData[i];
        }

        this.stackData = newArr;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Day18StacksAndQueues p = new Day18StacksAndQueues();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is "
                + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }

    @Test
    public void testStack() {
        String given = "stack";

        Day18StacksAndQueues stack = new Day18StacksAndQueues();

        for(char c : given.toCharArray()) {
            stack.pushCharacter(c);
        }

        assertEquals('k', stack.popCharacter());
        assertEquals('c', stack.popCharacter());
        assertEquals('a', stack.popCharacter());
        assertEquals('t', stack.popCharacter());
        assertEquals('s', stack.popCharacter());
    }
    @Test
    public void testLongStack() {
        String given = "stackstackstack";

        Day18StacksAndQueues stack = new Day18StacksAndQueues();

        for(char c : given.toCharArray()) {
            stack.pushCharacter(c);
        }

        for(int i = 0; i < 3; i++) {
            assertEquals('k', stack.popCharacter());
            assertEquals('c', stack.popCharacter());
            assertEquals('a', stack.popCharacter());
            assertEquals('t', stack.popCharacter());
            assertEquals('s', stack.popCharacter());
        }
    }


    @Test
    public void testQueue() {
        String given = "queue";

        Day18StacksAndQueues queue = new Day18StacksAndQueues();

        for(char c : given.toCharArray()) {
            queue.enqueueCharacter(c);
        }

        assertEquals('q', queue.dequeueCharacter());
        assertEquals('u', queue.dequeueCharacter());
        assertEquals('e', queue.dequeueCharacter());
        assertEquals('u', queue.dequeueCharacter());
        assertEquals('e', queue.dequeueCharacter());
    }
}
