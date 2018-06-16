package com.company.interviewBit.Level3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by tripti on 15/06/18.
 */

public class EvaluateExpression {
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < A.size(); i++) {
            if (!isOperator(A.get(i))) {
                stack.push(Integer.valueOf(A.get(i)));
            }
            else {
                int op1 = stack.pop();
                int op2 = stack.pop();
                if (A.get(i).equals("+")) {
                    stack.push(op2 + op1);
                }
                else if (A.get(i).equals("-")) {
                    stack.push(op2 - op1);
                }
                else if (A.get(i).equals("*")) {
                    stack.push(op2 * op1);
                }
                else if (A.get(i).equals("/")){
                    stack.push(op2 / op1);
                }
            }
        }
        return stack.pop();
    }

    boolean isOperator(String c) {
        if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
            return true;
        }
        return false;
    }

    public void takeCustomInput() {
        ArrayList<String> testList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numx = scanner.nextInt();
        for (int i = 0; i < numx; i++) {
            testList.add(scanner.next());
        }
        System.out.println(evalRPN(testList));
    }
}
