package com.company.interviewBit.Tree;

import java.util.ArrayList;

public class BuildTreeCartesian {

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

    public TreeNode buildTree(ArrayList<Integer> A) {
        if (A.size() == 0) {
            return null;
        }
        TreeNode node = null;
        int size = A.size() - 1;
        return buildTreeNode(node, A, 0 , size);
    }

    private TreeNode buildTreeNode(TreeNode node, ArrayList<Integer> A, int left, int right) {
        if (right < left) {
            return null;
        }

        if (right == left) {
            return (new TreeNode(A.get(left)));
        }

        int index = getMaxIndex(A,left,right);

        node = new TreeNode(A.get(index));

        node.left = buildTreeNode(node, A, left, index-1);
        node.right = buildTreeNode(node, A, index+1, right);

        return node;

    }

    private int getMaxIndex(ArrayList<Integer> A, int left, int right) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = left; i <= right; i++ ) {
            if (A.get(i) > max) {
                max = A.get(i);
                index = i;
            }
        }
        return index;
    }

    public void input() {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        buildTree(array);
    }

}
