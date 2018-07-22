package com.company.interviewBit.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if (A < B) {
            return result;
        }
        combination(A,B,0,0,result,temp);
        return result;
    }

    public void combination(int A, int B, int index,int count, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {
        if (count == B) {
            result.add(new ArrayList(temp));
            return;
        }
        for (int j = index; j < A; j++) {
            count++;
            temp.add(j+1);
            combination(A,B,j + 1,count,result,temp);
            count--;
            temp.remove(temp.size() - 1);
        }
    }

    //solution combination sum1
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> result = new  ArrayList<ArrayList<Integer>>();
        if(a == null || a.size() == 0)
            return result;
        Collections.sort(a);

        ArrayList<Integer> currentList = new ArrayList<Integer>();
        HashSet<ArrayList<Integer>> set = new  HashSet<ArrayList<Integer>>();
        combinationSum(a, b, 0, currentList, result, set);

        return result;
    }


    public static void combinationSum(ArrayList<Integer> a, int b,int j, ArrayList<Integer> currentList, ArrayList<ArrayList<Integer>> result,  HashSet<ArrayList<Integer>> set){
        if(b == 0){
            ArrayList<Integer> temp = new ArrayList<Integer>(currentList);
            if(!set.contains(temp)){
                set.add(temp);
                result.add(temp);
            }
            return;
        }

        for(int i = j; i < a.size(); i++){
            if(b < a.get(i))
                return;
            currentList.add(a.get(i));
            combinationSum(a, b - a.get(i), i, currentList, result, set);
            currentList.remove(currentList.size() - 1);
        }
    }
}
