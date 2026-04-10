package LeetCode.Daily_potd.Year26.April;

import java.util.*;

public class Day10MinimumDistance {

    public static void main(String[] args) {

        Day10MinimumDistance sol = new Day10MinimumDistance();

        // ============================
        // Test Case 1
        // ============================
        int[] nums1 = {1, 2, 1, 1};
        System.out.println("Input: [1,2,1,1]");
        System.out.println("Output: " + sol.minimumDistance(nums1));
        System.out.println("Expected: 4\n");

        // ============================
        // Test Case 2
        // ============================
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Input: [1,2,3,4]");
        System.out.println("Output: " + sol.minimumDistance(nums2));
        System.out.println("Expected: -1");
    }


    /*
    ============================
    Approach 1: Brute Force (Your Code)
    ============================

    Idea:
    - Try all triplets (i, j, k)
    - Check if nums[i] == nums[j] == nums[k]
    - Compute distance

    TC: O(n^3)
    SC: O(1)
    */


    /*
    public int minimumDistance(int[] nums) {

        int n = nums.length;
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < n ; i++){

            for(int j = i + 1 ; j < n ; j++){

                if(nums[i] != nums[j]) continue;

                for(int k = j + 1 ; k < n ; k++){

                    if(nums[i] == nums[j] && nums[j] == nums[k]){

                        int a = Math.abs(i - j);
                        int b = Math.abs(k - j);
                        int c = Math.abs(i - k);

                        min = Math.min(min, a + b + c);

                        break; // important optimization
                    }
                }
            }
        }

        if(min != Integer.MAX_VALUE) return min;

        return -1;
    }
    */


    /*
    ============================
    Approach 2: Optimized (HashMap)
    ============================

    Idea:
    - Store indices of each value
    - Check consecutive triplets

    TC: O(n)
    SC: O(n)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int minimumDistance(int[] nums) {

        int n = nums.length;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int min = Integer.MAX_VALUE;

        for(List<Integer> list : map.values()){

            if(list.size() < 3) continue;

            for(int i = 0 ; i <= list.size() - 3 ; i++){

                int first = list.get(i);
                int third = list.get(i + 2);

                min = Math.min(min, 2 * (third - first));
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}