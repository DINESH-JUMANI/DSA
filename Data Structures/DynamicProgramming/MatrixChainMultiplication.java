package DynamicProgramming;

public class MatrixChainMultiplication {
    public static int recursion(int [] arr, int start, int end){
        if(start==end) return 0;
        int minCost = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            int cost1 = recursion(arr,start,i); // arr[start-1] x arr[i]
            int cost2 = recursion(arr,i+1,end); // arr[i] x arr[end]
            int cost3 = arr[start-1] * arr[i] * arr[end];
            int finalCost = cost1+cost2+cost3;
            minCost = Math.min(minCost,finalCost);
        }
        return minCost;
    }

    public static int memoization(int [] arr, int start, int end,int [][]dp){
        if(start==end) return 0;
        if(dp[start][end]!=-1) return dp[start][end];
        int minCost = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            int cost1 = memoization(arr,start,i,dp); // arr[start-1] x arr[i]
            int cost2 = memoization(arr,i+1,end,dp); // arr[i] x arr[end]
            int cost3 = arr[start-1] * arr[i] * arr[end];
            int finalCost = cost1+cost2+cost3;
            minCost = Math.min(minCost,finalCost);
        }
        return dp[start][end] = minCost;
    }

    public static int tabulation(int [] arr){
        int n = arr.length;
        int [][] dp = new int[n][n];
        // initialization
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 0;
        }
        // fill bottom up
        for (int len = 2; len <=n-1; len++) {
            for (int i = 1; i <= n-len; i++) {
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <=j-1 ; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]* arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j],cost1+cost2+cost3);
                }
            }
        }
        return dp[1][n-1];
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,3};
        System.out.println(recursion(arr,1,arr.length-1));
        int [][]dp = new int[arr.length][arr.length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(memoization(arr,1,arr.length-1,dp));
        System.out.println(tabulation(arr));
    }
}
