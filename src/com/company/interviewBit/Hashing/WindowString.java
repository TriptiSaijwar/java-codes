package com.company.interviewBit.Hashing;

import java.util.Arrays;

public class WindowString {
    public String minWindow(String A, String B) {
        if (A == null || B == null) {
            return null;
        }
        int[] countA = new int[256];
        int[] countB = new int[256];
        Arrays.fill(countA , 0);
        Arrays.fill(countB , 0);
        for (int i = 0; i < B.length(); i++) {
            countB[(int)B.charAt(i)]++;
        }
        int start = -1;
        int i = 0;
        int maxLen = Integer.MIN_VALUE;
        int charIncluded = 0;
        while (i < A.length()) {
//            countA[(int)A.charAt(i)]++;
            if (countB[(int)B.charAt(i)] != 0) {
                if (start == -1) {
                    start = i;
                }
                countA[(int)A.charAt(i)]++;
            }
            if (countA[(int)A.charAt(i)] < countB[(int)B.charAt(i)]) {
                charIncluded++;
            }
            else if (A.charAt(start) == A.charAt(i)) {
                start++;
                while (start < i && countA[(int)A.charAt(start)] == 0 || (countA[(int)A.charAt(start)] > countA[(int)A.charAt(start)])) {
                    if (countA[(int)A.charAt(start)] > countA[(int)A.charAt(start)]) {
                        countA[(int)A.charAt(start)]--;
                    }
                }
                if (charIncluded == B.length()) {
                    if (maxLen < i - start + 1) {
                        maxLen = i - start + 1;
                    }
                }
            }
        }
        if (charIncluded == B.length()) {
            if (maxLen < i - start + 1) {
                maxLen = i - start + 1;
            }
        }
        if (maxLen == Integer.MIN_VALUE) {
            return "";
        }
        return A.substring(start,i);
    }
}
