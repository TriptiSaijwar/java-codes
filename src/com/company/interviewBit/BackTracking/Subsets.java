package com.company.interviewBit.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = A.size();
        Collections.sort(A);
        for (int i = 1; i < (1<<n); i++)
        {
            ArrayList<Integer> res = new ArrayList<>();
            // Print current subset
            for (int j = 0; j < n; j++) {

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0) {
                    res.add(A.get(j));
                }
            }
//            res.sort(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o1.compareTo(o2);
//                }
//            });
            result.add(res);
        }
        result.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int result = 0;
                if (o1.size() < o2.size()) {
                    for (int i = 0; i < o1.size() && result == 0 ; i++ ) {
                        result = o1.get(i).compareTo(o2.get(i));
                    }
                    if (result == 0) {
                        result = -1;
                    }
                }
                else if (o1.size() > o2.size()) {
                    for (int i = 0; i < o2.size() && result == 0 ; i++ ) {
                        result = o1.get(i).compareTo(o2.get(i));
                    }
                    if (result == 0) {
                        result = 1;
                    }
                }
                else {
                    for (int i = 0; i < o1.size() && result == 0 ; i++ ) {
                        result = o1.get(i).compareTo(o2.get(i));
                    }
                }
                return result;
            }
        });
        result.add(0,new ArrayList<>());
        return result;
    }

    //Backtracking
    public ArrayList<ArrayList<Integer>> subsets2(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        output.add(new ArrayList<Integer>());
        if (a.size() == 0)
            return output;
        Collections.sort(a);
        generate(a, output, new ArrayList<Integer>(), 0);
        return output;
    }

    public void generate(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> temp, int index)
    {
        for (int i = index; i < a.size(); i++)
        {
            temp.add(a.get(i));
            output.add(new ArrayList<Integer>(temp));
            generate(a, output, temp, i+1);
            temp.remove(temp.size() - 1);
        }
    }


    //Subsets2
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        output.add(new ArrayList<Integer>());
        if (a.size() == 0)
            return output;
        Collections.sort(a);
        HashSet<ArrayList<Integer>> set = new  HashSet<ArrayList<Integer>>();
        generate(a, output, new ArrayList<Integer>(), 0, set);
        return output;
    }

    public void generate(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> temp, int index, HashSet<ArrayList<Integer>> set)
    {
        for (int i = index; i < a.size(); i++)
        {
            temp.add(a.get(i));
            if(!set.contains(temp)){
                set.add(temp);
                output.add(new ArrayList<Integer>(temp));
            }
            generate(a, output, temp, i+1,set);
            temp.remove(temp.size() - 1);
        }
    }
}
