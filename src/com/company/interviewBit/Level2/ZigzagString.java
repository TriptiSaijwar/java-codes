package com.company.interviewBit.Level2;

public class ZigzagString {
    public String convert(String a, int b) {
        if (b == 1) return a;
        b--; // make level 0-based

        StringBuilder[] rows = new StringBuilder[b + 1];
        for (int i = 0; i <= b; i++) {
            rows[i] = new StringBuilder();
        }

        boolean naturalOrder = true;
        int level = 0;
        for (int i = 0; i < a.length(); i++) {
            rows[level].append(a.charAt(i));

            if (naturalOrder) {
                level++;
            } else {
                level--;
            }

            if (level > b) {
                naturalOrder = false;
                level = b - 1;
            } else if (level < 0) {
                naturalOrder = true;
                level = 1;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}
