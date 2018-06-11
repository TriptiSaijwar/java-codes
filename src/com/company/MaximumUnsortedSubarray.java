package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tripti on 11/06/18.
 */

public class MaximumUnsortedSubarray {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int s = 0,i,e = 0;
        for (i = 0; i < A.size()-1; i++) {
            if (A.get(i+1) < A.get(i)) {
                s = i;
                break;
            }
        }

        if (i == A.size()-1) {
            result.add(-1);
            return result;
        }

        for (i = A.size()-1; i > 0; i--) {
            if (A.get(i-1) > A.get(i)) {
                e = i;
                break;
            }
        }

        if (i == 0) {
            return A;
        }
        int min = A.get(s);
        int max = A.get(s);
        for (i = s+1; i <= e; i++) {
            if (A.get(i) < min) {
                min = A.get(i);
            }
            if (A.get(i) > max) {
                max = A.get(i);
            }
        }
        for (i = 0; i <= s-1; i++) {
            if (A.get(i) > min) {
                s = i;
                break;
            }
        }

        for (i = A.size()-1 ; i >= e+1; i-- ) {
            if (A.get(i) < max) {
                e = i;
                break;
            }
        }

        result.add(s);
        result.add(e);

        return result;
    }

    public void takeCustomInput() {
        ArrayList<Integer> testList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numx = scanner.nextInt();
        for (int i = 0; i < numx; i++) {
            testList.add(scanner.nextInt());
        }
        System.out.println(subUnsort(testList));
    }
}
