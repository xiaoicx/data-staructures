package com.dtsc.dbLinkeList;


import java.util.*;
import java.util.function.Consumer;

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
public class LoopLinkedTable<T> implements CustomList<T> {

    //头结点
    private Node<T> head = null;
    //尾节点
    private Node<T> tail = null;
    // 数量
    private int length = 0;

    //内部类 Node节点
    private class Node<T> {

        public T ele; //数据域
        public Node<T> next;//后继指针域
        public Node<T> prev;//前驱指针域

        public Node() {
            this(null, null, null);
        }

        public Node(T ele) {
            this.ele = ele;
            this.next = this.prev = null;
        }

        public Node(T ele, Node<T> next, Node<T> prev) {
            this.ele = ele;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" + "ele=" + ele + '}';
        }
    }

    /**
     * @param ele
     * @return void
     * @Description 添加元素, 默认添加到链表尾部
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-11 23:18
     */

    @Override
    public void add(T ele) {
        add(ele, length);
    }

    /**
     * @param ele
     * @param index
     * @return void
     * @Description 添加元素到指定位置
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-11 23:18
     */


    @Override
    public void add(T ele, int index) {
        if (index < 0 || index > length) {
            throw new RuntimeException("index out of range");
        }

        Node<T> newNode = new Node<>(ele);

        //头结点没有子元素
        if (isEmpty()) {
            head = newNode;
            tail = newNode;

            head.next = head;
            head.prev = tail;

            //头插
        } else if (index == 0) {
            newNode.prev = head.prev;//新节点的前驱尾头指针的前驱 指向tail节点
            newNode.next = head;//新节点的后继为head节点

            head.prev = newNode;//head的前驱重新复制为新节点
            head = newNode;//head指针重新指向新节点
            tail.next = head;//尾节点的指针域指向新的head

            //尾插
        } else if (index == length) {
            newNode.next = tail.next;
            newNode.prev = tail;

            tail.next = newNode;
            tail = newNode;
            head.prev = tail;

        } else {

            Node tempHead = null, curNode = null;

            //前半部分 正序遍历
            if (index <= length / 2) {

                //从头节点开始遍历, 遍历到当且要插入的节点的前一个位置
                //假设插入点为3 实际循环次数index=2  循环i=0,i=1
                curNode = head;
                for (int i = 0; i < index - 1; i++) {
                    curNode = curNode.next;
                }

                tempHead = curNode.next; //保存插入点后面的元素

                newNode.prev = curNode; //把新节点的前驱指向当前插入点的前一个节点
                newNode.next = tempHead; //把新节点的后继指向当前插入点的后一个节点

                curNode.next = newNode; //把当前遍历到的节点后继指向新插入节点
                tempHead.prev = newNode; //把插入点后面的节点的前驱指向新插入节点
            }

            //后半部分倒序遍历
            if (index >= length / 2) {

                //倒序遍历节点 遍历到插入点的后一个节点
                //假设插入点为4 实际循环次数i=6-1=5 index=4 循环 i=5, i=4
                curNode = tail;
                for (int i = length - 1; i > index; i--) {
                    curNode = curNode.prev;
                }

                tempHead = curNode.prev; //保存插入点前一个节点

                newNode.prev = tempHead; //把新节点的前驱指向插入点前面的节点
                newNode.next = curNode; //把新节点的后继指向当前遍历的节点

                tempHead.next = newNode; //把当前插入点的前一个节点的后继重新指向新节点
                curNode.prev = newNode; //把当前遍历的节点的前驱重新指向新节点
            }
        }
        length++;
    }

    /**
     * @param
     * @return void
     * @Description 清空链表
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-12 14:53
     */

    @Override
    public void clear() {
        if (Objects.isNull(head)) {
            return;
        }

        Node tempNode = null;
        while (head.next != head) {

            tempNode = head; //保存当前节点
            head = head.next; //指针后移

            head.prev = tempNode.prev; //把删除节点的前驱赋值给新的后节点的前驱
            tail.next = head; //把删尾节点的后继从新指向为新的头结点

            tempNode.next = null;
            tempNode.prev = null;
            tempNode.ele = null;
        }

        //头指针清空
        head.prev = null;
        head.prev = null;
        head.ele = null;
    }

    /**
     * @param ele
     * @return boolean
     * @Description 是否包含ele元素
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-12 14:56
     */

    @Override
    public boolean contains(T ele) {

        if (Objects.nonNull(ele)) {
            return false;
        }

        boolean flag = false;
        Node pointNode = head;

        //遍历链表
        while (pointNode.next != head) {

            //p判断链表是佛包含元素
            if (Objects.nonNull(ele) && ele.equals(pointNode.ele)) {
                flag = true;
                break;
            }
            pointNode = pointNode.next;
        }

        return flag;
    }

    /**
     * @param ele
     * @return int
     * @Description 查找元素所在位置
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-12 15:42
     */
    @Override
    public int indexOf(T ele) {

        if (Objects.isNull(ele)) {
            return -1;
        }

        //遍历链表查找元素
        int index = 0;
        boolean flag = false;
        Node pointNode = head;
        while (pointNode.next != head) {
            //找到了
            if (ele.equals(pointNode.ele)) {
                flag = true;
                break;
            }
            pointNode = pointNode.next;
            index++;
        }

        //没找到
        if (flag = false && index >= length - 1) {
            return -1;
        }

        return index + 1;
    }

    /**
     * @param index
     * @return T
     * @Description 根据索引获取元素
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-12 15:49
     */

    @Override
    public T get(int index) {
        if (index < 0 || index > length) {
            throw new RuntimeException("index out range");
        }

        T ele = null;

        //刚好在头结点
        if (index == 0) {
            ele = head.ele;

            //刚好在尾结点
        } else if (index == length - 1) {
            ele = tail.ele;

            //在中间
        } else {

            Node<T> pointNode = null;

            //在左半部分
            if (index <= length / 2) {

                //从头节点开始遍历
                pointNode = head;
                for (int i = 0; i < index - 1; i++) {
                    pointNode = pointNode.next;
                }

                //遍历结束找到了节点吧元素取出
                ele = pointNode.ele;

                //在右半部分
            } else if (index >= length / 2) {

                //从尾结点开始遍历
                pointNode = tail;
                for (int i = length - 1; i > index; i--) {
                    pointNode = pointNode.prev;
                }

                //遍历到当前节点length-index-1
                ele = pointNode.ele;
            }
        }

        return ele;
    }

    /**
     * @param
     * @return boolean
     * @Description 链表是否为空
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-12 15:49
     */

    @Override
    public boolean isEmpty() {
        return Objects.isNull(head);
    }

    /**
     * @param ele
     * @return void
     * @Description 根据元素删除节点
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-12 15:49
     */

    @Override
    public void remove(T ele) {
        int index = indexOf(ele);
        if (index != -1) {
            T remove = remove(index);
        }
    }

    /**
     * @param index
     * @return T
     * @Description 根据索引删除节点
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-12 15:50
     */

    @Override
    public T remove(int index) {

        if (index < 0 || index > length) {
            throw new RuntimeException("index out of range");
        }

        Node<T> tempNode = null;
        T ele = null;

        //移出头部节点
        if (index == 0) {
            tempNode = head; //保存头指针
            ele = tempNode.ele;//取出头只针对的元素
            head.next.prev = tempNode.prev;//头指针的下一个节点的前驱重新复制 指向tail
            head = tempNode.next;//头指针后移
            tail.next = head;//尾指针的后继重新指向新的头指针

            tempNode.prev = null;
            tempNode.next = null;

            //移出尾节点
        } else if (index == length - 1) {

            tempNode = tail; //取出尾指针
            tempNode.prev.next = head; //尾指针前一个节点的后继指向头结点
            ele = tempNode.ele; //取出元素

            tail = tempNode.prev; //尾指针移动到前一个节点
            head.prev = tail; //头指针的前驱重新赋值为新的尾结点

            tempNode.prev = null;
            tempNode.next = null;

            //中间节点
        } else {

            Node<T> pointNode = null;

            //头节点遍历
            if (index <= length / 2) {

                //遍历到当前要删除的节点
                //假设删除index=3 实际删除:index = index-1=2 实际循环: i=0,i=1
                pointNode = head;
                for (int i = 0; i < index - 1; i++) {
                    pointNode = pointNode.next;
                }

                //找到了
                tempNode = pointNode;
                ele = pointNode.ele;

                pointNode.prev.next = pointNode.next;
                pointNode.next.prev = pointNode.prev;

                tempNode.prev = null;
                tempNode.next = null;

                //从尾结点遍历
            } else if (index >= length / 2) {

                pointNode = tail;
                for (int i = length - 1; i > index; i--) {
                    pointNode = pointNode.prev;
                }

                tempNode = pointNode;
                ele = pointNode.ele;

                pointNode.prev.next = pointNode.next;
                pointNode.next.prev = pointNode.prev;

                tempNode.prev = null;
                tempNode.next = null;
            }

        }
        return ele;
    }

    @Override
    public T set(int index, T ele) {

        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("index out of range!");
        }

        if (Objects.isNull(ele)) {
            throw new IllegalArgumentException("ele is null");
        }

        T tempEle = null;

        //头结点
        if (index == 0) {
            tempEle = head.ele;
            head.ele = ele;

            //尾节点
        } else if (index == length - 1) {
            tempEle = tail.ele;
            tail.ele = ele;

            //中间节点
        } else {

            Node<T> pointNode = null;

            //前半部分
            if (index <= length / 2) {
                pointNode = head;
                for (int i = 0; i < index - 1; i++) {
                    pointNode = pointNode.next;//遍历到当前节点后一个
                }

                tempEle = pointNode.ele;
                pointNode.ele = ele;

                //后半部分
            } else if (index >= length / 2) {

                pointNode = tail;
                for (int i = length - 1; i > index; i--) {
                    pointNode = pointNode.prev;//遍历到当前节点的前一个
                }

                tempEle = pointNode.ele;
                pointNode.ele = ele;
            }
        }
        return tempEle;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void sort(Comparator<T> cmp) {

    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        if (Objects.isNull(action)) {
            throw new NullPointerException("action is null");
        }

        Node currentNode = head;

        for (int i = 0; i <= length - 1; i++) {

            action.accept((T) currentNode.ele);

            if (currentNode.next == head) {
                break;
            }

            currentNode = currentNode.next;
        }
    }

    @Override
    public Spliterator<T> spliterator() {

        return CustomList.super.spliterator();
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<T> {

        private Node<T> currentNode = head;
        private boolean flag = true;

        @Override
        public void remove() {
            Iterator.super.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            Iterator.super.forEachRemaining(action);
        }

        /**
         * @Description 下一个是否有元素
         * @Since: 1.0.0
         * @Author xiaoqi
         * @Date 2023-05-13 11:09
         * @param
         * @return boolean
         */
        @Override
        public boolean hasNext() {
            if (isEmpty()) {
                flag = false;
            }
            return flag;
        }

        @Override
        public T next() {
            T ele = currentNode.ele;
            currentNode = currentNode.next;

            if (currentNode == head) {
                flag = false;
            }

            return ele;
        }
    }

    /**
     * @Description toString
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-05-13 11:06
     * @param
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (isEmpty()) {
            sb.append("]");
        } else {
            Node pointNode = head;
            while (pointNode.next != head) {
                sb.append(pointNode.ele);
                sb.append(",");
                pointNode = pointNode.next;
            }
            sb.append(tail.ele + "]");
        }
        return sb.toString();
    }
}
