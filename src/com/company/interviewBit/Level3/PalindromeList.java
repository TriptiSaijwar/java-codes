package com.company.interviewBit.Level3;

public class PalindromeList {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    ListNode secondHalf,slow_ptr,fast_ptr;

    public int lPalin(ListNode A) {
        slow_ptr = A;
        fast_ptr = A;
        ListNode midNode = null;
        ListNode prev = null;
        ListNode head = A;

        if (A == null || A.next == null) {
            return 1;
        }

        while (fast_ptr != null && fast_ptr.next != null) {
            prev = slow_ptr;
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }

        if (fast_ptr != null) {
            midNode = slow_ptr;
            slow_ptr = slow_ptr.next;
        }
        secondHalf = slow_ptr;
        prev.next = null;
        reverseList();
        int result = compareLinkedLists(secondHalf, head);
        reverseList();

        if (midNode != null) {
            prev.next = midNode;
            midNode.next = slow_ptr;
        }
        else {
            prev.next = slow_ptr.next;
        }

        return result;
    }

    private void reverseList() {
        ListNode prev = null;
        ListNode current = secondHalf;
        ListNode next;
        while (current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        secondHalf = prev;
    }

    private int compareLinkedLists(ListNode secondHalf, ListNode firstHalf) {
        while (secondHalf != null && firstHalf != null) {
            if (secondHalf.val != firstHalf.val) {
                return 0;
            }
            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }

        if (secondHalf != null || firstHalf != null) {
            return 0;
        }

        return 1;
    }

    public void input() {
        ListNode list = new ListNode(6);
        list.next =  new ListNode(3);
        list.next.next = new ListNode(7);
        list.next.next.next = new ListNode(3);
        list.next.next.next.next = new ListNode(6);
        lPalin(list);
    }

    //Can do it with stack also
}
