package com.company.interviewBit.Tree;

public class LeastCommonAncestor {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    public int lca(TreeNode A, int B, int C) {
        boolean v1 = find(A,B);
        boolean v2 = find(A,C);
        if (v1 && v2) {
            return findLca(A,B,C);
        }
        return -1;
    }

    private boolean find(TreeNode A, int C) {
        if (A == null) {
            return false;
        }

        if (A.val == C) {
            return true;
        }

        return find(A.left,C) || find(A.right,C);

    }

    public int findLca(TreeNode A, int B, int C) {
        if (A == null)
            return -1;

        if (A.val == B || A.val == C)
            return A.val;

        int left_lca = findLca(A.left, B, C);
        int right_lca = findLca(A.right, B, C);

        if (left_lca!=-1 && right_lca!=-1)
            return A.val;

        return (left_lca != -1) ? left_lca : right_lca;
    }
}
