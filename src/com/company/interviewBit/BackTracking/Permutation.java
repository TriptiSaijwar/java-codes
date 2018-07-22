package com.company.interviewBit.BackTracking;

import java.util.ArrayList;

public class Permutation {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        permutation(A,result,0);
        return result;
    }

    public void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

    public void permutation(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result, int index) {
        if (index == A.size()-1) {
            // ArrayList<Integer> res = new ArrayList<>();
            result.add(new ArrayList(A));
            return;
        }
        for (int j = index; j < A.size(); j++) {
            swap(A,j,index);
            permutation(A,result,index+1);
            swap(A,j,index);
        }
    }
}
