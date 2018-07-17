package com.company.interviewBit.HeapMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class NMaxPairCombinations {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Collections.sort(A,Collections.reverseOrder());
        Collections.sort(B,Collections.reverseOrder());
        for (int i = 0;i < A.size(); i++) {
            for (int j = 0;j < A.size(); j++) {
                int s = A.get(i)+B.get(j);
                if (pq.size()<A.size()){
                    pq.add(s);
                } else {
                    if (s>pq.peek()){
                        pq.poll();
                        pq.add(s);
                    }else{
                        break;
                    }
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>(pq);
        Collections.sort(result,Collections.reverseOrder());
        return result;
    }
}
