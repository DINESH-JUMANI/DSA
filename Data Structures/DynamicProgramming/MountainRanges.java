package DynamicProgramming;

public class MountainRanges {
    public static int tabulation(int pairs){
        int [] dp = new int[pairs+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= pairs; i++) {
            for (int j = 0; j <=i-1; j++) {
                int innerPair = dp[j];
                int outerPair = dp[i-j-1];
                dp[i]+=innerPair*outerPair;
            }
        }
        return dp[pairs];
    }
    public static void main(String[] args) {
        int pairs = 4;
        System.out.println(tabulation(pairs));
    }
}
