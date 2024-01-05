package Array;

import java.util.Arrays;

public class ArrayOperations {

    public static int[] sort(int[]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }

    public static int[] sortRev(int[]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]<arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }

    public static void printArray(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }

    public static void printArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }

    public static void printArray(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }
    public static void printArray(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }

    public static void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(" "+arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(" "+arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printArray(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(" "+arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int max(int []arr){
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(maxElement<arr[i]){
                maxElement=arr[i];
            }
        }
        return maxElement;
    }

    public static int min(int []arr){
        int maxElement = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(maxElement>arr[i]){
                maxElement=arr[i];
            }
        }
        return maxElement;
    }

    public static String[][] subArray(String[] arr){
        int n = (arr.length)*(arr.length+1)/2;
        String[][]subArray = new String[n][];
        int k=0;
        for (int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length ; j++) {
                subArray[k]= Arrays.copyOfRange(arr,i,j+1);
                k++;
            }
        }
        return subArray;
    }

    public static int[][] subArray(int[] arr){
        int n = (arr.length)*(arr.length+1)/2;
        int[][]subArray = new int[n][];
        int k=0;
        for (int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length ; j++) {
                subArray[k]= Arrays.copyOfRange(arr,i,j+1);
                k++;
            }
        }
        return subArray;
    }

    public static char[][] subArray(char[] arr){
        int n = (arr.length)*(arr.length+1)/2;
        char[][]subArray = new char[n][];
        int k=0;
        for (int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length ; j++) {
                subArray[k]= Arrays.copyOfRange(arr,i,j+1);
                k++;
            }
        }
        return subArray;
    }

}
