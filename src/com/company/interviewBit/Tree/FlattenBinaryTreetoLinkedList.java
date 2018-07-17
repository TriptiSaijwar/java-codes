package com.company.interviewBit.Tree;

public class FlattenBinaryTreetoLinkedList {
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

//    public TreeNode flatten(TreeNode a) {
//        if (a == null) {
//            return null;
//        }
//        if (a.left != null) {
//            flatten(a.left);
//            TreeNode node = a.right;
//            a.right = a.left;
//            a.left = null;
//
//            TreeNode t = a.right;
//            while (t.right != null)
//                t = t.right;
//
//            t.right = node;
//        }
//        flatten(a.right);
//        return a;
//    }

    public TreeNode flatten(TreeNode a) {
        return flat(a);
    }

    public TreeNode flat(TreeNode root) {
        if(root ==null){
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left=null;
        flat(left);
        flat(right);

        root.right=left;
        TreeNode current = root;
        while(current.right !=null) current = current.right;
        current.right =right;


        return root;

    }

    public void flatten1(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                if (cur.right != null) { // if we need to prune a right subtree
                    TreeNode next = cur.left;
                    while (next.right != null) next = next.right;
                    next.right = cur.right;
                }
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

}
