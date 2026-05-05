package LeetCode.Daily_potd.Year26.May;

import java.util.*;

public class Day05RotateList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static void main(String[] args) {

        Day05RotateList sol = new Day05RotateList();

        // ============================
        // Test Case 1
        // ============================
        ListNode head1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        int k1 = 2;
        System.out.print("Input: 1->2->3->4->5 , k=2\nOutput: ");
        print(sol.rotateRight(head1, k1));
        System.out.println("Expected: 4->5->1->2->3\n");

        // ============================
        // Test Case 2
        // ============================
        ListNode head2 = new ListNode(0,
                new ListNode(1,
                        new ListNode(2)));

        int k2 = 4;
        System.out.print("Input: 0->1->2 , k=4\nOutput: ");
        print(sol.rotateRight(head2, k2));
        System.out.println("Expected: 2->0->1");
    }


    /*
    ============================
    Approach 1: Brute Force Rotation
    ============================

    Idea:
    - Rotate list k times
    - Each time:
        → take last node
        → move it to front

    TC: O(n * k)
    SC: O(1)

    ❌ Inefficient for large k
    */


    /*
    ============================
    Approach 2: Optimized (Length + Break Point)
    ============================

    Idea:
    1. Find length of list (n)
    2. Reduce k:
        k = k % n
    3. Find new head:
        → (n - k)th node becomes new head
    4. Break list and reconnect

    TC: O(n)
    SC: O(1)
    */


    // ============================
    // FINAL CODE (ACTIVE)
    // ============================

    public ListNode rotateRight(ListNode head, int k) {

        // Edge case
        if(head == null) return head;

        ListNode temp = head, prev = head;

        int n = 0;

        // Step 1: Find length
        while(temp != null){
            n++;
            temp = temp.next;
        }

        // Step 2: Reduce k
        k = k % n;

        if ((n == 1 && k >= 0) || k == 0 || (k == n)) return head;

        // Step 3: Move to new head position
        temp = head;
        for(int i = 1 ; i <= (n - k) ; i++){
            temp = temp.next;
        }

        // New head
        head = temp;

        // Step 4: Move to last node of rotated part
        for(int i = 1 ; i < k ; i++){
            temp = temp.next;
        }

        // Connect last node to old head
        temp.next = prev;

        // Step 5: Break the list
        for(int i = 1 ; i < (n - k) ; i++){
            prev = prev.next;
        }

        prev.next = null;

        return head;
    }


    // Helper function to print list
    static void print(ListNode head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}