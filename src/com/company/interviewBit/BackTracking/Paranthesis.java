package com.company.interviewBit.BackTracking;

import java.util.ArrayList;

public class Paranthesis {
    public ArrayList<String> generateParenthesis(int a) {
        ArrayList<String> result = new ArrayList<String>();
//        for(int i =1; i <= a; i++)
            Parenth("", 0, 0, a, result, a);

        return result;
    }
    private void Parenth(String output, int open, int close, int pairs, ArrayList<String> result, int a){
        System.out.println("output: " +  output);
        if(open == pairs && close == pairs && output.length() == 2*a){
            System.out.println("\t Adding to result");
            result.add(output);
        }
        else{
            if(open < pairs){
                System.out.println("\t Adding ( ");
                Parenth(output + "(", open + 1, close, pairs, result, a);
            }
            if(close < open){
                System.out.println("\t Adding ) ");
                Parenth(output + ")", open, close + 1, pairs, result, a);
            }
        }
    }

    //Queen
//    https://github.com/nagajyothi/InterviewBit/blob/master/BackTracking/NQueens.java
}
