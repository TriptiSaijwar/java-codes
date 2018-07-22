package com.company.interviewBit.Hashing;

import java.util.HashMap;

public class RandomPointer {
    class RandomListNode {
       int label;
       RandomListNode next, random;
       RandomListNode(int x) { this.label = x; }
   };
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode copy_head = null;
        RandomListNode copy_head_iterator = copy_head;
        RandomListNode iterator = head;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();

        while (iterator != null) {
            map.put(iterator,iterator.next);
            iterator = iterator.next;
        }
        iterator = head;
        while (iterator != null) {
            if (copy_head == null) {
                copy_head = new RandomListNode(iterator.label);
                copy_head.random = iterator;
                copy_head.next = null;
                iterator.next = copy_head;
                copy_head_iterator = copy_head;
            }
            else {
                RandomListNode node = new RandomListNode(iterator.label);
                node.random = iterator;
                node.next = null;
                iterator.next = node;
                copy_head_iterator.next = node;
                copy_head_iterator = copy_head_iterator.next;
            }
            iterator = map.get(iterator);
        }

        copy_head_iterator = copy_head;

        while (copy_head_iterator != null) {
            if (copy_head_iterator.random.random != null) {
                copy_head_iterator.random = copy_head_iterator.random.random.next;
            }
            else {
                copy_head_iterator.random = null;
            }
            copy_head_iterator = copy_head_iterator.next;
        }

        for (RandomListNode m : map.keySet()) {
            m.next = map.get(m);
        }
        return copy_head;
    }
}
