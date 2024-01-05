package BinarySearchAlgorithms;

public class SearchBitonicArray {
    public static int BinarySearchMax(int [] arr){
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

    public static int BinarySearchAsc(int [] arr, int max, int val){
        int start = 0;
        int end = max-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==val) return mid;
            else if(val>arr[mid]) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
    public static int BinarySearchDesc(int [] arr, int getMax ,int val){
        int start = getMax;
        int end = arr.length-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==val) return mid;
            else if(val<arr[mid]) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }


    public static void main(String[] args) {
        int [] arr = {1,2,3,6,8,9,7,5,4};
        int val = 4;
        int getMax = BinarySearchMax(arr);
        int asc = BinarySearchAsc(arr,getMax,val);
        int desc = BinarySearchDesc(arr,getMax,val);
        System.out.println(Math.max(asc,desc));
    }
}
