package com.company.interviewBit.DynamicProgramming;

import java.util.ArrayList;

public class MaxRectangleinBinaryMatrix {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        if (A.size() == 0) return 0;
        int[][] dp = new int[A.size()][A.get(0).size()];
        int maxRec = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int num = A.get(i).get(j);
                if (i == 0) dp[i][j] = num == 1 ? 1 : 0;
                else dp[i][j] = num == 1 ? dp[i-1][j] + 1 : 0;
                int col = j, width = dp[i][j];
                while (col >= 0 && dp[i][col] > 0) {
                    width = Math.min(width, dp[i][col]);
                    maxRec = Math.max(maxRec, width * (j - col + 1));
                    col--;
                }
            }
        }
        return maxRec;
    }
}
