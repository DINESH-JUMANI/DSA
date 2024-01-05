package DynamicProgramming;

public class CountingBST {
    public static int tabulation(int n){
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <=n; i++) {
            for (int j = 0; j <= i-1; j++) {
                int leftNodes = dp[j];
                int rightNodes = dp[i-j-1];
                dp[i] += leftNodes*rightNodes;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int nodes = 4;
        System.out.println(tabulation(nodes));
    }
}
