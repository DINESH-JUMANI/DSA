package AImportantProblems;

import Array.ArrayOperations;

import java.util.PriorityQueue;

public class SlidingWindowMaximum { // O(nlogk)

    static class Window implements Comparable<Window>{
        int val,index;
        public Window(int val, int idx){
            this.val = val;
            this.index = idx;
        }
        @Override
        public int compareTo(Window t2){
            return t2.val - this.val;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3; // Window size
        int [] result = new int[arr.length-k+1];
        PriorityQueue<Window> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(new Window(arr[i],i));
        }
        result[0] = pq.peek().val;
        for (int i = k; i < arr.length; i++) {
            while (pq.size()>0 && pq.peek().index<=(k-i)) pq.remove();
            pq.add(new Window(arr[i],i));
            result[i-k+1] = pq.peek().val;
        }
        ArrayOperations.printArray(result);
    }
}
