package com.company.interviewBit.Level3;

public class PartitionList {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode partition(ListNode A, int B) {
        if(A == null) return null;

        ListNode dummyS = new ListNode(0);
        ListNode dummyLE = new ListNode(0);
        dummyS.next = A;

        ListNode curr = A;
        ListNode prev = dummyS;
        ListNode p2 = dummyLE;

        while(curr != null){
            if(curr.val < B){
                curr = curr.next;
                prev = prev.next;
            }
            else{
                p2.next = curr;
                prev.next = curr.next;

                curr = prev.next;
                p2 = p2.next;
            }
        }
        p2.next = null;

        prev.next = dummyLE.next;
        return dummyS.next;
    }

    public void input() {
        ListNode list = new ListNode(1);
        list.next =  new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        partition(list,5);
    }
}

