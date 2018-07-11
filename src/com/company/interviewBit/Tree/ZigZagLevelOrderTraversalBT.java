package com.company.interviewBit.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagLevelOrderTraversalBT {

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

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        if (A == null) {
            return null;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> arr = new ArrayList<>();
            while (!stack1.empty()) {
                TreeNode node = stack1.pop();
                arr.add(node.val);
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
            }
            if (arr.size() != 0) {
                result.add(arr);
            }

            ArrayList<Integer> arr2 = new ArrayList<>();
            while (!stack2.empty()) {
                TreeNode node = stack2.pop();
                arr2.add(node.val);
                if (node.right != null) {
                    stack1.push(node.right);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                }
            }
            if (arr2.size() != 0) {
                result.add(arr2);
            }
        }
        return result;
    }
}
