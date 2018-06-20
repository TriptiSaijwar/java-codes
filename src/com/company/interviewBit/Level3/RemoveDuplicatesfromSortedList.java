package com.company.interviewBit.Level3;

public class RemoveDuplicatesfromSortedList {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode deleteDuplicates(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }

        ListNode current = A;

        while (current != null && current.next != null) {

            if (current.val == current.next.val) {
                ListNode next  = current.next.next;
                current.next = null;
                current.next = next;
            }
            else {
                current = current.next;
            }
        }
        return A;
    }

    public ListNode deleteDuplicates2(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }

        ListNode dummy = new ListNode(0);

        /* dummy node points to the original head*/
        dummy.next = A;
        ListNode prev = dummy;
        ListNode current = A;

        while (current != null && current.next != null) {

            while (current.next != null && prev.next.val == current.next.val) {
                current = current.next;
            }

            if (prev.next == current) {
                prev = prev.next;
            }
            else {
                prev.next = current.next;
            }

            current = current.next;
        }
        return dummy.next;
    }
}
