package com.company.interviewBit.Level6.DynamicProgramming;

import java.util.Arrays;

public class Ways2Decode {

    public int numDecodings(String A) {
        if (A==null||A.length()==0){
            return 0;
        }

        // declare ways array with two extra space, because ways[i] also affect by ways[i+2]
        int[] ways=new int[A.length()+2];


        Arrays.fill(ways, 1);
        int i=A.length()-1;

        ways[i]=A.charAt(i)=='0'?0:1;

        for (i=i-1; i>=0; i--){
            if (A.charAt(i)=='0'){
                // if current digit is '0', so no mater what right is, current ways should be 0;
                ways[i]=0;
            }
            else{
                // if current digit is not '0', current ways should be ways[i+1]
                // because, for example s="12", i=0, ways[1]=1, then because current digit is not zero, so for
                // each situation of when i=1, the current i=0 should  be a valid way,
                ways[i]=ways[i+1];


                // check is current digit with right 1 digit can be a valid situation,so in this situation only s.charAt(i)=='1'||
                // s.charAt(i)=='2' and s.charAt(i+1)<='6' can be valid situation, the ways[i] should + ways[i+2];

                if (i+2<ways.length && A.charAt(i)=='1'||A.charAt(i)=='2' && A.charAt(i+1)<='6'){
                    ways[i]+=ways[i+2];
                }
            }
        }

        return ways[0];

    }
}
