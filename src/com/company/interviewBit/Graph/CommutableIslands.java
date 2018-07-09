package com.company.interviewBit.Graph;

import java.util.*;

public class CommutableIslands {
    //krushkal Algo + union find
    private Deque<Edge> mst = new ArrayDeque<>();

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(List<Integer> e : B){
            pq.add(new Edge(e.get(0), e.get(1), e.get(2)));
        }

        UnionFind uf = new UnionFind(A+1);

        while (!pq.isEmpty() && mst.size() < A) {
            Edge e = pq.poll();
            int v = e.v, w = e.w;
            if (!uf.connected(v, w)) {
                uf.connect(v, w);
                mst.addLast(e);
            }
        }

        int result = 0;
        for(Edge e : mst){
            result += e.weight;
        }
        return result;

    }

    private class Edge implements Comparable<Edge>{
        int v,w,weight;

        public Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge that) {
            return this.weight - that.weight;
        }
    }

    private class UnionFind {

        private final int[] id;
        private int[] sz;

        public UnionFind(int n) {
            id = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        public boolean connected(int v, int w) {
            return root(v) == root(w);
        }

        public void connect(int v, int w) {
            int i = root(v);
            int j = root(w);
            if(sz[i] < sz[j]){
                id[i] = j; sz[j] +=sz[i];
            }else {
                id[j] = i; sz[i] +=sz[j];
            }
        }

        private int root(int i) {
            while (i != id[i]){
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }


    }
}
