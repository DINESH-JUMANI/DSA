package BinarySearchAlgorithms;

public class NearlySortedArray {

    public static int BinarySearch(int [] arr,int val){
        int start = 0;
        int end = arr.length-1;
        int mid = start + (end-start)/2;
        while (start<=end){
            if(val==arr[mid]) return mid;
            else if(mid-1>=start && val==arr[mid-1]) return mid-1;
            else if(mid+1<=end && val==arr[mid+1]) return mid+1;
            else if(val<arr[mid]) end=mid-2;
            else start = mid+2;
            mid = start + (end - start)/2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {1,4,6,8,10,33,56,99};
        System.out.println(BinarySearch(arr,99));
    }
}
