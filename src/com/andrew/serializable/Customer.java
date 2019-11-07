package com.andrew.serializable;

import java.io.Serializable;

public class Customer implements Serializable {
    private static final long serialVersionUID = 2L;
    private String name;
    private static int count;//no serialized field
    private transient String sex;	//no serialized field
 
    private double baseFeePerHour = 18.88;
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
        return "[ " + count + " " + name + " " + sex + " " + baseFeePerHour + " ]";
    }
    
    public double plusFee(double liberal) {
    	return baseFeePerHour + (liberal > 0 ? liberal : 0);
    }
    
    public double baseFee(){
    	return baseFeePerHour;
    }
    
    public void plusBaseFee(double generousBoss){
    	if (generousBoss < 0.01)
    		generousBoss = 0.01;
    	if (generousBoss > 200)
    		generousBoss = 200;
    	baseFeePerHour+=generousBoss;
    }
}