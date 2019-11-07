package com.andrew.serializable;

import java.io.Serializable;

public class Customer implements Serializable {
    private static final long serialVersionUID = 2L;
    private String name;
    private static int count;//no serialized field
    private transient String sex;	//no serialized field
 
    static {
        System.out.println("Static initial code block.");
    }
 
    public Customer() {
        System.out.println("Ctor with NO parameters.");
    }
    
    public String name(){
    	return name;
    }
 
    public Customer(String name, String sex) {
        System.out.println("Ctor with parameters.");
        this.name = name;
        this.sex = sex;
        count++;
    }
 
    public String toString() {
        return "[ " + count + " " + name + " " + sex + " ]";
    }
}