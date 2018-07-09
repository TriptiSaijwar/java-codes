package com.company.interviewBit.Level2;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Collections.binarySearch;

public class MatrixMedian {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int row = A.size();
        int column = A.get(0).size();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int numOfElements = row*column;

        int desired = (numOfElements + 1)/2;

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i).get(0) < min) {
                min = A.get(i).get(0);
            }

            if (A.get(i).get(column-1) > max) {
                max = A.get(i).get(column-1);
            }
        }


        while (min < max) {
            int mid = min + (max - min)/2;
            int place = 0;
            int get = 0;

            for (int i = 0; i < A.size(); i++) {
                get = Collections.binarySearch(A.get(i),mid);

                if (get < 0) {
                    get = Math.abs(get) - 1;
                }
                else {
                while(get < column && A.get(i).get(get) == mid)
                        get += 1;
                }
                place = place + get;
            }

            if (place < desired) {
                min = mid + 1;
            }
            else {
                max = mid;
            }
        }
        return min;
    }

    public void input() {
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(3);
        row1.add(5);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(2);
        row2.add(6);
        row2.add(9);

        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(3);
        row3.add(6);
        row3.add(9);
        array.add(row1);
        array.add(row2);
        array.add(row3);
        findMedian(array);
    }
}
