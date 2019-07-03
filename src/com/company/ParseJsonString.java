package com.company;

import javafx.beans.binding.ObjectExpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class ParseJsonString {

    class MyException extends Exception
    {
        public MyException(String s)
        {
            // Call constructor of parent Exception
            super(s);
        }
    }

    public static char STRING_START = '"';
    public static char STRING_END = '"';
    public static char LIST_BEGIN = '[';
    public static char  LIST_END = ']';
    public static char LIST_DELIMITER =',';
    public static char DICT_DELIMITER = ',';
    public static char DICT_COLON = ':';
    public static char DICT_SYMBOL = ':';
    public static char DICT_BEGIN = '{';
    public static char DICT_END = '}';
    public static char WHITESPACE = ' ';
    public static char  NEWLINE = '\n';

//    public Object[] parse(String string) {
//        Object res[] =  new Object[2];
//        String str = string;
////        while (str != null && str.length() > 0) {
//            if (str.charAt(0) ==  STRING_START) {
////                res = parse_string(str);
////                str = (String) res[1];
//                return parse_string(string);
//            }
//            else if (str.charAt(0) ==  LIST_BEGIN) {
////                res = parse_list(str);
////                str = (String) res[1];
//                return parse_list(string);
//            }
//            else if (str.charAt(0) ==  DICT_BEGIN) {
////                res = parse_dict(str);
////                str = (String) res[1];
//                return parse_dict(string);
//            }
//            else if (isDigit(str.charAt(0))) {
////                res = parse_number(str);
////                str = (String) res[1];
//                return parse_number(string);
//            }
//            else {
//                System.out.println("ParserException Invalid Token" + str);
//                return null;
//            }
////        }
//    }

    public ArrayList<Object> parse(String string) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '[' || string.charAt(i) == '{' ) {
                stack.push(string.charAt(i));
            }
            else if (string.charAt(i) == ']' || string.charAt(i) == '}') {
                if (stack.isEmpty()) {
                    //Exception
                    return null;
                }
                else if (string.charAt(i) == ']' && stack.peek() != '[' || string.charAt(i) == '}' && stack.peek() != '{' ) {
                    //Exception
                    return null;
                }
                else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            return parse2(string);
        }
        else {
            System.out.println("ParserException Invalid Token" + string);
            return null;
        }
//        return parse2(string);
    }


    public ArrayList<Object> parse2(String string) {
        ArrayList<Object> result = new ArrayList<>();
        Object res[] =  new Object[2];
        String str = string;
        while (str != null && str.length() > 0) {
            if (str.charAt(0) ==  WHITESPACE) {
                str = str.substring(1);
            }
            else if (isCharacter(str.charAt(0))) {
                res = parse_string(str);
                str = (String) res[1];
                result.add(res[0]);
            }
            else if (str.charAt(0) ==  STRING_START) {
                res = parse_string(str);
                str = (String) res[1];
                result.add(res[0]);
            }
            else if (str.charAt(0) ==  LIST_BEGIN) {
                result.add(parse2(str.substring(1)));
                String substring = str.substring(1);
                int i = 0 ;
                while (substring.charAt(i) != LIST_END) {
                    i++;
                    continue;
                }
                str = substring.substring(i+1);
            }
            else if (str.charAt(0) == LIST_DELIMITER) {
                str = str.substring(1);
            }
            else if (str.charAt(0) == LIST_END) {
                return result;
            }
            else if (str.charAt(0) == DICT_BEGIN) {
                ArrayList<Object> dict = parse2(str.substring(1));
                HashMap<Object,Object> map = new HashMap<>();
                for (int i = 0; i < dict.size()-1; i = i+2) {
                    map.put(dict.get(i),dict.get(i+1));
                }
                result.add(map);
                String substring = str.substring(1);
                int i = 0 ;
                while (substring.charAt(i) != DICT_END) {
                    i++;
                    continue;
                }
                str = substring.substring(i+1);
            }
            else if (str.charAt(0) == DICT_COLON){
                str = str.substring(1);
            }
            else if (str.charAt(0) == DICT_END){
                return result;
            }
            else if (isDigit(str.charAt(0))) {
                res = parse_number(str);
                str = (String) res[1];
                result.add(res[0]);
            }
            else {
                //Exception
                System.out.println("ParserException Invalid Token" + string);
//                throw new MyException("ParserException Invalid Token" + str);
                result.add(str);
                str = null;
            }
        }
        return result;
    }

    private boolean isCharacter(char c) {
        if ( (c >= 'a' && c <= 'z' ) || (c >= 'A' && c <= 'Z') ) {
            return true;
        }
        return false;
    }

    private Object[] parse_list(String str) {
        return null;
    }

    private Object[] parse_dict(String str) {
        return null;
    }

    private Object[] parse_string(String str) {
        if (isCharacter(str.charAt(0))) {
            StringBuilder stringBuilder = new StringBuilder("");
            int i = 0;
            for (; i < str.length(); i++) {
                if (isCharacter(str.charAt(i))) {
                    stringBuilder.append(str.charAt(i));
                }
                else {
//                stringBuilder.append(STRING_END);
                    break;
                }
            }
            String stringFormed = stringBuilder.toString();
            Object result[] = new Object[2];
            result[0] = stringFormed;
            if (i == str.length()) {
                result[1] = "";
            }
            else {
                result[1] = str.substring(i+1);
            }
            return result;
        }
        else {
            StringBuilder stringBuilder = new StringBuilder(STRING_START);
            int i = 1;
            for (; i < str.length(); i++) {
                if (str.charAt(i) != STRING_END) {
                    stringBuilder.append(str.charAt(i));
                }
                else {
//                stringBuilder.append(STRING_END);
                    break;
                }
            }
            String stringFormed = stringBuilder.toString();
            Object result[] = new Object[2];
            result[0] = stringFormed;
            if (i == str.length()) {
                result[1] = "";
            }
            else {
                result[1] = str.substring(i+1);
            }
            return result;
        }
    }

    private Object[] parse_number(String string) {
        StringBuilder stringBuilder = new StringBuilder("");
        int i = 0;
        for (; i < string.length(); i++) {
            if (isDigit(string.charAt(i))) {
                stringBuilder.append(string.charAt(i));
            }
            else {
                break;
            }
        }
        int number = Integer.valueOf(stringBuilder.toString());
        Object result[] = new Object[2];
        result[0] = number;
        result[1] = string.substring(i);
        return result;
    }

    public boolean isDigit(char a) {
        if (a >= '0' && a <= '9') {
            return true;
        }
        return false;
    }


}
