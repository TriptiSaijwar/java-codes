package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tripti on 08/06/18.
 */

public class Flip {
    public ArrayList<Integer> flip(String A) {

        int countOfZero = 0;
        int countOfOne = 1;
        int maxDiff = 0;
        int leftIndex = -1, rightIndex = -1;
        int left = 0,right = 0;


        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '0') countOfZero++;
            if (A.charAt(i) == '1') countOfOne++;

            if (countOfZero - countOfOne < 0) {
                left = i + 1;
                right = i + 1;
                countOfOne = 0;
                countOfZero = 0;
            }
            else {
                if (countOfZero - countOfOne > maxDiff) {
                    maxDiff = countOfZero - countOfOne;
                    leftIndex = left;
                    rightIndex = right;
                }
                right++;
            }
        }
        ArrayList<Integer> result = new ArrayList<>(2);
        if (leftIndex >= 0 ) {
            result.add(leftIndex + 1);
            result.add(rightIndex + 1);
        }
        return result;
    }

    public void takeCustomInput() {
        Scanner scanner = new Scanner(System.in);
        String testString = scanner.nextLine();
        System.out.println(flip(testString));
    }
}
