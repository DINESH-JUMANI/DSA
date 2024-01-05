package DynamicProgramming;

public class MinimumPartitioning {
    public static int tabulation(int [] nums){
        int totalSum = 0;
        for(int temp : nums) totalSum+=temp;
        int n = nums.length;
        int w = totalSum/2;
        int [][] dp = new int[n+1][w+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < w+1; j++) {
                if(nums[i-1]<=j) dp[i][j] = Math.max(nums[i-1]+dp[i-1][j-nums[i-1]],dp[i-1][j]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        int sum1 = dp[n][w];
        int sum2 = totalSum - sum1;
        return Math.abs(sum1-sum2);

    }
    public static void main(String[] args) {
        int [] nums = {1,6,11,5};
        System.out.println(tabulation(nums));
    }
}
