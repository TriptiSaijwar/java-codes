package com.company.interviewBit.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder1 {
    public int ladderLength(String start, String end, ArrayList<String> dictV) {
        int len = dictV.size();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        int startIdx = 0, endIdx = 0;
        for(int i = 0; i < len; i++) {
            adjList.add(new ArrayList<Integer>());
            if (dictV.get(i).equals(start)) startIdx = i;
            if (dictV.get(i).equals(end)) endIdx = i;
        }
        if (startIdx == endIdx) return 1;
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                if (connects(dictV.get(i), dictV.get(j))) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] size = new int[len];
        size[startIdx] = 1;
        queue.add(startIdx);
        while(queue.peek() != null) {
            int idx = queue.poll().intValue();
            int nextSize = size[idx]+1;
            ArrayList<Integer> list = adjList.get(idx);
            int conLen = list.size();
            for(int i = 0; i < conLen; i++) {
                int next = list.get(i).intValue();
                if (size[next] != 0) continue;
                if (next == endIdx) return nextSize;
                size[next] = nextSize;
                queue.add(next);
            }
        }
        return 0;
    }

    private boolean connects(String s1, String s2) {
        boolean found = false;
        int len = s1.length();
        for(int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (found) return false;
                found = true;
            }
        }
        return found;
    }

    public void input(){
        ArrayList<String> dict = new ArrayList<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("hit");
        dict.add("cog");
        ladderLength("hit","cog",dict);
    }
}
