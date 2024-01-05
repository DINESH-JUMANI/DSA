package DynamicProgramming;

public class Knapsack_Unbounded {
    public static int tabulation(int [] val, int [] wt, int w){ // O(n * w)
        int n = val.length;
        int [][] dp = new int[n+1][w+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        // i = number of items || j = max weight
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < w+1; j++) {
                int value = val[i-1];
                int weight = wt[i-1];
                if(weight<=j){
                    int incProfit = value + dp[i][j-weight];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit,excProfit);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][w];
    }
    public static void main(String[] args) {
        int [] val = {15,14,10,45,30};
        int [] wgt = {2,5,1,3,4};
        int bagWeight = 7;
        System.out.println(tabulation(val,wgt,bagWeight));
    }
}
