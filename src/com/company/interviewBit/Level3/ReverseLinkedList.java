package com.company.interviewBit.Level3;

public class ReverseLinkedList {

    class ListNode {
       public int val;
       public ListNode next;
       ListNode(int x) { val = x; next = null; }
    }

    public ListNode reverseList(ListNode A) {
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

    public ListNode reverseListRecursive(ListNode A) {
        return reverseListRecursiveUtil(A,null);
    }

    private ListNode reverseListRecursiveUtil(ListNode current, ListNode prev) {
        if (current.next == null) {
            current.next = prev;
            return current;
        }

        ListNode next = current.next;
        current.next = prev;
        return reverseListRecursiveUtil(next,current);
    }
}
