package com.dtsc.dbLinkeList;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.util.Objects;

/**
 * @version v1.0
 * @className: DubLinkedTable
 * @Package: com.dtsc.dbLinkeList
 * @description:
 * @author: xiaoqi
 * @Emial: onxiaoqi@qq.com
 * @create: 2023-04-10 22:19
 **/
@SuppressWarnings("all")
public class DubLinkedTable<T> {

    //头指针
    private DubNode<T> head = null;

    private Integer length = 0;

    /**
     * @param
     * @return null
     * @Description 初始化双向链表
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-10 22:24
     */
    public DubLinkedTable() {
        head = new DubNode<T>(null, 0);
    }

    public DubNode<T> getHead() {
        return head;
    }

    public void setHead(DubNode<T> head) {
        this.head = head;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * @param ele
     * @param uid
     * @return void
     * @Description 尾插入节点
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-10 22:27
     */
    public void insertRear(T ele, int uid) {
        if (head == null) {
            throw new RuntimeException("Linked List is null");
        }

        DubNode pointNode = head;
        while (Objects.nonNull(pointNode.next)) {
            if (pointNode.next == null) {
                break;
            }
            pointNode = pointNode.next;
        }

        DubNode<T> newNode = new DubNode<>(ele, uid);

        head.uid = ++length;

        newNode.prior = pointNode;
        pointNode.next = newNode;
    }

    /**
     * @param ele
     * @param uid
     * @return void
     * @Description 顺序插入
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-11 11:26
     */

    public void insertSeq(T ele, int uid) {
        if (head == null) {
            throw new RuntimeException("Linked List is null");
        }

        DubNode pointNode = head;
        DubNode<T> newNode = new DubNode<>(ele, uid);

        //只有一个头结点的情况
        if (Objects.isNull(pointNode.next)) {
            head.uid = ++length;
            newNode.next = pointNode.next;
            newNode.prior = pointNode;
            return;
        }

        //多个节点的情况
        while (Objects.nonNull(pointNode)) {

            //没有找到插入点直接插入尾部
            if (pointNode.next == null) {
                break;
            }

            //遍历的节点id大于插入的节点id结束遍历
            if (pointNode.uid > uid) {
                break;
            }
            pointNode = pointNode.next;
        }

        head.uid = ++length;

        //在遍历节点的前一个位子插入新的节点
        newNode.prior = pointNode.prior;
        newNode.next = pointNode;

        newNode.next.prior = newNode;
        newNode.prior.next = newNode;
    }

    /**
     * @param ele
     * @param uid
     * @return void
     * @Description 头插
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-11 09:15
     */

    public void insertHead(T ele, int uid) {

        if (head == null) {
            throw new RuntimeException("Linked List is null");
        }

        DubNode pointNode = head;
        DubNode<T> newNode = new DubNode<>(ele, uid);

        head.uid = ++length;

        //只有一个头结点的情况
        if (head.next == null) {
            //指针域置换
            newNode.prior = head;
            newNode.next = head.next;
            head.next = newNode;
            return;
        }

        //指针域置换
        newNode.prior = head;
        newNode.next = head.next;

        head.next.prior = newNode;
        head.next = newNode;
    }


    /**
     * @param ele
     * @return T
     * @Description 根据ele删除节点
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-11 09:50
     */

    public T delete(T ele) {
        if (Objects.isNull(ele) || Objects.isNull(head)) {
            throw new RuntimeException("删除的内容为null或头指针为null!");
        }

        DubNode pointNode = head;
        //遍历双向链表
        while (Objects.nonNull(pointNode.next)) {

            //判断是否遍历到了尾结点
            if (pointNode.next == null) {
                break;
            }

            //判断是否存在
            if (Objects.nonNull(pointNode.ele) && ele.equals(pointNode.ele)) {
                break;
            }
            pointNode = pointNode.next;
        }

        T deleteEle = (T) pointNode.ele;

        head.uid = --length;

        if (pointNode.next == null) {
            pointNode.prior.next = pointNode.next;
            return deleteEle;
        }

        pointNode.prior.next = pointNode.next;
        pointNode.next.prior = pointNode.prior;

        return deleteEle;
    }

    /**
     * @param ele
     * @param uid
     * @return T
     * @Description 根据uid删除节点
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-11 09:50
     */

    public T modfly(T ele, int uid) {

        if (Objects.nonNull(ele) || Objects.nonNull(head)) {
            throw new RuntimeException("删除的内容为null或头指针为null!");
        }

        DubNode pointNode = head;
        //遍历节点
        while (Objects.nonNull(pointNode.next)) {
            if (pointNode.next == null) {
                break;
            }
            //判断遍历节点是否为查找的节点
            if (Objects.nonNull(pointNode.ele) && uid == pointNode.uid) {
                break;
            }
            pointNode = pointNode.next;
        }

        //修改节点
        T modflyEle = (T) pointNode.ele;
        pointNode.ele = ele;

        return modflyEle;
    }


    /**
     * @param node1
     * @param node2
     * @return DubNode<T>
     * @Description 合并两个链表, 无序合并
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-11 11:09
     */

    public static <T> DubNode<T> mergeDubNode(DubNode<T> node1, DubNode<T> node2) {

        if (Objects.isNull(node1) || Objects.isNull(node2)) {
            throw new RuntimeException("合并的链表为空!");
        }

        DubNode rearNode1 = node1, rearNode2 = node2;

        while (Objects.nonNull(rearNode1.next) && Objects.nonNull(rearNode2.next)) {
            if (rearNode1.next == null) {
                break;
            } else if (rearNode2.next == null) {
                break;
            }
            rearNode1 = rearNode1.next;
            rearNode2 = rearNode2.next;
        }

        DubNode<T> newNodes = new DubNode<>(null, 0);

        //长度
        newNodes.uid = rearNode1.uid + rearNode2.uid;

        //node1短
        if (Objects.isNull(rearNode1.next)) {

            //合并尾部
            rearNode1.next = node2.next;
            node2.next.prior = rearNode1;

            //合并新的头部, 去除之前的头节点
            newNodes.next = node1.next;
            node1.next.prior = newNodes;


            //node2短
        } else if (Objects.isNull(rearNode2.next)) {

            //合并尾部
            rearNode2.next = node1.next;
            node1.next.prior = rearNode2;

            //合并新头部
            newNodes.next = node2.next;
            node2.next.prior = newNodes;
        }

        return newNodes;
    }


    /**
     * @param
     * @return void
     * @Description 遍历链表
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-11 11:12
     */

    public void listLinked() {
        if (Objects.isNull(head.next)) {
            System.out.println("链表为空");
            return;
        }
        DubNode pointNode = head;
        while (Objects.nonNull(pointNode)) {

            if (pointNode.next != null) {
                System.out.println("地址: " + pointNode.hashCode() + " ele: " + pointNode.ele + " uid: " + pointNode.uid + " next地址: " + pointNode.next.hashCode());
            } else {
                System.out.println("地址: " + pointNode.hashCode() + " ele: " + pointNode.ele + " uid: " + pointNode.uid);
            }
            pointNode = pointNode.next;
        }
    }

}
