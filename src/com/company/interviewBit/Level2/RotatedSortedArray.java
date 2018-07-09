package com.company.interviewBit.Level2;

import java.util.List;

public class RotatedSortedArray {
    public int search(final List<Integer> a, int b) {
        int pivot = findPivot(a,0,a.size()-1);

        if (pivot == -1) {
            return binarySearch(a,0,a.size()-1,b);
        }

        if (a.get(pivot) == b) {
            return pivot;
        }
        if (a.get(0) <= b ) {
            return binarySearch(a,0,pivot-1,b);
        }
        else  {
            return binarySearch(a,pivot,a.size()-1,b);
        }

    }

    public int findPivot(List<Integer> a, int start, int end) {
        if (end < start) {
            return -1;
        }
        if (start == end) {
            return start;
        }
        int mid = start + (end - start)/2;

        if (mid < end && a.get(mid) > a.get(mid+1)) {
            return mid;
        }
        if(mid > start && a.get(mid-1)>a.get(mid)) {
            return mid-1;
        }

        if(a.get(mid) <= a.get(start)) {
            return findPivot(a,start,mid-1);
        }
        else {
            return findPivot(a,mid+1,end);
        }

    }

    public int binarySearch(List<Integer> a, int start, int end,int b) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start)/2;
        if (a.get(mid) ==  b) {
            return mid;
        }
        if (b < a.get(mid)) {
            return binarySearch(a,0,mid-1,b);
        }
        else {
            return binarySearch(a,mid+1,end,b);
        }
    }

    public int binarySearchSinglePass(List<Integer> a, int l, int h,int key) {
        if (l > h)
            return -1;

        int mid = (l+h)/2;
        if (a.get(mid) == key)
            return mid;

        /* If arr[l...mid] is sorted */
        if (a.get(l) <= a.get(mid))
        {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= a.get(l) && key <= a.get(mid))
                return binarySearch(a, l, mid-1, key);

            return binarySearch(a, mid+1, h, key);
        }

        /* If arr[l..mid] is not sorted,
           then arr[mid... r] must be sorted*/
        if (key >= a.get(mid) && key <= a.get(h))
            return binarySearch(a, mid+1, h, key);

        return binarySearch(a, l, mid-1, key);
    }
}
