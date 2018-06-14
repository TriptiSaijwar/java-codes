package com.company.interviewBit.Level3;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by tripti on 13/06/18.
 */

public class KthSmallestElement {
    public int kthsmallest(final List<Integer> A, int B) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < B; i++) {
            queue.offer(A.get(i));
        }
        for (int i = B; i < A.size(); i++) {
            if (queue.peek() > A.get(i)) {
                queue.poll();
                queue.offer(A.get(i));
            }
        }
        return queue.peek();
//        smart Solution without constant space.
//        if (k > A.size())
//            return -1;
//        returns element not index.
//        int lo = *min_element(A.begin(), A.end());
//        int hi = *max_element(A.begin(), A.end());
//
//        while (lo <= hi)
//        {
//            int mid = lo + (hi - lo)/2;
//            int countLess = 0, countEqual = 0;
//
//            for (auto i = 0; i<A.size(); ++i)
//            {
//                if (A[i]<mid)
//                    ++countLess;
//                else if (A[i] == mid)
//                    ++countEqual;
//                if (countLess >= k)
//                    break;
//            }
//
//            if (countLess < k && countLess + countEqual >= k)
//                return mid;
//            else if (countLess >= k)
//                hi = mid - 1;
//            else
//                lo = mid + 1;
//        }
//        return -1;

    }

    public void takeCustomInput() {
        ArrayList<Integer> testList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numx = scanner.nextInt();
        for (int i = 0; i < numx; i++) {
            testList.add(scanner.nextInt());
        }
        int B = scanner.nextInt();
        System.out.println(kthsmallest(testList,B));
    }
}
