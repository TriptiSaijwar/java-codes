package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tripti on 11/06/18.
 */

public class RotateMatrix {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        if(a == null)
            return;

        if(a.size() == 0)
            return;

        int layers = a.size()/2;
        int size = a.size();
        for (int i = 0; i < layers; i++) {
            int first = i;
            int last = size - i - 1;
            for (int j = first; j < last; j++) {
                int offset = j-i;
                int top = a.get(first).get(j);

                a.get(first).set(j, a.get(last-offset).get(first)); // topleft = bottomleft
                a.get(last-offset).set(first, a.get(last).get(last-offset));//bottomleft = bottomright
                a.get(last).set(last-offset, a.get(j).get(last));//bottomright = topright;
                a.get(j).set(last, top);
            }
        }
    }

    public void takeCustomInput() {
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        int k;

        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        for (int i = 0; i < row; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                arr.add(scanner.nextInt());
            }
            array.add(arr);
        }
        rotate(array);
    }
}
