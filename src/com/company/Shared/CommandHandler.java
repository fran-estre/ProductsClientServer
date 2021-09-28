package com.company.Shared;

import java.io.IOException;
import java.util.Scanner;

public class CommandHandler {
    public String sendCommand(Command command) {
        byte[] data = Serialization.serialize(command);
        if (data == null)
            return "There was an error while serialization.";
        try {
            System.out.println("message size: " + data.length + "\n");
            if (ClientApp.getCommunication().send(data))
                return ClientApp.getCommunication().receive();
            return "The command was not sent";
        } catch (IOException e) {
            e.printStackTrace();
            return "There was an error while sending data.";
        }
    }
    // DataBox dataBox = (DataBox) Serialization.deserialize(buffer);
    //
    //            return dataBox.getResponse();
}
