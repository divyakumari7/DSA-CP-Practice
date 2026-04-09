package LeetCode.Topic_wise.DynamicProgramming;

public class Fibonacci_01 {
    public static void main(String[] args) {

        Fibonacci_01 sol = new Fibonacci_01();

        // ============================
        // Test Case 1
        // ============================
        int n1 = 5;
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + sol.fib(n1));
        System.out.println("Expected: 5\n");

        // ============================
        // Test Case 2
        // ============================
        int n2 = 10;
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + sol.fib(n2));
        System.out.println("Expected: 55");
    }

    /*
    ============================
    Approach 1: Recursion (Brute Force)
    ============================
    TC: O(2^n)
    SC: O(n) recursion stack

    public int fib(int n) {
        if(n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
    */


    /*
    ============================
    Approach 2: Memoization (Top-Down DP)
    ============================
    TC: O(n)
    SC: O(n) + recursion stack

    int[] dp;

    public int fib(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return find(n);
    }

    public int find(int n){
        if(n <= 1) return n;

        if(dp[n] != -1) return dp[n];

        dp[n] = find(n - 1) + find(n - 2);
        return dp[n];
    }
    */


    /*
    ============================
    Approach 3: Tabulation (Bottom-Up DP)
    ============================
    TC: O(n)
    SC: O(n)

    public int fib(int n) {
        if(n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
    */


    /*
    ============================
    Approach 4: Space Optimized DP (Most Optimal)
    ============================
    TC: O(n)
    SC: O(1)
    */

    public int fib(int n) {
        if(n <= 1) return n;

        int prev2 = 0;
        int prev1 = 1;

        for(int i = 2; i <= n; i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}