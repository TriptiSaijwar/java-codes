package com.company.interviewBit.GreedyAlgorithms;

import java.util.List;

public class GasStation {
    class station {
        int cost;
        int gas;

        station(int gas, int cost) {
            this.cost = cost;
            this.gas = gas;
        }
    }

        public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
            if (A == null || B == null || A.size() == 0 || B.size() == 0) {
                return -1;
            }
            station[] s = new station[A.size()];
            for (int i = 0; i < A.size(); i++) {
                s[i] = new station(A.get(i),B.get(i));
            }
            int n = A.size();
            int start = 0;
            int remaining = s[start].gas - s[start].cost;
            int end = 1;
            while (start != end || remaining < 0) {
                while(remaining < 0 && start != end)
                {
                    // Remove starting petrol pump. Change start
                    remaining -= s[start].gas - s[start].cost;
                    start = (start + 1) % n;

                    // If 0 is being considered as start again, then there is no
                    // possible solution
                    if(start == 0)
                        return -1;
                }
                // Add a petrol pump to current tour
                remaining += s[end].gas - s[end].cost;

                end = (end + 1)%n;
            }
            return start;
        }
}
