package com.company.interviewBit.Level3;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by tripti on 14/06/18.
 */

public class SimplifyDirectoryPath {
    public String simplifyPath(String A) {
        Stack<String> stack = new Stack();

        while(A.length() > 0 && A.charAt(A.length() - 1) == '/')
            A = A.substring(0, A.length()-1);

        int start = 0;
        for (int i = 1; i < A.length(); i++) {
            if (A.charAt(i) == '/') {
                stack.push(A.substring(start,i));
                start = i;
            }
            else if (i == A.length()-1) {
                stack.push(A.substring(start));
            }
        }

        ArrayList<String> result = new ArrayList<>();
        int back = 0;
        while(!stack.isEmpty()){
            String top = stack.pop();
            if(top.equals("/.") || top.equals("/")){
                //do nothing in the same directory
            }
            else if(top.equals("/.."))
                back++;
            else {
                if(back > 0)
                    back--;
                else
                    result.add(top);
            }

        }

        if(result.isEmpty())
            return "/";

        StringBuilder sb = new StringBuilder();
        for (int i = result.size()-1; i >= 0; i--){
            sb.append(result.get(i));
            //System.out.println(sb.toString());
        }
        return sb.toString();
    }
}
