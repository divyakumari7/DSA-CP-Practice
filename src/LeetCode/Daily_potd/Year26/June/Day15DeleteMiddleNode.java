package LeetCode.Daily_potd.Year26.June;

public class Day15DeleteMiddleNode {

    /*
    ============================
    LeetCode 2095
    Delete the Middle Node of a Linked List
    ============================

    Given:
    - Head of a singly linked list

    Task:
    - Delete the middle node
    - Return the modified linked list

    Middle Node:
    - Index = n / 2 (0-based indexing)

    Example:

    Input:
    1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6

    Length = 7

    Middle Index:
    7 / 2 = 3

    Delete:
    7

    Output:
    1 -> 3 -> 4 -> 1 -> 2 -> 6
    */


    /*
    ============================
    Approach 1: Brute Force
    ============================

    Idea:
    - Find length of linked list
    - Compute middle index = length / 2
    - Traverse to node before middle
    - Delete middle node

    TC: O(n) + O(n)
       = O(n)

    SC: O(1)
    */

    /*
    public ListNode deleteMiddle(ListNode head) {

        ListNode temp = head;

        int length = 0;

        while(temp != null){
            length++;
            temp = temp.next;
        }

        if(length == 1) return null;

        if(length == 2){
            head.next = null;
            return head;
        }

        int middle = length / 2;

        temp = head;

        for(int i = 1 ; i < middle ; i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }
    */


    /*
    ============================
    Approach 2: Slow Fast Pointer
    ============================

    Idea:
    - Slow moves 1 step
    - Fast moves 2 steps
    - When fast reaches end,
      slow reaches middle

    To delete middle:
    - Maintain previous node of slow
    - Connect previous -> slow.next

    TC: O(n)

    SC: O(1)

    Preferred Approach
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public ListNode deleteMiddle(ListNode head) {

        // Edge Case:
        // Empty list or single node

        if(head == null || head.next == null){
            return null;
        }

        ListNode temp = head;

        ListNode slow = head;
        ListNode fast = head;

        // temp stores node before middle

        while(fast != null && fast.next != null){

            temp = slow;

            slow = slow.next;

            fast = fast.next.next;
        }

        // Delete middle node

        temp.next = slow.next;

        return head;
    }
}


/*
============================
Dry Run
============================

Input:

1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6

Initial:

temp = 1
slow = 1
fast = 1

Iteration 1:

temp = 1
slow = 3
fast = 4

Iteration 2:

temp = 3
slow = 4
fast = 1

Iteration 3:

temp = 4
slow = 7
fast = 6

Loop Ends

Middle Node:
slow = 7

Delete:
temp.next = slow.next

4 -> 1

Final List:

1 -> 3 -> 4 -> 1 -> 2 -> 6


============================
Complexities
============================

Approach 1 (Length Based)

TC: O(n)
SC: O(1)

Approach 2 (Slow Fast Pointer)

TC: O(n)
SC: O(1)


============================
Pattern Used
============================

1. Linked List Traversal

2. Slow & Fast Pointer

3. Middle Node Detection
Best Approach:
Slow & Fast Pointer
*/
