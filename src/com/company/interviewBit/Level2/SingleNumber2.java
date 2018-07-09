package com.company.interviewBit.Level2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SingleNumber2 {
    public int singleNumber(final List<Integer> A) {
        int res = 0;
        int l = A.size();
        for(int i=0; i<32; i++){
            int x = 1<<i;
            int one = 0;
            for(int j=0; j<l; j++){
                if((A.get(j) & x)!=0){
                    one++;
                }
            }
            if(one%3==1){
                res = res | x;
            }
        }
        return res;

    }
}
