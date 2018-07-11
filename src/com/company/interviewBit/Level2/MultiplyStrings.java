package com.company.interviewBit.Level2;

import java.util.Arrays;

public class MultiplyStrings {
    public String multiply(String A, String B) {
        if (A.length() == 0 && B.length() == 0) {
            return "";
        }
        if (A.length() == 1 && A.charAt(0) == '0') {
            return "0";
        }
        if (B.length() == 1 && B.charAt(0) == '0') {
            return "0";
        }
        int lenA = A.length();
        int lenB = B.length();
        char result[] = new char[lenA+lenB+1];
        Arrays.fill(result,'0');
        String reverseA = (new StringBuilder(A)).reverse().toString();
        String reverseB = (new StringBuilder(B)).reverse().toString();
        int carry;
        for (int i = 0; i < reverseB.length(); i++) {
            int a = reverseB.charAt(i) - '0';
            carry = 0;
            for (int j = 0; j < reverseA.length(); j++) {
                int b = reverseA.charAt(j) - '0';
                int temp = result[i+j] - '0';
                int c = a*b + temp + carry;
                result[i+j] = (char) (c % 10 + '0');
                carry = c/10;
            }
            result[i + reverseA.length()] = (char)(carry + '0');
        }

        String res = (new StringBuilder(new String(result))).reverse().toString();
        int i = 0;
        while (i < res.length() && res.charAt(i) == '0') {
            i++;
        }
        return res.substring(i);
    }
}
