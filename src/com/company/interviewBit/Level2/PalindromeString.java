package com.company.interviewBit.Level2;

public class PalindromeString {
    public int isPalindrome(String A) {
        int l = 0;
        int r = A.length()-1;
        while (l < r) {
            while (l < A.length() && !isAlphanumericCharacter(A.charAt(l))) {
                l++;
            }

            while (r >= 0 && !isAlphanumericCharacter(A.charAt(r))) {
                r--;
            }

            if (!isSame(A.charAt(l),A.charAt(r))) {
                return 0;
            }
            l++;
            r--;
        }

        return 1;
    }

    boolean isAlphanumericCharacter(char c) {
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || isNum(c)) {
            return true;
        }
        return false;
    }

    public boolean isNum(char a){
        if(a >= '0' && a <= '9')
            return true;
        return false;
    }

    public boolean isSame(char a, char b){
        if(isNum(a) && isNum(b)){
            return a == b;
        }
        else if(Character.toLowerCase(a) == Character.toLowerCase(b)){
            return true;
        }
        else{
            return false;
        }
    }

    public void input() {
        String str = "A man, a plan, a canal: Panama";
        isPalindrome(str);
    }
}
