package com.company;

import java.util.ArrayList;

/**
 * Created by tripti on 10/06/18.
 */

public class AntiDiagonal {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> diagonalLine = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                diagonalLine.add(A.get(j).get(i-j));
            }
            result.add(diagonalLine);
        }
        if (A.size() != 1) {
            for (int i = A.size()-2; i >= 0; i--) {
                ArrayList<Integer> diagonalLine = new ArrayList<>();
                int k = A.size() - 1 - i;
                for (int j = 0; j <= i; j++) {
                    diagonalLine.add(A.get(k).get(A.size()-1-j));
                    k++;
                }
                result.add(diagonalLine);
            }
        }
        return result;
    }
}
