package com.company.interviewBit.GreedyAlgorithms;

import java.util.List;

public class MajorityElement {
    public int majorityElement(final List<Integer> A) {
        int majorrityElement = 0;
        int count = 1;
        for (int i = 1; i < A.size(); i++) {
            if ((long)A.get(i) == (long)A.get(majorrityElement)) {
                count++;
            }
            else {
                count--;
            }

            if (count == 0) {
                majorrityElement = i;
                count = 1;
            }
        }
        return A.get(majorrityElement);
    }
}
