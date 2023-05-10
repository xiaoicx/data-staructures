package com.dtsc.dbLinkeList;

/**
 * @className: DubNode
 * @Package: com.dtsc.dbLinkeList

 * @description:
 * @author: xiaoqi
 * @Emial: onxiaoqi@qq.com
 * @version v1.0
 * @create: 2023-04-10 22:19
 **/
@SuppressWarnings("all")
public class DubNode<T> {
    public T ele;
    public DubNode<T> prior;
    public DubNode<T> next;
    public Integer uid;

    public DubNode(T ele, Integer uid) {
        this.ele = ele;
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "DubNode{" +
                "ele=" + ele +
                ", uid=" + uid +
                '}';
    }
}
