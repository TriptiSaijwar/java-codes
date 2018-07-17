package com.company.interviewBit.Tree;

import java.util.ArrayList;

public class RootToLeafPathWithSum {

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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        if (A ==  null) {
            return null;
        }
        result = new ArrayList<>();
        int path[] = new int[getHeight(A)];
        path(A, path, B, 0);
        return result;
    }

    public void path(TreeNode A, int[] path, int B, int pathLen) {
        if (A == null) {
            return;
        }
        int sum = B - A.val;
        path[pathLen] = A.val;
        pathLen++;

        if (sum == 0 && A.left == null && A.right == null) {
            saveResult(path, pathLen);
        }
        else {
            path(A.left,path,sum, pathLen);
            path(A.right,path,sum, pathLen);
        }
    }

    public void saveResult(int[] path, int size) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(path[i]);
        }
        result.add(arr);
    }

    int getHeight(TreeNode A) {
        if (A == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(A.left),getHeight(A.right));
    }
}
