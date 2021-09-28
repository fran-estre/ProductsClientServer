package com.company.Shared;

import java.io.*;

public class Serialization {
    public static byte[] serialize(Object data) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(data);
            oos.flush();
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Serializable deserialize(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o;
        try {
            o = new ObjectInputStream(b);
            return (Serializable) o.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
