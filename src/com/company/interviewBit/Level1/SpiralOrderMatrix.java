package com.company.interviewBit.Level1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tripti on 08/06/18.
 */

public class SpiralOrderMatrix {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        if (A == 0) {
            return null;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(A);

        for (int i = 0; i < A; i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j < A; j++) {
                result.get(i).add(0);
            }
        }
        int xBeg = 0, xEnd = A-1;
        int yBeg = 0, yEnd = A-1;
        int currentValue = 1;
        while(true) {
            for(int i = yBeg; i <= yEnd; i++ ) {
                result.get(xBeg).set(i,currentValue++);
            }
            if (++xBeg > xEnd) break;
            for(int i = xBeg; i <= xEnd; i++ ) {
                result.get(i).set(yEnd,currentValue++);
            }
            if(--yEnd < yBeg) break;
            for(int i = yEnd; i >= yBeg; i-- ) {
                result.get(xEnd).set(i,currentValue++);
            }
            if(--xEnd < xBeg) break;
            for(int i=xEnd; i>= xBeg; i--) result.get(i).set(yBeg,currentValue++);
            if(++yBeg > yEnd) break;
        }
        return result;
    }

    public void takeCustomInput() {
        ArrayList<Integer> testList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numx = scanner.nextInt();
        System.out.println(generateMatrix(numx));
    }
}
