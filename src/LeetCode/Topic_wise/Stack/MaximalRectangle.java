package LeetCode.Topic_wise.Stack;
import java.util.*;

class MaximalRectangle {

    // Approach:
    // Step 1:
    // Convert the binary matrix into a height matrix.
    // Each cell heights[i][j] represents the number of consecutive '1's
    // ending at row i in column j.
    //
    // Step 2:
    // For each row in the height matrix, treat it as a histogram.
    //
    // Step 3:
    // Apply the Largest Rectangle in Histogram algorithm using a
    // Monotonic Increasing Stack for each row.
    //
    // Step 4:
    // Track the maximum rectangle area across all rows and return it.

    // Time Complexity: O(N * M)
    // - Building the height matrix takes O(N * M)
    // - For each row, histogram calculation takes O(M)
    //
    // Space Complexity: O(N * M)
    // - Height matrix storage
    // - Stack usage up to O(M) per row

    public int maximalRectangle(char[][] matrix) {

        // Number of rows and columns
        int n = matrix.length, m = matrix[0].length;

        // heights[i][j] stores consecutive '1's count vertically
        int [][] heights = new int[n][m];

        int count = 0;

        // Step 1: Build height matrix column-wise
        for(int i = 0 ; i < m ; i++){
            count = 0;
            for(int j = 0 ; j < n ; j++){
                if(matrix[j][i] == '1'){
                    count++;
                }
                else{
                    count = 0;
                }
                heights[j][i] = count;
            }
        }

        int max = 0;

        // Step 2 & 3: Apply Largest Rectangle in Histogram for each row
        for(int i = 0 ; i < n ; i++){

            // Stack stores indices of histogram bars
            Stack<Integer> stk = new Stack<>();
            int ele = 0;

            for(int j = 0 ; j < m ; j++){

                // Maintain increasing order in stack
                while(!stk.isEmpty() && heights[i][stk.peek()] > heights[i][j]){

                    // Height of the rectangle
                    ele = heights[i][stk.pop()];

                    // Calculate width and update max area
                    if(stk.isEmpty()){
                        max = Math.max(max, ele * (j - (-1) - 1));
                    }
                    else{
                        max = Math.max(max, ele * (j - stk.peek() - 1));
                    }
                }
                stk.push(j);
            }

            // Process remaining bars in stack
            while(!stk.empty()){
                ele = heights[i][stk.pop()];
                if(!stk.isEmpty())
                    max = Math.max(max, ele * (m - stk.peek() - 1));
                else
                    max = Math.max(max, ele * (m - (-1) - 1));
            }
        }

        // Step 4: Return maximum rectangle area
        return max;
    }
}
