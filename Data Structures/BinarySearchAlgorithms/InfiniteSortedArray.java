package BinarySearchAlgorithms;

public class InfiniteSortedArray {
    public static int BinarySearch(int [] arr , int val){
        int start = 0;
        int end = 1;
        // TO FIND END
        while (val>arr[end]){
            start=end;
            end*=2;
        }
        // NORMAL BINARY SEARCH
        int mid = start + (end-start)/2;
        while (start<=end){
            if(val==arr[mid]) return mid;
            else if(val<arr[mid]) end=mid-1;
            else start = mid+1;
            mid = start + (end - start)/2;
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        System.out.println(BinarySearch(arr,8));
    }
}
