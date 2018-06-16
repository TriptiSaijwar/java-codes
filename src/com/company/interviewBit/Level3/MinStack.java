package com.company.interviewBit.Level3;

import java.util.Stack;

/**
 * Created by tripti on 15/06/18.
 */

public class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> stack;

    MinStack() {
        minStack = new Stack<Integer>();
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            minStack.push(x);
        }
        else {
            stack.push(x);
            int y = minStack.peek();
            if (x < y) {
                minStack.push(x);
            }
            else {
                minStack.push(y);
            }
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        else {
            return -1;
        }
    }

    public int getMin() {
        if (!stack.isEmpty()) {
            return minStack.peek();
        }
        else {
            return -1;
        }
    }

    public void print() {
        System.out.println(stack);
        System.out.println(minStack);
        System.out.println("----------");
    }
}
