package DynamicProgramming;

public class FibonacciSeries {
    // Memoization method to implement DP
    public static int getFibRec(int n,int [] f){
        if(n==0 || n==1) return n;
        if(f[n]!=0) return f[n];
        return getFibRec(n-1,f) + getFibRec(n-2,f);
    }

    // Tabulation approach to implement DP
    public static int getFibTabulation(int n){
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <=n; i++) {
            dp[i] =dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        int [] fib = new int[n+1];
        System.out.println(getFibRec(n,fib));
        System.out.println(getFibTabulation(n));
    }
}
