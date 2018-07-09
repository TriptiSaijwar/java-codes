package com.company.interviewBit.Level6;

import java.util.ArrayList;

public class Invserions {
    public int countInversions(ArrayList<Integer> A) {
        int size = A.size();
        if (size <= 1) {
            return 0;
        }
        int inversions = 0;
        for (int i = 1; i < A.size(); i++) {
            int moveMe = A.get(i);
            int j = i-1;
            while (j >= 0 && (A.get(j) > moveMe)) {
                int k = j + 1;
                A.set(k,A.get(j));
                j--;
                inversions++;
            }
            A.set(j+1 , moveMe);
        }
        return inversions;
    }
}
