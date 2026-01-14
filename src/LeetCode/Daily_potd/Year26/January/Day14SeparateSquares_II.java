package LeetCode.Daily_potd.Year26.January;
import java.util.*;

class Day14SeparateSquaresAdvanced {

    /*
     * Problem:
     * Separate Squares - Advanced Version
     *
     * Given multiple squares represented as [x, y, l] (bottom-left corner and side length),
     * find the y-coordinate of a horizontal line that splits the total area of the squares into
     * two equal parts.
     *
     * Squares may overlap. Overlapping areas should be counted independently.
     *
     * This version uses a sweep line + segment tree approach for precise area calculation.
     */

    // ----------------------------------------------------
    // Approach:
    // ----------------------------------------------------
    // 1. Model the problem as a sweep line along the y-axis:
    //    - Each square generates two events: bottom edge (enter), top edge (leave)
    //
    // 2. Compress x-coordinates to efficiently represent segments
    //    in a segment tree for coverage calculations.
    //
    // 3. Sort all events by y-coordinate.
    //
    // 4. Use a segment tree to maintain:
    //    - coverCount: how many squares cover each segment
    //    - coveredLength: total x-length covered by squares at the current y
    //
    // 5. Sweep through events:
    //    - Calculate the area contributed by current horizontal strip
    //    - Update segment tree with event (enter or leave)
    //    - Track cumulative areas to split at half
    //
    // 6. After sweep, compute the y-coordinate where cumulative area equals half of total.

    // ----------------------------------------------------
    // Time Complexity:
    // ----------------------------------------------------
    // Let N = number of squares
    // Let M = number of unique x-coordinates
    //
    // - Compress x-coordinates: O(N log N)
    // - Sort events: O(2N log N) = O(N log N)
    // - Sweep line with segment tree updates:
    //   - Each update: O(log M)
    //   - Total updates: 2N
    //   - Total = O(N log M)
    //
    // Total Time Complexity ≈ O(N log N + N log M)
    //
    // Segment tree ensures efficient interval updates.

    // ----------------------------------------------------
    // Space Complexity:
    // ----------------------------------------------------
    // - Events list: O(2N)
    // - x-coordinate array: O(M)
    // - Segment tree arrays: O(4 * M)
    // - Parts list: O(2N)
    //
    // Total Space Complexity = O(N + M)

    class event {
        double y;
        int type; // 1 for start, -1 for end
        int xStart;
        int xEnd;

        event(double y, int type, int xStart, int xEnd) {
            this.y = y;
            this.type = type;
            this.xStart = xStart;
            this.xEnd = xEnd;
        }
    }

    public double separateSquares(int[][] squares) {

        List<event> events = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        // Step 1: Create events and collect unique x-coordinates
        for (int[] sq : squares) {
            int x = sq[0];
            int y = sq[1];
            int size = sq[2];

            // Bottom edge event
            events.add(new event(y, 1, x, x + size));
            // Top edge event
            events.add(new event(y + size, -1, x, x + size));

            set.add(x);
            set.add(x + size);
        }

        int n = set.size();
        int x[] = new int[n];
        int p = 0;

        for (int num : set) {
            x[p++] = num;
        }
        Arrays.sort(x);

        // Step 2: Sort events by y-coordinate
        events.sort(Comparator.comparingDouble(e -> e.y));

        int[] coverCount = new int[4 * n];
        double[] coveredLength = new double[4 * n];

        double totalArea = 0;
        double prevY = events.get(0).y;
        List<double[]> parts = new ArrayList<>();

        int i = 0;

        // Step 3: Sweep line processing
        while (i < events.size()) {
            double currY = events.get(i).y;

            if (currY > prevY) {
                double height = currY - prevY;
                double width = coveredLength[1]; // covered x-length at current strip
                totalArea += width * height;
                parts.add(new double[]{prevY, currY, width});
                prevY = currY;
            }

            // Step 4: Process all events at this y-coordinate
            while (i < events.size() && events.get(i).y == currY) {
                event e = events.get(i);
                int left = Arrays.binarySearch(x, e.xStart);
                int right = Arrays.binarySearch(x, e.xEnd);

                updateTree(1, 0, n, left, right, e.type, x, coverCount, coveredLength);
                i++;
            }
        }

        // Step 5: Find the horizontal line splitting area into half
        double half = totalArea / 2;
        double sum = 0;

        for (double[] part : parts) {
            double y1 = part[0];
            double y2 = part[1];
            double width = part[2];

            double area = width * (y2 - y1);

            if (sum + area >= half) {
                return y1 + (half - sum) / width;
            }
            sum += area;
        }

        return prevY;
    }

    // ----------------------------------------------------
    // Segment Tree Update Method
    // ----------------------------------------------------
    public void updateTree(int node, int start, int end, int left, int right, int value, int[] x,
                           int[] coverCount, double[] coveredLength) {

        if (right <= start || end <= left) return;

        if (left <= start && end <= right) {
            coverCount[node] += value;
        } else {
            int mid = (start + end) / 2;
            updateTree(node * 2, start, mid, left, right, value, x, coverCount, coveredLength);
            updateTree(node * 2 + 1, mid, end, left, right, value, x, coverCount, coveredLength);
        }

        if (coverCount[node] > 0) {
            coveredLength[node] = x[end] - x[start];
        } else {
            if (end - start == 1) {
                coveredLength[node] = 0;
            } else {
                coveredLength[node] = coveredLength[node * 2] + coveredLength[node * 2 + 1];
            }
        }
    }
}
