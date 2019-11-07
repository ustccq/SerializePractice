package com.andrew.rmi;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.andrew.serializable.Customer;

public class RemoteCalculatorImpl extends UnicastRemoteObject implements Calculator{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4128108239135558262L;

	public static String rmiRegisterKey = "MeowlomoCalculator";
	
	private int rmiRegistryPort = 1113;
	
	public static void startServer(int rmiRegistryPort) throws RemoteException {
		RemoteCalculatorImpl calculator = new RemoteCalculatorImpl(rmiRegistryPort);
		calculator.init();
	}
	
	private void init() throws RemoteException {
		InetAddress localHost;
		try {
			localHost = InetAddress.getByName("10.0.100.142");
		} catch (UnknownHostException e) {
			throw new RemoteException("Cannot start. Unable to get local host IP address");
		}
		Registry reg = null;
		try {
			reg = LocateRegistry.createRegistry(rmiRegistryPort);
		} catch(RemoteException e) {
			e.printStackTrace();
		}
		
		try {
			if (null != reg) {
				reg.rebind(rmiRegisterKey, this);
				System.out.println("registry " + rmiRegisterKey);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RemoteException("cannot start server.");
		}
	}
	
	protected RemoteCalculatorImpl(int rmiRegistryPort) throws RemoteException {
		super(0, null, null);
		this.rmiRegistryPort = rmiRegistryPort;
		System.out.println("Created remote object:" + this.getRef().remoteToString());
	}

	@Override
	public String getName() throws RemoteException {
		System.out.println("getName be called.");
		return "This is my Name";
	}

	@Override
	public void sayHello() throws RemoteException {
		System.out.println("sayHello be called.");
	}

	@Override
	public Double calculateFee(Customer c) throws RemoteException {
		System.out.println(c.toString());
		c.plusBaseFee(58.88);
		System.out.println(c.toString());
		return c.plusFee(100);
	}

}
