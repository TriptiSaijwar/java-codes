package com.company.interviewBit.Level2;

public class AddBinaryStrings {
    public String addBinary(String A, String B) {
        if (A == null) {
            return B;
        }

        if (B == null) {
            return A;
        }

        int j = B.length()-1;
        int i = A.length()-1;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder("");
        while (i >= 0 && j >= 0) {
            int c = Character.getNumericValue(A.charAt(i)) + Character.getNumericValue(B.charAt(j)) + carry;
            if (c <= 1) {
                stringBuilder.append(c == 1 ? '1' : '0');
                carry = 0;
            }
            else if (c == 2){
                carry = 1;
                stringBuilder.append('0');
            }
            else {
                carry = 1;
                stringBuilder.append('1');
            }
            i--;
            j--;
        }

        while (i >= 0) {
            int c = Character.getNumericValue(A.charAt(i)) + carry;
            if (c <= 1) {
                stringBuilder.append(c == 1 ? '1' : '0');
                carry = 0;
            }
            else {
                carry = 1;
                stringBuilder.append('0');
            }
            i--;
        }

        while (j >= 0) {
            int c = Character.getNumericValue(B.charAt(j)) + carry;
            if (c <= 1) {
                stringBuilder.append(c == 1 ? '1' : '0');
                carry = 0;
            }
            else {
                carry = 1;
                stringBuilder.append('0');
            }
            j--;
        }

        if (carry == 1) {
            stringBuilder.append('1');
        }

        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public void input() {
        addBinary("1010110111001101101000","1000011011000000111100110");
    }
}
