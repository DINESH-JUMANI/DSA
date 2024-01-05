package Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NonRepeatingLetters {


    public static void printNonRepeatingCharacters(String str){
        HashMap<Character,Integer> frequency = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            q.add(curr);
            if(frequency.containsKey(curr)) frequency.put(curr, frequency.get(curr)+1);
            else frequency.put(curr,1);
            while (!q.isEmpty()){
                if(frequency.get(q.peek())<2){
                    System.out.println(q.peek());
                    break;
                }
                else q.remove();
            }
            if(q.isEmpty()) System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        String str = "abcdabcdx";
        printNonRepeatingCharacters(str);
    }
}
