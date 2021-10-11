package com.company.Server;

import com.company.Shared.Commands.Command;

import com.company.Shared.Commands.DataBox;
import com.company.Shared.Commands.DataBoxHandler;
import com.company.Shared.Entities.Product;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import static com.company.Server.ServerApp.products;

public class ProcessHandler {
    public static String processCommand(Command command) {
        try {
            Class cls = Class.forName("com.company.Server.Execute" + getClassName(command.getCommandType().toString()));
            ExecuteCommand myTestObject = (ExecuteCommand) cls.newInstance();
            return myTestObject.execute(command);
        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException | JsonProcessingException e) {
        }
        return null;
    }

    private static String getClassName(String part) {
        StringBuilder className = new StringBuilder();
        className.append(Character.toString(part.charAt(0)).toUpperCase(Locale.ROOT));
        for (int actual = 1; actual < part.length(); actual++) {
            if (part.charAt(actual) == '_') {
                continue;
            }
            if (part.charAt(actual - 1) == '_') {
                className.append(Character.toString(part.charAt(actual)).toUpperCase(Locale.ROOT));
            } else {
                className.append(Character.toString(part.charAt(actual)).toLowerCase(Locale.ROOT));
            }
        }
        return className.toString();
    }
}

