package com.dstc.oj;

import sun.security.x509.X509Key;

import java.rmi.dgc.DGC;
import java.rmi.dgc.VMID;
import java.security.PublicKey;
import java.util.Arrays;

/**
 * @className: Solution_oj_26
 * @Package: com.dstc.oj

 * @description:
 * @author: xiaoqi
 * @version v1.0
 * @create: 2022-12-18 00:14
 **/
@SuppressWarnings("all")
public class Solution_oj_26 {
    public static void main(String[] args) {
        int arr[] = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int expectedNums = removeDuplicates(arr);
        System.out.println(expectedNums);
        System.out.println(Arrays.toString(arr));

    }

    public static int removeDuplicates(int[] nums) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] == nums[l]) {
                r++;
            } else {
                nums[l + 1] = nums[r];
                l++;
                r++;
            }
        }
        return l + 1;
    }
}
