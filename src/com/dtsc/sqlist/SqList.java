package com.dtsc.sqlist;

import java.util.Arrays;
import java.util.Objects;

/**
 * @className: SqList
 * @Package: com.dtsc.sqlist

 * @description:
 * @author: xiaoqi
 * @version v1.0
 * @create: 2022-12-01 22:01
 **/
@SuppressWarnings("all")
public class SqList<T> {

    private T[] data = null;
    private int length = -1;
    private int size = -1;

    public SqList(int size) {
        init(size);
    }

    /**
     * @Description 初始化
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-07 14:53
     * @param size
     * @return void
     */
    private void init(int size) {
        data = (T[]) new Object[size];
        length = 0;
        this.size = size;
    }

    /**
     * @Description 清空线性表
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-07 14:53
     * @param
     * @return void
     */
    public void clearList() {
        if (length > 0) {
            length = 0;
        }
    }

    /**
     * @Description 是否为空
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-07 14:54
     * @param
     * @return boolean
     */
    public boolean isEmpty() {
        return length > 0 ? false : true;
    }

    /**
     * @Description 获取长度
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-07 14:54
     * @param
     * @return int
     */
    public int length() {
        return this.length;
    }

    /**
     * @Description 获取元素
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-07 14:55
     * @param
     * @return T
     */
    public T get(int index) {
        //index超过范围区间
        if (index >= 0 && index <= length) {
            return null;
        }
        System.out.println("data[index] = " + data[index]);
        System.out.println("data[index-1] = " + data[index - 1]);
        return data[index - 1];
    }

    /**
     * @Description 返回元素所在线性表的位置
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-07 14:56
     * @param ele
     * @return int
     */
    public int locateIndex(T ele) {

        //如果为null返回-1
        if (Objects.isNull(ele)) {
            return -1;
        }

        int index = -1;
        for (int i = 0; i < length; i++) {
            if (ele.equals(data[i])) {
                index = i + 1;
                break;
            }
        }

        return index;
    }

    /**
     * @Description 返回当前元素的前一个元素
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-07 14:57
     * @param ele
     * @return T
     */
    public T getPrior(T ele) {

        //如果为null返回null
        if (Objects.isNull(ele)) {
            return null;
        }

        T e = null;
        for (int i = 0; i < length; i++) {
            //判断ele是否和线性表内元素一致
            if (ele.equals(data[i])) {

                //判断上一个元素是否存在 防止溢出
                if (i > 0) {
                    //获取上一个元素
                    e = data[i - 1];
                    break;
                }
            }
        }
        return e;
    }

    /**
     * @Description 返回当前元素的下一个元素
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-07 14:58
     * @param ele
     * @return T
     */
    public T getNext(T ele) {

        //如果为null返回null
        if (Objects.isNull(ele)) {
            return null;
        }

        T e = null;
        for (int i = 0; i < length; i++) {
            //比较元素
            if (ele.equals(data[i])) {

                //判断下一个元素是否存在 防止溢出
                if (i < length) {
                    //获取下一个元素
                    e = data[i + 1];
                    break;
                }
            }
        }
        return e;
    }

    /**
     * @Description 指定位置插入元素
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-07 14:59
     * @param
     * @return null
     */
    public void insert(int index, T ele) {

        //判断index是否再区间内
        if (index <= 0 && index > size) {
            throw new ArrayStoreException("线性表空间不足, 插入失败!");
        }

        //插入点再最后
        if (index >= length) {
            //插入到最后的位置
            data[length++] = ele;
        }

        //插入点在元素中间存在元素
        if (index <= length) {

            //元素后移 倒序遍历依次后移 length+1 = length
            for (int i = length; i > index - 1; i--) {
                data[i] = data[i - 1];
            }

            //插入元素
            data[index - 1] = ele;
            //数量+1
            length++;
        }

        System.out.printf("插入成功, 插入位置[%d]-插入元素[%s]\n", index - 1, ele);
    }


    /**
     * @Description 像尾部添加元素
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-07 15:41
     * @param ele
     * @return void
     */
    public void add(T ele) {
        if (length + 1 > size) {
            throw new ArrayStoreException("list表已满, 无法加入元素!");
        }

        data[length++] = ele;
    }

    /**
     * @Description 删除指定位置的元素, 返回删除的元素. 失败返回null
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-07 14:59
     * @param index
     * @return T
     */
    public T delete(int index) {

        //判断index是否再区间内
        if (index <= 0 && index > length) {
            return null;
        }

        T ele = null;

        //删除元素在最后
        if (index == length) {
            ele = data[length - 1];
            length--;
        }

        //删除元素在中间
        if (index > 0 && index < length) {

            //要删除的元素
            ele = data[index - 1];

            //元素前移, 正序遍历 index - 1 = index
            for (int i = index - 1; i < length; i++) {
                data[i] = data[i + 1];
            }

            //length-1
            length--;
        }
        return ele;
    }

    /**
     * @Description 遍历线性表
     * @Since: 1.0.0
     * @Author xiaoqi
     * @Date 2023-04-07 15:01
     * @param
     * @return void
     */
    public void printList() {
        Arrays.stream(data).forEach(System.out::println);
    }

}
