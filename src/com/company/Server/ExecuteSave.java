package com.company.Server;

import com.company.Shared.Commands.Command;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class ExecuteSave extends ExecuteCommand {

    @Override
    public String execute(Command command) throws JsonProcessingException {
        if (ServerApp.products.size() == 0) {
            return "there are no products to save.";
        }
        ObjectMapper myObjectMapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        myObjectMapper.setDateFormat(df);
        String json = myObjectMapper.writeValueAsString(ServerApp.products);
        System.out.println("This is the file that you saved:" + json);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(ServerApp.getFileName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (writer != null) {
            try {
                writer.write(json);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "the Products were saved.";
    }
}
