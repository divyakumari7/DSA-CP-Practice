package LeetCode.Daily_potd.Year26.June;

import java.util.Arrays;

public class Day21MaxIceCreamBars {

    public static void main(String[] args) {

        Day21MaxIceCreamBars sol =
                new Day21MaxIceCreamBars();

        // ============================
        // Test Case 1
        // ============================
        int[] costs1 = {1, 3, 2, 4, 1};
        int coins1 = 7;

        System.out.println("Input: [1,3,2,4,1], coins = 7");
        System.out.println("Output: " + sol.maxIceCream(costs1, coins1));
        System.out.println("Expected: 4\n");

        // ============================
        // Test Case 2
        // ============================
        int[] costs2 = {10, 6, 8, 7, 7, 8};
        int coins2 = 5;

        System.out.println("Input: [10,6,8,7,7,8], coins = 5");
        System.out.println("Output: " + sol.maxIceCream(costs2, coins2));
        System.out.println("Expected: 0");
    }

    /*
    ============================
    POTD 21 June
    Maximum Ice Cream Bars
    ============================

    Problem:
    - You are given an array costs[]
    - costs[i] = price of i-th ice cream
    - You are given coins
    - You can buy ice creams until coins run out

    Task:
    Return maximum number of ice creams you can buy.
    */


    /*
    ============================
    Approach 1: Greedy + Sorting
    ============================

    Idea:

    - To maximize count, always buy cheapest ice cream first
    - Sort the array
    - Keep buying until coins are sufficient

    Why Greedy works:
    - Smaller cost items preserve coins for more purchases

    TC: O(n log n)
    SC: O(1) (ignoring sort space)
    */

    public int maxIceCream(int[] costs, int coins) {

        Arrays.sort(costs);

        int count = 0;

        for (int cost : costs) {

            if (cost <= coins) {
                coins -= cost;
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}


/*
============================
Dry Run
============================

Input:
costs = [1, 3, 2, 4, 1]
coins = 7

Step 1: Sort
[1, 1, 2, 3, 4]

Step 2:

coins = 7

Take 1  → coins = 6 → count = 1
Take 1  → coins = 5 → count = 2
Take 2  → coins = 3 → count = 3
Take 3  → coins = 0 → count = 4
Stop (cannot take 4)

Answer = 4


============================
Complexities
============================

Time Complexity:
O(n log n) → sorting

Space Complexity:
O(1) → in-place sorting


============================
Pattern Used
============================

1. Greedy Algorithm
2. Sorting
3. Prefix choice optimization idea

Best Approach:
Sort + Greedy pick cheapest first
*/