package com.andrew.serializable;

import java.io.ObjectInputStream;
import java.net.Socket;

public class SerializableClient {
    public void recive() throws Exception {
        Socket socket = new Socket("10.0.100.142", 8000);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        Object obj1 = in.readObject();
        Object obj2 = in.readObject();
        System.out.println(obj1);
        System.out.println(obj1==obj2);
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
        socket.close();
    }
 
    public static void main(String[] args) {
        try {
            new SerializableClient().recive();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}