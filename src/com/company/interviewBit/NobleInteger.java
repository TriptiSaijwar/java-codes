package com.company.interviewBit;

import java.util.*;

/**
 * Created by tripti on 10/06/18.
 */

public class NobleInteger {
    public int solve(ArrayList<Integer> A) {
        if (A.size() == 0) {
            return -1;
        }

        Collections.sort(A); //increasing order
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) ==  A.get(i-1)) {
                continue;
            }
            else {
                if (A.size()-1-(i-1) == A.get(i-1)) {
                    return 1;
                }
            }
        }

        if (A.get(A.size()-1) == 0) {
            return 1;
        }

        return -1;
    }

    public void takeCustomInput() {
        ArrayList<Integer> testList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numx = scanner.nextInt();
        for (int i = 0; i < numx; i++) {
            testList.add(scanner.nextInt());
        }
        System.out.println(solve(testList));
    }
}
