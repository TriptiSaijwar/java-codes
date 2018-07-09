package com.company.interviewBit.Level2;

import java.util.*;

public class Sum3Zero {
    // Np need to use hashset and remove duplicated...just run loops for i,j,k and ignore duplicates - SEE Solution 2
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);
        for (int i = 0; i < A.size()-2; i++) {
            int j = i+1;
            int k = A.size()-1;
            while (j < k) {
                if (A.get(i) + A.get(j) + A.get(k) == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(A.get(i));
                    list.add(A.get(j));
                    list.add(A.get(k));
                    result.add(list);
                    j++;
                    k--;
                }
                else if (A.get(i) + A.get(j) + A.get(k) < 0) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        HashSet<ArrayList<Integer>> hs = new HashSet<>();
        hs.addAll(result);
        result.clear();
        result.addAll(hs);
        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0) > o2.get(0)) {
                    return 1;
                }
                else if (o1.get(0) == o2.get(0)) {
                    if (o1.get(1) > o2.get(1) ) {
                        return 1;
                    }
                    else if (o1.get(1) == o2.get(1)) {
                        if (o1.get(2) > o2.get(2)) {
                            return 1;
                        }
                        else {
                            return 0;
                        }
                    }
                }
                return 0;
            }
        });
        return result;
    }

    public ArrayList<ArrayList<Integer>> threeSum2(ArrayList<Integer> A) {
        Collections.sort(A);
        int result=0;
        int l=0;
        ArrayList<ArrayList<Integer>> ar=new ArrayList<ArrayList<Integer>>();
        int i=0;
        while(i<A.size()-2){
            int s2=A.get(i);
            int j=i+1;
            int k=A.size()-1;

            while(j<k){
                int sum=A.get(i)+A.get(j)+A.get(k);
                int s=A.get(j);
                int  s1=A.get(k);
                if(sum==0){
                    ar.add(new ArrayList<Integer>());
                    ar.get(l).add(A.get(i));
                    ar.get(l).add(A.get(j));
                    ar.get(l).add(A.get(k));
                    l++;
                }
                if(sum>=0){
                    k--;
                    while(k>=0&&A.get(k)==s1)k--;
                }
                else{
                    j++;
                    while(j<A.size()&&A.get(j)==s)j++;
                }
            }
            i++;
            while(i<A.size() && A.get(i)==s2)i++;
        }

        return ar;}
}
