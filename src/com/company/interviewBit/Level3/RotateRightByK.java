package com.company.interviewBit.Level3;

public class RotateRightByK {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    //gave TLE on directly returing A;
    public ListNode rotateRight(ListNode A, int B) {
        ListNode newHead = A;
        if (B == 0) return newHead;
        ListNode current  = A;

        int count = 0;
        while (current !=  null)
        {
            count++;
            current = current.next;
        }

        int k = 1;
        current = A;
        int dist = B % count;
        while (k < count-dist && current !=  null)
        {
            k++;
            current = current.next;
        }
        if (current == null)
        {
            return newHead;
        }

        ListNode kthNode = current;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newHead;
        newHead = kthNode.next;
        kthNode.next = null;

        return newHead;
    }

    public void input() {
        ListNode list = new ListNode(91);
        list.next =  new ListNode(34);
        list.next.next = new ListNode(18);
        list.next.next.next = new ListNode(83);
        list.next.next.next.next = new ListNode(38);
        list.next.next.next.next.next = new ListNode(82);
        list.next.next.next.next.next.next = new ListNode(21);
        list.next.next.next.next.next.next.next = new ListNode(69);
        rotateRight(list,89);
    }
}
