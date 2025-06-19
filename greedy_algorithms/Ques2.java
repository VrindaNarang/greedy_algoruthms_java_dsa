
package greedy_algorithms;

import java.util.*;

public class Ques2 {
    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        // Activities are sorted by end time, so we can directly apply the greedy
        // strategy
        int maxAct = 1; // we always select the first activity
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0); // select the first activity by default

        int lastEnd = end[0]; // track end time of last selected activity

        for (int i = 1; i < start.length; i++) {
            if (start[i] >= lastEnd) {
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }

        System.out.println("Maximum number of activities: " + maxAct);
        System.out.print("Selected activity indices: ");
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
