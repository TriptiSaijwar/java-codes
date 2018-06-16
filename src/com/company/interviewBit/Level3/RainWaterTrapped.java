package com.company.interviewBit.Level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tripti on 15/06/18.
 */

public class RainWaterTrapped {
    public int trap(final List<Integer> A) {
        int result = 0;
        if (A == null || A.size() <= 2) {
            return result;
        }

        ArrayList<Integer> left = new ArrayList<>(Collections.nCopies(A.size(),0));
        ArrayList<Integer> right = new ArrayList<>(Collections.nCopies(A.size(),0));

        int max = A.get(0);
        left.set(0,max);
        for(int i = 1; i < A.size(); i++){
            if(A.get(i) < max)
                left.set(i,max);
            else{
                max = A.get(i);
                left.set(i,max);
            }

        }

        //scan from right to left to find max
        max = A.get(A.size() -1 );
        right.set(A.size() - 1,max);
        for(int i = A.size() - 2; i >= 0; i--){
            if(A.get(i) < max)
                right.set(i,max);
            else{
                max = A.get(i);
                right.set(i,max);
            }
        }

        for(int i = 0; i < A.size(); i++){
            result += Math.min(left.get(i), right.get(i)) - A.get(i);
        }

        return result;
    }
}
