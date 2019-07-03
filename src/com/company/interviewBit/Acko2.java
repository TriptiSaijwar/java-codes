package com.company.interviewBit;

import java.util.HashMap;
import java.util.Map;

public class Acko2 {
    static Map<Character,Integer> map = new HashMap<>();


    static long getFactorial(long n){
        if (n == 0)
            return 1l;
        else
            return(n * getFactorial(n-1));
    }


    static long findSimilar(String a, String b){
        if (isNumbersSimilar(a,b)){
            return getSimilarNumbers(a);
        }else {
            return getSimilarNumbers(b);
        }

    }

    static long getSimilarNumbers(String s){
        int countOfZeros = 0;
        Map<Character,Long> countMap = new HashMap<>();
        int sLength = s.length();
        for (int i=0;i<sLength;i++){
            if (s.charAt(i) == '0'){
                countOfZeros++;
            }
            if (countMap.containsKey(s.charAt(i))){
                long count = countMap.get(s.charAt(i));
                count++;
                countMap.put(s.charAt(i),count);
            }else{
                countMap.put(s.charAt(i),1l);
            }
        }
        long ans = getFactorial(sLength);
        for (long val : countMap.values()){
            ans = ans / getFactorial(val);
        }
        if (countOfZeros == 0){
            return ans;
        }else {
            long noWithZeroStart = ans;
            noWithZeroStart = noWithZeroStart * countOfZeros;
            noWithZeroStart = noWithZeroStart/sLength;
            return ans - noWithZeroStart;
        }
    }

    static boolean isNumbersSimilar(String a, String b){
        if (a.length() != b.length()){
            return false;
        }
        for(int i=0;i<a.length();i++){
            if (map.containsKey(a.charAt(i))){
                int count = map.get(a.charAt(i));
                count++;
                map.put(a.charAt(i),count);
            }else{
                map.put(a.charAt(i),1);
            }
        }
        for (int j=0;j<b.length();j++){
            if (!map.containsKey(b.charAt(j))){
                return false;
            }else {
                int count = map.get(b.charAt(j));
                count--;
                if (count < 0){
                    return false;
                }
                map.put(b.charAt(j),count);
            }
        }

        for(int i=0;i<a.length();i++){
            if (!map.containsKey(a.charAt(i))){
                return false;
            }else {
                if (map.get(a.charAt(i)) != 0){
                    return false;
                }
            }
        }
        return true;
    }

}
