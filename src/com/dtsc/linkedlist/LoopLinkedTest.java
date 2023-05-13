package com.dtsc.linkedlist;

/**
 * @className: LoopLinkedTest
 * @Package: com.dtsc.linkedlist

 * @description:
 * @author: xiaoqi
 * @Emial: onxiaoqi@qq.com
 * @version v1.0
 * @create: 2023-04-10 19:01
 **/
@SuppressWarnings("all")
public class LoopLinkedTest {
    public static void main(String[] args) {
        LoopLinkedTable<Integer> loopLinkedTable = new LoopLinkedTable<>();
        System.out.println(loopLinkedTable.isEmpty());

        loopLinkedTable.insert(1);
        loopLinkedTable.insert(2);
        loopLinkedTable.insert(3);

        System.out.println("loopLinkedTable.isEmpty() = " + loopLinkedTable.isEmpty());
        Integer eleData = loopLinkedTable.get(2);
        System.out.println("eleData = " + eleData);

        System.out.println("loopLinkedTable.getHeadNode() = " + loopLinkedTable.getHeadNode());
        System.out.println("loopLinkedTable.getRearNode() = " + loopLinkedTable.getRearNode());

        Integer modifly = loopLinkedTable.modifly(11, 2);
        System.out.println("modifly = " + modifly);

        Integer delete = loopLinkedTable.delete(2);
        System.out.println("delete = " + delete);
    }
}
