package com.company.interviewBit;

import java.util.*;

/**
 * Created by tripti on 10/06/18.
 */

public class LargestNumber {
    public String largestNumber(final List<Integer> A) {

        List<String> stringA = new ArrayList<>();
        A.stream().forEach(x -> {
            stringA.add(String.valueOf(x));
        });
        Collections.sort(stringA, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String n1 = o1.concat(o2);
                String n2 = o2.concat(o1);
                if (n1.compareTo(n2) > 0) return -1;
                else return 1;
            }
        }); //decreasing
//        Collections.reverse(stringA);
//          do not use string to get result. It is immutable. Uses Memory.
//        String result = "";
//        for (int i = 0; i < stringA.size(); i++) {
//            result = result + stringA.get(i);
//        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stringA.size(); i++) {
            result.append(stringA.get(i));
        }

        if (result.charAt(0) == '0') {
            return "0";
        }
        return result.toString();
    }

    public void takeCustomInput() {
        ArrayList<Integer> testList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numx = scanner.nextInt();
        for (int i = 0; i < numx; i++) {
            testList.add(scanner.nextInt());
        }
        System.out.println(largestNumber(testList));
    }
}
