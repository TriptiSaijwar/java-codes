package com.company.interviewBit.GreedyAlgorithms;

public class Seats {
    public int seats(String a) {
        int i = findMedian(a.toCharArray());
        if(i == -1)
            return 0;
        return shift(a.toCharArray(), i);
    }

    public static int findMedian(char[] s){
        int count1 = 0;
        for(int i = 0; i <s.length; i++){
            if(s[i] == 'x')
                count1++;
        }
        if(count1 == 0)
            return -1;

        count1 = (count1 + 1)/2;
        int count2 = 0;
        for(int i = 0; i <s.length; i++){
            if(s[i] == 'x'){
                count2++;
                if(count2 == count1)
                    return i;
            }
        }
        return -1;

    }

    public static int shift(char[] s, int i){
        int l = i;
        int ans = 0;
        while (l >= 0 && s[l] == 'x') {
            l--;
        }
        int r = i;
        while (r < s.length && s[r] == 'x') {
            r++;
        }
        int start = 0;
        while (start < l) {
            if (s[start] == '.') {
                start++;
            }
            else {
                s[l] = s[start];
                s[start] = '.';
                ans = ans + (l-start);
                ans = ans % 10000003;
                l--;
                start++;
                while (s[l] == 'x' && l >= 0) {
                    l--;
                }
            }
        }

        int end = s.length-1;
        while (end > r) {
            if (s[end] == '.') {
                end--;
            }
            else {
                s[r] = s[end];
                s[end] = '.';
                ans = ans + (end-r);
                ans = ans % 10000003;
                r++;
                end--;
                while (s[r] == 'x' && r < s.length) {
                    r++;
                }
            }
        }
        return ans;
    }
}
