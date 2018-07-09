package com.company.interviewBit.Tree;

import java.util.ArrayList;

public class PreInOrderBuildTree {
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
    private static int preIndex = 0;
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size() == 0 || B.size() == 0) {
            return null;
        }
        int size = A.size() - 1;
        preIndex = 0;
        //A = preOrder
        //B = Inorder
        return buildTreeNode(A, B, 0 , size);
    }

    private TreeNode buildTreeNode(ArrayList<Integer> A, ArrayList<Integer> B, int left, int right) {
        if (right < left) {
            return null;
        }

        TreeNode node = new TreeNode(A.get(preIndex++));

        if (right == left) {
            return node;
        }

        int index = searchIndex(B, left, right, node.val);

        node.left = buildTreeNode(A, B, left, index-1);
        node.right = buildTreeNode(A, B, index+1, right);

        return node;
    }

    private int searchIndex(ArrayList<Integer> B, int left, int right, int data) {
        int index = -1;
        for (int i = left; i <= right; i++) {
            if (B.get(i) == data) {
                return i;
            }
        }
        return index;
    }
}
