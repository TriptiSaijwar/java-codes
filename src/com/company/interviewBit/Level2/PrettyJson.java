package com.company.interviewBit.Level2;

import java.util.ArrayList;

public class PrettyJson {
    public ArrayList<String> prettyJSON(String A) {
        if (A == null ) {
            return null;
        }

        if (A.charAt(0) == '{' || A.charAt(0) == '[' ) {
            int noOfIdentations = 0;
            ArrayList<StringBuilder> res = new ArrayList<>();
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) == ' ') {
                    continue;
                }
                if (A.charAt(i) == '{' || A.charAt(i) == '[') {
                    if (res.size() != 0 && res.get(res.size()-1).charAt(res.get(res.size()-1).length()-1) == '\t') {
                        res.get(res.size()-1).append(A.charAt(i));
                    }
                    else {
                        StringBuilder str = new StringBuilder("");
                        int idt = noOfIdentations;
                        while (idt > 0) {
                            str.append('\t');
                            idt--;
                        }
                        str.append(A.charAt(i));
                        res.add(str);
                    }
                    noOfIdentations++;
                    StringBuilder str1 = new StringBuilder("");
                    int idt1 = noOfIdentations;
                    while (idt1 > 0) {
                        str1.append('\t');
                        idt1--;
                    }
                    res.add(str1);
                } else if (A.charAt(i) == '}' || A.charAt(i) == ']') {
                    StringBuilder str = new StringBuilder("");
                    noOfIdentations--;
                    int idt = noOfIdentations;
                    while (idt > 0) {
                        str.append('\t');
                        idt--;
                    }
                    str.append(A.charAt(i));
                    res.add(str);
                } else if (A.charAt(i) == ',') {
                    res.get(res.size() - 1).append(A.charAt(i));
                    StringBuilder str = new StringBuilder("");
                    int idt1 = noOfIdentations;
                    while (idt1 > 0) {
                        str.append('\t');
                        idt1--;
                    }
                    res.add(str);
                } else {
                    res.get(res.size() - 1).append(A.charAt(i));
                }
            }

            ArrayList<String> result = new ArrayList<>();
            for (StringBuilder t : res) {
                result.add(t.toString());
            }
            return result;
        }
        return null;
    }

     public void input() {
        prettyJSON("[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]");
    }
}
