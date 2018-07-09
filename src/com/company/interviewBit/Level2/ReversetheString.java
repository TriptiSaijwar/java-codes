package com.company.interviewBit.Level2;

public class ReversetheString {
    StringBuilder stringBuilder;
    public String reverseWords(String a) {
        if (a == null || a.isEmpty()) {
            return null;
        }
        int startOfWord = -1;
        int endOfWord = -1;
        stringBuilder = new StringBuilder(a);

        if (a.charAt(0) != ' ') {
            startOfWord = 0;
        }

        int i = 1;
        while (i < stringBuilder.length()){
            if (stringBuilder.charAt(i) == ' ' && isCharacter(stringBuilder.charAt(i-1))) {
                endOfWord = i-1;
                reverse(startOfWord,endOfWord);
            }
            else if (stringBuilder.charAt(i) == ' ' && stringBuilder.charAt(i-1) == ' ') {
                startOfWord = -1;
                stringBuilder.deleteCharAt(i);
                continue;
            }
            else if (stringBuilder.charAt(i-1) == ' ' && isCharacter(stringBuilder.charAt(i))) {
                startOfWord = i;
            }
            i++;
        }
        if (startOfWord != -1) {
            reverse(startOfWord,stringBuilder.length()-1);
        }

        if (stringBuilder.charAt(stringBuilder.length()-1) == ' ') {
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

        if (stringBuilder.length() != 0 && stringBuilder.charAt(0) == ' ') {
            stringBuilder.deleteCharAt(0);
        }

        reverse(0,stringBuilder.length()-1);

        return stringBuilder.toString();
    }

    private void reverse(int startOfWord, int endOfWord) {
        int l = startOfWord;
        int r = endOfWord;
        while (l < r) {
            char temp = stringBuilder.charAt(l);
            stringBuilder.setCharAt(l,stringBuilder.charAt(r));
            stringBuilder.setCharAt(r,temp);
            l++;
            r--;
        }
    }

    boolean isCharacter(char c) {
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }

    public void input() {
        reverseWords("   ");
    }
}
