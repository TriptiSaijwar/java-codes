package com.company.interviewBit.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PopulateNextRightPointersTree {
    public class TreeLinkNode {
       int val;
       TreeLinkNode left, right, next;
       TreeLinkNode(int x) { val = x; }
   }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<ArrayList<TreeLinkNode>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;
            ArrayList<TreeLinkNode> arr = new ArrayList<>();
            while (i < size) {
                TreeLinkNode node = queue.poll();
                arr.add(node);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                i++;
            }
            if (arr.size() != 0) {
                arr.add(null);
                result.add(arr);
            }
        }
        for (ArrayList<TreeLinkNode> t : result) {
            for(int i = 1; i < t.size(); i++) {
                t.get(i-1).next = t.get(i);
            }
        }
    }

    public void connect1(TreeLinkNode root) {
        if(root==null) return;
        Queue<TreeLinkNode> queue=new LinkedList<TreeLinkNode>();
        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty())
        {
            TreeLinkNode curr=queue.poll();
            if(curr!=null)
            {
                //Get the next element in current level and set it as next right to curr element
                curr.next=queue.peek();
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            else
            {
                if(!queue.isEmpty()) queue.offer(null);
            }
        }
    }
}
