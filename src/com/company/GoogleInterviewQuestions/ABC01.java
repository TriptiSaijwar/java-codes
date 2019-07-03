package com.company.GoogleInterviewQuestions;

public class ABC01 {

    public void printABC01(String string) {
        if (string.length() == 0 || string == null) {
            return;
        }
        char arr[] = string.toCharArray();
        printSequesnce(arr, 0, string.length());
    }

    private void printSequesnce(char[] arr, int i, int length) {
        if (i == length) {
            System.out.println(arr);
            return;
        }

        if (arr[i] == '?') {
            arr[i] = '0';
            printSequesnce(arr, i+1, length);
            arr[i] = '1';
            printSequesnce(arr, i+1, length);
            arr[i] = '?';
        }
        else {
            printSequesnce(arr, i+1, length);
        }
    }

    public void input() {
        printABC01("a?b?c?");
        printABC01("??");
    }
}
