package com.company.interviewBit.Level2;

import java.util.StringTokenizer;

public class CompareVersionNumbers {
    public int compareVersion(String A, String B) {
        StringTokenizer stringTokenizerA = new StringTokenizer(A,".");
        StringTokenizer stringTokenizerB = new StringTokenizer(B,".");
        int i = 0;
        int j = 0;
        while (stringTokenizerA.hasMoreTokens() && stringTokenizerB.hasMoreTokens()) {
            String strA = stringTokenizerA.nextToken().replaceAll("^0+(?!$)", "");
            String strB = stringTokenizerB.nextToken().replaceAll("^0+(?!$)", "");
            if (compareString(strA,strB) < 0) {
                return -1;
            }
            else if (compareString(strA,strB) > 0) {
                return 1;
            }
            i++;
            j++;
        }

        while (stringTokenizerA.hasMoreTokens()) {
            String str = stringTokenizerA.nextToken().replaceAll("^0+(?!$)", "");
            if (!str.equals("0")) {
                return 1;
            }
        }

        while (stringTokenizerB.hasMoreTokens()) {
            String str = stringTokenizerB.nextToken().replaceAll("^0+(?!$)", "");
            if (!str.equals("0")) {
                return -1;
            }
        }

        return 0;
    }

    int compareString(String a, String b) {
        if (a.length() > b.length()) {
            return 1;
        }
        else if (a.length() < b.length()) {
            return -1;
        }
        return a.compareTo(b);
    }



    public void input() {
        compareVersion("4444371174137455","5.168");
    }
}
