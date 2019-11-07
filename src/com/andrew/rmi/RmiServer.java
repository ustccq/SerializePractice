package com.andrew.rmi;

import java.rmi.RemoteException;

public class RmiServer {

	public static void main(String[] args) {
		
		try {
			RemoteCalculatorImpl.startServer(1113);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
