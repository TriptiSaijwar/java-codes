package com.company.interviewBit.Level6.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestAreaRectanglePermutations {
    //without permutation;
    public int solve(ArrayList<ArrayList<Integer>> A) {
        if (A.size() == 0) {
            return 0;
        }
        int m = A.size();
        int n = A.get(0).size();
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i],0);
            for (int j = 0; j < n; j++) {
                if (A.get(i).get(j) == 1) {
                    dp[i][j] = (i == 0) ? 1 : dp[i-1][j] + 1;
                }
            }
        }

        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            maxArea = Math.max(maxArea,histogram(dp[i]));
        }
//       with permutation
//        int res=0;
//        for(int i=0;i<m;i++){
//            int count[]=new int[m+1];
//
//            for(int j=0;j<n;j++){
//                count[hist[i][j]]++;
//            }
//            int cnt=0;
//            for(int k=m;k>=0;k--){
//                cnt += count[k];
//                res = Math.max(res, cnt * k);
//            }
//
//
//        }
        return maxArea;
    }

    private int histogram(int[] ints) {
        int i = 0;
        Stack<Integer> stack = new Stack();
        int area = 0;
        while (i < ints.length) {
            if (stack.empty() || ints[i] >= ints[stack.peek()]) {
                stack.push(i);
                i++;
            }
            else {
                int top = stack.peek();
                stack.pop();
                area = Math.max(area,ints[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }

        while(!stack.isEmpty()){
            int height = ints[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() -1;
            area = Math.max(area, height * width);
        }
        return area;
    }
}
