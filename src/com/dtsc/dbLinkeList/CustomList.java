package com.dtsc.dbLinkeList;

import java.util.Comparator;
import java.util.List;

/**
 * @version v1.0
 * @className: CustomList
 * @Package: com.dtsc.dbLinkeList
 * @description:
 * @author: xiaoqi
 * @Emial: onxiaoqi@qq.com
 * @create: 2023-05-11 23:02
 **/
public interface CustomList<T> extends Iterable<T> {
    public abstract void add(T ele);

    public abstract void add(T ele, int index);

    public abstract void clear();

    public abstract boolean contains(T ele);

    public abstract T get(int index);

    public abstract boolean isEmpty();

    public abstract void remove(T ele);

    public abstract T remove(int index);

    public abstract T set(int index, T ele);

    public abstract int size();

    public abstract int indexOf(T ele);

    public abstract void sort(Comparator<T> cmp);

    public abstract List<T> subList(int fromIndex, int toIndex);
}
