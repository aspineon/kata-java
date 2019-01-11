package practice.tutorials.daysofcode;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Day16Exception {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        
        System.out.println(parseInt(S));
    }
    
    public static String parseInt(String s) {
        try {
            return String.format("%d", Integer.parseInt(s));
        } catch (Exception e) {
            return "Bad String";
        }
    }
}
