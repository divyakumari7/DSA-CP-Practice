package LeetCode.Daily_potd.Year26.April;

public class Day07WalkingRobotSimulation {

    /*
     * ----------------------------------------------------
     * POTD Day 07 (April)
     * Problem:
     * Design Robot Movement on Grid Boundary
     * ----------------------------------------------------
     *
     * Given:
     * - A grid of size width × height
     * - Robot starts at (0,0) facing East
     *
     * Functions:
     * - step(num) → move robot num steps
     * - getPos() → return current position
     * - getDir() → return current direction
     *
     * Movement Rules:
     * - Robot moves only along the boundary
     * - It follows rectangular perimeter
     * - Turns anti-clockwise at corners
     *
     * Directions:
     * East → North → West → South → repeat
     *
     * ----------------------------------------------------
     * Approach:
     * ----------------------------------------------------
     * 1. Key Observation:
     *    - Robot always moves along the perimeter
     *    - Total boundary length:
     *          perimeter = 2 * (width + height) - 4
     *
     * 2. Optimization:
     *    - Instead of moving num steps directly,
     *      reduce:
     *          num = num % perimeter
     *
     *    - If num becomes 0 → it means full cycle
     *      so set num = perimeter
     *
     * 3. Movement Logic:
     *    - Maintain:
     *         (x, y) → current position
     *         dir → current direction
     *
     *    - For each direction:
     *
     *      dir = 0 → move East
     *          x increases
     *
     *      dir = 1 → move North
     *          y increases
     *
     *      dir = 2 → move West
     *          x decreases
     *
     *      dir = 3 → move South
     *          y decreases
     *
     * 4. At each step:
     *    - Move as much as possible in current direction
     *    - If boundary reached → turn (dir + 1) % 4
     *
     * 5. Repeat until all steps are consumed
     *
     * ----------------------------------------------------
     * Key Insight:
     * ----------------------------------------------------
     * - Robot moves ONLY on boundary
     * - Use modulo with perimeter to avoid extra loops
     * - Movement is chunk-based (not step-by-step)
     *
     */


    class Robot {

        int [][] grid;
        int dir = 0;

        // Direction arrays
        int [] dx = {1, 0, -1, 0};
        int [] dy = {0, 1, 0, -1};

        int x = 0;
        int y = 0;

        int perimeter;

        public Robot(int width, int height) {

            // Grid just used for dimensions
            this.grid = new int[width][height];

            // Calculate total boundary length
            this.perimeter = 2 * (width + height) - 4;
        }

        public void step(int num) {

            // Reduce unnecessary full cycles
            num = num % perimeter;

            // Handle full loop case
            if(num == 0) num = perimeter;

            while(num > 0){

                int move = 0;

                // Move East
                if(dir == 0){
                    move = Math.min(num, grid.length - 1 - x);
                    x += move;
                }

                // Move North
                else if(dir == 1){
                    move = Math.min(num, grid[0].length - 1 - y);
                    y += move;
                }

                // Move West
                else if(dir == 2){
                    move = Math.min(num, x);
                    x -= move;
                }

                // Move South
                else if(dir == 3){
                    move = Math.min(num, y);
                    y -= move;
                }

                // Reduce steps
                num -= move;

                // Turn if steps still left
                if(num > 0){
                    dir = (dir + 1) % 4;
                }
            }
        }

        public int[] getPos() {
            return new int[]{x, y};
        }

        public String getDir() {
            if(dir == 0) return "East";
            else if(dir == 1) return "North";
            else if(dir == 2) return "West";
            else return "South";
        }
    }


    /*
     * ----------------------------------------------------
     * Time Complexity (TC):
     * ----------------------------------------------------
     * Let:
     * K = number of steps given in step(num)
     *
     * - Due to modulo:
     *      num = num % perimeter
     *
     * - Each movement reduces steps significantly
     *
     * Worst Case:
     * O(perimeter) ≈ O(width + height)
     *
     * ----------------------------------------------------
     * Space Complexity (SC):
     * ----------------------------------------------------
     * O(1)
     *
     * (Grid is not used for storage logic,
     * only for dimension reference)
     *
     * ----------------------------------------------------
     * Why Efficient:
     * ----------------------------------------------------
     * - Avoids step-by-step simulation
     * - Uses boundary movement chunks
     * - Reduces large input using modulo
     *
     * ----------------------------------------------------
     * Key Benefit:
     * ----------------------------------------------------
     * Handles very large step values efficiently
     * without TLE
     */
}