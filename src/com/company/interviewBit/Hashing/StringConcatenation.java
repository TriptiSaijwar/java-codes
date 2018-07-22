package com.company.interviewBit.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringConcatenation {
    public ArrayList<Integer> findSubstring(String A, final List<String> B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(B.size() == 0 || A == null || B == null || A.length() == 0)
            return result;

        char[] array = A.toCharArray();
        int length = array.length;

        int num = B.size() * B.get(0).length();
        int strLength = B.get(0).length();


        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < B.size(); i++){
            if(map.containsKey(B.get(i)))
                map.put(B.get(i), map.get(B.get(i)) +  1);
            else
                map.put(B.get(i), 1);
        }



        for(int i = 0; i <= length - num; i++){ // length of string - sum of all lengths in list
            HashMap<String, Integer> tempMap = (HashMap<String, Integer>)map.clone();
            for(int j = 0; j < B.size(); j++){
                String str = A.substring(i + j * strLength, i + (j + 1) * strLength);
                if(!tempMap.containsKey(str)){
                    break;
                }
                else if(tempMap.get(str) > 1){
                    tempMap.put(str, tempMap.get(str) -  1);
                }
                else if(tempMap.get(str) == 1){
                    tempMap.remove(str);
                }
            }
            if(tempMap.isEmpty())
                result.add(i);
        }
        return result;
    }
}
