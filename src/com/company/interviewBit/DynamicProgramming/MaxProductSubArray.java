package com.company.interviewBit.DynamicProgramming;

import java.util.List;

public class MaxProductSubArray {
    // Consider when element is zero
    public int maxProduct(final List<Integer> A) {
        if (A.size() == 0) {
            return 0;
        }
        if (A.size() == 1) {
            return A.get(0);
        }
        int n = A.size();
        int max_ending_here = 1;
        int min_ending_here = 1;
        int max_so_far = 0;
        for (int i = 0; i < n; i++)
        {
            if (A.get(i) > 0)
            {
                max_ending_here = max_ending_here*A.get(i);
                min_ending_here = min_ending_here * A.get(i);
                if (max_ending_here > max_so_far) {
                    max_so_far = max_ending_here;
                }
            }
            else if (A.get(i) == 0)
            {
                max_ending_here = 1;
                min_ending_here = 1;
            }
            else
            {
                int temp = max_ending_here;
                if (min_ending_here * A.get(i) > temp) {
                    max_ending_here = min_ending_here * A.get(i);
                    if (max_ending_here > max_so_far) {
                        max_so_far = max_ending_here;
                    }
                }
                else {
                    max_ending_here = 1;
                }
                min_ending_here = temp * A.get(i);
            }
        }

        return max_so_far;
    }
}
