package Stack;

import java.util.Stack;

public class StockSpanProblem {


    public static void stockSpan(int [] stocks, int [] span){
        Stack<Integer> st = new Stack<>();
        st.push(0);
        span[0]=1;
        for (int i = 1; i < stocks.length ; i++) {
            while (!st.isEmpty() && stocks[i]> stocks[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) span[i]=i+1;
            else span[i]=i-st.peek();
            st.push(i);
        }
        for(int temp : span) System.out.println(temp);
    }

    public static void main(String[] args) {
        int [] stocks = {100,80,60,70,60,85,100};
        int [] span = new int[stocks.length];
        stockSpan(stocks,span);
    }
}
