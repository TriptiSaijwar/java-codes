package com.company.interviewBit.Level3;

public class AddTwoNumbersasLists {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    ListNode result;

    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }
        result = null;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        ListNode num1 = A;
        ListNode num2 = B;
        int carry = 0;
        while (num1 != null && num2 != null ) {
            int digitSum = num1.val + num2.val + carry;
            carry = digitSum / 10;
            digitSum = digitSum % 10;
            p.next = new ListNode(digitSum);
            p = p.next;
            num1 = num1.next;
            num2 = num2.next;
        }

        ListNode biggerList = (num1 != null) ? num1 : num2;
        if (biggerList != null) {
            while (biggerList != null) {
                int digitSum = biggerList.val + carry;
                carry = digitSum / 10;
                digitSum = digitSum % 10;
                p.next = new ListNode(digitSum);
                p = p.next;
                biggerList = biggerList.next;
            }
        }
        if (carry == 1) {
            p.next = new ListNode(1);
        }
        result = dummy.next;
//        reverse();
        return result;

    }

    private void reverse() {
        ListNode prev = null;
        ListNode next = null;
        ListNode current = result;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        result = prev;
    }

    public void input() {
        ListNode list1 = new ListNode(9);
        list1.next =  new ListNode(9);
        list1.next.next = new ListNode(9);

        ListNode list2 = new ListNode(1);
//        list2.next =  new ListNode(6);
//        list2.next.next = new ListNode(4);

        addTwoNumbers(list1,list2);
    }


}

