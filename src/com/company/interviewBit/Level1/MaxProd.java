package com.company.interviewBit.Level1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MaxProd {
    public int maxSpecialProduct(ArrayList<Integer> A) {
        if (A.size() == 0 || A == null || A.size() == 1) {
            return 0;
        }

        int left[] = new int[A.size()];
        int right[] = new int[A.size()];
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        int n = A.size();
        for(int i = 1; i < n; i++){
            while(!q.isEmpty()){
                if(A.get(q.getLast()) > A.get(i)) break;
                q.removeLast();
            }
            left[i] = (q.isEmpty()) ? 0 : q.getLast();
            q.addLast(i);
        }
        q = new ArrayDeque<>();
        q.addLast(n - 1);
        for(int i = n - 2; i >= 0; i--){
            while(!q.isEmpty()){
                if(A.get(q.getLast()) > A.get(i)) break;
                q.removeLast();
            }
            right[i] = (q.isEmpty()) ? 0 : q.getLast();
            q.addLast(i);
        }
        long result = 0;
        for (int i = 0;i < A.size(); i++) {
            long answer = ((long)left[i]*(long)right[i])%1000000007;
            if (result < answer) {
                result = answer;
            }
        }
        return (int)result;
    }

    public void input() {
        ArrayList<Integer> test = new ArrayList<>();
//        5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9
        test.add(5);
        test.add(9);
        test.add(6);
        test.add(8);test.add(6);test.add(4);test.add(6);
        test.add(9);test.add(5);test.add(4);test.add(9);
        maxSpecialProduct(test);


    }
}
