package com.company.interviewBit.Level2;

public class RomanToInteger {
    public int romanToInt(String A) {
        int res = 0;
        for (int i = 0 ; i < A.length(); i++) {
            int c1 = getValue(A.charAt(i));
            if (i+1 < A.length()) {
                if (c1 >= getValue(A.charAt(i+1))) {
                    res = res + c1;
                }
                else {
                    res = res + (getValue(A.charAt(i+1)) - c1);
                    i++;
                }
            }
            else {
                res = res + c1;
                i++;
            }
        }
        return res;
    }

    int getValue(char c) {
        int value = 0;
        if (c == 'I') {
            value = 1;
        }
        else if (c == 'V') {
            value = 5;
        }
        else if (c == 'X') {
            value = 10;
        }
        else if (c == 'L') {
            value = 50;
        }
        else if (c == 'C') {
            value = 100;
        }
        else if (c == 'D') {
            value = 500;
        }
        else if (c == 'M') {
            value = 1000;
        }

        return value;
    }

}
