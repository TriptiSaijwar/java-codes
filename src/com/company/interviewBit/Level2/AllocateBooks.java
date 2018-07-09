package com.company.interviewBit.Level2;

import java.util.ArrayList;

public class AllocateBooks {
    public int books(ArrayList<Integer> A, int B) {
        if (A.size() == 0) {
            return -1;
        }
        //atleast one
        if (B > A.size()) {
            return -1;
        }
        long low = getMax(A,A.size());
        long high = getSum(A,A.size());
        while (low < high) {
            int mid = (int)(low + (high - low)/2);
            int students = getRequiredStudents(A,A.size(),mid);
            if (students <= B) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return (int)low;
    }

    private int getRequiredStudents(ArrayList<Integer> C, int n, int maxPagesPerStudent){
        int total = 0;
        int numStudents = 1;
        for(int i =0;i < n; i++){
            total += C.get(i);
            if(total > maxPagesPerStudent){
                total = C.get(i);
                numStudents++;
            }

        }
        return numStudents;
    }

    private long getSum(ArrayList<Integer> C, int n){
        int total = 0;
        for(int i = 0; i < n; i++){
            total += C.get(i);
        }
        return total;
    }

    public long getMax(ArrayList<Integer> C, int n){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(C.get(i) > max)
                max = C.get(i);
        }
        return max;
    }
}
