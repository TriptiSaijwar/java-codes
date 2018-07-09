package com.company.interviewBit.Tree;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {
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

    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList();
        if (A == null) {
            return result;
        }
        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();
        TreeNode current = A;
        stack1.push(current);
        while (!stack1.isEmpty()) {
            current = stack1.pop();
            stack2.push(current);
            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }
        while (!stack2.isEmpty()){
            current = stack2.pop();
            result.add(current.val);
        }
        return result;
    }

    //Single stack

//    ArrayList<Integer> postOrderIterative(Node node)
//    {
//        Stack<Node> S = new Stack<Node>();
//
//        // Check for empty tree
//        if (node == null)
//            return list;
//        S.push(node);
//        Node prev = null;
//        while (!S.isEmpty())
//        {
//            Node current = S.peek();
//
//            /* go down the tree in search of a leaf an if so process it
//            and pop stack otherwise move down */
//            if (prev == null || prev.left == current ||
//                    prev.right == current)
//            {
//                if (current.left != null)
//                    S.push(current.left);
//                else if (current.right != null)
//                    S.push(current.right);
//                else
//                {
//                    S.pop();
//                    list.add(current.data);
//                }
//
//                /* go up the tree from left node, if the child is right
//                   push it onto stack otherwise process parent and pop
//                   stack */
//            }
//            else if (current.left == prev)
//            {
//                if (current.right != null)
//                    S.push(current.right);
//                else
//                {
//                    S.pop();
//                    list.add(current.data);
//                }
//
//                /* go up the tree from right node and after coming back
//                 from right node process parent and pop stack */
//            }
//            else if (current.right == prev)
//            {
//                S.pop();
//                list.add(current.data);
//            }
//
//            prev = current;
//        }
//
//        return list;
//    }
}
