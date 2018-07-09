package com.company.interviewBit.Level2;

import java.util.ArrayList;

public class MatrixSearch {
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        if (a.size() == 0 || a.get(0).size() == 0) {
            return 0;
        }
            int i = 0;
            int j = a.get(0).size() -1;
            while (i < a.size() && j >= 0 ) {
                if (a.get(i).get(j) == b) {
                    return 1;
                }

                if (a.get(i).get(j)  > b) {
                    j--;
                }
                else {
                    i++;
                }
            }
            return 0;
    }

    public int searchMatrix1(ArrayList<ArrayList<Integer>> a, int b) {
        if (a.size() == 0 || a.get(0).size() == 0) {
            return 0;
        }
        int rows = a.size();
        int cols = a.get(0).size();
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int i = mid / cols;
            int j = mid % cols;
            int midVal = a.get(i).get(j);
            if (midVal == b) {
                // found!
                return 1;
            } else if (midVal < b) {
                // go to right part to search
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;

    }
}
