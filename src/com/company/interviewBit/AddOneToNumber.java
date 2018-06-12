package com.company.interviewBit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by tripti on 03/06/18.
 */

public class AddOneToNumber {
    public ArrayList<Integer> addOneToNumerList(ArrayList<Integer> A) {
        int sizeA = A.size();
        int carry = 1;
        int i = sizeA - 1, j;
        ArrayList<Integer> result = new ArrayList<>();
        for(; i >= 0; i--) {
            if (A.get(i) == 9) {
                result.add(0);
                continue;
            }
            else {
                carry = 0;
                break;
            }
        }
        if(i == -1 && carry == 1) {
            result.add(1);
        }
        else {
            result.add(A.get(i) + 1);
            for (j = 0; j < A.size(); j++ ) {
                if (A.get(j) != 0) {
                    break;
                }
            }
            for (int k = i-1; k >= j; k-- ) {
                result.add(A.get(k));
            }
        }
        Collections.reverse(result);
        return result;
    }

    public void takeCustomInput() {
        ArrayList<Integer> testList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numx = scanner.nextInt();
        for (int i = 0; i < numx; i++) {
            testList.add(scanner.nextInt());
        }
        System.out.println(addOneToNumerList(testList));
    }
}
