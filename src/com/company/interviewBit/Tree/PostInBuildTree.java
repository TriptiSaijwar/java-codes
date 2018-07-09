package com.company.interviewBit.Tree;

import java.util.ArrayList;

public class PostInBuildTree {
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

    private static int postIndex = 0;

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size() == 0 || B.size() == 0) {
            return null;
        }
        int size = A.size() - 1;
        postIndex = B.size() - 1;
        return buildTreeNode(A, B, 0, size);
    }

    private TreeNode buildTreeNode(ArrayList<Integer> A, ArrayList<Integer> B, int left, int right) {
        if (right < left) {
            return null;
        }

        TreeNode node = new TreeNode(B.get(postIndex--));

        if (right == left) {
            return node;
        }

        int index = A.indexOf(node.val);

        node.right = buildTreeNode(A, B, index + 1, right);
        node.left = buildTreeNode(A, B, left, index - 1);

        return node;
    }
}
