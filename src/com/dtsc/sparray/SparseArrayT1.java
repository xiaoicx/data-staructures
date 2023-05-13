package com.dtsc.sparray;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * @className: SparseArrayT1
 * @Package: com.dtsc.sparray

 * @description:
 * @author: xiaoqi
 * @Emial: onxiaoqi@qq.com
 * @version v1.0
 * @create: 2023-03-08 14:59
 **/
public class SparseArrayT1 {
    public static void main(String[] args) {

        //初始化数组
        int[][] arr1 = new int[5][5];
        arr1[0][2] = 3;
        arr1[1][1] = -1;
        arr1[1][3] = 4;
        arr1[2][3] = 6;
        arr1[3][4] = 5;
        arr1[4][2] = 9;

        //压缩数组
        System.out.println("-------------------------------------");
        int[][] ints = SparseArray1.SparseArrayZip(arr1);
        System.out.println("-------------------------------------");

        //格式化输出
        System.out.println("格式化输出:arr1");
        SparseArray1.printArry(arr1);

        System.out.println("格式化输出:zipArr");
        SparseArray1.printArry(ints);

        SparseArray1.writeArray(ints);
        System.out.println("格式化输出:zipArr");
        int[][] read = SparseArray1.readToArray();
        SparseArray1.printArry(read);
        System.out.println("解压缩格式化输出:zipArr");
        int[][] unZipArray = SparseArray1.unZipArray(read);
        SparseArray1.printArry(unZipArray);

    }
}


class SparseArray1 {

    /**
     * 稀疏数组                 row  col   val
     *  0   0   3   0   0   0   5    5      5
     *  0  -1   0   0   0   1   0    2      3
     *  0   0   6   0   0   2   1    1     -1
     *  0   0   0   5   0   3   2    2      6
     *  0   0   0   0   9   4   3    5      3
     *                      5   4    1      9
     */

    /**
     * @Description 格式化输出
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-03-09 09:59
     * @param arr
     * @return void
     */
    public static void printArry(int[][] arr) {
        for (int[] ints1 : arr) {
            for (int i : ints1) {
                System.out.format("%d\t", i);
            }
            System.out.println();
        }
    }


    /**
     * @Description 压缩数组
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-03-09 09:59
     * @param arr1
     * @return int
     */
    public static int[][] SparseArrayZip(int[][] arr1) {
        int[][] zipArr = new int[7][3];
        zipArr[0][0] = arr1.length;
        zipArr[0][1] = arr1[0].length;
        zipArr[0][2] = 0;
        int len = 0;
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j] != 0) {
                    len++;
                    zipArr[0][2] = len;
                    zipArr[len][0] = i;
                    zipArr[len][1] = j;
                    zipArr[len][2] = arr1[i][j];
                }
            }
        }
        return zipArr;
    }

    /**
     * @Description 序列化到本地文件
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-03-09 10:00
     * @param arr1
     * @return void
     */
    public static void writeArray(int[][] arr1) {
        StringBuilder sb = new StringBuilder();
        for (int[] ints1 : arr1) {
            for (int i : ints1) {
                sb.append(i + "\t");
            }
            sb.append("\r");
        }
        File file = new File("D:\\SparseArray.data");

        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    System.out.println("文件创建失败!无法保存!");
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(sb.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件写入失败!");
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("写出文件:" + file.getPath());
    }

    /**
     * @Description 反序列化
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-03-09 10:00
     * @param
     * @return int
     */
    public static int[][] readToArray() {
        BufferedReader bfr = null;
        int[][] ints = null;
        try {
            File file = new File("D:\\SparseArray.data");
            System.out.println("读取文件:" + file.getPath());
            bfr = new BufferedReader(new FileReader(file));
            ArrayList<String> list = new ArrayList<>();
            String r = "";
            while ((r = bfr.readLine()) != null) {
                list.add(r);
            }
            ints = new int[list.size()][3];
            for (int i = 0; i < list.size(); i++) {
                String[] split = list.get(i).split("\\s");
                for (int j = 0; j < split.length && split.length <= 3; j++) {
                    ints[i][j] = Integer.parseInt(split[j]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bfr != null) {
                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return ints;
    }

    /**
     * @Description 解压数组
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-03-09 10:00
     * @param arr1
     * @return int
     */
    public static int[][] unZipArray(int[][] arr1) {
        int row = arr1[0][0];
        int col = arr1[0][1];
        int count = arr1[0][2];
        int[][] arr = new int[row][col];

        System.out.println(arr1[1][1]);

        for (int i = 1; i < arr1.length; i++) {
            int arow = arr1[i][0];
            int acol = arr1[i][1];
            int val = arr1[i][2];
            arr[arow][acol] = val;
        }
        return arr;
    }
}
