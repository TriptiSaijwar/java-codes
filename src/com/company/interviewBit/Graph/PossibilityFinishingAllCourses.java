package com.company.interviewBit.Graph;

import java.util.*;

public class PossibilityFinishingAllCourses {
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        LinkedList<Integer>[] graph = new LinkedList[A+1];
        for(int i=1;i<=A;i++)
        {
            graph[i]=new LinkedList<>();
        }
        for(int i=0;i<B.size();i++)
        {
            graph[B.get(i)].add(C.get(i));
        }

        boolean visited[] = new boolean[A+1];
        Arrays.fill(visited,false);
        Set<Integer> recursiceStack = new HashSet<>();
        boolean cycleExist = false;
        for (int i = 1;i <= A; i++) {
            if (findCycle(graph,visited,recursiceStack,i) == true) {
                cycleExist = true;
                break;
            }
        }

        if (cycleExist) {
            return 0;
        }
        return 1;
    }

    private Boolean findCycle(LinkedList<Integer>[] graph, boolean[] visited, Set<Integer> recursiceStack,int i) {
        if (visited[i] == false) {
            visited[i] = true;
            recursiceStack.add(i);
            Iterator<Integer> it = graph[i].iterator();
            while (it.hasNext()) {
                int el = it.next();
                if (!visited[el] && findCycle(graph,visited,recursiceStack,el)) {
                    return true;
                }
                else if (recursiceStack.contains(el)) {
                    return true;
                }
            }
        }
        recursiceStack.remove(i);
        return false;
    }
}
