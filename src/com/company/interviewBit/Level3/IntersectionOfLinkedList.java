package com.company.interviewBit.Level3;

public class IntersectionOfLinkedList {
    class ListNode {
       public int val;
       public ListNode next;
       ListNode(int x) { val = x; next = null; }
   }
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        ListNode list1 = a;
        ListNode list2 = b;
        int list1Count = 0;
        int list2Count = 0;
        while (list1 != null) {
            list1Count++;
            list1 = list1.next;
        }
        while (list2 != null) {
            list2Count++;
            list1 = list2.next;
        }
        int diff = (list1Count > list2Count) ? (list1Count - list2Count) : (list2Count - list1Count);
        if (list1Count > list2Count) {
            list1 = a;
            list2 = b;
        }
        else {
            list1 = b;
            list2 = a;
        }

        int i = 0;
        while (list1 != null && i < diff) {
            i++;
            list1 = list1.next;
        }

        while(list1 != null && list2 != null) {
            if (list1.val == list2.val) {
                return list1;
            }
            list1 = list1.next;
            list2 = list2.next;
        }

        return null;
    }
}
