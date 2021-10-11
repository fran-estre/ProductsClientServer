package com.company.Server;

import com.company.Shared.Commands.Command;

public class ExecuteRemoveGreater extends ExecuteCommand {

    @Override
    public String execute(Command command) {
        for (int i = 0; i < ServerApp.products.size(); i++) {
            if (ServerApp.products.get(i).getPrice() > command.getDataBox().getPrice()) {
                ServerApp.products.remove(i);
                i--;
            }
        }
        return "The products with a higher price than:" + command.getDataBox().getPrice() + " were removed.";
    }
}