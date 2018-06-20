package com.company.interviewBit.Level3;

public class MergeTwoSortedLists {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        return merge(A,B);
    }

    //partially correct
    public ListNode merge(ListNode A, ListNode B) {
        if (B == null) {
            return A;
        }
        if (A == null) {
            return B;
        }

        if (A.val < B.val)
        {
            A.next = merge(A.next, B);
            return A;
        }
        else
        {
            B.next = merge(A, B.next);
            return B;
        }
    }

    public ListNode mergeTwoLists2(ListNode A, ListNode B) {
        ListNode p1 = A;
        ListNode p2 = B;

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }

            p = p.next;
        }

        if (p1 != null)
            p.next = p1;
        if (p2 != null)
            p.next = p2;

        return dummy.next;
    }
}
