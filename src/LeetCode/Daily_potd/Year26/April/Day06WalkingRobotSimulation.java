package LeetCode.Daily_potd.Year26.April;

import java.util.*;

public class Day06WalkingRobotSimulation {

    public static void main(String[] args) {

        Day06WalkingRobotSimulation sol = new Day06WalkingRobotSimulation();

        // ============================
        // Test Case 1
        // ============================
        int[] commands1 = {4, -1, 3};
        int[][] obstacles1 = {};
        System.out.println("Input: commands = [4,-1,3], obstacles = []");
        System.out.println("Output: " + sol.robotSim(commands1, obstacles1));
        System.out.println("Expected: 25\n");

        // ============================
        // Test Case 2
        // ============================
        int[] commands2 = {4, -1, 4, -2, 4};
        int[][] obstacles2 = {{2, 4}};
        System.out.println("Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]");
        System.out.println("Output: " + sol.robotSim(commands2, obstacles2));
        System.out.println("Expected: 65");
    }

    /*
     * ----------------------------------------------------
     * POTD Day 07 (April)
     * Problem:
     * Walking Robot Simulation
     * ----------------------------------------------------
     *
     * Given:
     * - commands[] → instructions for robot movement
     * - obstacles[][] → blocked positions on grid
     *
     * Commands:
     * - -2 → turn left
     * - -1 → turn right
     * - positive number → move forward that many steps
     *
     * Task:
     * Return the maximum Euclidean distance squared
     * from origin (0,0) achieved during the walk.
     *
     * ----------------------------------------------------
     * Approach:
     * ----------------------------------------------------
     * 1. Use a HashSet to store obstacle positions
     *    for O(1) lookup.
     *
     * 2. Maintain:
     *    - Current position (x, y)
     *    - Direction index (dir)
     *
     * 3. Use direction arrays:
     *      dx = {0, 1, 0, -1}
     *      dy = {1, 0, -1, 0}
     *
     *    Meaning:
     *    0 → North
     *    1 → East
     *    2 → South
     *    3 → West
     *
     * 4. Process each command:
     *    - If turn → update direction
     *    - If move → move step-by-step
     *
     * 5. Before each step:
     *    - Check if next cell is obstacle
     *    - If yes → stop current movement
     *
     * 6. Update maximum distance:
     *      dist = max(dist, x² + y²)
     *
     * ----------------------------------------------------
     * Key Insight:
     * ----------------------------------------------------
     * Move one step at a time instead of jumping directly,
     * so obstacle detection works correctly.
     */

    public int robotSim(int[] commands, int[][] obstacles) {

        int x = 0, y = 0;

        // Step 1: Store obstacles in HashSet for fast lookup
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            set.add(obstacles[i][0] + "," + obstacles[i][1]);
        }

        // Step 2: Direction arrays (N, E, S, W)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int dir = 0;   // initially facing North
        int dist = 0;  // max distance squared

        // Step 3: Process each command
        for (int i = 0; i < commands.length; i++) {

            int curr = commands[i];

            // Turn right
            if (curr == -1) {
                dir = (dir + 1) % 4;
            }

            // Turn left
            else if (curr == -2) {
                dir = (dir + 3) % 4;
            }

            // Move forward
            else {

                for (int j = 0; j < curr; j++) {

                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    // Stop if obstacle encountered
                    if (set.contains(nx + "," + ny)) {
                        break;
                    }

                    // Move to next position
                    x = nx;
                    y = ny;

                    // Update max distance
                    dist = Math.max(dist, x * x + y * y);
                }
            }
        }

        return dist;
    }

    /*
     * ----------------------------------------------------
     * Time Complexity (TC):
     * ----------------------------------------------------
     * Let:
     * N = number of commands
     * K = total steps moved (sum of commands)
     *
     * - Building set: O(M)  (M = obstacles)
     * - Simulation: O(K)
     *
     * Overall TC: O(M + K)
     *
     * ----------------------------------------------------
     * Space Complexity (SC):
     * ----------------------------------------------------
     * O(M)
     * For storing obstacles in HashSet
     *
     * ----------------------------------------------------
     * Why this works:
     * ----------------------------------------------------
     * Step-by-step simulation ensures correct obstacle handling,
     * while HashSet allows O(1) obstacle checking.
     */

    /*
     * ----------------------------------------------------
     * POTD Day 07 (April)
     * Problem:
     * Walking Robot Simulation
     * ----------------------------------------------------
     *
     * Optimization:
     * ----------------------------------------------------
     * Instead of storing obstacles as "x,y" strings,
     * we encode coordinates into a single long value.
     *
     * This avoids:
     * - String creation overhead
     * - Extra memory usage
     *
     * Encoding:
     * ----------------------------------------------------
     * key = ((long)x << 32) | (y & 0xffffffffL)
     *
     * This uniquely represents (x, y)
     *
     * ----------------------------------------------------
     * Approach:
     * ----------------------------------------------------
     * Same as before:
     * - Use HashSet for obstacles
     * - Track position and direction
     * - Move step-by-step
     * - Update max distance
     *
     * Only change:
     * - Efficient obstacle lookup using long keys
     */

//    public int robotSim(int[] commands, int[][] obstacles) {
//
//        int x = 0, y = 0;
//
//        // Step 1: Store obstacles using long encoding
//        HashSet<Long> set = new HashSet<>();
//        for (int i = 0; i < obstacles.length; i++) {
//
//            long key = (((long) obstacles[i][0]) << 32)
//                    | (obstacles[i][1] & 0xffffffffL);
//
//            set.add(key);
//        }
//
//        // Step 2: Direction arrays (N, E, S, W)
//        int[] dx = {0, 1, 0, -1};
//        int[] dy = {1, 0, -1, 0};
//
//        int dir = 0;   // North
//        int dist = 0;  // max distance squared
//
//        // Step 3: Process commands
//        for (int i = 0; i < commands.length; i++) {
//
//            int curr = commands[i];
//
//            // Turn right
//            if (curr == -1) {
//                dir = (dir + 1) % 4;
//            }
//
//            // Turn left
//            else if (curr == -2) {
//                dir = (dir + 3) % 4;
//            }
//
//            // Move forward
//            else {
//
//                for (int j = 0; j < curr; j++) {
//
//                    int nx = x + dx[dir];
//                    int ny = y + dy[dir];
//
//                    // Encode next position
//                    long key = (((long) nx) << 32)
//                            | (ny & 0xffffffffL);
//
//                    // Check obstacle
//                    if (set.contains(key)) {
//                        break;
//                    }
//
//                    // Move
//                    x = nx;
//                    y = ny;
//
//                    // Update distance
//                    dist = Math.max(dist, x * x + y * y);
//                }
//            }
//        }
//
//        return dist;
//    }

    /*
     * ----------------------------------------------------
     * Time Complexity (TC):
     * ----------------------------------------------------
     * O(M + K)
     * M = obstacles, K = total steps
     *
     * ----------------------------------------------------
     * Space Complexity (SC):
     * ----------------------------------------------------
     * O(M)
     *
     * ----------------------------------------------------
     * Why Optimized:
     * ----------------------------------------------------
     * - No string creation → faster
     * - Better memory usage
     * - HashSet lookup still O(1)
     *
     * ----------------------------------------------------
     * Key Benefit:
     * ----------------------------------------------------
     * Reduces constant factor significantly
     * (important in large test cases)
     */
}