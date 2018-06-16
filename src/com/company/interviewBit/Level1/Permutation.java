package com.company.interviewBit.Level1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tripti on 12/06/18.
 */

public class Permutation {
    public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        int countOfI = 0, c1 = 0,c2 = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'I') {
                countOfI++;
            }
        }
        c1 = B-countOfI;
        c2 = c1 - 1;
        result.add(c1);
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'I') {
                c1++;
                result.add(c1);
            }
            else {
                result.add(c2);
                c2--;
            }
        }
        return result;
    }

    public void takeCustomInput() {
        ArrayList<Integer> testList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String A = scanner.next();
        int B = scanner.nextInt();
        System.out.println(findPerm(A, B));
    }
}
