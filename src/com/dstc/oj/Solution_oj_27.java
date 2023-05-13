package com.dstc.oj;

import java.util.Arrays;

/**
 * @className: Solution_oj_27
 * @Package: com.dstc.oj

 * @description:
 * @author: xiaoqi
 * @version v1.0
 * @create: 2022-12-21 16:43
 **/
public class Solution_oj_27 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int r = removeElement(nums, 2);
        System.out.println(Arrays.toString(nums) + "   " + r);
    }

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
