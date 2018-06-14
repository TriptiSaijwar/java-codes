package com.company.interviewBit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tripti on 13/06/18.
 */

public class SetMatixZero {
    //Gave TLE
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        if (a == null) {
            return;
        }
//        HashSet consumes about 5.5 times more memory than ArrayList for the same number of elements (although they're both still linear), and has significantly slower iteration (albeit with the same asymptotics); a quick Google search suggests a 2-3x slowdown for HashSet iteration versus ArrayList.
//        If you don't care about uniqueness or the performance of contains, then use ArrayList.
//        this is giving TLE. So, had to use Set.
//        ArrayList<Integer> row = new ArrayList<>();
//        ArrayList<Integer> column = new ArrayList<>();
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(0).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(0).size(); j++) {
                if (row.contains(i) || column.contains(j)) {
                    a.get(i).set(j,0);
                }
            }
        }
    }

    public void setZeroesSolution2(ArrayList<ArrayList<Integer>> a) {
        if (a == null) {
            return;
        }
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).get(0) == 0) {
                firstColumnHasZero = true;
            }
        }
        for (int i = 0; i < a.get(0).size(); i++) {
            if (a.get(0).get(i) == 0) {
                firstRowHasZero = true;
            }
        }
        for (int i = 1; i < a.size(); i++) {
            for (int j = 1; j < a.get(0).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    a.get(0).set(j,0);
                    a.get(i).set(0,0);
                }
            }
        }

        for (int i = 1; i < a.size(); i++) {
            for (int j = 1; j < a.get(0).size(); j++) {
                if (a.get(i).get(0) == 0 || a.get(0).get(j) == 0) {
                    a.get(i).set(j,0);
                }
            }
        }

        if (firstRowHasZero) {
            for (int i = 0; i < a.get(0).size(); i++) {
                a.get(0).set(i,0);
            }
        }

        if (firstColumnHasZero) {
            for (int i = 0; i < a.size(); i++) {
                a.get(i).set(0,0);
            }
        }

    }
}
