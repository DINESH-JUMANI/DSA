package Stack;

import java.util.Stack;

public class MaxAreaHistogram {

    public static int getMax(int [] heights){ //O(n)
        int maxArea = 0;
        int [] nextSmallRight = new int[heights.length];
        int [] nextSmallLeft = new int[heights.length];

        // FOR NEXT SMALLER RIGHT O(n)
        Stack<Integer> st = new Stack<>();
        for (int i = heights.length-1; i >=0 ; i--) {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()) nextSmallRight[i]=heights.length;
            else nextSmallRight[i]=st.peek();
            st.push(i);
        }

        // FOR NEXT SMALLER LEFT O(n)
        st = new Stack<>();
        for (int i = 0; i < heights.length ; i++) {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()) nextSmallLeft[i]=-1;
            else nextSmallLeft[i]=st.peek();
            st.push(i);
        }

        // AREA O(n)
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int width = nextSmallRight[i]-nextSmallLeft[i]-1;
            maxArea = Math.max(maxArea,height*width);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int [] heights = {2,1,5,6,2,3};
        System.out.println(getMax(heights));
    }
}
