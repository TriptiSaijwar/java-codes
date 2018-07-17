package com.company.interviewBit.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;

public class MiceHole {
    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A == null || B == null || A.size() != B.size())
            return -1;
        int time = Integer.MIN_VALUE;
        Collections.sort(A);
        Collections.sort(B);
        for(int i =0; i < A.size(); i++){
            time = Math.max(Math.abs(B.get(i) - A.get(i)),time);
        }
        return time;
    }
}
