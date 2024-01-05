package Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int top = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;
        int left = 0;
        List<Integer> result = new ArrayList<>();
        ArrayList<String> check = new ArrayList<>();
        while (check.size()!=(matrix.length*matrix[0].length)){
            // TOP
            for (int i = 0; i < colLength; i++) {
                String temp = String.valueOf(top) + i;
                if(!check.contains(temp)) {
                    result.add(matrix[top][i]);
                    check.add(temp);
                }
            }
            top++;
            // RIGHT
            for (int i = 0; i < rowLength; i++) {
                String temp = String.valueOf(i) + right;
                if(!check.contains(temp)){
                    result.add(matrix[i][right]);
                    check.add(temp);
                }
            }
            right--;
            // BOTTOM
            for (int i =colLength-1 ; i >=0 ; i--) {
                String temp = String.valueOf(bottom) + i;
                if(!check.contains(temp)){
                    result.add(matrix[bottom][i]);
                    check.add(temp);
                }
            }
            bottom--;
            // LEFT
            for (int i = rowLength-1; i >= 0 ; i--) {
                String temp = String.valueOf(i) + left;
                if(!check.contains(temp)){
                    result.add(matrix[i][left]);
                    check.add(temp);
                }
            }
            left++;
        }
        System.out.println(result);
    }
}
