package LeetCode.Topic_wise.Stack;

import java.util.*;

class LargestRectangleInHistogram {

    // Approach 1: Monotonic Stack (Single Pass)
    //
    // Idea:
    // - We maintain a stack that stores indices of bars in increasing height order.
    // - When a bar with smaller height is encountered, it means rectangles
    //   with the popped bar as the smallest height must end here.
    //
    // Steps:
    // 1. Traverse the histogram from left to right.
    // 2. While current bar height is smaller than the height at stack top:
    //    - Pop the index
    //    - Calculate area using popped height
    // 3. Push current index into stack.
    // 4. After traversal, process remaining elements in the stack.
    //
    // This guarantees that each bar is pushed and popped only once.

    // Time Complexity: O(N)
    //   - Each index is pushed and popped at most once
    //
    // Space Complexity: O(N)
    //   - Stack storage

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        Stack<Integer> stk = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            while (!stk.isEmpty() && heights[stk.peek()] > heights[i]) {

                int height = heights[stk.pop()];
                int width;

                if (stk.isEmpty()) {
                    width = i;
                } else {
                    width = i - stk.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            stk.push(i);
        }

        // Process remaining bars
        while (!stk.isEmpty()) {

            int height = heights[stk.pop()];
            int width;

            if (stk.isEmpty()) {
                width = n;
            } else {
                width = n - stk.peek() - 1;
            }

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    // ------------------------------------------------------------
    // My Second Approach: Previous Smaller Element (PSE)
    //                    + Next Smaller Element (NSE)
    // ------------------------------------------------------------
    /*
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        Stack<Integer> stk = new Stack<>();

        // Compute Next Smaller Element (NSE)
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
            nse[i] = stk.isEmpty() ? n : stk.peek();
            stk.push(i);
        }

        stk.clear();

        // Compute Previous Smaller Element (PSE)
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }
            pse[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }

        int maxArea = 0;

        // Calculate maximum area
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea,
                    heights[i] * (nse[i] - pse[i] - 1));
        }

        return maxArea;
    }
    */
}
