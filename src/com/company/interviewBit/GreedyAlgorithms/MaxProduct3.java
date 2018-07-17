package com.company.interviewBit.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;

public class MaxProduct3 {
    public int maxp3(ArrayList<Integer> A) {
        Collections.sort(A);
        int n = A.size();
        return Math.max((A.get(n-1) * A.get(n-2) * A.get(n-3)),
                (A.get(n-1) * A.get(0) * A.get(1)));
    }
}
