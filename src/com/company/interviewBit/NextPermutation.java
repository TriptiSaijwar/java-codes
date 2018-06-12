package com.company.interviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tripti on 12/06/18.
 */

public class NextPermutation {
    public void nextPermutation(ArrayList<Integer> a) {
        if (a.size() == 0) {
            return;
        }
        int l=0,p =1;
        for(int i = 0; i < a.size()-1; i++){
            if(a.get(i) < a.get(i+1))
                p = i;
        }
        if (p == -1) {
            Collections.sort(a);
            return;
        }

//        Special test case 1, 3, 2
        for(int i = p+1; i < a.size(); i++){
            if(a.get(i) > a.get(p)){
                l = i;
            }
        }
        int temp = a.get(l);
        a.set(l, a.get(p));
        a.set(p, temp);
        int j = p + 1;
        int last = a.size()-1;
        while(j <= last){
            temp = a.get(j);
            a.set(j, a.get(last));
            a.set(last, temp);
            j++;
            last--;
        }
        return;
    }


    void swapWith(int num, List<Integer> A, int i){
        int min = A.get(i);
        int j = i, index = i;
        for(j = i; j < A.size(); j++){
            if(min > A.get(j) && A.get(j) > A.get(num)){
                index = j;
                min = A.get(j);
            }
        }
        int temp = A.get(index);
        A.set(index, A.get(num));
        A.set(num, temp);
    }


    public void nextPermutationSolution1(ArrayList<Integer> A) {
        if (A.size() == 0 || A.size() == 1) {
            return;
        }

        int flag = 0;

        for (int i = A.size() - 1; i > 0; i--) {
            if (A.get(i) > A.get(i-1)) {
                swapWith(i - 1, A, i);
                Collections.sort(A.subList(i,A.size()));
                flag = 1;
                break;
            }
        }

        if (flag == 0) {
            Collections.sort(A);
        }
    }

    public void takeCustomInput() {
        ArrayList<Integer> testList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numx = scanner.nextInt();
        for (int i = 0; i < numx; i++) {
            testList.add(scanner.nextInt());
        }
        nextPermutation(testList);
    }
}
