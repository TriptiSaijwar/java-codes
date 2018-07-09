package com.company.interviewBit.Level2;

import java.util.Arrays;

public class ImplementStrStr {
    public int strStr(final String A, final String B) {
        if (A.length() == 0 || B.length() == 0) {
            return -1;
        }

        if (B.length() > A.length()) {
            return -1;
        }

        int countA[] = new int[256];
        int countB[] = new int[256];
        Arrays.fill(countA,0);
        Arrays.fill(countB,0);
        for (int i = 0; i < B.length(); i++) {
            countB[B.charAt(i)]++;
        }

        for (int i = 0; i < B.length(); i++) {
            countA[A.charAt(i)]++;
        }
        if (sameCount(countA,countB)) {
            int k = 0;
            for (int j = 0; j <= B.length(); j++) {
                if (A.charAt(j) != B.charAt(k)) {
                    break;
                }
                k++;
            }
            if (k == B.length()) {
                return 0;
            }
        }
        int len = B.length();
        for (int i = B.length(); i < A.length(); i++) {
            countA[A.charAt(i - len)]--;
            countA[A.charAt(i)]++;
            if (sameCount(countA,countB)) {
                int k = 0;
                for (int j = i - len + 1; j <= i; j++) {
                    if (A.charAt(j) != B.charAt(k)) {
                        break;
                    }
                    k++;
                }
                if (k == B.length()) {
                    return i - len + 1;
                }
            }
        }
        return -1;
    }

    public static int strStr1(final String haystack, final String needle) {
        if(haystack.isEmpty() || needle.isEmpty())
            return -1;
        if(haystack == null || needle == null)
            return -1;
        int N = haystack.length();
        int M = needle.length();
        for(int i = 0; i <= N-M; i++){
            int j;
            for(j = 0; j < M; j++){
                if(haystack.charAt(i+j) != needle.charAt(j))
                    break;
            }
            if(j == M) return i;
        }
        return -1;
    }

    //better approachExplicit backup
    public int strStrBetter(final String haystack, final String needle) {
        if(haystack.isEmpty() || needle.isEmpty())
            return -1;
        if(haystack == null || needle == null)
            return -1;
        int i, j;
        int M = needle.length();
        int N = haystack.length();

        for(i = 0, j = 0; i < N && j < M; i++){
            if(haystack.charAt(i) == needle.charAt(j))
                j++;
            else{
                i = i - j;
                j = 0;
            }
        }
        if(j == M)
            return i - M;
        else
            return -1;
    }

    boolean sameCount(int countA[], int countB[]) {
        for (int i = 0; i < 256; i++) {
            if (countA[i] != countB[i]) {
                return false;
            }
        }
        return true;
    }

    public void input() {
        String A = "bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba";
        String B = "babaaa";
        strStr(A,B);
    }
}
