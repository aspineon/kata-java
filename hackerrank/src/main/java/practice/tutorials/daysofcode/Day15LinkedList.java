package practice.tutorials.daysofcode;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Day15LinkedList {

    public static  Node insert(Node head,int data) {

        if(head == null) {
            head = new Node(data);
            return head;
        }

        Node ret = head;
        Node next = new Node(data);
        while(head != null) {
            if(head.next == null) {
                head.next = next;
                break;
            }
            head = head.next;
        }

        return ret;
    }

    public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }

    @Test
    public void whenOneelementIsGiven_thenOnlyOneNodeIsReturned() {
        System.out.println("-");
        int only = 2;

        Node actual = null;
        actual = insert(actual, only);

        assertEquals(only, actual.data);
        assertTrue(actual.next == null);
    }

    @Test
    public void whenTwoElementsAreGiven_thenListHasTwoNodes() {
        System.out.println("-");
        int[] data = {1, 2};

        Node actual = null;
        actual = insert(actual, data[0]);
        actual = insert(actual, data[1]);

        assertEquals(data[0], actual.data);
        actual = actual.next;
        assertEquals(data[1], actual.data);
    }

    @Test
    public void whenSampleCaseIsGiven_thenReturnAnswer() {
        int[] given = {2, 3, 4, 1};

        Node head = null;

        for(int i : given) {
            head = insert(head, i);
        }

        if(head == null || head.next == null) {
            fail("글러먹었다.");
        }

        int index = 0;
        while(head != null) {
            assertEquals(given[index++], head.data);
            head = head.next;
        }
    }

}

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}