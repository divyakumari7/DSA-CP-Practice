package LeetCode.Daily_potd.Year26.April;

public class Day13GetMinDistance {

    public static void main(String[] args) {

        Day13GetMinDistance sol = new Day13GetMinDistance();

        // ============================
        // Test Case 1
        // ============================
        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 5, start1 = 3;
        System.out.println("Input: nums=[1,2,3,4,5], target=5, start=3");
        System.out.println("Output: " + sol.getMinDistance(nums1, target1, start1));
        System.out.println("Expected: 1\n");

        // ============================
        // Test Case 2
        // ============================
        int[] nums2 = {1};
        int target2 = 1, start2 = 0;
        System.out.println("Input: nums=[1], target=1, start=0");
        System.out.println("Output: " + sol.getMinDistance(nums2, target2, start2));
        System.out.println("Expected: 0");
    }


    /*
    ============================
    Approach: Linear Scan
    ============================

    Idea:
    - Traverse entire array
    - Whenever nums[i] == target
        → compute distance from start
    - Keep minimum distance

    TC: O(n)
    SC: O(1)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int getMinDistance(int[] nums, int target, int start) {

        int n = nums.length;
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < n ; i++){

            if(nums[i] != target) continue;

            // compute distance
            min = Math.min(min, Math.abs(i - start));
        }

        return min;
    }
}