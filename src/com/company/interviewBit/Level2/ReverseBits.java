package com.company.interviewBit.Level2;

public class ReverseBits {
    public long reverse(long a) {
        if (a == 0) {
            return 0;
        }
        if (a == 1) {
            return 1;
        }
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < 32; i++) {
            stringBuilder = stringBuilder.append("0");
        }
        int k = 0;
        for (long c = a; c > 0;) {
            if ((1 & c) != 0) {
                count++;
                stringBuilder.setCharAt(k,'1');
            }
            k++;
            c = c >> 1;
        }
//        long result = 0;
//        for(int i= 0;i < stringBuilder.length();i++){
//            if(stringBuilder.charAt(i)=='1') {
//                result+=(long)Math.pow(2, 31-i);
//            }
//        }
        long result = Long.parseLong(stringBuilder.toString(),2);
        return result;
    }
}
