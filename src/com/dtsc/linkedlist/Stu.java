package com.dtsc.linkedlist;

/**
 * @className: Stu
 * @Package: com.dtsc.linkedlist

 * @description:
 * @author: xiaoqi
 * @Emial: onxiaoqi@qq.com
 * @version v1.0
 * @create: 2023-04-08 15:28
 **/
public class Stu {
    private String name;
    private Integer id;

    public Stu(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
