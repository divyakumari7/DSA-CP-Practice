package LeetCode.Daily_potd.Year26.May;

import java.util.*;

public class Day06RotatingTheBox {

    public static void main(String[] args) {

        Day06RotatingTheBox sol = new Day06RotatingTheBox();

        // ============================
        // Test Case 1
        // ============================
        char[][] boxGrid1 = {
                {'#', '.', '#'}
        };

        System.out.println("Input: [[#,.,#]]");
        System.out.println("Output: " + Arrays.deepToString(sol.rotateTheBox(boxGrid1)));
        System.out.println("Expected: [[.],[#],[#]]\n");

        // ============================
        // Test Case 2
        // ============================
        char[][] boxGrid2 = {
                {'#', '.', '*', '.'},
                {'#', '#', '*', '.'}
        };

        System.out.println("Input: [[#,.,*,.],[#,#,*,.]]");
        System.out.println("Output: " + Arrays.deepToString(sol.rotateTheBox(boxGrid2)));
        System.out.println("Expected: [[#, .], [#, #], [*, *], [., .]]");
    }


    /*
    ============================
    Approach 1: Simulation + Rotation
    ============================

    Idea:
    - First simulate gravity row-wise.
    - Stones '#' move towards the right side of the row.
    - Empty cells '.' are filled behind them.
    - Obstacles '*' block movement.

    Steps:
    1. Traverse every row from right to left.
    2. Count stones '#' and blanks '.' until obstacle '*'.
    3. When obstacle is found:
        - Fill stones from last available position.
        - Fill remaining cells as '.'
        - Reset counters.
    4. After row traversal, process remaining part before first obstacle.
    5. Finally rotate the whole box 90 degrees clockwise.

    TC: O(n * m)
    SC: O(n * m)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public char[][] rotateTheBox(char[][] boxGrid) {

        int n = boxGrid.length, m = boxGrid[0].length;

        int blank = 0, box = 0;
        int last = m - 1;
        boolean obstacle = false;

        // Step 1: Apply gravity row-wise
        for(int i = 0 ; i < n ; i++){

            last = m - 1;
            obstacle = false;
            box = 0;
            blank = 0;

            for(int j = m - 1 ; j >= 0 ; j--){

                if(boxGrid[i][j] == '#') box++;

                else if(boxGrid[i][j] == '.') blank++;

                else{
                    obstacle = true;

                    if(box == 0){
                        blank = 0;
                        last = j - 1;
                    }
                    else{
                        for(int k = last ; k > j ; k--){

                            if(box != 0){
                                boxGrid[i][k] = '#';
                                box--;
                            }
                            else{
                                boxGrid[i][k] = '.';
                            }
                        }

                        box = 0;
                        blank = 0;
                        last = j - 1;
                    }
                }
            }

            // Process remaining part of row before obstacle
            // if(!obstacle){
            for(int k = last ; k >= 0 ; k--){

                if(box != 0){
                    boxGrid[i][k] = '#';
                    box--;
                }
                else{
                    boxGrid[i][k] = '.';
                }
            }
            // }
        }

        // Step 2: Rotate matrix 90 degrees clockwise
        char [][] result = new char[m][n];

        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                result[j][n - 1 - i] = boxGrid[i][j];
            }
        }

        return result;
    }


    /*
    ============================
    Approach 2: Rotation using Transpose + Reverse
    ============================

    Idea:
    - First copy rotated values using transpose logic.
    - Or:
        1. Transpose matrix
        2. Reverse rows

    Your commented logic below does the same thing
    using result[j][i] and then reversing each row.

    TC: O(n * m)
    SC: O(n * m)
    */

    /*
    public char[][] rotateTheBox(char[][] boxGrid) {

        int n = boxGrid.length, m = boxGrid[0].length;

        // Gravity logic same as above...

        char [][] result = new char[m][n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                result[j][i] = boxGrid[i][j];
            }
        }

        int l = 0, r = n - 1;

        for(int i = 0 ; i < m ; i++){
            l = 0;
            r = n - 1;

            while(l < r){
                char t = result[i][l];
                result[i][l] = result[i][r];
                result[i][r] = t;
                l++;
                r--;
            }
        }

        return result;
    }
    */
}