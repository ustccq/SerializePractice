package com.andrew.rmi;

import java.rmi.RemoteException;

public class RmiServer {

	public static void main(String[] args) {
		
		try {
			RemoteCalculatorImpl.startServer(RmiClient.port);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
