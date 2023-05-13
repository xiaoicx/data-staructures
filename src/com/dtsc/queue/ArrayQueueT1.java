package com.dtsc.queue;

import java.util.Scanner;

/**
 * 队列, 一端进入一端出  队尾:rear  对头front
 * 队列是一个有序列表，可以用数组或是链表来实现。
 * 遵循先入先出的原则。即:先存入队列的数据，要先取出。后存入的要后取出
 *   出队                            进队
 *  <---a1   a2  a3  a4  a5  ...    an<----
 *  front                          rear
 **/
public class ArrayQueueT1 {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>(5);
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

class ArrayQueue<T> {
    private T queue[];
    private int maxSize;
    private int rear = -1;
    private int front = -1;

    public ArrayQueue(int size) {
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
        queue[++rear] = ele;
    }


    public T getQueueEle() {
        if (isEnpty()) {
            System.out.println("队列为空");
            return null;
        }

        return queue[++front];
    }

    public void showFrontEle() {
        if (isEnpty()) {
            System.out.println("队列为空!");
            return;
        }
        System.out.println("front Item=" + queue[front + 1]);
    }

    public void printQueue() {
        System.out.println("QueueArray");
        if (isEnpty()) {
            System.out.println("队列为空!");
            return;
        }
        for (int i = 0; i < queue.length; i++) {
            System.out.format("item[" + i + "]=" + queue[i] + "\n");
        }
    }

    public boolean isEnpty() {
        return rear == front;
    }

    public boolean isFull() {
        return rear == (maxSize - 1);
    }

}
