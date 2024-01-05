package DynamicProgramming;

public class LongestCommonSubsequence {
    public static int recursion(String str1, String str2,int n,int m){
        if(n==0 || m==0) return 0;
        if(str1.charAt(n-1)==str2.charAt(m-1)) return recursion(str1,str2,n-1,m-1)+1;
        else {
            int ans1 = recursion(str1,str2,n-1,m);
            int ans2 = recursion(str1, str2, n, m-1);
            return Math.max(ans1,ans2);
        }
    }

    public static int memoization(String str1, String str2,int n,int m,int [][]dp){
        if(n==0 || m==0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        if(str1.charAt(n-1)==str2.charAt(m-1)) return dp[n][m] = memoization(str1,str2,n-1,m-1,dp)+1;
        else {
            int ans1 = memoization(str1,str2,n-1,m,dp);
            int ans2 = memoization(str1, str2, n, m-1,dp);
            return dp[n][m]=Math.max(ans1,ans2);
        }
    }

    public static int tabulation(String str1, String str2){
        int [][] dp = new int[str1.length()+1][str2.length()+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[str1.length()][str2.length()];
    }
    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        System.out.println(recursion(str1,str2,str1.length(),str2.length()));
        int [][]dp = new int[str1.length()+1][str2.length()+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
        System.out.println(memoization(str1,str2, str1.length(), str2.length(),dp));
        System.out.println(tabulation(str1,str2));
    }
}
