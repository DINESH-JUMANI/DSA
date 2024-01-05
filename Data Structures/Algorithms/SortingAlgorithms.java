package Algorithms;

import Array.ArrayOperations;

public class SortingAlgorithms {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prevPos = i - 1;
            while (prevPos >= 0 && arr[prevPos] > curr) {
                arr[prevPos + 1] = arr[prevPos];
                prevPos--;
            }
            arr[prevPos + 1] = curr;
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) minPos = j;
            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void countingSort(int[] arr) {
        // FIND LARGEST VALUE
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) largest = Math.max(largest, arr[i]);

        // TOTAL NO OF REPEATED VALUES
        int[] count = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) count[arr[i]]++;

        // VALUE INSERT
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void quickSort(int [] arr, int startingIndex, int endingIndex){
        if(startingIndex>=endingIndex) return;
        int pivotIndex = partition(arr,startingIndex,endingIndex);
        quickSort(arr,startingIndex,pivotIndex-1);
        quickSort(arr,pivotIndex+1,endingIndex);
    }

    public static int partition(int [] arr, int startingIndex, int endingIndex)  {
        int pivot = arr[endingIndex];
        int i = startingIndex-1;
        for (int j = startingIndex;j<endingIndex;j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // to put pivot to right position
        i++;
        arr[endingIndex] = arr[i];
        arr[i] = pivot;
        return i;
    }

    public static void mergeSort(int[] arr, int startingIndex, int endingIndex) {
        if (startingIndex >= endingIndex) return;
        int mid = (startingIndex + endingIndex) / 2; //(si+(ei-si)/2)
        mergeSort(arr, startingIndex, mid);  // left part
        mergeSort(arr, mid + 1, endingIndex); // right part
        merge(arr, startingIndex, mid, endingIndex); // to merge both parts
    }

    public static void merge(int[] arr, int startingIndex, int mid, int endingIndex) {
        int[] temp = new int[endingIndex - startingIndex + 1];
        int i = startingIndex; // iterator for left part
        int j = mid + 1;  // iterator for right part
        int k = 0;  // iterator for temp array

        while (i <= mid && j <= endingIndex) {
            if (arr[i] < arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        // remaining if in the left part
        while (i <= mid) temp[k++] = arr[i++];

        // remaining if in the right part
        while (j <= endingIndex) temp[k++] = arr[j++];

        // copy temp to original array
        for (k = 0, i = startingIndex; k < temp.length; k++, i++) arr[i] = temp[k];

    }

    public static void maxHeapify(int start, int end, int [] arr){
        int left = 2*start+1;
        int right = 2*start+2;
        int maxIndex = start;
        if(left< end && arr[maxIndex]<arr[left]) maxIndex = left;
        if(right< end && arr[maxIndex]<arr[right]) maxIndex = right;
        if(maxIndex!=start){
            int temp = arr[start];
            arr[start] = arr[maxIndex];
            arr[maxIndex] = temp;
            maxHeapify(maxIndex,end,arr);
        }
    }

    public static void heapSort(int [] arr){ //O(nlogn)
        int n = arr.length;
        for (int i = n/2; i >=0 ; i--) {
            maxHeapify(i,n,arr);
        }
        for (int i = n-1; i >0 ; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeapify(0,i,arr);
        }
    }

    public static void main(String[] args) {
        int [] arr = {10,9,8,7,6,5,4,3,2,1};
        //countingSort(arr);
        //bubbleSort(arr);
        //insertionSort(arr);
        //selectionSort(arr);
        //mergeSort(arr,0,arr.length-1);
        //quickSort(arr,0,arr.length-1);
        heapSort(arr);
        ArrayOperations.printArray(arr);
    }
}
