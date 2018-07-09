package com.company.interviewBit.Level6.DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LengthofLongestSubsequence {
    public int longestSubsequenceLength(final List<Integer> A) {
        if (A.size() == 0 ) {
            return 0;
        }
        int maxLength = Integer.MIN_VALUE;
        ArrayList<Integer> dp1 = new ArrayList<>(Collections.nCopies(A.size(),1));
        ArrayList<Integer> dp2 = new ArrayList<>(Collections.nCopies(A.size(),1));
        for (int i = 1; i < A.size(); i++) {

            for (int j = i-1; j >=0 ; j--) {
                if (A.get(j) < A.get(i) && dp1.get(i) <  dp1.get(j) + 1 ) {
                    dp1.set(i,dp1.get(j) + 1);
                }
            }
        }

        for (int i = A.size()-2; i >= 0; i--) {

            for (int j = i+1; j < A.size() ; j++) {
                if (A.get(j) < A.get(i) && dp2.get(i) <  dp2.get(j) + 1) {
                    dp2.set(i,dp2.get(j) + 1);
                }
            }
        }

        for (int i = 0; i < A.size(); i++) {
            if (maxLength < dp1.get(i) + dp2.get(i) - 2) {
                maxLength = dp1.get(i) + dp2.get(i) - 2;
            }
        }

        return maxLength;
    }
}
