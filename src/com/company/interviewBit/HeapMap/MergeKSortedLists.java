package com.company.interviewBit.HeapMap;

import java.util.ArrayList;

public class MergeKSortedLists {

    class ListNode {
       public int val;
       public ListNode next;
       ListNode(int x) { val = x; next = null; }
   }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int index;
        while ((index = getSmallerList(a)) != -1) {
            current.next = a.get(index);
            current = current.next;
            a.set(index,a.get(index).next);
        }
        return dummy.next;
    }

    int getSmallerList(ArrayList<ListNode> a) {
        int index = -1;
        int small = Integer.MAX_VALUE;
        for (ListNode i : a) {
            if (i != null && i.val < small) {
                small = i.val;
                index = a.indexOf(i);
            }
        }
        return index;
    }
}
