package com.dstc.oj;

import java.util.Arrays;

/**
 * @className: Solution_oj1
 * @Package: com.dstc.oj

 * @description:
 * @author: xiaoqi
 * @version v1.0
 * @create: 2022-12-17 23:30
 **/
@SuppressWarnings("all")
public class Solution_oj_1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 5, 11};
        int target = 10;
        int i = nums.length,
                j = 0,//头指针
                p = j + 1, r[] = null;//尾指针
        while (j < i) {

            if (p >= i) { //判断循环次数
                j++; //头指针后移
                p = j + 1;
            }

            if ((nums[j] + nums[p]) == target) {
                r = new int[]{j, p};
                break;
            }
            ++p;
        }
        System.out.println(Arrays.toString(r));
    }
}
