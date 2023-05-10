package com.dtsc.linkedlist;

import java.util.Objects;

/**
 * @className: LoopLinkedTable
 * @Package: com.dtsc.linkedlist

 * @description:
 * @author: xiaoqi
 * @Emial: onxiaoqi@qq.com
 * @version v1.0
 * @create: 2023-04-10 17:08
 **/
@SuppressWarnings("all")
public class LoopLinkedTable<T> {

    //循环链表的尾结点
    private LNode<T> rear = null;

    //链表长度
    private Integer length = 0;

    //初始化循环链表
    public LoopLinkedTable() {
        rear = new LNode<T>(null, 0);

        //初始化尾指针指向头节点
        rear.next = rear;
        length = 0;
    }

    /**
     * @Description 判断节点是否为空
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-10 19:01
     * @param
     * @return boolean
     */
    public boolean isEmpty() {
        //当前节点的指针域不等于节点本身
        return rear.next == rear;
    }

    /**
     * @Description 尾插法
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-10 18:02
     * @param ele
     * @param uid
     * @return void
     */
    public void insert(T ele) {

        if (Objects.isNull(ele)) {
            System.out.println("元素为空!");
            return;
        }

        //创建新节点
        LNode<T> eleNode = new LNode<>(ele, length + 1);


        //吧尾节点的指针域给新节点的指针域
        eleNode.next = rear.next;

        //吧新节点地址赋值给为节点的指针域
        rear.next = eleNode;
        //尾结点指针后移
        rear = eleNode;

        length++;
    }

    /**
     * @Description 根据索引获取节点元素
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-10 19:34
     * @param index
     * @return T
     */
    public T get(int index) {

        if (index < 0 || index > length) {
            System.out.println("索引超出了范围");
            return null;
        }

        LNode head = rear.next, p = rear.next;

        int len = 0;
        boolean flag = false;

        while (Objects.nonNull(p) && p.next != head) {

            len++;

            //判断是否查找到
            if (len == index) {
                flag = true;
                break;
            }
            //移动指针
            p = p.next;
        }

        //判断是否找到
        if (!flag) {
            System.out.println("没有找到");
            return null;
        }

        return (T) p.ele;
    }

    /**
     * @Description 更具索引删除元素
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-10 19:50
     * @param index
     * @return T
     */
    public T delete(int index) {

        if (index < 0 || index > length) {
            System.out.println("删除索引超出范围!");
            return null;
        }

        LNode p = rear.next;
        int len = 0;
        boolean flag = false;

        while (Objects.nonNull(p) && p.next != rear) {
            len++;
            if (len == index) {
                flag = true;
                break;
            }
            p = p.next;
        }

        if (!flag) {
            System.out.println("没有找到!");
            return null;
        }

        T eleData = (T) p.next.ele;
        p.next = p.next.next;
        length--;

        return eleData;
    }

    /**
     * @Description 修改节点元素
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-10 22:10
     * @param ele
     * @param index
     * @return T
     */
    public T modifly(T ele, int index) {

        if (Objects.isNull(ele)) {
            System.out.println("修改的元素为null");
            return null;
        }

        if (index < 0 || index > length) {
            System.out.println("修改元素的节点超出范围");
            return null;
        }

        LNode lp = rear.next;
        int len = 0;
        boolean flag = false;
        while (Objects.nonNull(lp) && len < index) {
            len++;
            if (len == index) {
                flag = true;
                break;
            }
            lp = lp.next;
        }

        if (!flag) {
            System.out.println("没有找到元素, 修改失败!");
            return null;
        }

        T modiflyData = (T) lp.ele;
        lp.ele = ele;

        return modiflyData;
    }


    /**
     * @Description 获取头结点
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-10 19:35
     * @param
     * @return T
     */
    public LNode<T> getHeadNode() {
        return rear.next;
    }

    /**
     * @Description 获取尾节点
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-10 19:37
     * @param
     * @return LNode<T>
     */
    public LNode<T> getRearNode() {
        return rear;
    }
}