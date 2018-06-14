package com.company.interviewBit.Level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by tripti on 14/06/18.
 */

public class NearestSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        if (A == null) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(A.size(),-1));

        Stack<Integer> stack = new Stack<>();
        stack.push(A.size()-1);
        for (int i = A.size()-2; i >=0; i--) {
            while (!stack.isEmpty() && A.get(stack.peek()) > A.get(i)) {
                int index = stack.pop();
                result.set(index, A.get(i));
            }
            stack.push(i);
        }
        return result;
    }
}
