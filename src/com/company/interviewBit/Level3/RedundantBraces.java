package com.company.interviewBit.Level3;

import java.util.Stack;

/**
 * Created by tripti on 14/06/18.
 */

public class RedundantBraces {
    //cases to be considered
    //a+b
    //(a)
    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        //considering valid expressions
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(') {
                stack.push(A.charAt(i));
            }
            else if (A.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    if (isOperator(stack.peek())) {
                        while (!stack.isEmpty() && isOperator(stack.peek()))
                        {
                            stack.pop();
                        }
                        if (!stack.isEmpty()) {
                            if (stack.peek() == '(') {
                                stack.pop();
                            }
                        }
                    }
                    else {
                        stack.push(')');
                    }
                }
            }
            else {
                    if (isOperator(A.charAt(i))) {
                        stack.push(A.charAt(i));
                    }
                    else {
                        // do nothing already result push
                    }
            }
        }

        while (!stack.isEmpty() && isOperator(stack.peek()))
        {
            stack.pop();
        }

        if (stack.isEmpty()) {
            return 0;
        }
        return 1;
    }

    boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            return true;
        }
        return false;
    }
}
