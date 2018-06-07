package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tripti on 07/06/18.
 */

public class MaxSumContinuosSubarray {
    public int maxSubArray(List<Integer> A) {
        final int[] sum = {0};
        final int[] maxSum = {Integer.MIN_VALUE};
        A.forEach(x -> {
            sum[0] = sum[0] + x;
            if (sum[0] > maxSum[0]) {
                maxSum[0] = sum[0];
            }
            if (sum[0] < 0) {
                sum[0] = 0;
            }
        });
        return maxSum[0];
    }

    public void takeCustomInput() {
        ArrayList<Integer> testList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numx = scanner.nextInt();
        for (int i = 0; i < numx; i++) {
            testList.add(scanner.nextInt());
        }
        System.out.println(maxSubArray(testList));
    }
}
