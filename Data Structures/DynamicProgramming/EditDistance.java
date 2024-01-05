package DynamicProgramming;

public class EditDistance {
    public static int tabulation(String word1, String word2){
        int n = word1.length();
        int m = word2.length();
        int [][] dp = new int[n+1][m+1];
        // initialization
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i==0) dp[i][j] = j;
                if(j==0) dp[i][j] = i;
            }
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else {
                    int add = dp[i][j-1]+1;
                    int delete = dp[i-1][j]+1;
                    int replace = dp[i-1][j-1]+1;
                    dp[i][j] = Math.min(add,Math.min(delete,replace));
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(tabulation(word1,word2));
    }
}
