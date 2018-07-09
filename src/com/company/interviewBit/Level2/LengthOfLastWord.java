package com.company.interviewBit.Level2;

public class LengthOfLastWord {
    public int lengthOfLastWord(final String A) {
        int j = A.length()-1;
        while (j >= 0 && A.charAt(j) == ' ') {
            j--;
        }

        int count = 0;

        while (j >= 0 && A.charAt(j) != ' ') {
            count++;
        }
        return count;
    }
}
