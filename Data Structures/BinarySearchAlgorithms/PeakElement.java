package BinarySearchAlgorithms;

public class PeakElement {
    public static int BinarySearch(int [] arr){
        int start = 0;
        int end = arr.length-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if(mid>0 && mid< arr.length-1){
                if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]) return arr[mid];
                else if(arr[mid]>arr[mid+1]) end = mid-1;
                else start=mid+1;
            }
            else if(mid==0) {
                return Math.max(arr[mid], arr[mid + 1]);
            }
            else if(mid== arr.length-1){
                return Math.max(arr[mid], arr[mid - 1]);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {1,5,6,7,8,9,9,10};
        System.out.println(BinarySearch(arr));
    }
}
