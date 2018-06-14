package com.company.interviewBit.Level3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by tripti on 14/06/18.
 */

public class GenerateallParentheses {
    public int isValid(String A) {
        if (A.length() == 0 || A.length() == 1) {
            return 0;
        }
        char c[] = A.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            if (c[i] == '(' || c[i] == '{' || c[i] == '[') {
                stack.push(c[i]);
            }
            else  {
                if (!stack.isEmpty()) {
                    if ((c[i] == ')' && stack.peek() == '(') || (c[i] == '}' && stack.peek() == '{' )|| (c[i] == ']' && stack.peek() == '[' )) {
                        stack.pop();
                    }
                    else {
                        return 0;
                    }
                }
                else {
                    return 0;
                }
            }
        }

        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }

    public void takeCustomInput() {
        ArrayList<Integer> testList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(isValid(str));
    }
}
