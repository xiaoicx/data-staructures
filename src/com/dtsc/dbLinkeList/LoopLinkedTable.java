package com.dtsc.dbLinkeList;

import java.util.Objects;

/**
 * @version v1.0
 * @className: LoopLinkedTable
 * @Package: com.dtsc.dbLinkeList
 * @description:
 * @author: xiaoqi
 * @Emial: onxiaoqi@qq.com
 * @create: 2023-05-11 15:16
 **/
@SuppressWarnings("all")
public class LoopLinkedTable<T> {

    //头指针
    private DubNode<T> head = null;
    private DubNode<T> rear = null;
    private Integer length = 0;

    public LoopLinkedTable() {
        head = new DubNode<>(null, -1);
        rear = head;

        head.next = head;
        head.prior = head;
    }

    /**
     * @param ele
     * @param uid
     * @return void
     * @Description 添加顺序
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-11 15:18
     */
    public void insertHead(T ele, int uid) {

        if (Objects.isNull(head) || Objects.isNull(ele)) {
            throw new RuntimeException("头指针为null或元素为null");
        }

        DubNode<T> newNode = new DubNode<>(ele, uid);
        length++;

        //头指针没有节点
        if (head.next == head) {
            //交换新节点的前驱和后继
            newNode.next = head.next;
            newNode.prior = head;

            //把头指针的前驱指向最后一个节点
            //把头指针的后继指向下一个节点
            head.next = newNode;
            head.prior = newNode;

            rear = newNode;
            return;
        }

        //先交换新节点的前驱和后继
        newNode.prior = head;
        newNode.next = head.next;

        //在交换后继的后继节点的前驱 和 前驱节点的后继
        head.next.prior = newNode;
        head.next = newNode;
    }

    /**
     * @param ele
     * @param uid
     * @return void
     * @Description 尾插
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-11 17:43
     */

    public void insertRear(T ele, int uid) {
        if (Objects.isNull(head) || Objects.isNull(ele)) {
            throw new RuntimeException("头指针为null或元素为null");
        }

        DubNode<T> newNode = new DubNode<>(ele, uid);

        length++;

        //先交换尾结点的后继, 让后继重新指向头结点
        newNode.next = rear.next;
        //在交换新节点的前驱,
        newNode.prior = rear;

        
        rear.next = newNode;
        head.prior = newNode;
        rear = newNode;
    }


}
