package LeetCode.Daily_potd.Year26.January;

class Day10MinimumASCIIDeleteSumForTwoStrings {

    // Approach:
    // We use Dynamic Programming with recursion + memoization.
    //
    // Let dp[i][j] represent the minimum ASCII delete sum
    // to make substrings s1[i..] and s2[j..] equal.
    //
    // Cases:
    // 1. If both strings are fully processed -> cost = 0
    // 2. If s1 is finished, we must delete remaining characters of s2
    // 3. If s2 is finished, we must delete remaining characters of s1
    // 4. If characters match, move both pointers forward
    // 5. If characters don't match:
    //    - Delete character from s1
    //    - OR delete character from s2
    //    - Take the minimum cost
    //
    // Memoization avoids recalculating overlapping subproblems.

    // Time Complexity: O(N * M)
    //   - Each state (i, j) is computed once
    //
    // Space Complexity: O(N * M)
    //   - DP table + recursion stack

    Integer[][] dp;

    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        dp = new Integer[n + 1][m + 1];
        return find(s1, s2, n, m, 0, 0);
    }

    private int find(String s1, String s2, int n, int m, int i, int j) {

        // If both strings are fully traversed
        if (i == n && j == m) return 0;

        // If already computed
        if (dp[i][j] != null) return dp[i][j];

        // If s1 is exhausted, delete remaining characters of s2
        if (i == n) {
            return dp[i][j] = s2.charAt(j) + find(s1, s2, n, m, i, j + 1);
        }

        // If s2 is exhausted, delete remaining characters of s1
        if (j == m) {
            return dp[i][j] = s1.charAt(i) + find(s1, s2, n, m, i + 1, j);
        }

        int a = s1.charAt(i);
        int b = s2.charAt(j);

        // If characters match, no deletion needed
        if (a == b) {
            return dp[i][j] = find(s1, s2, n, m, i + 1, j + 1);
        }

        // Option 1: delete character from s1
        int deleteFromS1 = a + find(s1, s2, n, m, i + 1, j);

        // Option 2: delete character from s2
        int deleteFromS2 = b + find(s1, s2, n, m, i, j + 1);

        return dp[i][j] = Math.min(deleteFromS1, deleteFromS2);
    }
}
