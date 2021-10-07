package com.company.Server;

import com.company.Shared.Commands.Command;

import java.util.Scanner;
import java.util.Vector;

public class ExecuteInsertAtIndex extends ExecuteCommand {

    @Override
    public String execute(Command command) {
        {
            int indexValue;
            do {
                StringBuilder stringBuilder = new StringBuilder();
                indexValue = ParseAll.tryParseInt(command.getDataCommand().getIndex().toString(), 0, stringBuilder);
                if (stringBuilder.length() > 0) {
                    System.out.println("The value was incorrect, enter a valid value");
                } else {
                    break;
                }
            } while (true);

            ServerApp.products.add(command.getDataCommand().getProduct());
        }
        return "the Product vas inserted at :" + command.getDataCommand().getIndex().toString();
    }
}
