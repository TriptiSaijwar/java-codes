package com.company.interviewBit.Graph;

import java.util.ArrayList;

public class BlackSheeps {
    public int black(ArrayList<String> A) {
        if (A == null && A.size() == 0 ) {
            return 0;
        }
        int row = A.size();
        int col = A.get(0).length();
        boolean visited[][] = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A.get(i).charAt(j) == 'X') {
                    visited[i][j] = false;
                }
                else {
                    visited[i][j] = true;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j]) {
                    ans++;
                    dfs(visited, A, i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(boolean[][] visited,ArrayList<String> A, int i, int j) {
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        int indexi[] = {0,0,-1,1};
        int indexj[] = {-1,1,0,0};
        for (int k = 0; k < 4; k++) {
            if (!(i+indexi[k] < 0 || i+indexi[k] >= A.size() || j+indexj[k] < 0 || j+indexj[k] >= A.get(0).length())) {
                if (!visited[i+indexi[k]][j+indexj[k]]) {
                    dfs(visited, A, i+indexi[k], j+indexj[k]);
                }
            }
        }
    }
}
