package com.company.interviewBit;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tripti on 10/06/18.
 */

public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int A) {
        ArrayList<ArrayList<Integer>>  result = new ArrayList<>();

        for (int i = 1 ; i <= A; i++) {
            int C = 1;
            ArrayList<Integer> lineResult = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                lineResult.add(C);
                C = C * (i - j)/j;
            }
            result.add(lineResult);
        }
        return result;
    }

    public void takeCustomInput() {
        ArrayList<Integer> testList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numx = scanner.nextInt();
        System.out.println(generate(numx));
    }
}
