package com.company.GoogleInterviewQuestions;

public class CircleCutChord {

    static int chordCnt(int A)
    {

        // n = no of points required
        int n = 2 * A;

        // dp array containing the sum
        int[] dpArray = new int[n + 1];
        dpArray[0] = 1;
        dpArray[2] = 1;
        for (int i = 4; i <= n; i += 2) {
            for (int j = 0; j < i - 1; j += 2)
            {
                dpArray[i] += (dpArray[j] *
                        dpArray[i - 2 - j]);
            }
        }

        // returning the required number
        return dpArray[n];
    }
}
