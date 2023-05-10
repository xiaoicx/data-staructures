package com.dstc.oj;

/**
 * @className: Solution_oj_189
 * @Package: com.dstc.oj

 * @description:
 * @author: xiaoqi
 * @Emial: onxiaoqi@qq.com
 * @version v1.0
 * @create: 2023-02-25 00:18
 **/
public class Solution_oj_189 {
    public static void main(String[] args) {

    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
//        反转区间为前n的子串
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
}
