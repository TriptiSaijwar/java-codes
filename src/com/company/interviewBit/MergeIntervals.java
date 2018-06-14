package com.company.interviewBit;

import java.util.ArrayList;

/**
 * Created by tripti on 12/06/18.
 */

public class MergeIntervals {
     public class Interval {
       int start;
       int end;
       Interval() { start = 0; end = 0; }
       Interval(int s, int e) { start = s; end = e; }
   }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(newInterval.start > newInterval.end){
            int temp = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = temp;
        }
        int n = intervals.size();
        if(intervals == null || intervals.size() < 1){
            intervals.add(newInterval);
        }
        else if(newInterval.start <= intervals.get(0).start){
            intervals.add(0, newInterval);
        }
        else if(newInterval.start >= intervals.get(n-1).start){
            intervals.add(n, newInterval);
        }
        else{
            for(int i = 0; i < intervals.size()-1; i++){
                if(intervals.get(i).start < newInterval.start && newInterval.start < intervals.get(i+1).start){
                    intervals.add(i+1, newInterval);
                    //flag = 1;
                    break;
                }

            }
        }

        return merge(intervals);
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1)
            return intervals;
        ArrayList<Interval> result = new ArrayList<Interval>();
        Interval prev = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval current = intervals.get(i);
            if(prev.end >= current.start){
                Interval merged = new Interval(prev.start, Math.max(prev.end, current.end));
                prev = merged;
            }
            else{
                result.add(prev);
                prev = current;
            }
        }
        result.add(prev);
        return result;
    }
}
