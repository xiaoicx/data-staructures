package com.dtsc.linkedlist;

import java.util.Objects;
import java.util.Stack;

/**
 * @className: LinkedTable
 * @Package: com.dtsc.linkedlist

 * @description:
 * @author: xiaoqi
 * @Emial: onxiaoqi@qq.com
 * @version v1.0
 * @create: 2023-04-07 22:43
 **/
@SuppressWarnings("all")
public class LinkedTable<T> {

    //创建头指针
    private final LNode<T> head;
    //创建尾指针
    private LNode<T> rear;
    //链表元素数量
    private Integer length;

    /**
     * @Description 初始化链表
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-07 22:57
     * @param
     * @return null
     */
    public LinkedTable() {

        //初始化头指针
        head = new LNode<>(null, 0);

        //头指针指针域为空
        head.next = null;

        //尾指针
        rear = head;

        //链表元素数量
        length = 0;
    }


    public LNode<T> getHead() {
        return head;
    }

    /**
     * @Description 获取索引处的元素
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-07 22:58
     * @param index
     * @return T
     */
    public T getEle(int index) {

        //判断头指针后继元素是否存在
        if (head.next == null || index > length) {
            return null;
        }

        //记录头指针的第一个后继元素
        LNode p = head.next;

        //遍历其实位置, 去掉头指针后的
        int i = 1;
        //判断下一个元素是否存在, 且 遍历的数量小区索引位置
        while (p != null && i < index) {

            //指针后移
            p = p.next;
            i++;
        }

        //判断p是否为null 或 遍历的位置大于index索引 (找不到元素)
        if (Objects.isNull(p) || i > index) {
            return null;
        }

        //返回元素
        return (T) p.ele;
    }

    /**
     * @Description 根据索引插入元素
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-07 23:17
     * @param ele
     * @param index
     * @return int
     */
    public int insert(T ele, int index) {

        //获取头指针的后继元素用于遍历
        LNode p = head.next;

        //遍历元素计数
        int i = 1;

        //遍历链表 条件: 后继元素不为null 且 当前遍历的位置小于插入的位置
        while (p != null && i < index) {

            //元素后移
            p = p.next;
            i++;
        }

        //遍历的元素p不为null  或 遍历的位置小于 index
        if (Objects.isNull(p) || i > index) {
            throw new ArrayStoreException("指定插入位置不存在, 插入失败!");
        }

        //创建节点
        LNode<T> eleNode = new LNode<>(ele, length);

        //先把头指针的指针域给新节点的指针域
        eleNode.next = head.next;

        //把新元素的地址赋值给head的next指针域
        head.next = eleNode;

        //移动尾指针
        rear = eleNode;

        //数量大小
        length++;

        return index;
    }

    /**
     * @Description 插入元素从头部插入
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-07 23:43
     * @param ele
     * @return int
     */
    public void insert(T ele) {

        //创建元素节点
        LNode<T> eleNode = new LNode<T>(ele, length);

        //把头指针的指针域赋值非新元素的指针域
        eleNode.next = head.next;

        //把head的指针域指向新元素
        head.next = eleNode;

        //移动尾指针
        rear = eleNode;

        length++;
    }

    /**
     * @Description 顺序插入 尾插法
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-08 15:13
     * @param
     * @return void
     */
    public void seqenceInsert(T ele, int noId) {

        //获取头结点的后继节点
        LNode temp = head;

        //查找标志 true为编号存在
        boolean flag = false;

        //遍历链表
        while (true) {

            //temp 从头节点的后继节点开始
            if (Objects.isNull(temp.next)) {
                break;
            }

            //如果下一个节点号小于noid则在这个节点的后面插入
            if (temp.next.no > noId) {
                break;
            }

            //如果下一个加点的no == noid 则节点存在不能重新插入
            if (temp.next.no == noId) {
                flag = true;
                break;
            }

            //指针后移
            temp = temp.next;
        }

        //编号存在不插入
        if (flag) {
            System.out.printf("当前序号节点已存在, 不能重复插入! no:[%d] noId:[%d]\n", temp.no, noId);
            return;
        }

        //创建新节点
        LNode<T> eleNode = new LNode<>(ele, noId);

        //在两个节点之间插入新节点
        eleNode.next = temp.next;
        temp.next = eleNode;

        length++;
    }


    /**
     * @Description 根据索引删除元素
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-08 00:50
     * @param
     * @return T
     */
    public T delete(int index) {

        //判断删除索引的区间
        if (index < 0 || index > length) {
            throw new ArrayStoreException("删除的索引范围无效!");
        }

        //循环的索引记录
        int i = 1;

        //删除的元素
        T eleData = null;

        //从head的第一个后继开始遍历
        LNode p = head.next;

        while (Objects.nonNull(p) && i < index) {

            //指针后移, 循环索引记录+1
            p = p.next;
            i++;
        }

        //判断节点是否存在 或 循环的索引 大于 指定的索引
        if (Objects.isNull(p) || i > index) {
            throw new ArrayStoreException("删除链表索引元素不存在");
        }

        //把p节点的指针域 重新赋值为 p的后继的后继节点的地址
        LNode q = p.next;
        p.next = q.next;

        //删除的元素
        eleData = (T) q.ele;
        length--;

        //释放节点
        q = null;

        return eleData;
    }

    /**
     * @Description 根据noId删除
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-08 16:27
     * @param ele
     * @return T
     */
    public T delete(T ele) {

        //强转为stu类型 取得noId
        Stu e = (Stu) ele;

        //判断元素查找的元素是否为空
        if (Objects.isNull(ele)) {
            System.out.println("元素为null");
            return null;
        }

        int i = 0;
        LNode temp = head;
        boolean flag = false;

        while (true) {

            if (Objects.isNull(temp.next)) {
                System.out.println("头指针的后继节点为空!");
                break;
            }

            if (temp.next.no == e.getId()) {
                flag = true;
                break;
            }

            //指针后移
            temp = temp.next;
        }

        //没有找到
        if (!flag) {
            System.out.println("元素不存在, 删除失败!");
            return null;
        }

        //获取删除节点的数据
        T eleData = (T) temp.next.ele;

        //删除节点
        temp.next = temp.next.next;
        length--;

        return eleData;
    }


    /**
     * @Description 根据元素noId更新节点数据
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-08 16:49
     * @param ele
     * @return T
     */
    public T modifly(T ele, int noId) {

        if (Objects.isNull(ele)) {
            System.out.println("查找的元素不存在!");
            return null;
        }

        int len;
        LNode temp = head;
        boolean flag = false;

        //遍历链表
        while (true) {
            if (Objects.isNull(head.next)) {
                System.out.println("头指针的后继节点不存!");
                break;
            }

            //当前节点的id 是否等于查找节点的id
            if (temp.next.no == noId) {
                flag = true;
                break;
            }

            //指针后移
            temp = temp.next;
        }

        if (!flag) {
            System.out.printf("没有查找到元素, 修改失败! no:[%d] noId:[%d]\n", temp.no, noId);
        }

        //获取修改的元素
        T eleData = (T) temp.next.ele;

        //修改元素
        temp.next.ele = ele;

        //返回修改前的元素
        return eleData;
    }


    /**
     * @Description 清空链表
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-08 14:55
     * @param
     * @return void
     */
    public void clearLinkedTable() {
        if (Objects.isNull(head.next)) {
            System.out.println("链表为空");
            return;
        }

        //获取头指针的后继节点
        LNode p = head.next,
                //释放节点的临时变量
                tmpNode = null;

        //循环遍历链表
        while (Objects.nonNull(p)) {
            //把当前节点的后继节点赋值给临时变量
            tmpNode = p.next;
            //当前节点释放
            p = null;
            //把临时节点赋值给p依次后移
            p = tmpNode;
        }

        //头节点的指针域清空
        head.next = null;

        //尾指针移动
        rear = head;

        //清空length
        length = 0;
    }

    /**
     * @Description 头插法 随机插入100个节点
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-08 01:24
     * @param n
     * @return void
     */
    public static void insertRandomHead(int n) {

        //创建头节点
        LNode<Integer> head = new LNode<Integer>(null, 0);

        //头插法插入随机元素
        int len = 1;
        for (int i = 0; i < n; i++) {
            String ele = i + 1 + "-" + Math.ceil(Math.random() * 100);
            LNode<String> node = new LNode<>(ele, len);
            node.next = head.next;
            head.next = node;
            len++;
        }

        //打印
        LNode p = head.next;
        while (Objects.nonNull(p)) {
            System.out.println(p);
            p = p.next;
        }

    }


    /**
     * @Description 尾插法 随机插入100个节点
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-08 01:25
     * @param n
     * @return void
     */
    public static void insertRandomRear(int n) {

        //创建头指针
        LNode<String> head = new LNode<>(null, 0);

        //初始化尾指针
        LNode<String> rear;
        rear = head;

        //数量
        int len = 1;
        for (int i = 0; i < n; i++) {

            //创建节点
            String ele = i + 1 + "_" + Math.ceil(Math.random() * 100 + 1);
            LNode<String> node = new LNode<>(ele, len);

            //把尾节点指针域赋值为新节点的地址
            rear.next = node;

            //把尾指针移动到新的尾节点
            rear = node;

            len++;
        }

        //遍历链表
        LNode p = head.next;
        while (Objects.nonNull(p)) {
            System.out.println(p);
            p = p.next;
        }
    }

    /**
     * @Description 打印链表
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-08 01:26
     * @param node
     * @return void
     */
    public static void printLinkedTable(LNode node) {
        System.out.println("打印链表: ");
        if (Objects.isNull(node)) {
            System.out.println("链表没有数据!!");
        }
        LNode p = node;
        while (p != null) {
            System.out.println(p);
            p = p.next;
        }
    }

    /**
     * 单链表面试题(新浪、百度、腾讯)=======================================================================
     */

    /**
     * @Description 统计链表中有效节点的个数
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-08 17:05
     * @param node
     * @return int
     */
    public static int linkedNodeSize(LNode node) {

        //如果后继节点为null 则当前没有有效节点
        if (Objects.isNull(node.next)) {
            return 0;
        }

        LNode temp = node;
        int len = 0;

        //循环遍历链表  判断节点是否有后继
        while (Objects.nonNull(temp.next)) {
            len++;
            temp = temp.next;
        }

        return len;
    }


    /**
     * @Description 查找链表中倒数第K个结点
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-08 17:26
     * @param node
     * @param k
     * @return T
     */
    public static <T> T findBackNode(LNode node, int k) {

        //1. 获取链表的总长度, 第一次遍历
        int len = 0;
        LNode temp = node;
        while (Objects.nonNull(temp.next)) {
            len++;
            temp = temp.next;
        }

        //2. 获取正序遍历的数量 例: end = 5 - 2 = 3  -> 正序遍历3个节点就是倒数第二个节点
        int end = len - k;
        if (end <= 0 || end > len) {
            System.out.println("倒数查找的范围无效!");
            return null;
        }

        //重置temp, len
        temp = node;
        len = 0;
        while (Objects.nonNull(temp.next)) {
            //判断循环遍
            if (len == end) {
                break;
            }
            //指针后移 和 遍历次数增加
            temp = temp.next;
            len++;
        }

        //返回当前节点的下一个节点中的数据
        return (T) temp.next.ele;
    }


    /**
     * @Description 单链表的反转【腾讯面试题，有点难度】
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-08 17:54
     * @param
     * @return void
     */
    public static <T> LNode<T> reversLinkedTable1(LNode node) {

        //判断是否存在后继节点和后继节点的后继节点
        if (Objects.isNull(node.next) || Objects.isNull(node.next.next)) {
            System.out.println("链表没有后继元素或只有一个后继元素, 无需翻转!");
            return null;
        }

        //声明临时的链表头节点和 当前循环的链表
        LNode tmpHead = new LNode(null, 0), curHead = node;

        //遍历原始链表
        while (Objects.nonNull(curHead.next)) {

            //取出节点 利用头插法插入到临时的链表
            //1. 保存当前节点为临时节点
            LNode tmp = new LNode(curHead.ele, curHead.no);

            //2.把tmpHead的指针域赋值给tmp节点的指针域
            tmp.next = tmpHead.next;

            //3. 把tmp赋值给tmpHead的指针域
            tmpHead.next = tmp;

            //4. 移动指针
            curHead = curHead.next;
        }

        //元素移动完成, 在吧临时链表的指针域赋值给当前链表
        curHead.next = tmpHead.next;

        //释放临时链表
        tmpHead = null;

        //打印链表
       /* while (Objects.nonNull(curHead.next)) {
            System.out.println("翻转后的节点值: " + curHead.ele + " 序号:" + curHead.no);
            curHead = curHead.next;
        }*/
        return curHead;
    }

    /**
     * @Description 从尾到头打印单链表【百度，要求方式1:反向遍历。方式2: Stack栈】
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-08 17:54
     * @param
     * @return void
     */
    public static void printReversLinkedTable1(LNode node) {

        if (Objects.isNull(node.next)) {
            System.out.println("头节点没有后继节点");
            return;
        }

        Stack<Object> stack = new Stack<>();
        LNode p = node.next;

        int len = 0;
        while (Objects.nonNull(p)) {
            stack.push(p);
            p = p.next;
            len++;
        }

        System.out.println("反转链表: ");
        for (int i = 0; i < len; i++) {
            System.out.println(stack.pop());
        }
    }

    /**
     * @Description 从尾到头打印单链表【百度，要求方式1:反向遍历。方式2: Stack栈】
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-08 17:54
     * @param
     * @return void
     */
    public static void printReversLinkedTable2(LNode node) {

        //递归反转链表
        System.out.println("递归反转链表: ");
        if (Objects.nonNull(node.next)) {
            printReversLinkedTable2(node.next);
        }

        System.out.println(node);
    }

    /**
     * @Description 合并两个链表, 返回一个新链表
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-08 19:58
     * @param node1
     * @param node2
     * @return void
     */
    public static <T> LNode<T> mergeLinkedTable(LNode node1, LNode node2) {
        if (Objects.isNull(node1) || Objects.isNull(node2)) {
            System.out.println("参数有一个为null!");
            return null;
        }

        int len1 = 0, len2 = 0;
        LNode tmpRear1 = null, tmpRear2 = null;

        //统计链表一的数量
        LNode tempNode = node1;
        while (Objects.nonNull(tempNode.next)) {
            len1++;
            tempNode = tempNode.next;
        }
        //记录链表1的尾节点用于合并
        if (Objects.isNull(tempNode.next)) {
            tmpRear1 = tempNode;
        }

        //统计链表二的数量
        tempNode = node2;
        while (Objects.nonNull(tempNode.next)) {
            len2++;
            tempNode = tempNode.next;
        }
        //记录链表2的尾节点用于合并s
        if (Objects.isNull(tempNode.next)) {
            tmpRear2 = tempNode;
        }

        //新建头结点
        LNode<Object> head = new LNode<>(null, 0);

        //链表1比链表2长
        if (len1 < len2) {

            head.next = node1.next;
            tmpRear1.next = node2.next;
        } else {

            head.next = node2.next;
            tmpRear2.next = node1.next;
        }

        return (LNode<T>) head;
    }
}
