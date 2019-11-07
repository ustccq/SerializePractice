package com.andrew.serializable;

import java.io.Serializable;

public class Customer implements Serializable {
    private static final long serialVersionUID = 2L;
    private String name;
    private static int count;
    private transient String sex;
 
    static {
        System.out.println("调用静态代码块");
    }
 
    public Customer() {
        System.out.println("无参构造方法");
    }
 
    public Customer(String name, String sex) {
        System.out.println("有参构造方法");
        this.name = name;
        this.sex = sex;
        count++;
 
    }
 
    public String toString() {
        return "[ " + count + " " + name + " " + sex + " ]";
    }
}