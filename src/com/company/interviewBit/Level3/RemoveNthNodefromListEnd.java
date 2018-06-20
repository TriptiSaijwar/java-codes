package com.company.interviewBit.Level3;

public class RemoveNthNodefromListEnd {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode removeNthFromEnd(ListNode A, int B) {

        ListNode current = A;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }

        if (B >= count) {
            return A.next;
        }

        ListNode prev = null;
        int dist = count - B;
        int i = 0;
        current = A;
        while (current != null && i < dist) {
            i++;
            prev = current;
            current = current.next;
        }
        if (prev !=  null) {
            prev.next = current.next;
        }

        return A;
    }
}
