package com.company.interviewBit.HeapMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianAndChocolates {
    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : B) {
            pq.offer(i);
        }
        long ans = 0;
        int count = 0;
        while (count < A) {
            int s = pq.poll();
            ans = ans + s;
            ans = ans % 1000000007;
            pq.offer(s/2);
            count++;
        }
        ans = ans % 1000000007;
        return (int)ans;
    }
}
