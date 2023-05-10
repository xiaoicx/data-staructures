package com.dtsc.linkedlist;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Objects;

/**
 * @className: LinkedListT1
 * @Package: com.dtsc.linkedlist

 * @description:
 * @author: xiaoqi
 * @Emial: onxiaoqi@qq.com
 * @version v1.0
 * @create: 2023-03-10 21:44
 **/
public class LinkedListT1 {
    public static void main(String[] args) {
/*        LinkedTable<Integer> linkedTable = new LinkedTable<>();
        linkedTable.insert(123);
        linkedTable.insert(456);
        linkedTable.insert(789);

        linkedTable.insert(110, 2);

        linkedTable.delete(2);


        linkedTable.printLinkedTable(linkedTable.getHead());
        linkedTable.clearLinkedTable();*/


//        LinkedTable.insertRandomHead(100);
//        LinkedTable.insertRandomRear(100);


        LinkedTable<Stu> stuLinkedTable = new LinkedTable<>();
        Stu s1 = new Stu("宋江", 0);
        Stu s2 = new Stu("林冲", 1);
        Stu s3 = new Stu("吴用", 2);
        Stu s4 = new Stu("鲁智深", 3);
        Stu s5 = new Stu("孙悟空", 4);
        Stu s6 = new Stu("沙和尚", 5);

        stuLinkedTable.seqenceInsert(s1, 0);
        stuLinkedTable.seqenceInsert(s4, 3);
        stuLinkedTable.seqenceInsert(s2, 1);
        stuLinkedTable.seqenceInsert(s3, 2);
        stuLinkedTable.seqenceInsert(s6, 5);
        stuLinkedTable.seqenceInsert(s5, 4);


        System.out.println("stuLinkedTable.getEle(2) = " + stuLinkedTable.getEle(2));
        stuLinkedTable.delete(new Stu("鲁智深", 3));


        stuLinkedTable.modifly(new Stu("智多星", 2), 2);

        int len = LinkedTable.linkedNodeSize(stuLinkedTable.getHead());
        System.out.println("len = " + len);

        Object eleData = LinkedTable.findBackNode(stuLinkedTable.getHead(), 1);
        System.out.println("eleData = " + eleData);

//        LNode<Stu> reversLinkedTable1 = LinkedTable.reversLinkedTable1(stuLinkedTable.getHead());
//        LinkedTable.printLinkedTable(reversLinkedTable1);


//        LinkedTable.printReversLinkedTable1(stuLinkedTable.getHead());
//        LinkedTable.printReversLinkedTable2(stuLinkedTable.getHead());

        LinkedTable<Stu> stuLinkedTable2 = new LinkedTable<>();
        Stu s11 = new Stu("宋江", 0);
        Stu s22 = new Stu("林冲", 1);
        Stu s33 = new Stu("吴用", 2);

        stuLinkedTable2.seqenceInsert(s11, 0);
        stuLinkedTable2.seqenceInsert(s33, 3);
        stuLinkedTable2.seqenceInsert(s22, 2);

        LNode<Stu> mergeLinkedTable =
                LinkedTable.mergeLinkedTable(stuLinkedTable.getHead(), stuLinkedTable2.getHead());
        LinkedTable.printLinkedTable(mergeLinkedTable);

    }
}



