package com.company.interviewBit.Level3;

import java.util.*;

/**
 * Created by tripti on 15/06/18.
 */

public class SlidingWindowMaximum {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(A.size() - B +1,-1));

        if( A == null || A.size() == 0)
            return result;
        if(B > A.size()){
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < A.size(); i++) {
                if (max < A.get(i)) {
                    max = A.get(i);
                }
            }
            result.add(max);
            return result;
        }

        int i = 0;
        int j = 0;
        while (i < B) {
            while(!deque.isEmpty() && A.get(deque.getLast()) <= A.get(i))
                deque.removeLast();

            deque.addLast(i++);
        }
        result.set(j,A.get(deque.getFirst()));
        j++;

        while (i < A.size()) {
            while(!deque.isEmpty() && A.get(deque.getLast()) <= A.get(i))
                deque.removeLast();
            deque.addLast(i);
            if(!deque.isEmpty() && i-B >= deque.getFirst()){
                deque.removeFirst();
            }
            ++i;
            result.set(j,A.get(deque.getFirst()));
            j++;
        }
        return result;
    }

    public void takeCustomInput() {
        ArrayList<Integer> testList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numx = scanner.nextInt();
        for (int i = 0; i < numx; i++) {
            testList.add(scanner.nextInt());
        }
        scanner.nextLine();
        int x = scanner.nextInt();
        System.out.println(slidingMaximum(testList, x));
    }
}
