package com.company.interviewBit.Level3;

public class ReorderList {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode reorderList(ListNode A) {
        if (A == null || A.next == null) {
            return null;
        }

        ListNode slow_ptr = A;
        ListNode fast_ptr = A;
        ListNode prev = null;

        while (fast_ptr != null && fast_ptr.next != null) {
            prev = slow_ptr;
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }

        if (fast_ptr != null) {
            prev = slow_ptr;
            slow_ptr = slow_ptr.next;
        }

        prev.next = reverseList(slow_ptr);

        ListNode current = A;
        ListNode secondHalf = prev.next; 
        ListNode next1 = null,next2;
        // current != prev for even/odd
        while (current != null && current.next != null && secondHalf != null && current != prev ) {
            next1 = current.next;
            current.next = secondHalf;
            next2 = secondHalf.next;
            prev.next = next2;
            secondHalf.next = next1;
            secondHalf = next2;
            current = next1;
        }
        return A;
    }

    public ListNode reverseList( ListNode A) {
        ListNode prev = null;
        ListNode next = null;
        ListNode current = A;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public void input() {
        ListNode list = new ListNode(1);
        list.next =  new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(6);
//        list.next.next.next.next.next.next = new ListNode(7);
        reorderList(list);
    }
}
