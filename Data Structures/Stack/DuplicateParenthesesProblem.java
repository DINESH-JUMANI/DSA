package Stack;

import java.util.Scanner;
import java.util.Stack;

public class DuplicateParenthesesProblem {

    public static boolean isDuplicate(String str){
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if(curr!=')') st.push(curr);
            else {
                int operation = 0;
                while (st.peek()!='('){
                    operation++;
                    st.pop();
                }
                st.pop();
                if(operation==0) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = "(((a+(b)))+(c+d))";
        String str2 = "((((a)+(b))+c+d))";
        String str3 = "((a+b)+(c+d))";
        String str4 = "(((a+b))+c)";
        if(isDuplicate(str1)) System.out.println("Yes");
        if(isDuplicate(str2)) System.out.println("Yes");
        if(isDuplicate(str3)) System.out.println("Yes");
        if(isDuplicate(str4)) System.out.println("Yes");
        else System.out.println("NO");
    }
}
