package DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs {

    public static int recursion(int n){
        if(n==0) return 1;
        if(n<0) return 0;
        return recursion(n-1) + recursion(n-2);
    }

    public static int memoization(int n,int [] temp){
        if(n==0) return 1;
        if(n<0) return 0;
        if(temp[n]!=-1) return temp[n];
        return temp[n] = memoization(n-1,temp) + memoization(n-2,temp);
    }

    public static int tabulation(int n){
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int [] temp = new int[n+1];
        Arrays.fill(temp,-1);
        System.out.println(recursion(n));
        System.out.println(memoization(n,temp));
        System.out.println(tabulation(n));
    }
}
