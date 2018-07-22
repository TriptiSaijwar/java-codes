package com.company.interviewBit.Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String A) {
        if (A == null || A.length() == 1 || A.length() == 0) {
            return A == null ? 0 : A.length();
        }
        int[] count = new int[256];
        Arrays.fill(count , 0);
        int start = 0;
        int i = 0;
        int maxLen = Integer.MIN_VALUE;
        while (i < A.length()) {
            if (count[(int)A.charAt(i)] == 0) {
                count[(int)A.charAt(i)]++;
            }
            else {
                if (maxLen < i - start) {
                    maxLen = i - start;
                }
                while (start < i && A.charAt(start) != A.charAt(i)) {
                    count[(int)A.charAt(start)]--;
                    start++;
                }
                // count[(int)A.charAt(start)]--;
                start++;
            }
            i++;
        }
        if (maxLen == Integer.MIN_VALUE) {
            return A.length();
        }

        if (maxLen < A.length() - start) {
            maxLen = A.length() - start;
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring2(String A) {
        HashSet<Character> hashSet = new HashSet<Character>();
        int maxCount = 0;
        int start = 0;
        for(char c : A.toCharArray()){
            while(hashSet.contains(c)){
                hashSet.remove(A.charAt(start));
                start++;
            }
            hashSet.add(c);
            maxCount = Math.max(maxCount, hashSet.size());
        }

        return maxCount;
    }
}
