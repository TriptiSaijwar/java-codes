package com.company.interviewBit.Tree;

import java.util.ArrayList;

public class SumRoottoLeafNumbers {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }
    ArrayList<ArrayList<Integer>> result;
    long sum;
    public int sumNumbers(TreeNode A) {
        if (A ==  null) {
            return 0;
        }
        result = new ArrayList<>();
        sum = 0L;
        int path[] = new int[getHeight(A)];
        path(A, path, 0);
        return (int)sum % 1003;
    }

    private void path(TreeNode A, int[] path, int pathLen) {
        if (A == null) {
            return;
        }
        path[pathLen] = A.val;
        pathLen++;

        if (A.left == null && A.right == null) {
            saveResult(path, pathLen);
        }
        else {
            path(A.left,path, pathLen);
            path(A.right,path, pathLen);
        }
    }

    public void saveResult(int[] path, int size) {
        long res = 0;
        for (int i = 0; i < size; i++) {
            res = res*10 + path[i];
            res = res % 1003;
        }
        sum = (sum + res) % 1003;
    }

    int getHeight(TreeNode A) {
        if (A == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(A.left),getHeight(A.right));
    }
}
