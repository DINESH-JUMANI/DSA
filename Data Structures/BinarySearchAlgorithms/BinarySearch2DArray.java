package BinarySearchAlgorithms;

public class BinarySearch2DArray {

    public static boolean BinarySearchFor2D(int [][] arr, int key){
        int row = 0;
        int column = arr[0].length-1;

        while (row< arr.length && column>=0){
            if(arr[row][column]==key) return true;
            else if(key<arr[row][column]) column--;
            else row++;
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] arr = {{10,20,30,40},
                        {11,21,31,41},
                        {12,22,32,42},
                        {13,23,33,43}};
        int key = 13;
        System.out.println(BinarySearchFor2D(arr,key));
    }
}
