package Heaps;

import java.util.ArrayList;

public class HeapOperations {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){ // O(logn)
            arr.add(data);
            int childIndex = arr.size()-1;
            int parentIndex = (childIndex-1)/2;
            while (arr.get(childIndex)<arr.get(parentIndex)){
                int temp = arr.get(childIndex);
                arr.set(childIndex,arr.get(parentIndex));
                arr.set(parentIndex,temp);
                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        private void heapify(int parentIdx){ // O(logn)
            int leftChildIndex = 2*parentIdx + 1;
            int rightChildIndex = leftChildIndex+1;

            int minIndex = parentIdx;

            if(leftChildIndex< arr.size() && arr.get(minIndex)>arr.get(leftChildIndex)) minIndex = leftChildIndex;
            if(rightChildIndex< arr.size() && arr.get(minIndex)>arr.get(rightChildIndex)) minIndex = rightChildIndex;
            if(minIndex!=parentIdx){
                int temp = arr.get(parentIdx);
                arr.set(parentIdx,arr.get(minIndex));
                arr.set(minIndex,temp);
                heapify(minIndex);
            }
        }

        public boolean isEmpty(){
            return arr.size()==0;
        }

        public int remove(){ // O(logn)
            int data = arr.get(0);

            // SWAP first and last
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            // Remove last
            arr.remove(arr.size()-1);

            // Heapify
            heapify(0);
            return data;
        }
    }

    public static void main(String[] args) {

        Heap h = new Heap();
        h.add(3);
        h.add(1);
        h.add(4);
        h.add(2);
        while (!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }


    }
}
