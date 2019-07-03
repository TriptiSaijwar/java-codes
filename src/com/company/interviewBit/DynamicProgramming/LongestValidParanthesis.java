package com.company.interviewBit.DynamicProgramming;

import java.util.Arrays;
import java.util.Stack;




public class LongestValidParanthesis {

//    public int seats(String s){
//        int maxConsecutive = 0;
//        int consecutiveEndingAt = -1;
//        int i=0;
//        while(i<s.length()){
//            int j=i;
//            while (s.charAt(j) == '.'){
//                j++;
//            }
//        }
//    }


    public int longestValidParentheses(String A) {
        if (A == null || A.length() == 0) {
            return 0;
        }

        int opB = -1;
        int len = 0;
        int[] memo = new int[A.length()];
        Stack<Integer> stack = new Stack();
        Arrays.fill(memo,0);
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(') {
                stack.push(i);
            }
            else if (!stack.isEmpty()) {
                int dis = (i - stack.peek()) + 1;
                memo[i] = dis;
                if (i - dis >= 0) {
                    memo[i] += memo[i-dis];
                }
                len = Math.max(len,memo[i]);
                stack.pop();
            }
        }
        return len;

    }
}
