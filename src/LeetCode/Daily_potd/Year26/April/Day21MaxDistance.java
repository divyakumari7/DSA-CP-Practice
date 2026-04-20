package LeetCode.Daily_potd.Year26.April;

import java.util.*;

public class Day21MaxDistance {

    public static void main(String[] args) {

        Day21MaxDistance sol = new Day21MaxDistance();

        // ============================
        // Test Case 1
        // ============================
        int[] colors1 = {1, 1, 1, 6, 1, 1, 1};
        System.out.println("Input: [1,1,1,6,1,1,1]");
        System.out.println("Output: " + sol.maxDistance(colors1));
        System.out.println("Expected: 3\n");

        // ============================
        // Test Case 2
        // ============================
        int[] colors2 = {1, 8, 3, 8, 3};
        System.out.println("Input: [1,8,3,8,3]");
        System.out.println("Output: " + sol.maxDistance(colors2));
        System.out.println("Expected: 4");
    }


    /*
    ============================
    Approach: Two Pointer
    ============================

    Idea:
    - We want maximum |i - j| such that:
        colors[i] != colors[j]

    - Since we want maximum distance:
        → check from both ends

    Step 1:
    - Fix left = 0
    - Move right from end until different found

    Step 2:
    - Fix right = n-1
    - Move left from start until different found

    - Take maximum of both

    TC: O(n)
    SC: O(1)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int maxDistance(int[] colors) {

        int n = colors.length;

        int a = 0, b = n - 1;
        int x = 0, y = n - 1;

        int max = 0;

        // Case 1: Fix left, move right
        while(a < b){

            if(colors[a] != colors[b]){
                max = Math.max(max, Math.abs(a - b));
                break;
            }
            else{
                a++;
            }
        }

        // Case 2: Fix right, move left
        while(x < y){

            if(colors[x] != colors[y]){
                max = Math.max(max, Math.abs(x - y));
                break;
            }
            else{
                y--;
            }
        }

        return max;
    }
}