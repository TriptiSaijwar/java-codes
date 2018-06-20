package com.company.interviewBit.Level3;

public class ReverseLinkedList2 {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode reverseBetween(ListNode A, int B, int C)  {
        ListNode current = A;
        ListNode next = null;
        ListNode prev = null;
        ListNode nodeBeforeStart = null;
        ListNode startNode = null;
        ListNode head = A;

        int start = 1;
        while (start < B && current != null) {
            start++;
            nodeBeforeStart = current;
            current = current.next;
        }

        startNode = current;
        int count = 0;
        /* Reverse first k nodes of linked list */
        while (count < C-B+1 && current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (nodeBeforeStart != null) {
            nodeBeforeStart.next = prev;
        }
        startNode.next = next;

        if (B == 1) {
            return prev;
        }
        return head;
    }
}
