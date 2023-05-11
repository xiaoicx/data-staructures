package com.dtsc.dbLinkeList;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @version v1.0
 * @className: DubLinkedListTest
 * @Package: com.dtsc.dbLinkeList
 * @description:
 * @author: xiaoqi
 * @Emial: onxiaoqi@qq.com
 * @create: 2023-05-11 09:02
 **/
public class DubLinkedListTest {
    public static void main(String[] args) {
        DubLinkedTable<Integer> table = new DubLinkedTable<>();
        table.insertHead(3, 3);
        table.insertHead(4, 4);
        table.insertSeq(2, 2);
        System.out.println("==========table1========");
        table.listLinked();

        DubLinkedTable<Integer> table2 = new DubLinkedTable<>();
        table2.insertRear(1, 1);
        table2.insertRear(2, 2);
        table2.insertRear(5, 5);
        table2.insertRear(6, 6);
        System.out.println("==========table2========");
        table2.listLinked();


        System.out.println("==========table3-merge========");
        DubNode<Integer> mergeDubNode = DubLinkedTable.mergeDubNode(table.getHead(), table2.getHead());
        DubLinkedTable<Integer> table3 = new DubLinkedTable<>();
        table3.setHead(mergeDubNode);
        table3.listLinked();


    }
}
