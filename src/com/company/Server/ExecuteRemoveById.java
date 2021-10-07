package com.company.Server;

import com.company.Shared.Commands.Command;
import com.company.Shared.Entities.Product;

import java.util.Vector;

public class ExecuteRemoveById extends ExecuteCommand {

    @Override
    public String execute(Command command) {
        int idValue;
        do {
            StringBuilder stringBuilder = new StringBuilder();
            idValue = ParseAll.tryParseInt(command.getDataCommand().getId().toString(), 0, stringBuilder);
            if (stringBuilder.length() > 0) {
                System.out.println("The value was incorrect, enter a valid value");
            } else {
                break;
            }
        } while (true);

        for (Product actual : ServerApp.products) {
            if (actual.getId() == idValue) {
                ServerApp.products.remove(actual);
                break;
            }
        }
        return "the Product was removed.";
    }
}
