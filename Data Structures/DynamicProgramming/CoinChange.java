package DynamicProgramming;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CoinChange {
    public static void recursion(Set<ArrayList<Integer>> result, ArrayList<Integer>temp , int[] coins, int sum, int currSum){
        if(currSum==sum){
            ArrayList<Integer> temp2 = new ArrayList<>(temp);
            Collections.sort(temp2);
            result.add(new ArrayList<>(temp2));
            return;
        }
        if(currSum>sum) return;
        for (int i = 0; i < coins.length; i++) {
            if(currSum+coins[i]<=sum) {
                currSum+=coins[i];
                temp.add(coins[i]);
                recursion(result,temp,coins,sum,currSum);
                currSum-=coins[i];
                temp.remove(temp.size()-1);
            }
        }
    }

    public static int tabulation(int [] coins, int amount){
        int n = coins.length;
        int [][]dp = new int[n+1][amount+1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < amount+1; j++) {
                if(coins[i-1]<=j) dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][amount];
    }
    public static void main(String[] args) {
        int [] coins = {5,2,3,6};
        int sum = 10;
        Set<ArrayList<Integer>>result = new HashSet<>();
        recursion(result,new ArrayList<>(),coins,sum,0);
        System.out.println(result);
        System.out.println(tabulation(coins,sum));
    }
}
