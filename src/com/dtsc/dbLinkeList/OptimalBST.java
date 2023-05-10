package com.dtsc.dbLinkeList;

/**
 * @version v1.0
 * @className: OptimalBST
 * @Package: com.dtsc.dbLinkeList
 * @description:
 * @author: xiaoqi
 * @Emial: onxiaoqi@qq.com
 * @create: 2023-05-05 08:29
 **/
public class OptimalBST {
    public static float optimalSearchTree(float[] p, float[] q, int n) {

        float[][] e = new float[n + 2][n + 1];
        float[][] w = new float[n + 2][n + 1];
        int[][] root = new int[n + 1][n + 1];

        for (int i = 1; i <= n + 1; i++) {
            e[i][i - 1] = q[i - 1];
            w[i][i - 1] = q[i - 1];
        }

        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                e[i][j] = Float.MAX_VALUE;
                w[i][j] = w[i][j - 1] + p[j] + q[j];
                for (int r = i; r <= j; r++) {
                    float t = e[i][r - 1] + e[r + 1][j] + w[i][j];
                    if (t < e[i][j]) {
                        e[i][j] = t;
                        root[i][j] = r;
                    }
                }
            }
        }

        return e[1][n];
    }

    public static void main(String[] args) {
        float[] p = {0.15f, 0.10f, 0.05f, 0.10f, 0.20f};
        float[] q = {0.05f, 0.10f, 0.05f, 0.05f, 0.05f, 0.10f};
        System.out.println("最优的最小成本是: " + optimalSearchTree(p, q, p.length - 1));
    }
}
