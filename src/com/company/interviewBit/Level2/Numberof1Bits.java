package com.company.interviewBit.Level2;

public class Numberof1Bits {
    public int numSetBits(long a) {
        if (a == 0) {
            return 0;
        }
        if (a == 1) {
            return 1;
        }
        int count = 0;
        for (long c = a; c > 0;) {
            if ((1 & c) != 0) {
                count++;
            }
            c = c >> 1;
        }
        return count;
    }
}
