package com.dtsc.dbLinkeList;

import java.util.stream.IntStream;

/**
 * @version v1.0
 * @className: TestLinked
 * @Package: com.dtsc.dbLinkeList
 * @description:
 * @author: xiaoqi
 * @Emial: onxiaoqi@qq.com
 * @create: 2023-05-11 23:53
 **/
public class TestLinked {
    public static void main(String[] args) {
        int n = 5;
        int y = 20;
        int[] weights = {2, 3, 4, 5, 9};
        int[] values = {5, 7, 8, 10, 17};

        System.out.println("Greedy algorithm:");
        System.out.println(greedyCoinChange(n, y, weights, values));
    }

    public static int greedyCoinChange(int n, int Y, int[] weights, int[] values) {
        double[] unitValues = new double[n];
        for (int i = 0; i < n; i++) {
            unitValues[i] = (double) values[i] / (double) weights[i];
        }
        Integer[] sortedCoins = IntStream.range(0, n)
                .boxed()
                .sorted((i, j) -> Double.compare(unitValues[j], unitValues[i]))
                .toArray(Integer[]::new);
        int totalWeight = 0;
        for (int i : sortedCoins) {
            if (weights[i] + totalWeight <= Y) {
                totalWeight += weights[i];
            } else {
                break;
            }
        }
        return totalWeight;
    }

}
