package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by tripti on 10/06/18.
 */

public class WaveArray {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        for (int i = 1; i < A.size();i = i + 2) {
            int temp = A.get(i-1);
            A.set(i-1,A.get(i));
            A.set(i,temp);
        }
        return A;
    }
}
