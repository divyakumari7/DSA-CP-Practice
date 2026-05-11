package LeetCode.Daily_potd.Year26.May;

import java.util.*;

public class Day11SeparateDigits {

    public static void main(String[] args) {

        Day11SeparateDigits sol = new Day11SeparateDigits();

        // ============================
        // Test Case 1
        // ============================
        int[] nums1 = {13, 25, 83, 77};
        System.out.println("Input: [13,25,83,77]");
        System.out.println("Output: " + Arrays.toString(sol.separateDigits(nums1)));
        System.out.println("Expected: [1,3,2,5,8,3,7,7]\n");

        // ============================
        // Test Case 2
        // ============================
        int[] nums2 = {7, 1, 3, 9};
        System.out.println("Input: [7,1,3,9]");
        System.out.println("Output: " + Arrays.toString(sol.separateDigits(nums2)));
        System.out.println("Expected: [7,1,3,9]");
    }


    /*
    ============================
    Approach 1: Brute Force (Digit Extraction)
    ============================

    Idea:
    - For each number:
        → Extract digits using %10
        → Reverse to maintain order
        → Add to final list

    TC: O(total digits)
    SC: O(total digits)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int[] separateDigits(int[] nums) {

        int n = nums.length;

        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){

            int num = nums[i];

            List<Integer> temp = new ArrayList<>();

            // Extract digits (reverse order)
            while(num != 0){
                temp.add(num % 10);
                num = num / 10;
            }

            // Reverse to correct order
            Collections.reverse(temp);

            list.addAll(temp);
        }

        // Convert list to array
        int [] ans = new int[list.size()];

        for(int i = 0 ; i < list.size() ; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }


    /*
    ============================
    Approach 2: String Conversion (Cleaner)
    ============================

    Idea:
    - Convert each number to string
    - Iterate characters and convert back to int

    TC: O(total digits)
    SC: O(total digits)

    public int[] separateDigits(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for(int num : nums){
            String s = String.valueOf(num);

            for(char ch : s){
                list.add(ch - '0');
            }
        }

        int[] ans = new int[list.size()];

        for(int i = 0 ; i < list.size() ; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
    */
}