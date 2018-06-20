package com.company.interviewBit.Level3;

import java.util.HashSet;

public class ListCycle {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public ListNode detectCycle(ListNode a) {
        if (a == null) {
            return null;
        }

        ListNode slow_ptr = a;
        ListNode fast_ptr = a;
        boolean isCycle = false;

        while (fast_ptr != null && fast_ptr.next != null) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
            if (slow_ptr == fast_ptr) {
                isCycle = true;
                break;
            }
        }

        if(!isCycle) {
            return null;
        }

        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode current = a;
        ListNode result = null;
        while (current != null) {
            if (hashSet.contains(current)) {
                result = current;
                break;
            }
            else {
                hashSet.add(current);
                current = current.next;
            }
        }
        return result;
    }
}
