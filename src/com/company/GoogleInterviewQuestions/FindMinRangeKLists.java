package com.company.GoogleInterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMinRangeKLists {

    class MinNode implements Comparable<MinNode> {
        int ele;
        int index;
        int listIndex;
        MinNode(int ele, int index, int listIndex) {
            this.ele = ele;
            this.index = index;
            this.listIndex = listIndex; // index in list
        }

        @Override
        public int compareTo(MinNode o) {
            return (this.ele < o.ele) ? -1 : 1;
        }
    }

    public void findRange(ArrayList<ArrayList<Integer>> lists) {
        if (lists == null || lists.size() == 0) {
            return;
        }

        PriorityQueue<MinNode> priorityQueue = new PriorityQueue<>();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).size() != 0) {
                priorityQueue.add(new MinNode(lists.get(i).get(0),i,0));
            }
            else {
                System.out.println("No such Range Exists");
                return;
            }
            if (lists.get(i).get(0) > max) {
                max = lists.get(i).get(0);
            }
        }


        int answer = Integer.MAX_VALUE;
        int minAns = -1;
        int maxAns = -1;
        while (true) {
            MinNode minElement = priorityQueue.poll();
            min = minElement.ele;
            if (max - min < answer) {
                answer = max - min;
                minAns = min;
                maxAns = max;

            }

            if (minElement.listIndex + 1 < lists.get(minElement.index).size()) {
                priorityQueue.add(new MinNode(lists.get(minElement.index).get(minElement.listIndex+1), minElement.index, minElement.listIndex+1));
            }
            else {
               break;
            }

            if (lists.get(minElement.index).get(minElement.listIndex + 1) > max) {
                max = lists.get(minElement.index).get(minElement.listIndex + 1);
            }
        }
        System.out.println("MIN = " + minAns + " MAX = " + maxAns);
    }

    public void input() {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.add(7);
        list1.add(9);
        list1.add(12);
        list1.add(15);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(8);
        list2.add(10);
        list2.add(14);
        list2.add(20);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(12);
        list3.add(16);
        list3.add(30);
        list3.add(50);

//        ArrayList<Integer> list1 = new ArrayList<>();
//        list1.add(4);
//        list1.add(10);
//        list1.add(15);
//        list1.add(24);
//        list1.add(26);
//
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.add(0);
//        list2.add(9);
//        list2.add(12);
//        list2.add(20);
//
//        ArrayList<Integer> list3 = new ArrayList<>();
//        list3.add(5);
//        list3.add(18);
//        list3.add(22);
//        list3.add(30);


        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        findRange(lists);
    }
}
