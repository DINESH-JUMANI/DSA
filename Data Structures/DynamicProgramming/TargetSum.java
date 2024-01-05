package DynamicProgramming;

public class TargetSum {

    public static boolean tabulation(int [] nums, int targetSum){ //O(n * sum)
        int n = nums.length;
        boolean [][] dp = new boolean[n+1][targetSum+1];
        // initialization
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        // i = items, j = targetSum
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < targetSum+1; j++) {
                int val = nums[i-1];
                if(val<=j && dp[i-1][j-val]) dp[i][j] = true;
                else if(dp[i-1][j]) dp[i][j] = true;
            }
        }
        return dp[n][targetSum];
    }
    public static void main(String[] args) {
        int [] nums = {2,4,7,1,3};
        int targetSum = 10;
        System.out.println(tabulation(nums,targetSum));
    }
}
