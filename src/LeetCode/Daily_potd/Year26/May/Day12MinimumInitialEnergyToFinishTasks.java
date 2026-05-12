package LeetCode.Daily_potd.Year26.May;

import java.util.*;

public class Day12MinimumInitialEnergyToFinishTasks {

    public static void main(String[] args) {

        Day12MinimumInitialEnergyToFinishTasks sol = new Day12MinimumInitialEnergyToFinishTasks();

        // ============================
        // Test Case 1
        // ============================
        int[][] tasks1 = {
                {1, 2},
                {2, 4},
                {4, 8}
        };
        System.out.println("Input: [[1,2],[2,4],[4,8]]");
        System.out.println("Output: " + sol.minimumEffort(tasks1));
        System.out.println("Expected: 8\n");

        // ============================
        // Test Case 2
        // ============================
        int[][] tasks2 = {
                {1, 3},
                {2, 4},
                {10, 11},
                {10, 12},
                {8, 9}
        };
        System.out.println("Input: [[1,3],[2,4],[10,11],[10,12],[8,9]]");
        System.out.println("Output: " + sol.minimumEffort(tasks2));
        System.out.println("Expected: 32");
    }


    /*
    ============================
    Approach: Greedy + Sorting
    ============================

    Idea:
    - Each task has:
        actual → energy spent
        minimum → minimum energy required before starting

    - We want to minimize initial energy.

    Key Observation:
    - Tasks with higher (minimum - actual) should be done first
    - Because they need more extra buffer energy

    Sorting:
    - Sort tasks by:
        (minimum - actual) descending

    Process:
    - Maintain:
        current → current available energy
        energy → total initial energy required

    - For each task:
        if(current < minimum):
            increase energy
            update current

        then perform task:
            current -= actual

    TC: O(n log n)
    SC: O(1)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int minimumEffort(int[][] tasks) {

        // Step 1: Sort by (minimum - actual) descending
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int current = 0; // current energy
        int energy = 0;  // total required initial energy

        // Step 2: Process tasks
        for(int [] task : tasks){

            int actual = task[0];
            int minimum = task[1];

            // If current energy is less than required
            if(current < minimum){
                energy += (minimum - current);
                current = minimum;
            }

            // Perform task
            current -= actual;
        }

        return energy;
    }
}