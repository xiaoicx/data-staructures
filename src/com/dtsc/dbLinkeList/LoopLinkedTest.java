package com.dtsc.dbLinkeList;

/**
 * @version v1.0
 * @className: LoopLinkedTest
 * @Package: com.dtsc.dbLinkeList
 * @description:
 * @author: xiaoqi
 * @Emial: onxiaoqi@qq.com
 * @create: 2023-05-11 15:54
 **/
public class LoopLinkedTest {
    public static void main(String[] args) {
        LoopLinkedTable<Integer> table = new LoopLinkedTable<>();
        table.insertHead(1,1);
        table.insertHead(2,2);
        table.insertHead(3,3);
        table.insertHead(4,4);

        table.insertRear(5,5);
        table.insertRear(6,6);
        table.insertRear(7,7);

    }
}
