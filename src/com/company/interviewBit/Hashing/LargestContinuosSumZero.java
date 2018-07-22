package com.company.interviewBit.Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class LargestContinuosSumZero {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        if (A == null || A.size() == 0) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        int start = -1;
        int end = -1;
        int sum = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            sum = sum + A.get(i);
            if (!map.containsKey(sum)) {
                map.put(sum,i);
            }
            else {
                if (maxLen <= i - map.get(sum)) {
                    start = map.get(sum)  + 1;
                    end = i;
                    maxLen = i - map.get(sum);
                }
            }
        }
        if (start != -1 && end != -1) {
            for (int i = start; i <= end; i++) {
                result.add(A.get(i));
            }
        }
        return result;
    }
}
