package Stack;

import java.util.Stack;

public class NextGreaterElement {

    public static void findGreaterElement(int [] arr, int [] solution){
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length-1; i >=0; i--) {
            while (!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()) solution[i]=-1;
            else solution[i]=st.peek();
            st.push(arr[i]);
        }
        for(int temp : solution) System.out.println(temp);
    }

    public static void main(String[] args) {
        int [] arr = {6,8,0,1,3};
        int [] solution = new int[arr.length];
        findGreaterElement(arr,solution);
    }
}
