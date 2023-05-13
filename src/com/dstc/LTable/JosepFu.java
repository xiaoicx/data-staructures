package com.dstc.LTable;

import java.util.Objects;

/**
 * @version v1.0
 * @className: JosepFu
 * @Package: com.dstc.LTable
 * @description:
 * @author: xiaoqi
 * @Emial: onxiaoqi@qq.com
 * @create: 2023-05-11 18:01
 **/
@SuppressWarnings("all")
public class JosepFu {
    public static void main(String[] args) {

        JosepFu jsf = new JosepFu();
        jsf.fillLinkedTable(25);
        System.out.println(jsf);
        jsf.takeNum(2);

    }

    //头节点
    private Node<Integer> head = null;
    //尾结点
    private Node<Integer> tail = null;

    //节点定义
    private class Node<T> {
        public T ele;
        public Node<T> next;


        public Node() {
            this(null, null);
        }

        public Node(T ele, Node<T> next) {
            this.ele = ele;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" + "ele=" + ele + '}';
        }
    }

    /**
     * @Description 填充链表
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-13 16:22
     * @param length
     * @return void
     */
    public void fillLinkedTable(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("生成长度要>=1");
        }

        Node<Integer> newNode = null;

        for (int i = 1; i <= length; i++) {

            //没有头节点 和 尾节点 是个空链表
            if (Objects.isNull(head) && Objects.isNull(tail)) {

                //创建节点
                newNode = new Node<>();
                newNode.ele = i;

                head = newNode;
                tail = newNode;

                //只有一个头节点, 让头结点的后继指向头结点
                head.next = head;

                //头结点不为空
            } else {

                newNode = new Node<>();
                newNode.ele = i;

                //把尾结点的后继赋值给新节点的后继
                newNode.next = tail.next;
                tail.next = newNode;//尾结点的后继重新指向新节点
                tail = newNode; //交换尾节点
            }
        }
    }

    /**
     * @Description 约瑟夫解法
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-13 17:56
     * @param spaceCount
     * @return void
     */
    public void takeNum(int spaceCount) {
        if (spaceCount < 1) {
            throw new IllegalArgumentException("间隔数必须 >=1");
        }

        Node pointNode = head,//遍历的指针
                tempNode = null; //储存要删除节点的上一个节点

        StringBuilder sb = new StringBuilder();
        sb.append("josepFu => [");

        //开始遍历 如果当前节点的后继等于当前节点则停止遍历
        while (pointNode.next != pointNode) {

            //跳过数量,
            for (int i = 0; i < spaceCount - 1; i++) {
                tempNode = pointNode; //保存删除节点的前一个节点
                pointNode = pointNode.next; //指针后移到删除的节点
            }

            sb.append(pointNode.ele + ",");

            //删除节点, pointNode为删除的节点,pointNodes为删除节点的后一个节点
            tempNode.next = pointNode.next;

            pointNode = pointNode.next; //指针后移从下一个开始重新在遍历
        }

        //遍历结束还剩一个头结点没取出
        sb.append(pointNode.ele + "]");

        //删除头尾节点
        head = null;
        tail = null;

        System.out.println(sb);
    }

    @Override
    public String toString() {

        Node pointNode = head;
        StringBuilder sb = new StringBuilder();
        sb.append("JosepFu => [");

        while (true) {

            sb.append(pointNode.ele);

            if (pointNode.next == head) {
                sb.append("]");
                break;
            }

            sb.append(",");
            pointNode = pointNode.next;
        }

        return sb.toString();
    }
}


