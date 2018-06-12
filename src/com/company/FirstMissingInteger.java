package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.jar.JarEntry;

/**
 * Created by tripti on 12/06/18.
 */

public class FirstMissingInteger {
    public int firstMissingPositive(ArrayList<Integer> A) {
        int positiveNumStartIndex = segregrate(A);

        // Mark arr[i] as visited by making
        // arr[arr[i] - 1] negative. Note that
        // 1 is subtracted because index start
        // from 0 and positive numbers start from 1
        int j = 0;
        for (int i = positiveNumStartIndex; i < A.size(); i++) {
            A.set(j,A.get(i));
            j++;
        }
        for (int i = 0; i < j; i++) {
            if (Math.abs(A.get(i)) - 1 < j && A.get(Math.abs(A.get(i))-1) > 0) {
                A.set(Math.abs(A.get(i))-1, -1 * A.get(Math.abs(A.get(i))-1));
            }
        }

        for (int i =0; i < j; i++) {
            if (A.get(i) > 0 ) {
                return i+1;
            }
        }
        return j + 1;
    }

    private int segregrate(ArrayList<Integer> A) {
        int j = 0, i;
        for(i = 0; i < A.size(); i++)
        {
            if (A.get(i) <= 0)
            {
                int temp;
                temp = A.get(i);
                A.set(i,A.get(j));
                A.set(j,temp);
                j++;
            }
        }
        return j;
    }

    public void takeCustomInput() {
        ArrayList<Integer> testList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numx = scanner.nextInt();
        for (int i = 0; i < numx; i++) {
            testList.add(scanner.nextInt());
        }
        System.out.println(firstMissingPositive(testList));
    }
}
