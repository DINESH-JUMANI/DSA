package DynamicProgramming;



public class Knapsack_01 {
    public static int recursion(int [] val,int [] wgt,int maxWgt,int idx){
        if(idx==-1 || maxWgt==0) return 0;
        if(wgt[idx]<=maxWgt){
            int ans1 = val[idx]+recursion(val,wgt,maxWgt-wgt[idx],idx-1);
            int ans2 = recursion(val,wgt,maxWgt,idx-1);
            return Math.max(ans1,ans2);
        }
        else return recursion(val,wgt,maxWgt,idx-1);
    }

    public static int memoization(int [] val,int [] wgt,int maxWgt,int idx,int [][] dp){ // O(n * maxWeight)
        if(idx==-1 || maxWgt==0) return 0;
        if(dp[idx+1][maxWgt]!=-1) return dp[idx+1][maxWgt];
        if(wgt[idx]<=maxWgt){
            int ans1 = val[idx]+memoization(val,wgt,maxWgt-wgt[idx],idx-1,dp);
            int ans2 = memoization(val,wgt,maxWgt,idx-1,dp);
            return dp[idx+1][maxWgt] = Math.max(ans1,ans2);
        }
        else return dp[idx+1][maxWgt] = memoization(val,wgt,maxWgt,idx-1,dp);
    }

    public static int tabulation(int [] val,int [] wgt,int w){
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
                int weight = wgt[i-1];
                if(weight<=j){
                    int incProfit = value + dp[i-1][j-weight];
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
        int [][] dp = new int[val.length+1][bagWeight+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
        System.out.println(recursion(val,wgt,bagWeight,wgt.length-1));
        System.out.println(memoization(val,wgt,bagWeight, val.length-1, dp));
        System.out.println(tabulation(val,wgt,bagWeight));
    }
}
