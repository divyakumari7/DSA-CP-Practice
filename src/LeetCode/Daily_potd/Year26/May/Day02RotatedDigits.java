package LeetCode.Daily_potd.Year26.May;

public class Day02RotatedDigits {

    public static void main(String[] args) {

        Day02RotatedDigits sol = new Day02RotatedDigits();

        // ============================
        // Test Case 1
        // ============================
        int n1 = 10;
        System.out.println("Input: n = 10");
        System.out.println("Output: " + sol.rotatedDigits(n1));
        System.out.println("Expected: 4\n");

        // ============================
        // Test Case 2
        // ============================
        int n2 = 20;
        System.out.println("Input: n = 20");
        System.out.println("Output: " + sol.rotatedDigits(n2));
        System.out.println("Expected: 9");
    }


    /*
    ============================
    Approach 1: Brute Force (Digit Check)
    ============================

    Idea:
    - Check each number from 1 → n
    - For each digit:
        Invalid digits → 3,4,7 → reject number
        Valid same digits → 0,1,8
        Changing digits → 2,5,6,9

    - A number is "good" if:
        → No invalid digits
        → At least one changing digit

    TC: O(n * digits)
    SC: O(1)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int rotatedDigits(int n) {

        int count = 0;

        for(int i = 1 ; i <= n ; i++){

            int currentNum = i;

            boolean found = false;   // at least one changing digit
            boolean invalid = false; // contains invalid digit

            while(currentNum > 0){

                int d = currentNum % 10;

                // invalid digits
                if(d == 3 || d == 4 || d == 7){
                    invalid = true;
                    break;
                }

                // changing digits
                else if(d == 2 || d == 5 || d == 6 || d == 9){
                    found = true;
                }

                currentNum /= 10;
            }

            if(!invalid && found) count++;
        }

        return count;
    }


    /*
    ============================
    Approach 2: DP (Digit DP idea)
    ============================

    Idea:
    - Use dp[i]:
        0 → invalid
        1 → valid but same after rotation
        2 → good number (changes after rotation)

    TC: O(n)
    SC: O(n)

    public int rotatedDigits(int n) {

        int[] dp = new int[n + 1];
        int count = 0;

        for(int i = 0 ; i <= n ; i++){

            if(i < 10){
                if(i == 0 || i == 1 || i == 8) dp[i] = 1;
                else if(i == 2 || i == 5 || i == 6 || i == 9){
                    dp[i] = 2;
                    count++;
                }
                else dp[i] = 0;
            }
            else{
                int a = dp[i / 10];
                int b = dp[i % 10];

                if(a == 0 || b == 0) dp[i] = 0;
                else if(a == 1 && b == 1) dp[i] = 1;
                else{
                    dp[i] = 2;
                    count++;
                }
            }
        }

        return count;
    }
    */
}