package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tripti on 08/06/18.
 */

public class MaxNonNegativeSubArray {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        int left = 0;
        int right = 0;
        int leftIndex = -1, rightIndex = -1;
        long currentSum = 0, maxSum = 0;
        int size = 0;
        for (int i = 0; i  < A.size(); i++) {
            if (A.get(i) < 0) {
                left = i + 1;
                right = i + 1;
                currentSum = 0;
            }
            else {
                currentSum = currentSum + A.get(i);
                right++;
            }

            if (currentSum > maxSum || (currentSum == maxSum && size < (right-left)) ) {
                leftIndex = left;
                rightIndex = right - 1;
                maxSum = currentSum;
                size = rightIndex - leftIndex + 1;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        if (leftIndex >= 0) {
            for (int i = leftIndex; i <= rightIndex; i++) {
                result.add(A.get(i));
            }
        }
        return result;
    }

    public void takeCustomInput() {
        ArrayList<Integer> testList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numx = scanner.nextInt();
        for (int i = 0; i < numx; i++) {
            testList.add(scanner.nextInt());
        }
        System.out.println(maxset(testList));
    }
}
