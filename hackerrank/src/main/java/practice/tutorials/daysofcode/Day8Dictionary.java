package practice.tutorials.daysofcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day8Dictionary {
    public static void main(String []argh){
        Map<String, Integer> phonebook = new HashMap<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            phonebook.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            if(phonebook.containsKey(s)) {
                System.out.println(String.format("%s=%d", s, phonebook.get(s)));
            } else {
                System.out.println("Not found");
            }
        }
        in.close();
    }
}
