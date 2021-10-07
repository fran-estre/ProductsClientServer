package com.company.Server;

import com.company.Shared.Commands.Command;

import java.util.Vector;

public class ExecuteRemoveGreater extends ExecuteCommand {

    @Override
    public String execute(Command command) {
        for (int i = 0; i < ServerApp.products.size(); i++) {
            if (ServerApp.products.get(i).getPrice() > command.getDataCommand().getPrice()) {
                ServerApp.products.remove(i);
                i--;
            }
        }
        return "The products with a higher price than:" + command.getDataCommand().getPrice() + " were removed.";
    }
}