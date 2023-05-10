package com.dtsc.dbLinkeList;

import java.util.Objects;

/**
 * @className: DubLinkedTable
 * @Package: com.dtsc.dbLinkeList

 * @description:
 * @author: xiaoqi
 * @Emial: onxiaoqi@qq.com
 * @version v1.0
 * @create: 2023-04-10 22:19
 **/
@SuppressWarnings("all")
public class DubLinkedTable<T> {

    //双线链表的头节点
    private DubNode<T> dbHead;
    //双向链表的尾节点
    private DubNode<T> dbRear;
    //大小
    private Integer length;

    /**
     * @Description 初始化双向链表
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-10 22:24
     * @param
     * @return null
     */
    public DubLinkedTable() {

        dbHead = new DubNode(null, 0);
        dbRear = dbHead;
        length = 0;

    }

    /**
     * @Description 插入节点
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-10 22:27
     * @param ele
     * @param uid
     * @param index
     * @return void
     */
    public void insert(T ele, int uid) {

        if (Objects.isNull(ele) || Objects.isNull(uid)) {
            System.out.println("插入的元素或uid为null!");
            return;
        }

        //创建新节点
        DubNode<T> eleNode = new DubNode<>(ele, uid);

        //双向链表添加



    }

}
