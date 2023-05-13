package com.dtsc.sqlist;

/**
 * @className: SqlistTest
 * @Package: com.dtsc.sqlist

 * @description:
 * @author: xiaoqi
 * @version v1.0
 * @create: 2022-11-21 22:58
 **/
public class SqlistTest {
    public static void main(String[] args) {
        SqList<Integer> list = new SqList<>(32);
        list.add(12);
        list.add(13);
        list.add(14);

        System.out.println("list.length() = " + list.length());
        System.out.println("list.get(2) = " + list.get(2));

        list.insert(2, 15);
        System.out.println("list.length() = " + list.length());

        System.out.println("list.locateIndex(13) = " + list.locateIndex(13));

        System.out.println("list.delete(2) = " + list.delete(2));
        System.out.println("list.length() = " + list.length());

        System.out.println("list.getPrior(13) = " + list.getPrior(13));
        System.out.println("list.getNext(12) = " + list.getNext(12));

        list.insert(10, 110);

        list.printList();


    }
}
