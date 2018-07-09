package com.company.interviewBit.Level2;

import java.util.ArrayList;

public class MaxContinuousSeriesOfOne {

    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int N = A.size();
        int i = 0;
        int j = 0;
        int max_len = 0;
        int cnt = 0;
        ArrayList<Integer> result = new ArrayList<>();

        int ans_start = 0;
        int ans_end = 0;

        while(i < N) {
            if(cnt + ((A.get(i) == 0) ? 1 : 0) > B) {
                int temp_len = (i - j); // length from j to i - 1.
                if(temp_len > max_len) {
                    max_len = temp_len;
                    ans_start = j;
                    ans_end = i - 1;
                }

                while(i >= j && cnt + ((A.get(i) == 0) ? 1 : 0) > B) {
                    cnt -= ((A.get(j) == 0) ? 1 : 0);
                    j++;
                }
                cnt += ((A.get(i) == 0) ? 1 : 0);
            } else {
                cnt +=((A.get(i) == 0) ? 1 : 0);
            }

            i++;
        }

        int temp_len = (i - j);
        if(temp_len > max_len) {
            temp_len = max_len;
            ans_start = j;
            ans_end = i - 1;
        }

        for (int ele = ans_start; ele <= ans_end; ele++) {
            result.add(ele);
        }
        return result;
    }
}
