package com.andrew.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import com.andrew.serializable.Customer;

public interface Calculator extends Remote{
	String getName() throws RemoteException;
	void sayHello() throws RemoteException;
	Double calculateFee(Customer c) throws RemoteException;
	Customer waiter() throws RemoteException;
}
