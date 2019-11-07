package com.andrew.rmi;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteObject;

public class RmiClient {

	public static void main(String[] args) {
		
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
                System.out.println("Using remote object: "+robj.getRef().remoteToString()); // NOSONAR
            }
            return cal;
        }
        throw new RemoteException("Could not find "+name);
    }
}
