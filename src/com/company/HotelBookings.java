package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by tripti on 11/06/18.
 */

public class HotelBookings {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        if(arrive == null || arrive.size() == 0||
                depart == null || depart.size() == 0 ||
                depart.size() != arrive.size() || K < 1)
            return false;

        Collections.sort(arrive);
        Collections.sort(depart);
        int aIndex = 0;
        int dIndex = 0;

        int currentRooms = 0;
//        int max =0; at a point max this many rooms are required
        while(aIndex < arrive.size() && dIndex < arrive.size()){
            if(arrive.get(aIndex) < depart.get(dIndex)) {
                aIndex++;
                currentRooms++;
//                max = Math.max(max, currentRooms);
            }
            else {
                dIndex++;
                currentRooms--;
            }
            if (currentRooms > K) {
                return false;
            }
        }
//        return max <= K
        return true;
    }

    public void takeCustomInput() {
        ArrayList<Integer> testList1 = new ArrayList<>();
        ArrayList<Integer> testList2 = new ArrayList<>();
        int k;

        Scanner scanner = new Scanner(System.in);
        int numx = scanner.nextInt();
        for (int i = 0; i < numx; i++) {
            testList1.add(scanner.nextInt());
        }
        scanner.nextLine();
        int numy = scanner.nextInt();
        for (int i = 0; i < numy; i++) {
            testList2.add(scanner.nextInt());
        }
        scanner.nextLine();
        k = scanner.nextInt();
        System.out.println(hotel(testList1,testList2,k));
    }
}
