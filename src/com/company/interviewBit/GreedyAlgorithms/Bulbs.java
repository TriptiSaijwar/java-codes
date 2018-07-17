package com.company.interviewBit.GreedyAlgorithms;

import java.util.ArrayList;

public class Bulbs {
    public int bulbs(ArrayList<Integer> A) {
        int ways = 0;
        for (int i : A) {
            if (i == 1) {
                if (ways % 2 == 1) {
                    ways = ways + 1;
                }
            }
            else {
                if (ways % 2 == 0) {
                    ways = ways + 1;
                }
            }
        }
        return ways;
    }
}
