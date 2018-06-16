package com.company.interviewBit.Level1;

import sun.nio.cs.ext.MacThai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tripti on 11/06/18.
 */

public class MaxDistance {
    public int maximumGap(final List<Integer> A) {
        int size = A.size();
        ArrayList<Integer> leftMin =  new ArrayList<>(Collections.nCopies(size, 0));
        ArrayList<Integer> rightMax =  new ArrayList<>(Collections.nCopies(size, 0));
        leftMin.set(0,A.get(0));
        for (int i = 1; i < size; i++) {
            leftMin.set(i,Math.min(leftMin.get(i-1),A.get(i)));
        }
        rightMax.set(size-1,A.get(size-1));
        for (int i = size - 2; i >= 0; i--) {
            rightMax.set(i,Math.max(rightMax.get(i+1),A.get(i)));
        }
        int i = 0, j = 0;
        int maxDiff = -1;
        while (i < A.size() && j < A.size()) {
            if (leftMin.get(i) <= rightMax.get(j)) {
                maxDiff = Math.max(maxDiff,j-i);
                j++;
            }
            else {
                i++;
            }
        }
        return maxDiff;
    }

    public void takeCustomInput() {
        ArrayList<Integer> testList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numx = scanner.nextInt();
        for (int i = 0; i < numx; i++) {
            testList.add(scanner.nextInt());
        }
        System.out.println(maximumGap(testList));
    }
}
