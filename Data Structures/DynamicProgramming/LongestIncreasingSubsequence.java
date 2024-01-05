package DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;

public class LongestIncreasingSubsequence {
    public static int tabulation(int [] arr1){
        HashSet<Integer> hs = new HashSet<>();
        for(int temp : arr1) hs.add(temp);
        int [] arr2 = new int[hs.size()];
        int idx=0;
        for(int temp : hs) arr2[idx++] = temp;
        Arrays.sort(arr2);
        // LCS
        int n = arr1.length;
        int m = arr2.length;
        int [][] dp = new int[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(arr1[i-1]==arr2[j-1]) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        int [] arr = {50,3,10,7,40,80};
        System.out.println(tabulation(arr));
    }
}
