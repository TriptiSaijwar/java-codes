package com.company.interviewBit.Level3;

public class MergeSort {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null)
        {
            return A;
        }

        // get the middle of the list
        ListNode middle = getMiddle(A);
        ListNode nextofmiddle = middle.next;

        // set the next of middle node to null
        middle.next = null;

        // Apply mergeSort on left list
        ListNode left = sortList(A);

        // Apply mergeSort on right list
        ListNode right = sortList(nextofmiddle);

        // Merge the left and right lists
        ListNode sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    //2 3 4 5...returning 3
    private ListNode getMiddle(ListNode h)
    {
        //Base case
        if (h == null)
            return h;
        ListNode fastptr = h.next;
        ListNode slowptr = h;

        // Move fastptr by two and slow ptr by one
        // Finally slowptr will point to middle node
        while (fastptr != null)
        {
            fastptr = fastptr.next;
            if(fastptr!=null)
            {
                slowptr = slowptr.next;
                fastptr=fastptr.next;
            }
        }
        return slowptr;
    }

    private ListNode sortedMerge(ListNode A, ListNode B)
    {
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
