package LeetCode.Topic_wise.Stack;


import java.util.*;

class NextGreaterElement_II {

    // Approach:
    // This is a circular array version of Next Greater Element.
    //
    // Idea:
    // - Since the array is circular, elements after the last index
    //   can be found by wrapping around to the beginning.
    // - To simulate circular behavior, we push all elements once
    //   into the stack before actual processing.
    //
    // Steps:
    // 1. Push all elements of nums into the stack (right to left).
    // 2. Traverse nums again from right to left:
    //    - Pop elements smaller than or equal to current element.
    //    - If stack becomes empty → next greater element is -1.
    //    - Otherwise, top of stack is the next greater element.
    //    - Push current element back into stack.
    //
    // Monotonic Stack ensures efficient computation.

    // Time Complexity: O(N)
    //   - Each element is pushed and popped at most once
    //
    // Space Complexity: O(N)
    //   - Stack storage

    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        Stack<Integer> stk = new Stack<>();

        // Push all elements to simulate circular array
        for (int i = n - 1; i >= 0; i--) {
            stk.push(nums[i]);
        }

        // Process elements from right to left
        for (int i = n - 1; i >= 0; i--) {

            while (!stk.isEmpty() && stk.peek() <= nums[i]) {
                stk.pop();
            }

            if (stk.isEmpty()) {
                stk.push(nums[i]);
                nums[i] = -1;
            } else {
                int curr = nums[i];
                nums[i] = stk.peek();
                stk.push(curr);
            }
        }

        return nums;
    }
}
