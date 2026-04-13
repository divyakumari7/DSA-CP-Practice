package LeetCode.Topic_wise.DynamicProgramming;

public class NinjaTraining_09 {

    public static void main(String[] args) {

        NinjaTraining_09 sol = new NinjaTraining_09();

        // ============================
        // Test Case 1
        // ============================
        int[][] mat1 = {
                {1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}
        };
        System.out.println("Input: [[1,2,5],[3,1,1],[3,3,3]]");
        System.out.println("Output: " + sol.maximumPoints(mat1));
        System.out.println("Expected: 11\n");

        // ============================
        // Test Case 2
        // ============================
        int[][] mat2 = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };
        System.out.println("Input: [[10,40,70],[20,50,80],[30,60,90]]");
        System.out.println("Output: " + sol.maximumPoints(mat2));
        System.out.println("Expected: 210");
    }


    /*
    ============================
    Approach 1: Recursion
    ============================

    Idea:
    - day → current day
    - state → last task (0,1,2) or 3 = no restriction

    TC: O(3^n)
    SC: O(n)
    */

    /*
    public int maximumPoints(int mat[][]) {
        int n = mat.length;
        return find(mat, n, 3);
    }

    public int find(int [][] mat, int day, int state){

        if(day == 0) return 0;

        int t0 = 0, t1 = 0, t2 = 0;

        if(state != 0) t0 = mat[day - 1][0] + find(mat, day - 1, 0);
        if(state != 1) t1 = mat[day - 1][1] + find(mat, day - 1, 1);
        if(state != 2) t2 = mat[day - 1][2] + find(mat, day - 1, 2);

        return Math.max(t0, Math.max(t1, t2));
    }
    */


    /*
    ============================
    Approach 2: Memoization
    ============================

    TC: O(n * 4 * 3)
    SC: O(n * 4)
    */

    /*
    static int [][] dp;

    public int maximumPoints(int mat[][]) {

        int n = mat.length;
        dp = new int[n][4];

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i], -1);
        }

        return find(mat, n, 3);
    }

    public int find(int [][] mat, int day, int state){

        if(day == 0) return 0;

        if(dp[day - 1][state] != -1) return dp[day - 1][state];

        int max = 0;

        for(int task = 0 ; task < 3 ; task++){
            if(task != state){
                max = Math.max(max,
                        mat[day - 1][task] + find(mat, day - 1, task));
            }
        }

        return dp[day - 1][state] = max;
    }
    */


    /*
    ============================
    Approach 3: Tabulation
    ============================

    TC: O(n * 4 * 3)
    SC: O(n * 4)
    */

    /*
    public int maximumPoints(int mat[][]) {

        int n = mat.length;
        int[][] dp = new int[n][4];

        // Base case (day 0)
        dp[0][0] = Math.max(mat[0][1], mat[0][2]);
        dp[0][1] = Math.max(mat[0][0], mat[0][2]);
        dp[0][2] = Math.max(mat[0][0], mat[0][1]);
        dp[0][3] = Math.max(mat[0][0], Math.max(mat[0][1], mat[0][2]));

        for(int day = 1 ; day < n ; day++){

            for(int state = 0 ; state <= 3 ; state++){

                for(int task = 0 ; task < 3 ; task++){

                    if(task != state){
                        dp[day][state] = Math.max(dp[day][state],
                                mat[day][task] + dp[day - 1][task]);
                    }
                }
            }
        }

        return dp[n - 1][3];
    }
    */


    /*
    ============================
    Approach 4: Space Optimized (FINAL)
    ============================

    TC: O(n * 4 * 3)
    SC: O(4)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int maximumPoints(int mat[][]) {

        int n = mat.length;

        int [] prev = new int[4];

        // Day 0 base
        prev[0] = Math.max(mat[0][1], mat[0][2]);
        prev[1] = Math.max(mat[0][0], mat[0][2]);
        prev[2] = Math.max(mat[0][0], mat[0][1]);
        prev[3] = Math.max(mat[0][0], Math.max(mat[0][1], mat[0][2]));

        for(int day = 1 ; day < n ; day++){

            int [] temp = new int[4];

            for(int state = 0 ; state <= 3 ; state++){

                for(int task = 0 ; task < 3 ; task++){

                    if(task != state){
                        temp[state] = Math.max(temp[state],
                                mat[day][task] + prev[task]);
                    }
                }
            }

            prev = temp;
        }

        return prev[3];
    }
}