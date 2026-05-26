package LeetCode.Daily_potd.Year26.May;

import java.util.*;

public class Day27CountSpecialCharacters {

    public static void main(String[] args) {

        Day27CountSpecialCharacters sol = new Day27CountSpecialCharacters();

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
        String word2 = "abc";
        System.out.println("Input: abc");
        System.out.println("Output: " + sol.numberOfSpecialChars(word2));
        System.out.println("Expected: 0");
    }


    /*
    ============================
    Approach 1: Brute Force
    ============================

    Idea:
    - For every lowercase character:
        check whether uppercase exists

    Example:
        a → check A
        b → check B

    TC: O(26 * n)
    SC: O(1)
    */

    /*
    public int numberOfSpecialChars(String word) {

        int count = 0;

        for(char ch = 'a' ; ch <= 'z' ; ch++){

            boolean lower = false;
            boolean upper = false;

            for(char c : word.toCharArray()){

                if(c == ch) lower = true;

                if(c == Character.toUpperCase(ch)) upper = true;
            }

            if(lower && upper) count++;
        }

        return count;
    }
    */


    /*
    ============================
    Approach 2: HashSet (FINAL)
    ============================

    Idea:
    - Store lowercase letters in one set
    - Store uppercase letters (converted to lowercase)
      in another set

    - Common characters between both sets
      are special characters

    TC: O(n)
    SC: O(26)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public int numberOfSpecialChars(String word) {

        int n = word.length();

        int count = 0;

        Set<Character> lower = new HashSet<>();
        Set<Character> upper = new HashSet<>();

        // Store lowercase and uppercase characters
        for(char ch : word.toCharArray()){

            if(Character.isLowerCase(ch))
                lower.add(ch);

            else
                upper.add(Character.toLowerCase(ch));
        }

        // Count common characters
        for(char ch : lower){

            if(upper.contains(ch))
                count++;
        }

        return count;
    }
}