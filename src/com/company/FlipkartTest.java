package com.company;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FlipkartTest {

    public void solve() {
        PriorityQueue<Pair>[] curr_remaining = new PriorityQueue[50000];
        PriorityQueue<Integer> sum_remaining = new PriorityQueue<>();
        int p,q,r, floor_num, sum_rem, to_x, to_y, to_floor;
        int curr_no;
        Pair<Integer, Integer> empty_place;
        Scanner scanner = new Scanner(System.in);
        p = scanner.nextInt();
        q = scanner.nextInt();
        r = scanner.nextInt();

        int n;
        n = scanner.nextInt();

        for(int i=0; i<p; i++)
        {
            int fl_st_no = (q + r - 1) * i;
            for(int j=0; j<q; j++)
            {
                for(int k=0; k<r; k++)
                {
                    curr_no = fl_st_no + j + k;
                    curr_remaining[curr_no].add(new Pair(-j,-k));
                    sum_remaining.add(-curr_no);
                }
            }
        }

        for(int i=0; i<n; i++)
        {
            int type_query;
            type_query = scanner.nextInt();

            if (type_query == 1)
            {
                sum_rem = sum_remaining.peek();
                sum_remaining.poll();

                empty_place = curr_remaining[-sum_rem].peek();
                curr_remaining[-sum_rem].poll();

                floor_num = (-sum_rem + empty_place.getKey() + empty_place.getValue()) / ((q + r - 1));

                System.out.print(floor_num + " " + (-empty_place.getKey()) + " " +(-empty_place.getValue()));
//                printf("%d %d %d\n", floor_num, -empty_place.getKey(), -empty_place.getValue());
            }
            else
            {
                to_floor = scanner.nextInt();
                to_x = scanner.nextInt();
                to_y = scanner.nextInt();
                curr_no = (q + r - 1) * to_floor + to_x + to_y;
                sum_remaining.add(-curr_no);
                curr_remaining[curr_no].add(new Pair(-to_x,-to_y));
            }
        }

    }
}
