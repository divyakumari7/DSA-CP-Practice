package LeetCode.Daily_potd.Year26.January;

import java.util.*;

class Day11MaximalRectangle {

    // ============================================
    // Approach 1: Monotonic Stack (Single Pass)
    // ============================================
    //
    // Idea:
    // - Use a Monotonic Increasing Stack to store indices of bars.
    // - When the current bar is smaller than the top of the stack,
    //   it indicates the right boundary for rectangles with the popped height.
    // - Calculate the area for each popped bar.
    //
    // Steps:
    // 1. Traverse histogram from left to right.
    // 2. While current height < height at stack top:
    //    - Pop the index
    //    - Calculate area using the popped height:
    //      width = (if stack empty) i - (-1) - 1
    //              else i - stack.peek() - 1
    // 3. Push current index into stack.
    // 4. After traversal, process remaining bars in the stack.
    //
    // Time Complexity: O(N)
    //   - Each index pushed and popped at most once
    //
    // Space Complexity: O(N)
    //   - Stack storage

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        Stack<Integer> stk = new Stack<>();
        int ele = 0, max = 0;

        for(int i = 0 ; i < n ; i++){

            while(!stk.isEmpty() && heights[stk.peek()] > heights[i]){
                ele = heights[stk.pop()];

                if(stk.isEmpty()){
                    max = Math.max(max, ele * (i - (-1) - 1));
                }
                else{
                    max = Math.max(max, ele * (i - stk.peek() - 1));
                }
            }
            stk.push(i);
        }

        while(!stk.empty()){
            ele = heights[stk.pop()];
            if(!stk.isEmpty()) max = Math.max(max, ele * (n - stk.peek() - 1));
            else max = Math.max(max, ele * (n - (-1) - 1));
        }

        return max;
    }

    // ============================================
    // Approach 2: Previous Smaller Element (PSE) + Next Smaller Element (NSE)
    // ============================================
    /*
    Approach:
    1. For each bar, find:
       - NSE[i] = index of Next Smaller Element to the right
       - PSE[i] = index of Previous Smaller Element to the left
    2. Width of rectangle with heights[i] as the smallest bar:
       width = NSE[i] - PSE[i] - 1
    3. Area = heights[i] * width
    4. Track the maximum area.

    Time Complexity: O(N)
    - Finding NSE: Each element pushed and popped at most once -> O(N)
    - Finding PSE: Each element pushed and popped at most once -> O(N)
    - Calculating areas: O(N)
    => Total ~ O(3N) = O(N)

    Space Complexity: O(N)
    - NSE array -> O(N)
    - PSE array -> O(N)
    - Stack -> O(N)
    */

    /*
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int [] nse = new int[n];
        int [] pse = new int[n];
        Stack<Integer> stk = new Stack<>();

        // Compute Next Smaller Element (NSE)
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                nse[i] = n;
                stk.push(i);
            }
            else{
                nse[i] = stk.peek();
                stk.push(i);
            }
        }

        stk = new Stack<>();

        // Compute Previous Smaller Element (PSE)
        for(int i = 0 ; i < n ; i++){
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                pse[i] = -1;
                stk.push(i);
            }
            else{
                pse[i] = stk.peek();
                stk.push(i);
            }
        }

        int max = 0;

        // Calculate maximum area using NSE and PSE
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max, (heights[i] * (nse[i] - pse[i] - 1)));
        }

        return max;
    }
    */
}
