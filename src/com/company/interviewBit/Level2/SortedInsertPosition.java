package com.company.interviewBit.Level2;

import java.util.ArrayList;

public class SortedInsertPosition {
    public int searchInsert(ArrayList<Integer> a, int b) {
        if (a.size() == 0) {
            return 0;
        }
        if (b < a.get(0)) {
            return 0;
        }
        if (b > a.get(a.size()-1)) {
            return a.size();
        }
        return binarySearch(a,b,0,a.size()-1);
    }

    public int binarySearch(ArrayList<Integer> a, int b, int start,int end) {
        if (start == end) {
            return start;
        }

        int mid = (start + end)/2;

        if (a.get(mid) == b) {
            return mid;
        }
        if (mid < a.size()-1 && b < a.get(mid+1) && b > a.get(mid) ) {
            // System.out.print(" mid value1 " + mid);
            return mid+1;
        }

        if (mid > 0 && b > a.get(mid-1) && b < a.get(mid)) {
            // System.out.print("mid value2" + mid);
            return mid;
        }

        if (b < a.get(mid)) {
            return binarySearch(a,b,start,mid-1);
        }
        else {
            return binarySearch(a,b,mid+1,end);
        }


    }
}
