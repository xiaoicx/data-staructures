package com.dtsc.sqlist;

/**
 * @className: SqlType
 * @Package: com.dtsc.sqlist

 * @description: 顺序表类型
 * @author: xiaoqi
 * @version v1.0
 * @create: 2022-12-01 21:59
 **/
public class SqlType {
    public BookType[] BookType = null;
    public Integer length = 0;
}

class BookType{
    public String name;
    public double price;

    @Override
    public String toString() {
        return "BookType{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}