package LeetCode.Daily_potd.Year26.June;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Day14MaximumTwinSumOfLinkedList {

    /*
    ===========================
    POTD Day 14 (June)
    Problem:
    Maximum Twin Sum of a Linked List
    ===========================

    Given:
    - Even length linked list

    Twin Nodes:
    - 1st ↔ last
    - 2nd ↔ second last
    - and so on

    Task:
    Return maximum twin sum.

    Example:
    5 -> 4 -> 2 -> 1

    Twin sums:
    5 + 1 = 6
    4 + 2 = 6

    Answer = 6
    */


    /*
    ===========================
    Approach 1: Brute Force
    ===========================

    Idea:
    - Store all node values into ArrayList
    - Use two pointers
    - Compute twin sums

    TC: O(n)
    SC: O(n)

    public int pairSum(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = list.size() - 1;

        int max = 0;

        while(left < right){

            max = Math.max(max,
                    list.get(left) + list.get(right));

            left++;
            right--;
        }

        return max;
    }
    */


    /*
    ===========================
    Approach 2: Optimized
    ===========================

    Idea:
    1. Find middle using Slow/Fast pointer
    2. Reverse second half
    3. Traverse both halves together
    4. Compute maximum twin sum

    TC: O(n)
    SC: O(1)

    Why Better?
    - No extra ArrayList
    - In-place solution
    */


    // ===========================
    // FINAL CODE (YOUR APPROACH)
    // ===========================

    public int pairSum(ListNode head) {

        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Special case
        if(slow.next.next == null){
            return head.val + head.next.val;
        }

        // Step 2: Reverse second half
        ListNode prev = null;
        ListNode current = null;
        ListNode next = slow.next;

        while(next != null){

            current = next;
            next = next.next;

            current.next = prev;
            prev = current;
        }

        slow.next = prev;

        // Step 3: Calculate twin sums
        slow = slow.next;
        current = head;

        int max = 0;
        int sum = 0;

        while(slow != null){

            sum = current.val + slow.val;

            max = Math.max(max, sum);

            current = current.next;
            slow = slow.next;
        }

        return max;
    }


    /*
    ===========================
    Dry Run
    ===========================

    Input:
    5 -> 4 -> 2 -> 1

    Middle:
    slow = 4

    Reverse second half:
    1 -> 2

    First Half:
    5 -> 4

    Second Half:
    1 -> 2

    Twin Sums:

    5 + 1 = 6
    4 + 2 = 6

    Maximum = 6

    Output:
    6
    */


    /*
    ===========================
    Time Complexity
    ===========================

    Finding middle = O(n)

    Reversing second half = O(n/2)

    Calculating twin sums = O(n/2)

    Overall TC:
    O(n)


    ===========================
    Space Complexity
    ===========================

    Only pointers used

    Overall SC:
    O(1)
    */
}