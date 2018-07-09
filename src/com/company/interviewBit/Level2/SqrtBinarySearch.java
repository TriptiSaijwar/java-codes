package com.company.interviewBit.Level2;

public class SqrtBinarySearch {

    public int sqrt(int A) {
        long i = 0;
        long j = A / 2 + 1;
        while(i <= j){
            long mid = (i + j) / 2;
            if(mid *  mid == A)
                return (int)mid;
            if(mid *  mid < A)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return (int)j;
    }

    public int binarySearchSqrt(int A) {
       return (int)binarySearchSqrtUtil(A,0,(A/2 + 1));
    }

    public long binarySearchSqrtUtil(int A,long start,long end) {
        if (end < start) {
            return end;
        }
        long mid = start + (end - start)/2;
        if (mid * mid == A) {
            return mid;
        }

        if (mid * mid < A) {
            return binarySearchSqrtUtil(A,mid + 1,end);
        }
        else {
            return binarySearchSqrtUtil(A,start,mid-1);
        }
    }

    public void input() {
        sqrt(11);
    }
}
