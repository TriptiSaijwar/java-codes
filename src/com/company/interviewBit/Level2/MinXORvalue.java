package com.company.interviewBit.Level2;

import java.util.ArrayList;
import java.util.Collections;

public class MinXORvalue {
    public int findMinXor(ArrayList<Integer> A) {
        if (A.size() == 0) {
            return 0;
        }
        if (A.size() == 1) {
            return A.get(0);
        }
        int xor = Integer.MAX_VALUE;
        Collections.sort(A);
        for (int i = 1; i < A.size(); i++) {
            int xorPair = A.get(i)^A.get(i-1);
            if (xor > xorPair) {
                xor = xorPair;
            }
        }
        return xor;
    }
}
