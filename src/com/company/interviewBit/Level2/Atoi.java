package com.company.interviewBit.Level2;

public class Atoi {

    public int atoi(final String A) {
        StringBuilder stringBuilder = new StringBuilder("");

        int i = 0;
        int spaceAfterNum = 0;
        while (i < A.length()) {
            if (isNum(A.charAt(i))) {
                stringBuilder.append(A.charAt(i));
                spaceAfterNum = 1;
            }
            else if (A.charAt(i) == ' ') {
                if (spaceAfterNum > 0) {
                    break;
                }
            }
            else if (A.charAt(i) == '-' || A.charAt(i) == '+') {
                if (stringBuilder.length() == 0) {
                    stringBuilder.append(A.charAt(i));
                    spaceAfterNum = 1;
                }
                else {
                    break;
                }
            }
            else {
                break;
            }
            i++;
        }
        String result = stringBuilder.toString().replaceAll("^0*", "");
        if (result.equals("") || result.equals("+") || result.equals("-")) {
            return 0;
        }
        if (Double.parseDouble(result) > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (Double.parseDouble(result) < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return Integer.parseInt(result);
    }

    public boolean isNum(char a){
        if(a >= '0' && a <= '9')
            return true;
        return false;
    }
}
