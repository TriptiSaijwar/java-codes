package com.company.GoogleInterviewQuestions;

import java.util.HashSet;
import java.util.PriorityQueue;

public class KthSmallestSumPair {

    class Node implements Comparable<Node>{
        int i;
        int j;
        int val;
        public Node(int i, int j, int val){
            this.i = i;
            this.j = j;
            this.val = val;
        }

        @Override
        public int compareTo(Node another){
            if(this.val == another.val){
                return 0;
            }
            return this.val > another.val? 1 : -1;
        }
    }

    int[] di = new int[]{1, 0};
    int[] dj = new int[]{0, 1};
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        if(A == null || B == null || A.length == 0 && B.length == 0 || k > A.length * B.length){
            return 0;
        }else if(A.length == 0){
            return B[k];
        }else if(B.length == 0){
            return A[k];
        }

        HashSet<String> set = new HashSet<String>();
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        Node temp = new Node(0, 0, A[0] + B[0]);
        queue.offer(temp);
        set.add(temp.i + "," + temp.j);
        Node next;
        int i = 0;
        int j = 0;
        for(int n = 0; n < k - 1; n++){
            temp = queue.poll();
            for(int m = 0; m < 2; m++){
                i = temp.i + di[m];
                j = temp.j + dj[m];
                next = new Node(i, j, 0);
                if(i >= 0 && i < A.length && j >= 0 && j < B.length && !set.contains(next.i + "," + next.j)){
                    next.val = A[i] + B[j];
                    queue.offer(next);
                    set.add(next.i + "," + next.j);
                }
            }
        }
        return queue.peek().val;
    }
}
