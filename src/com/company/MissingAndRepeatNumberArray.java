package com.company;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tripti on 08/06/18.
 */

public class MissingAndRepeatNumberArray {
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();

        int x = 0,y = 0;
        int xor = 0;
        int countDouble1 = 0, countDouble2 = 0;

        for (int i = 0;i < A.size(); i++) {
            xor = xor^A.get(i);
        }
        for (int i = 1;i <= A.size(); i++) {
            xor = xor^i;
        }
        int set_bit_no = xor & ~(xor - 1);

        for (int i = 0;i < A.size(); i++) {
            if ((A.get(i) & set_bit_no) > 0) {
                x = x^A.get(i);
            }
            else {
                y = y^A.get(i);
            }
        }
        for (int i = 1;i <= A.size(); i++) {
            if ((i & set_bit_no) > 0) {
                x = x^i;
            }
            else {
                y = y^i;
            }
        }

        for (int i = 0;i < A.size(); i++) {
            if (A.get(i) == x) {
                countDouble1++;
            }
            else if (A.get(i) == y) {
                countDouble2++;
            }
        }
        if (countDouble1 == 2) {
            result.add(x);
            result.add(y);
        }
        else {
            result.add(y);
            result.add(x);
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
        System.out.println(repeatedNumber(testList));
    }
}
