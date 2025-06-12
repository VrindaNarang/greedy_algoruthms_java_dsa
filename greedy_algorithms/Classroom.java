package greedy_algorithms;

import java.util.*;

public class Classroom {

    public static void main(String args[]) {
        int val[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int W = 50;

        // array to store ratios
        double ratio[][] = new double[val.length][2];

        // 0th coloums stores original index of item
        // 1st coloumn stores ratio of value and weight

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }

        // ascending order sorting of 1st coloumn of the 2d array
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int finalVal = 0;

        // now sorting the array's first coloumn which contains ratio in descending
        // order

        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                finalVal += val[idx];
                capacity -= weight[idx];
            } else {
                // include fractional item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("final Val:" + finalVal);

    }
}