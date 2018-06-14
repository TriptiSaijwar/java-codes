package com.company.interviewBit.Level2;

import java.util.ArrayList;

/**
 * Created by tripti on 13/06/18.
 */

public class CheckPoint {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A <= 0) {
            return result;
        }
        // initialize matrix
        int n = 2 * A - 1;

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            result.add(row);
        }

        // update matrix
        int i = 0;
        int j = 0;
        int dir = 0;
        for (int num = A; num > 0; num--) {
            // watch the corner case when num = 1
            int size = num == 1 ? 1
                    : (2 * num - 1) * (2 * num - 1) - (2 * num - 3) * (2 * num - 3);
            int count = 0;
            while (count < size) {
                // print number in a circle
                count++;
                result.get(i).set(j,num);
                if (dir == 0) {
                    j++; // move to right
                    if (j == n || result.get(i).get(j) != 0) {
                        dir = 1;
                        j--;
                        i++;
                    }
                } else if (dir == 1) {
                    i++; // move downwards
                    if (i == n || result.get(i).get(j) != 0) {
                        dir = 2;
                        i--;
                        j--;
                    }
                } else if (dir == 2) {
                    j--; // move to left
                    if (j < 0 || result.get(i).get(j) != 0) {
                        dir = 3;
                        j++;
                        i--;
                    }
                } else {
                    i--; // move upwards
                    if (i < 0 || result.get(i).get(j) != 0) {
                        dir = 0;
                        i++;
                        j++;
                    }
                }
            }
        }

        return result;
    }
}
