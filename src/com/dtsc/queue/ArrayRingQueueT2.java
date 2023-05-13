package com.dtsc.queue;

import java.util.Scanner;

/**
 * @className: ArrayRingQueueT2
 * @Package: com.dtsc.queue

 * @description:
 * @author: xiaoqi
 * @Emial: onxiaoqi@qq.com
 * @version v1.0
 * @create: 2023-03-09 16:41
 **/
public class ArrayRingQueueT2 {
    public static void main(String[] args) {
        RingQueue<Integer> queue = new RingQueue<>(6);
        Scanner scanner = new Scanner(System.in);
        char key = 0;
        boolean flag = true;

        while (flag) {
            System.out.println("s (show)");
            System.out.println("a (add)");
            System.out.println("g (get)");
            System.out.println("h (head)");
            System.out.println("e (exit)");
            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    queue.printQueue();
                    break;
                case 'a':
                    System.out.print("请输入一个数:");
                    int anInt = scanner.nextInt();
                    queue.addQueueEle(anInt);
                    break;
                case 'g':
                    Integer ele = queue.getQueueEle();
                    if (ele != null) {
                        System.out.println("item=" + ele);
                    }
                    break;
                case 'h':
                    queue.showFrontEle();
                    break;
                case 'e':
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

    }
}

class RingQueue<T> {
    private T queue[];
    private int maxSize;
    private int rear = 0;
    private int front = 0;

    public RingQueue(int size) {
        this.init(size);
    }

    private void init(int size) {
        queue = (T[]) new Object[size];
        maxSize = size;
    }

    public void addQueueEle(T ele) {
        if (isFull()) {
            System.out.println("队列已满!");
            return;
        }
        //环形队列如果不取模会溢出 例如当前 rear=2 front=1 总共有3个元素 则下一个元素位置为 (rear+1)%maxSize=0
        queue[(rear++) % maxSize] = ele;
    }

    public T getQueueEle() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return null;
        }

        //环形队列如果不取模会溢出 例如当前 rear=2 front=1 总共有3个元素 则下一个front指针为 (front+1)%maxSize=2
        return queue[(front++) % maxSize];
    }

    public void showFrontEle() {
        if (isEmpty()) {
            System.out.println("队列为空!");
            return;
        }
        //front指针就是指向第一个元素
        System.out.println("front Item=" + queue[front]);
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("队列为空!");
            return;
        }
        System.out.println("QueueArray");
        //front + size()为从front位置+5  应为是循环列表所以需要计算rear<front的情况
        for (int i = front; i < front + size(); i++) {
            int p = i % maxSize;
            System.out.format("item[" + p + "]=" + queue[p] + "\n");
        }
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public int size() {
        /**
         * 当front > rear 元素个数为 maxSize-front
         * 当rear < front 元素个数为0 + rear
         */
        return (maxSize - front + rear) % maxSize;
    }

}