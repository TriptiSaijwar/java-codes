package com.company.interviewBit.Level2;

public class DivideIntergers {

    public int divide(int A, int B) {
        long n = A, m = B;
        int sign = n < 0 ^ m < 0 ? -1 :1;
        long q = 0;
        n = Math.abs(n);
        m = Math.abs(m);
        for (long t = 0, i = 31; i >= 0; i--)
        if (t + (m << i) <= n) {
            t += m << i;
            q |= 1L << i;
        }

        // assign back the sign
        if (sign < 0) q = -q;

        // check for overflow and return
        return (q >= Integer.MAX_VALUE || q < Integer.MIN_VALUE) ? Integer.MAX_VALUE : (int)q;
    }

    public void input() {
        divide(25,4);
    }
}
