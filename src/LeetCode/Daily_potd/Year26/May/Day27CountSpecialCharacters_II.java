package LeetCode.Daily_potd.Year26.May;

import java.util.*;

public class Day27CountSpecialCharacters_II {

    public static void main(String[] args) {

        Day27CountSpecialCharacters_II sol = new Day27CountSpecialCharacters_II();

        // ============================
        // Test Case 1
        // ============================
        String word1 = "aaAbcBC";
        System.out.println("Input: aaAbcBC");
        System.out.println("Output: " + sol.numberOfSpecialChars(word1));
        System.out.println("Expected: 3\n");

        // ============================
        // Test Case 2
        // ============================
        String word2 = "AbBCab";
        System.out.println("Input: AbBCab");
        System.out.println("Output: " + sol.numberOfSpecialChars(word2));
        System.out.println("Expected: 0");
    }


    /*
    ============================
    Approach 1: HashMap
    ============================

    Idea:
    - Store last index of lowercase character
    - Store first index of uppercase character
    - A character is special if:
        last lowercase index < first uppercase index

    TC: O(n)
    SC: O(26)
    */

    /*
    public int numberOfSpecialChars(String word) {

        int n = word.length();
        int count = 0;

        Map<Character, Integer> lower = new HashMap<>();
        Map<Character, Integer> upper = new HashMap<>();

        for(int i = 0 ; i < n ; i++){

            char ch = word.charAt(i);

            if(Character.isLowerCase(ch))
                lower.put(ch, i);

            if(Character.isUpperCase(ch) && !upper.containsKey(Character.toLowerCase(ch)))
                upper.put(Character.toLowerCase(ch), i);
        }

        for(char ch : lower.keySet()){

            if(upper.containsKey(ch) && lower.get(ch) <= upper.get(ch))
                count++;
        }

        return count;
    }
    */


    /*
    ============================
    Approach 2: Array Index Tracking (FINAL)
    ============================

    Idea:
    - lower[i] stores last index of lowercase letter
    - upper[i] stores first index of uppercase letter

    Example:
        'a' / 'A' -> index 0
        'b' / 'B' -> index 1

    Condition:
        lower[i] != -1
        upper[i] != -1
        lower[i] < upper[i]

    TC: O(n + 26)
    SC: O(26)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int numberOfSpecialChars(String word) {

        int[] lower = new int[26];
        int[] upper = new int[26];

        Arrays.fill(lower, -1);
        Arrays.fill(upper, -1);

        int n = word.length();

        for (int i = 0; i < n; i++) {

            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {
                lower[ch - 'a'] = i;
            }
            else {
                int idx = Character.toLowerCase(ch) - 'a';

                if (upper[idx] == -1) {
                    upper[idx] = i;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {

            if (lower[i] != -1 && upper[i] != -1
                    && lower[i] < upper[i]) {

                count++;
            }
        }

        return count;
    }
}