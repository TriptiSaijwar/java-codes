package com.company.interviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by tripti on 10/06/18.
 */

public class TripletSumBetweenGivenRange {
    public int solve(ArrayList<String> A) {
        if (A.size() == 0) {
            return 0;
        }
        ArrayList<Double> list = new ArrayList<>();
        A.stream().forEach(x -> {
                Double d = Double.valueOf(x);
                list.add(d);
        });
        double first = list.get(0);
        double second = list.get(1);
        double third = list.get(2);

        for(int i = 3; i < A.size(); i ++){
            // check if sum fall in (1, 2)
            if((first+second+third) > 1 && (first+second+third) < 2){
                return 1;
            }
            // if not, then check is sum greater then 2
            // if so, then replece MAX(a,b,c) to new number
            else if((first+second+third) >= 2){
                if(first > second && first > third){
                    first = list.get(i);
                }
                else if( second > third){
                    second = list.get(i);
                }
                else{
                    third = list.get(i);
                }
            }
            // else then sum must be less than 1
            // then replece MIN(a,b,c) to new number
            else{
                if(first < second && first < second){
                    first = list.get(i);
                }
                else if( second < third){
                    second = list.get(i);
                }
                else{
                    third = list.get(i);
                }
            }
        }
        // check for last a, b, c  pair
        if((first+second+third) > 1 && (first+second+third) < 2){
            return 1;
        }
        else{
            return 0;
        }
    }

    public void takeCustomInput() {
        ArrayList<String> testList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numx = scanner.nextInt();
        for (int i = 0; i < numx; i++) {
            testList.add(scanner.next());
        }
        System.out.println(solve(testList));
    }
}
