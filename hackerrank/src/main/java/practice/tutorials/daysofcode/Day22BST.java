package practice.tutorials.daysofcode;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Day22BST {


    public static int getHeight(Node root){
        if( (root == null) || (root.left == null && root.right == null) ) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
    }

    public static Node insert(Node root, int data){
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
        int height=getHeight(root);
        System.out.println(height);
    }

    public Node getSample(int[] given) {
        Node root = null;

        for(int i : given) {
            Node n = new Node(i);
            if(root == null) {
                root = n;
            } else {
                root = insert(root, i);
            }
        }

        return root;
    }

    @Test
    public void sampleCase() {
        int[] given = {3, 5, 2, 1, 4, 6, 7};
        assertEquals(3, getHeight(getSample(given)));
    }

    @Test
    public void sampleCase2() {
        int[] given = {3, 5, 2, 1, 4, 6};
        assertEquals(2, getHeight(getSample(given)));
    }

    @Test
    public void sampleCase_emptyElement() {
        int[] given = {6};
        assertEquals(0, getHeight(getSample(given)));
    }
}

class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
