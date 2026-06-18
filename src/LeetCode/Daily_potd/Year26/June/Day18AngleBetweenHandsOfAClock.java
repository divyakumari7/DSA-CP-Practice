package LeetCode.Daily_potd.Year26.June;

public class Day18AngleBetweenHandsOfAClock {

    public static void main(String[] args) {

        Day18AngleBetweenHandsOfAClock sol =
                new Day18AngleBetweenHandsOfAClock();

        // ============================
        // Test Case 1
        // ============================
        int hour1 = 12;
        int minutes1 = 30;

        System.out.println("Input: hour = 12, minutes = 30");
        System.out.println("Output: " +
                sol.angleClock(hour1, minutes1));
        System.out.println("Expected: 165.0\n");

        // ============================
        // Test Case 2
        // ============================
        int hour2 = 3;
        int minutes2 = 30;

        System.out.println("Input: hour = 3, minutes = 30");
        System.out.println("Output: " +
                sol.angleClock(hour2, minutes2));
        System.out.println("Expected: 75.0");
    }


    /*
    ============================
    Approach 1: Clock Angle Formula
    ============================

    Idea:
    - Hour hand moves:
        30° per hour
        0.5° per minute

    - Minute hand moves:
        6° per minute

    Hour hand angle:
        30 * hour + 0.5 * minutes

    Minute hand angle:
        6 * minutes

    Difference:
        abs(hourAngle - minuteAngle)

    Since clock is circular:
        answer = min(diff, 360 - diff)

    TC: O(1)
    SC: O(1)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public double angleClock(int hour, int minutes) {

        // Hour hand position
        double hourAngle =
                (30 * hour) + (0.5 * minutes);

        // Minute hand position
        double minuteAngle =
                6 * minutes;

        // Absolute angle difference
        double angle =
                Math.abs(hourAngle - minuteAngle);

        // Smaller angle
        angle = Math.min(angle, 360 - angle);

        return angle;
    }


    /*
    ============================
    Your Formula (Short Form)
    ============================

    Observation:

    hourAngle - minuteAngle

    = (30 * hour + 0.5 * minutes)
      - (6 * minutes)

    = (30 * hour)
      - (5.5 * minutes)

    Therefore:

    public double angleClock(int hour, int minutes) {

        double angle =
                Math.abs((30 * hour)
                - (5.5 * minutes));

        angle = Math.min(angle,
                360 - angle);

        return angle;
    }

    TC: O(1)
    SC: O(1)
    */
}