package LeetCode.Topic_wise.Stack;

class NextGreaterElement_III_Number {

    // Approach:
    // This problem is based on finding the next lexicographically greater
    // permutation of the digits of a given number.
    //
    // Steps:
    // 1. Convert the number into a character array.
    // 2. Traverse from right to left and find the first index `index`
    //    such that digit[index] < digit[index + 1].
    //    - If no such index exists, no greater number is possible.
    // 3. From the rightmost side, find the smallest digit greater than
    //    digit[index] and swap them.
    // 4. Reverse the subarray to the right of `index` to get the smallest
    //    possible arrangement.
    // 5. Convert the result back to a number.
    // 6. If the number exceeds Integer.MAX_VALUE, return -1.

    // Time Complexity: O(N)
    //   - Single traversal + reversal
    //
    // Space Complexity: O(N)
    //   - Character array storage

    public int nextGreaterElement(int n) {

        String s = Integer.toString(n);
        char[] c = s.toCharArray();
        int l = c.length;

        // Step 1: find the first decreasing digit from the right
        int index = -1;
        for (int i = l - 1; i > 0; i--) {
            if (c[i - 1] < c[i]) {
                index = i - 1;
                break;
            }
        }

        // If no next greater permutation exists
        if (index == -1) return -1;

        // Step 2: find the smallest digit greater than c[index] from the right
        for (int i = l - 1; i >= 0; i--) {
            if (c[i] > c[index]) {
                char temp = c[i];
                c[i] = c[index];
                c[index] = temp;
                break;
            }
        }

        // Step 3: reverse the suffix
        int start = index + 1, end = l - 1;
        while (start < end) {
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }

        // Step 4: convert to number and check overflow
        long num = 0;
        for (int i = 0; i < l; i++) {
            num = num * 10 + (c[i] - '0');
        }

        if (num > Integer.MAX_VALUE) return -1;
        return (int) num;
    }
}
