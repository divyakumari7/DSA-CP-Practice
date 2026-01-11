package LeetCode.Topic_wise.Stack;

import java.util.*;

class NextGreaterElement_I {

    // Approach:
    // We use a Monotonic Decreasing Stack to find the Next Greater Element.
    //
    // Idea:
    // - Traverse nums2 from right to left
    // - Maintain a stack that keeps elements in decreasing order
    // - For each element:
    //     - Pop all elements smaller than or equal to it
    //     - The top of the stack (if any) is the next greater element
    //     - If stack is empty, next greater element is -1
    // - Store results in a HashMap for quick lookup
    // - Finally, update nums1 using the precomputed values
    //
    // This avoids repeated scanning and gives an efficient solution.

    // Time Complexity: O(N + M)
    //   - nums2 is traversed once
    //   - nums1 is traversed once
    //
    // Space Complexity: O(M)
    //   - Stack + HashMap storage

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        Stack<Integer> stk = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Process nums2 from right to left
        for (int i = m - 1; i >= 0; i--) {

            // Remove elements smaller than or equal to current
            while (!stk.isEmpty() && stk.peek() <= nums2[i]) {
                stk.pop();
            }

            // Store next greater element
            if (stk.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stk.peek());
            }

            // Push current element onto stack
            stk.push(nums2[i]);
        }

        // Build result for nums1
        for (int i = 0; i < n; i++) {
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;
    }
}
