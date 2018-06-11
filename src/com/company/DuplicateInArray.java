package com.company;

import java.util.*;

/**
 * Created by tripti on 11/06/18.
 */

public class DuplicateInArray {
    public int repeatedNumber(final List<Integer> a) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            result.add(a.get(i));
        }
        for (int i = 0; i < a.size(); i++)
        {
            if (result.get(Math.abs(result.get(i))) >= 0)
                result.set(Math.abs(result.get(i)),-1 * result.get(Math.abs(result.get(i))));
            else
                return a.get(i);
        }
        return -1;
    }

    public int repeatedNumberInterviewBit1(final List<Integer> a) {
        BitSet b=new BitSet();
        for (int aa:a) {
            if (b.get(aa)) return aa;
            b.set(aa);
        }
        return -1;
    }

    public int repeatedNumberInterviewBit2(final List<Integer> a)
    {
        int[] count = new int[a.size()];
        for(int i=0;i<a.size();i++)
        {
            count[a.get(i)]++;
            if(count[a.get(i)] > 1)
                return a.get(i);
        }
        return -1;
    }

//    c++ solution
//    public int repeatedNumberInterviewBit3(const vector<int> &A) {
//        int i = (A.size()/2)+1;
//        vector<int> T(i, 0);
//
//        for(i = 0; i < A.size(); i++){
//            if((A[i]%2) == 0){
//                if(T[(A[i]/2)-1] == 0){
//                    T[(A[i]/2)-1] = A[i];
//                }
//                else{
//                    return A[i];
//                }
//            }
//        }
//
//        fill(T.begin(), T.end(), 0);
//
//        for(i = 0; i < A.size(); i++){
//            if((A[i]%2) != 0){
//                if(T[A[i]/2] == 0){
//                    T[A[i]/2] = A[i];
//                }
//                else{
//                    return A[i];
//                }
//            }
//        }
//        return -1;
//    }

    public void takeCustomInput() {
        ArrayList<Integer> testList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numx = scanner.nextInt();
        for (int i = 0; i < numx; i++) {
            testList.add(scanner.nextInt());
        }
        System.out.println(repeatedNumber(testList));
    }
}
