package com.company.Server;

import com.company.Shared.Commands.Command;
import com.company.Shared.Entities.Product;

import java.util.Scanner;
import java.util.Vector;

public class ExecuteUpdate extends ExecuteCommand {

    @Override
    public String execute(Command command) {

        int idValue;
        StringBuilder stringBuilder = new StringBuilder();
        idValue = ParseAll.tryParseInt(command.getDataCommand().getId().toString(), 0, stringBuilder);
        if (stringBuilder.length() > 0) {
            return "The value was not a number, enter a valid value.";
        }

        for (Product actual : ServerApp.products) {
            if (actual.getId() == idValue) {
                ServerApp.products.remove(actual);
                ServerApp.products.add(command.getDataCommand().getProduct());
            }
        }
        return "the Product was updated";
    }
}
