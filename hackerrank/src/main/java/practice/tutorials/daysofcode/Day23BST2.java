package practice.tutorials.daysofcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Day23BST2 {

    static void levelOrder(Node root){
        //Write your code here

    }

    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        levelOrder(root);
    }

    private Node makeNodes(int[] numbers) {
        Node root = null;

        for(int n : numbers) {
            if(root == null) {
                Node curr = new Node(n);
                root = curr;
            } else {
                insert(root, n);
            }
        }
        return root;
    }

    @Test
    public void sampleCase() {
        int[] given = {3, 2, 5, 1, 4, 7};
        Node root = makeNodes(given);
        assertThat(bst(root)).isEqualTo("3 2 5 1 4 7");
    }
    @Test
    public void sampleCase2() {
        int[] given = {3, 2, 5, 1, 4};
        Node root = makeNodes(given);
        assertThat(bst(root)).isEqualTo("3 2 5 1 4");
    }

    private String bst(Node root) {
        StringBuilder sb = new StringBuilder();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        sb.append(root.data);

        while(queue.size() > 0) {
            Node cur = queue.poll();

            if(cur.left != null) {
                queue.add(cur.left);
                sb.append(" " + cur.left.data);
            }
            if(cur.right != null) {
                queue.add(cur.right);
                sb.append(" " + cur.right.data);
            }
        }
        return sb.toString();
    }
}
