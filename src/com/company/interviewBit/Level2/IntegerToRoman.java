package com.company.interviewBit.Level2;

public class IntegerToRoman {
    public String intToRoman(int A) {
        StringBuilder stringBuilder = new StringBuilder("");
        int num = A;
        while (num > 0 ) {
            if (num >= 1000) {
                int loop = num/1000;
                while (loop > 0) {
                    stringBuilder.append('M');
                    loop--;
                }
                num = num % 1000;
            }
            else if (num >= 500) {
                if (num < 900) {
                    int loop = num/500;
                    while (loop > 0) {
                        stringBuilder.append('D');
                        loop--;
                    }
                    num = num % 500;
                }
                else {
                    stringBuilder.append('C');
                    stringBuilder.append('M');
                    num = num % 100;
                }

            }
            else if (num >= 100) {
                if (num < 400) {
                    int loop = num/100;
                    while (loop > 0) {
                        stringBuilder.append('C');
                        loop--;
                    }
                    num = num % 100;
                }
                else {
                    stringBuilder.append('C');
                    stringBuilder.append('D');
                    num = num % 100;
                }
            }
            else if (num >= 50) {
                if (num < 90) {
                    int loop = num/50;
                    while (loop > 0) {
                        stringBuilder.append('L');
                        loop--;
                    }
                    num = num % 50;
                }
                else {
                    stringBuilder.append('X');
                    stringBuilder.append('C');
                    num = num % 10;
                }
            }
            else if (num >= 10) {
                if (num < 40) {
                    int loop = num/10;
                    while (loop > 0) {
                        stringBuilder.append('X');
                        loop--;
                    }
                    num = num % 10;
                }
                else {
                    stringBuilder.append('X');
                    stringBuilder.append('L');
                    num = num % 10;
                }
            }
            else if (num >= 5) {
                if (num < 9) {
                    int loop = num/5;
                    while (loop > 0) {
                        stringBuilder.append('V');
                        loop--;
                    }
                    num = num % 5;
                }
                else {
                    stringBuilder.append('I');
                    stringBuilder.append('X');
                    num = 0;
                }
            }
            else if (num >= 1) {
                if (num < 4) {
                    int loop = num;
                    while (loop > 0) {
                        stringBuilder.append('I');
                        loop--;
                    }
                }
                else {
                    stringBuilder.append('I');
                    stringBuilder.append('V');
                }
                num = 0;
            }
        }
        return stringBuilder.toString();
    }
}
