package com.company.interviewBit.Hashing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Diff2 {
    public int diffPossible(final List<Integer> A, int B) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : A) {
            if (map.containsKey(i)) {
                map.put(i,2);
            }
            else {
                map.put(i,1);
            }
        }

        for (Map.Entry< Integer,Integer> it : map.entrySet()) {
            int diff = it.getKey() - B;
            if (map.containsKey(diff)) {
                if (map.get(diff) > 1) {
                    return 1;
                }

                if(diff != it.getKey()) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
