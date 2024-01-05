package Stack;

import java.util.*;

public class ValidParenthesesProblem {

    public static boolean isValid(String str){
        Stack<Character> st = new Stack<>();
        HashMap<Character,Integer> open = new HashMap<>();
        open.put('(',1);
        open.put('[',2);
        open.put('{',3);
        HashMap<Character,Integer> close = new HashMap<>();
        close.put(')',1);
        close.put(']',2);
        close.put('}',3);
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if(open.containsKey(current)) st.push(current);
            else{
                if(st.isEmpty()) return false;
                else if(!Objects.equals(open.get(st.peek()), close.get(current))) return false;
                else st.pop();
            }
        }

        return st.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(isValid(str)) System.out.println("YES");
        else System.out.println("NO");
    }
}
