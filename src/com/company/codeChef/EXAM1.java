package com.company.codeChef;

import java.util.Scanner;

public class EXAM1 {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        Integer testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++ ) {
            Integer questions = scanner.nextInt();
            String answers = scanner.next();
            String answersByChef = scanner.next();
            int score = 0;
            for (int j = 0; j < questions;) {
                if (answersByChef.charAt(j) == 'N') {
                    j += 1;
                    continue;
                }
                if(answers.charAt(j) == answersByChef.charAt(j)){
                    score++;
                    j += 1;
                } else {
                    j += 2;
                }
            }
            System.out.println(score);
        }
    }
}
