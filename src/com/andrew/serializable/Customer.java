package com.andrew.serializable;

import java.util.List;
import java.io.Serializable;
import java.util.LinkedList;

public class Customer implements Serializable {
    private static final long serialVersionUID = 2L;
    private String name;
    private static int count;//no serialized field
    private transient String sex;	//no serialized field
 
    private double baseFeePerHour = 18.88;
    LinkedList<Double> fees = new LinkedList<Double>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 9168445254393236900L;

		{
			push(baseFeePerHour);
		}
	};
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
    
    public double baseFeeInCollection(){
    	return fees.get(0);
    }
    
    public void plusBaseFee(double generousBoss){
    	if (generousBoss < 0.01)
    		generousBoss = 0.01;
    	if (generousBoss > 200)
    		generousBoss = 200;
    	System.err.println("base fee add:" + generousBoss);
    	baseFeePerHour+=generousBoss;
    	fees.set(0, baseFeePerHour);
    	System.err.println("base fee get from collection:" + fees.get(0));
    }
}