package BinarySearchAlgorithms;

public class CeilingOfElement {
    public static int BinarySearch(int [] arr,int val){
        int start = 0;
        int end = arr.length-1;
        int mid = start + (end-start)/2;
        int result = arr[0];
        while (start<=end){
            if(val==arr[mid]) return val;
            else if(val<arr[mid]){
                end=mid-1;
                result = arr[mid];
            }
            else start = mid + 1;
            mid = start + (end - start)/2;
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr = {1,4,6,8,10,33,56,99};
        System.out.println(BinarySearch(arr,12));
    }
}
