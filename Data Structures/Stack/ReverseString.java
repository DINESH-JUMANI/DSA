package Stack;

import java.util.Stack;

public class ReverseString {

    public static StringBuilder reverse(String str){
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            ans.append(s.pop());
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "DINESH";
        System.out.println(reverse(str));
    }
}