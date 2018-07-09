package com.company.interviewBit.Level2;

import java.util.ArrayList;

public class LongestCommonPrefix {
    public String longestCommonPrefix(ArrayList<String> A) {
        if (A == null) {
            return "";
        }

        if (A.size() == 1) {
            return A.get(0);
        }
        String temp = commonPrefix(A.get(0),A.get(1));
        for (int i = 2; i < A.size() && temp.length() != 0; i++) {
            String res = commonPrefix(temp,A.get(i));
            temp = res;
        }
        return temp;
    }

    private String commonPrefix(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder("");
        int l = 0;
        while (l < a.length() && l < b.length()) {
            if (a.charAt(l) == b.charAt(l)) {
                stringBuilder = stringBuilder.append(a.charAt(l));
                l++;
            }
            else {
                break;
            }
        }
        return stringBuilder.toString();
    }
}
