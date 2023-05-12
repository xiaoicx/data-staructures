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
        table.add(1);
        table.add(2);
        table.add(3);
        table.add(4);

        table.add(5, table.size());
        table.add(6, table.size());
        table.add(7, table.size());


        table.add(8, 0);
        table.add(9, 0);
        table.add(10, 0);

        table.add(11, 3);
        table.add(12, 7);
        table.add(13, 9);
        System.out.println("table.size() = " + table.size());
        System.out.println("table.isEmpty() = " + table.isEmpty());

        int indexOf = table.indexOf(3);
        System.out.println("indexOf = " + indexOf);

        Integer remove = table.remove(3);
        System.out.println("remove = " + remove);
        Integer remove1 = table.remove(5);
        System.out.println("remove1 = " + remove1);


    }
}
