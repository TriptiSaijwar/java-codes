package com.company.interviewBit.BackTracking;

import java.util.ArrayList;

public class PalindromePartioning {
    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if(a == null || a.length() == 0)
            return result;

        ArrayList<String> partition = new ArrayList<String>();
        addPalindrome(a, 0, partition, result);

        return result;
    }

    public void addPalindrome(String s, int start, ArrayList<String> partition, ArrayList<ArrayList<String>> result) {
        if(start == s.length()){
            ArrayList<String> temp = new ArrayList<String>(partition);
            result.add(temp);
            return;
        }

        for(int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if(isPalindrome(str)) {
                partition.add(str);
                addPalindrome(s, i, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }


    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;

    }
}
