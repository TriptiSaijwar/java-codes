package com.company.interviewBit.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;

public class LetterPhone {

    HashMap<Character,ArrayList<Character>> map;
    public LetterPhone() {
        map = new HashMap<>();
        ArrayList<Character> res0 = new ArrayList<>();
        res0.add('0');
        map.put('0',res0);
        ArrayList<Character> res1 = new ArrayList<>();
        res1.add('1');
        map.put('1',res1);
        ArrayList<Character> res2 = new ArrayList<>();
        res2.add('a');
        res2.add('b');
        res2.add('c');
        map.put('2',res2);
        ArrayList<Character> res3 = new ArrayList<>();
        res3.add('d');
        res3.add('e');
        res3.add('f');
        map.put('3',res3);
        ArrayList<Character> res4 = new ArrayList<>();
        res4.add('g');
        res4.add('h');
        res4.add('i');
        map.put('4',res4);
        ArrayList<Character> res5 = new ArrayList<>();
        res5.add('j');
        res5.add('k');
        res5.add('l');
        map.put('5',res5);
        ArrayList<Character> res6 = new ArrayList<>();
        res6.add('m');
        res6.add('n');
        res6.add('o');
        map.put('6',res6);
        ArrayList<Character> res7 = new ArrayList<>();
        res7.add('p');
        res7.add('q');
        res7.add('r');
        res7.add('s');
        map.put('7',res7);
        ArrayList<Character> res8 = new ArrayList<>();
        res8.add('t');
        res8.add('u');
        res8.add('v');
        map.put('8',res8);
        ArrayList<Character> res9 = new ArrayList<>();
        res9.add('w');
        res9.add('x');
        res9.add('y');
        res9.add('z');
        map.put('9',res9);
    }

    public ArrayList<String> letterCombinations(String A) {
        ArrayList<String> output = new ArrayList<>();
        ArrayList<ArrayList<Character>> dictionary = new ArrayList<ArrayList<Character>>();
        for (int i = 0; i < A.length(); i++) {
            dictionary.add(map.get(A.charAt(i)));
        }
        StringBuilder temp = new StringBuilder("");
        generate(output,dictionary,A.length(),0,temp);
        return output;
    }

    private void generate(ArrayList<String> output, ArrayList<ArrayList<Character>> dictionary, int length, int index,StringBuilder temp) {
        if (index == length) {
            output.add(new String(temp));
            return;
        }

        for (int i = 0; i < dictionary.get(index).size() && index < length; i++) {
            temp.append(dictionary.get(index).get(i));
            generate(output,dictionary,length,index+1,temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
