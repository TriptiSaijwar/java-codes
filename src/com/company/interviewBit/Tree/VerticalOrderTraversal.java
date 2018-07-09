package com.company.interviewBit.Tree;

import java.util.*;

public class VerticalOrderTraversal {
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

    class Values {
        int min;
        int max;
    }

    ArrayList<ArrayList<Integer>> result;
    Values val;

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        result = new ArrayList<>();
        val = new Values();
        findMinMaxWidthOfTree(A,val,val,0);
        int k = 0;
        for (int i = val.min; i <= val.max; i++) {
            ArrayList<Integer> level = new ArrayList<>();
            result.add(level);
            printVerticalOrderTraversal(A,i,0,k);
            k++;
        }
        return result;
    }

    private void printVerticalOrderTraversal(TreeNode A, int widthLevel, int currentWidth, int arrayIndex) {
        if (A == null) {
            return;
        }

        if (currentWidth  == widthLevel) {
            result.get(arrayIndex).add(A.val);
        }

        printVerticalOrderTraversal(A.left,widthLevel,currentWidth - 1,arrayIndex);
        printVerticalOrderTraversal(A.right,widthLevel,currentWidth + 1,arrayIndex);
    }

    private void findMinMaxWidthOfTree(TreeNode A, Values min, Values max, int widthLevel) {
        if (A == null) {
            return;
        }

        if (widthLevel < min.min) {
            min.min = widthLevel;
        }
        else if (widthLevel > max.max) {
            max.max = widthLevel;
        }

        findMinMaxWidthOfTree(A.left,min,max,widthLevel-1);
        findMinMaxWidthOfTree(A.right,min,max,widthLevel+1);

    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal2(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(A == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> levelNodeMap = new HashMap<>();
        Queue<Integer> levels = new LinkedList<Integer>();
        queue.offer(A);
        levels.offer(0);
        Integer minLevel=0;
        Integer maxLevel=0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            Integer level = levels.poll();
            minLevel = Math.min(level, minLevel);
            maxLevel = Math.max(maxLevel, level);

            if(!levelNodeMap.containsKey(level)){
                levelNodeMap.put(level, new ArrayList<Integer>());
            }
            levelNodeMap.get(level).add(node.val);
            if(node.left != null) {
                queue.offer(node.left);
                levels.offer(level - 1);
            }
            if(node.right != null) {
                queue.offer(node.right);
                levels.offer(level + 1);
            }

        }
        for(int level = minLevel; level <= maxLevel; ++level){
            if(levelNodeMap.containsKey(level)){
                result.add(levelNodeMap.get(level));
            }
        }
        return result;
    }


}
