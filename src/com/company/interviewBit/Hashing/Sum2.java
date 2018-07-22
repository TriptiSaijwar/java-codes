package com.company.interviewBit.Hashing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Sum2 {
    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int first = -1;
        int second = -1;
        for (int i = 0; i < A.size(); i++) {
           if (!map.containsKey(A.get(i))) {
               map.put(A.get(i),i);
           }

           if (map.containsKey(B-A.get(i)) && map.get(B-A.get(i)) != i) {
               first = map.get(B-A.get(i));
               second = i;
               break;
           }
        }
        if (first != -1 && second != -1) {
            result.add(first + 1);
            result.add(second + 1);
        }
        return result;
    }
}
