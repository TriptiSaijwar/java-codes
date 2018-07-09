package com.company.interviewBit.Graph;

import java.util.*;

public class SmallestMultipleWith01 {
    public String multiple(int A) {
        Queue<String> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.offer("1");
        while (!q.isEmpty()) {
            String s = q.peek();
            q.poll();
            int mod = modulus(s,A);
            if (mod == 0) {
                return s;
            }
            else if (!set.contains(mod)) {
                set.add(mod);
                q.offer(s + "0");
                q.offer(s + "1");
            }
        }
        return "";
    }

    private int modulus(String s, int a) {
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res*10 + (s.charAt(i) - '0');
            res = res % a;
        }
        return (int)res%a;
    }
}
