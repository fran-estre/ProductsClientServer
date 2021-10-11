package com.company.Client;

import com.company.Shared.Commands.Command;
import com.company.Shared.Commands.DataBox;
import com.company.Shared.Commands.Serialization;

import java.io.IOException;

public class CommandHandler {
    public String sendCommand(Command command) {
        byte[] data = Serialization.serialize(command);
        if (data == null)
            return "There was an error while serialization.";
        try {
            System.out.println("message size: " + data.length + "\n");
            if (ClientApp.getCommunication().send(data)) {
                StringBuilder errors = new StringBuilder();
                byte[] response = ClientApp.getCommunication().receive(errors);
                Command command1 = (Command) Serialization.deserialize(response);
                DataBox dataBox = command1.getDataBox();
                if (dataBox != null)
                    return dataBox.getResponse();
                else {
                    return "nothing";
                }
            }
            return "The command was not sent";
        } catch (IOException e) {
            e.printStackTrace();
            return "There was an error while sending data.";
        }
    }
}
