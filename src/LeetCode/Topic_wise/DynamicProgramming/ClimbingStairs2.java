package LeetCode.Topic_wise.DynamicProgramming;

public class ClimbingStairs2 {

    public static void main(String[] args) {

        ClimbingStairs2 sol = new ClimbingStairs2();

        // ============================
        // Test Case 1
        // ============================
        int[] cost1 = {1, 2, 3, 4, 5};
        int n1 = cost1.length;
        System.out.println("Input: n = " + n1 + ", cost = [1,2,3,4,5]");
        System.out.println("Output: " + sol.climbStairs(n1, cost1));
        System.out.println("Expected: (depends on path)\n");

        // ============================
        // Test Case 2
        // ============================
        int[] cost2 = {10, 15, 20};
        int n2 = cost2.length;
        System.out.println("Input: n = " + n2 + ", cost = [10,15,20]");
        System.out.println("Output: " + sol.climbStairs(n2, cost2));
        System.out.println("Expected: (minimum cost path)");
    }


    /*
    ============================
    Approach 1: Recursion (Brute Force)
    ============================
    TC: Exponential (≈ O(3^n))
    SC: O(n)

    public int climbStairs(int n, int[] cost) {
        return find(n, cost);
    }

    public int find(int n, int[] cost){
        if(n == 0) return 0;

        int left = find(n - 1, cost) + cost[n - 1] + 1;

        int right = Integer.MAX_VALUE;
        int next = Integer.MAX_VALUE;

        if(n > 1) right = find(n - 2, cost) + cost[n - 1] + 4;
        if(n > 2) next = find(n - 3, cost) + cost[n - 1] + 9;

        return Math.min(left, Math.min(right, next));
    }
    */


    /*
    ============================
    Approach 2: Memoization (Top-Down DP)
    ============================
    TC: O(n)
    SC: O(n) + recursion stack

    int[] dp;

    public int climbStairs(int n, int[] cost) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return find(n, cost);
    }

    public int find(int n, int[] cost){
        if(n == 0) return 0;

        if(dp[n] != -1) return dp[n];

        int left = find(n - 1, cost) + cost[n - 1] + 1;

        int right = Integer.MAX_VALUE;
        int next = Integer.MAX_VALUE;

        if(n > 1) right = find(n - 2, cost) + cost[n - 1] + 4;
        if(n > 2) next = find(n - 3, cost) + cost[n - 1] + 9;

        dp[n] = Math.min(left, Math.min(right, next));
        return dp[n];
    }
    */


    /*
    ============================
    Approach 3: Tabulation (Bottom-Up DP)
    ============================
    TC: O(n)
    SC: O(n)

    public int climbStairs(int n, int[] cost) {
        int[] dp = new int[n + 1];

        dp[0] = 0;

        for(int i = 1; i <= n; i++){

            int left = dp[i - 1] + cost[i - 1] + 1;

            int right = Integer.MAX_VALUE;
            int next = Integer.MAX_VALUE;

            if(i > 1) right = dp[i - 2] + cost[i - 1] + 4;
            if(i > 2) next = dp[i - 3] + cost[i - 1] + 9;

            dp[i] = Math.min(left, Math.min(right, next));
        }

        return dp[n];
    }
    */


    /*
    ============================
    Approach 4: Space Optimized (Advanced)
    ============================
    TC: O(n)
    SC: O(1)

    Idea:
    Only last 3 states needed
    */

    public int climbStairs(int n, int[] cost) {
        if(n == 0) return 0;

        int prev3 = 0; // dp[i-3]
        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for(int i = 1; i <= n; i++){

            int left = prev1 + cost[i - 1] + 1;

            int right = Integer.MAX_VALUE;
            int next = Integer.MAX_VALUE;

            if(i > 1) right = prev2 + cost[i - 1] + 4;
            if(i > 2) next = prev3 + cost[i - 1] + 9;

            int curr = Math.min(left, Math.min(right, next));

            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}