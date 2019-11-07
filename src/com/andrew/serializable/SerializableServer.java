package com.andrew.serializable;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SerializableServer {
    public void send(Object obj) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        while (true) {
            Socket socket = serverSocket.accept();
            ObjectOutputStream out = new ObjectOutputStream(
                    socket.getOutputStream());
            out.writeObject(obj);
            out.writeObject(obj);
            System.err.println(obj.hashCode());
            out.close();
            socket.close();
        }
    }
 
    public static void main(String[] args) throws Exception {
 
        Customer customer = new Customer("rollen", "male");
        new SerializableServer().send(customer);
    }
}
