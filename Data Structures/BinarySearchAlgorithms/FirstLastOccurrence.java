package BinarySearchAlgorithms;

public class FirstLastOccurrence {
    public static int BinarySearchFirstOccurrence(int [] arr,int val){
        int start = 0;
        int end = arr.length-1;
        int mid = start + (end-start)/2;
        int result = -1;
        while (start<=end){
            if(val==arr[mid]){
                result = mid;
                end = mid-1;
            }
            else if(val<arr[mid]) end= mid-1;
            else start = mid+1;
            mid = start + (end - start)/2;
        }
        return result;
    }
    public static int BinarySearchLastOccurrence(int [] arr,int val){
        int start = 0;
        int end = arr.length-1;
        int mid = start + (end-start)/2;
        int result = -1;
        while (start<=end){
            if(val==arr[mid]){
                result = mid;
                start = mid+1;
            }
            else if(val<arr[mid]) end= mid-1;
            else start = mid+1;
            mid = start + (end - start)/2;
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr = {1,1,1,2,3,3,4,4,5,5};
        System.out.println(BinarySearchFirstOccurrence(arr,5));
        System.out.println(BinarySearchLastOccurrence(arr,5));
    }
}
