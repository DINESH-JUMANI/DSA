package DynamicProgramming;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class RodCutting {

    public static void recursion(int [] prices, int length, int sum, int currLen, TreeSet<Integer> result){
        if(currLen==length){
            result.add(sum);
            return;
        }
        for (int i = 1; i <=length ;i++) {
            if(currLen<length){
                currLen+=i;
                sum+=prices[i-1];
                recursion(prices, length, sum, currLen, result);
                currLen-=i;
                sum-=prices[i-1];
            }
        }
    }

    public static int tabulation(int [] price,int length){
        int n = price.length;
        int [][] dp = new int[n+1][length+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < length+1; j++) {
                if(i==0 || j==0) dp[i][j]=0;
            }
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < length+1; j++) {
                if(i<=j) dp[i][j] = Math.max(price[i-1]+ dp[i][j-i],dp[i-1][j]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][length];
    }

    public static void main(String[] args) {
        int [] price = {1,5,8,9,10,17,17,20};
        int length = 8;
        TreeSet<Integer> ans = new TreeSet<>();
        recursion(price,length,0,0,ans);
        System.out.println(ans);
        System.out.println(tabulation(price,length));
    }
}
