package BinarySearchAlgorithms;
// ARRAY WHICH IS INCREASING THEN DECREASING GRADUALLY IS BITONIC ARRAY
public class MaxBitonicArray {

    public static int BinarySearch(int [] arr){
        int start = 0;
        int end = arr.length-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if(mid!=0 && mid!= arr.length-1){
                if(arr[mid]>=arr[mid-1] && arr[mid]>=arr[mid+1]) return mid;
                else if(arr[mid]>arr[mid-1]) start = mid+1;
                else end = mid-1;
            }
            else if(mid==0) return mid+1;
            else return mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,7,8,9};
        System.out.println(arr[BinarySearch(arr)]);
    }
}
