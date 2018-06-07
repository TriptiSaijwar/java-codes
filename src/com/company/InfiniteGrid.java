package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tripti on 03/06/18.
 */

public class InfiniteGrid {
    private int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int ans = 0;
//        A.stream().forEach(x -> {
//            System.out.println("VALUE READ: => " + x);
//        });
        for (int i = 1; i < A.size(); i++) {
            int deltax = (A.get(i) - A.get(i-1)) < 0 ? A.get(i-1) - A.get(i) : A.get(i) - A.get(i-1);
            int deltay = (B.get(i) - B.get(i-1)) < 0 ? B.get(i-1) - B.get(i) : B.get(i) - B.get(i-1);
            int diagonalSteps = (deltax >= deltay) ? deltay : deltax;
            int extraSteps = (deltax - deltay) > 0 ? deltax - deltay : deltay - deltax;
            ans = ans + diagonalSteps + extraSteps;
        }
        return ans;
    }

    public void takeCustomInput() {
        ArrayList<Integer> testXList = new ArrayList<>();
        ArrayList<Integer> testYList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numx = scanner.nextInt();
        for (int i = 0; i < numx; i++) {
            testXList.add(scanner.nextInt());
        }
        scanner.nextLine();
        int numy = scanner.nextInt();
        for (int i = 0; i < numy; i++) {
            testYList.add(scanner.nextInt());
        }
        System.out.println(coverPoints(testXList,testYList));
    }
}
