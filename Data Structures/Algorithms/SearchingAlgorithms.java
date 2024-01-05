package Algorithms;

import java.util.*;
public class SearchingAlgorithms {

    public static int linearSearch(int[] arr,int key){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==key) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr,int key){
        // FOR BINARY SEARCH IT IS NECESSARY TO HAVE SORTED ARRAY
        Arrays.sort(arr);

        int start=0, end=arr.length-1;
        while (start<=end){
            int mid=start + (end-start)/2;
            if(arr[mid]==key) return mid;
            if(arr[mid]<key){
                start=mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return -1;
    }

    public static boolean staircaseSearch(int[][] mat,int key){

        // FOR THIS 2D MATRIX MUST BE SORTED ROW AND COLUMN WISE
        int row=0,col=mat[0].length-1;
        while (row<mat.length && col>=0){
            if(mat[row][col]==key) return true;
            else if (key<mat[row][col]) col--;
            else row++;
        }
        return false;
    }

    public static void main(String[] args) {
        int [] arr = {3,4,5,7,1,9,12,41,15,20};
        int key = 41;
        int [][] mat ={{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        int key2 = 33;
        System.out.println(staircaseSearch(mat,key2));
        //System.out.println(linearSearch(arr,key));
        //System.out.println(binarySearch(arr,key));
    }
}
