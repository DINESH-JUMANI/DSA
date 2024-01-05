package BackTracking;

import java.util.Scanner;

public class GridWays_Backtracking {

    public static int countWays(int i, int j, int m, int n){
        // base case
        if(i==n-1 || j==m-1) return 1;
        else if (i==n || j==m) return 0;

        // recursive step
        int w1 = countWays(i,j+1,m,n);
        int w2 = countWays(i+1,j,m,n);
        return w1+w2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(countWays(0,0,m,n));
    }
}
