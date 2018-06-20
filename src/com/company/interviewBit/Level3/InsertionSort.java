package com.company.interviewBit.Level3;

public class InsertionSort {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    ListNode sorted;
    public ListNode insertionSortList(ListNode A) {
        sorted = null;
        ListNode current = A;
        while (current != null) {
            ListNode next = current.next;
            sortInsertion(current);
            current = next;
        }
        return sorted;
    }

    private void sortInsertion(ListNode currentNode) {
        if (sorted == null || sorted.val > currentNode.val) {
            currentNode.next = sorted;
            sorted = currentNode;
        }
        else {
            ListNode curr = sorted;
            while (curr.next != null && curr.next.val < currentNode.val) {
                curr = curr.next;
            }
            currentNode.next = curr.next;
            curr.next = currentNode;
        }
    }

    public void input() {
        ListNode list = new ListNode(1);
        list.next =  new ListNode(3);
        list.next.next = new ListNode(2);
        insertionSortList(list);
    }
}
