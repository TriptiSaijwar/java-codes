package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.max;

/**
 * Created by tripti on 07/06/18.
 */

public class MaxAbsoluteDifference {
    public int maxArr(ArrayList<Integer> A) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, max4 = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        int size = A.size();
        for (int i = 0; i < size; ++i)
        {
            max1 = max(max1, A.get(i) + i);
            max2 = max(max2, -A.get(i) + i);
            max3 = max(max3, A.get(i) - i);
            max4 = max(max4, -A.get(i) - i);
        }
        for (int i = 0; i<size; ++i)
        {
            ans = max(ans, max1 - A.get(i) - i);
            ans = max(ans, max2 + A.get(i) - i);
            ans = max(ans, max3 - A.get(i) + i);
            ans = max(ans, max4 + A.get(i) + i);
        }
        return ans;
    }

    public void takeCustomInput() {
        ArrayList<Integer> testList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numx = scanner.nextInt();
        for (int i = 0; i < numx; i++) {
            testList.add(scanner.nextInt());
        }
        System.out.println(maxArr(testList));
    }
}
