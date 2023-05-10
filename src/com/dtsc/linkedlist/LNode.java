package com.dtsc.linkedlist;

/**
 * @className: LNode
 * @Package: com.dtsc.linkedlist

 * @description:
 * @author: xiaoqi
 * @Emial: onxiaoqi@qq.com
 * @version v1.0
 * @create: 2023-04-07 22:43
 **/
@SuppressWarnings("all")
class LNode<T> {

    public T ele; //数据域
    public LNode next; //节点域
    public Integer no; //数量

    public LNode(T ele, Integer no) {
        this.ele = ele;
        this.no = no;
    }

    @Override
    public String toString() {
        return "LNode{" +
                "ele=" + ele +
                ", no=" + no +
                '}';
    }
}
