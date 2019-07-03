package com.company.interviewBit;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Acko {
    // Complete the longestChain function below.
    static int longestChain(List<String> words) {
        int answer = Integer.MIN_VALUE;
        for (String word : words) {
            int current = traverseWord(word,words);
            // System.out.println(" =>  " + current);
            if (answer < current) {
                answer = current;
            }
        }
        return answer;
    }


    static int traverseWord(String wrd, List<String> words) {
        if (wrd.length() == 1) {
            return 1;
        }

        Stack<String> stack = new Stack<>();
        stack.push(wrd);

        int startIndex = 0;
        int endIndex = 1;

        while (!stack.isEmpty()) {
            String current = stack.peek();

            if (endIndex > current.length()) {
                if (!words.contains(stack.peek())) {
                    stack.pop();
                    break;
                }
                else {
                    break;
                }
            }

            if (words.contains(current)) {
                StringBuilder strBuilder = new StringBuilder(current);
                strBuilder.delete(startIndex,endIndex);
                stack.add(strBuilder.toString());
                // startIndex = 0;
                // endIndex = 1;
            }
            else {
                stack.pop();
                startIndex++;
                endIndex++;
            }
        }
        return stack.size();
    }

    public void input() {
        List<String> words = new ArrayList<>();
        words.add("a");
        words.add("zxb");
        words.add("ba");
        words.add("bca");
        words.add("bda");
        words.add("bdca");
        words.add("zxbe");
        words.add("azxbe");
        words.add("azxpbe");
        System.out.println(longestChain(words));
    }

}
