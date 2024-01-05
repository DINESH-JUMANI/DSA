package DynamicProgramming;

public class LongestCommonSubstring { // O(st1.length * str.length)
    public static int tabulation(String str1,String str2){
        int [][]dp = new int[str1.length()+1][str2.length()+1];
        int lenMax = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(str1.charAt(i-1)== str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    lenMax = Math.max(lenMax,dp[i][j]);
                }
                else dp[i][j] = 0;
            }
        }
        return lenMax;
    }
    public static void main(String[] args) {
        String str1 = "abcdgh";
        String str2 = "acdghr";
        System.out.println(tabulation(str1,str2));

    }
}
