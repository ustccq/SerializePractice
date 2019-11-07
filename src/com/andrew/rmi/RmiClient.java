package com.andrew.rmi;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteObject;

import com.andrew.serializable.Customer;

public class RmiClient {

	public final static int port = 1113;
	private final static String hostAndPort = "192.168.0.111:" + port;
	public static void main(String[] args) {
		try {
			Calculator cal = RmiClient.getCalculator(hostAndPort);
			System.out.println("Rmi Calculator getName():" + cal.getName());
			cal.sayHello();
			System.out.println("Rmi Calculator sayHello():");
			System.out.println("Rmi Calculator getName():" + cal.calculateFee(new Customer("Lucy", "girl")));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Calculator getCalculator(String hostAndPort) 
            throws RemoteException, NotBoundException {
        final String name = RemoteCalculatorImpl.rmiRegisterKey;
        String host = hostAndPort;
        int port = 1113;
        int indexOfSeparator = hostAndPort.indexOf(':');
        if (indexOfSeparator >= 0) {
            host = hostAndPort.substring(0, indexOfSeparator);
            String portAsString = hostAndPort.substring(indexOfSeparator+1);
            port = Integer.parseInt(portAsString);
        }
        Registry registry = LocateRegistry.getRegistry(
               host, 
               port,
               null);
        Remote remobj = registry.lookup(name);
        if (remobj instanceof Calculator){
            final Calculator cal = (Calculator) remobj;
            if (remobj instanceof RemoteObject){
                RemoteObject robj = (RemoteObject) remobj;
                System.out.println("Using remote object: "+robj.getRef().remoteToString());
            }
            return cal;
        }
        throw new RemoteException("Could not find "+name);
    }
}
