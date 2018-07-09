package com.company.interviewBit.Level2;

public class ValidNumber {
    public int isNumber(final String A) {

        StringBuilder stringBuilder = new StringBuilder("");

        int i = 0;
        int spaceAfterNum = 0;
        int decimal = 0;
        int eVal = 0;
        int lastCharSpace = 0;
        while (i < A.length()) {
            if (spaceAfterNum > 0) {
                if (isCharacterE(stringBuilder.charAt(stringBuilder.length()-1)) && !isNum(A.charAt(i)) && !(A.charAt(i) == '-' || A.charAt(i) == '+' || A.charAt(i) == '-' || A.charAt(i) == '.')) {
                    return 0;
                }
                if (stringBuilder.length() > 2 && (isCharacterE(A.charAt(stringBuilder.length()-2)) && (A.charAt(i) == '-' || A.charAt(i) == '+') && !isNum(A.charAt(i)) )) {
                    return 0;
                }
            }

            if (isNum(A.charAt(i))) {
                stringBuilder.append(A.charAt(i));
                spaceAfterNum = 1;
                if (lastCharSpace == 1) {
                    return 0;
                }
            }
            else if (A.charAt(i) == ' ') {
                if (spaceAfterNum > 0) {
                    if (!isNum(A.charAt(stringBuilder.length()-1))) {
                        return 0;
                    }
                    lastCharSpace = 1;
                }
            }
            else if (A.charAt(i) == '-' || A.charAt(i) == '+') {
                if (stringBuilder.length() == 0) {
                    stringBuilder.append(A.charAt(i));
                    spaceAfterNum = 1;
                    i++;
                    continue;
                }
                if ((eVal  > 0 && isCharacterE(stringBuilder.charAt(stringBuilder.length()-1)))) {
                    stringBuilder.append(A.charAt(i));
                    i++;
                    continue;
                }
                return 0;
            }
            else if (A.charAt(i) == '.' )  {
                if (stringBuilder.length() == 0) {
                    stringBuilder.append(A.charAt(i));
                    spaceAfterNum = 1;
                    decimal = 1;
                    i++;
                    continue;
                }

                if (eVal > 0) {
                    return 0;
                }

                if (decimal > 0) {
                    return 0;
                }


                stringBuilder.append(A.charAt(i));
                decimal = 1;
            }
            else if (isCharacterE(A.charAt(i))) {
                if (stringBuilder.length() == 0) {
                    return 0;
                }
                else if (eVal == 0 && isNum(stringBuilder.charAt(stringBuilder.length()-1))){
                    stringBuilder.append(A.charAt(i));
                    eVal = 1;
                }
                else {
                    return 0;
                }
            }
            else {
                return 0;
            }
            i++;
        }
        String result = stringBuilder.toString();
        if (result.equals("") || result.equals("+") || result.equals("-")) {
            return 0;
        }
        if (!result.equals("") && i == A.length() && !isNum(result.charAt(stringBuilder.length()-1))) {
            return 0;
        }
        return 1;
    }

    private boolean isCharacterE(char c) {
        if (c == 'e') {
            return true;
        }
        return false;
    }

    public boolean isNum(char a){
        if(a >= '0' && a <= '9')
            return true;
        return false;
    }

    public void input() {
        isNumber(" 123.123 ");
    }

    //1line solution
    public int isNumber2(final String a) {
        return (a.matches("\\s*[\\-\\+]?([0-9]*\\.?)?[0-9]+(e[\\-\\+]?[0-9]+)?\\s*")) ? 1 : 0;
    }
}
