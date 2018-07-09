package com.company.interviewBit.Level2;

import java.util.ArrayList;

public class DifferentBitsSumPairwise {
    public int cntBits(ArrayList<Integer> A) {
        if (A.size() == 0) {
            return 0;
        }
        int size = A.size();
        long result = 0;
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < A.size(); j++) {
            if (A.get(j) > max) {
                max = A.get(j);
            }
        }
        int count = 0;
        while (max > 0) {
            count++;
            max = max >> 1;
        }
        for (int i = 0; i < count ; i++) {
            long bit = 1 << i;
            int countIthBit = 0;
            for (int j = 0; j < A.size(); j++) {
                if ( (A.get(j) & bit) != 0) {
                    countIthBit++;
                }
            }
            result = result + 2 * countIthBit * (size - countIthBit);
        }
        return (int)(result % 1000000007);
    }

    public void input() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(5);
        cntBits(arr);
    }
}
