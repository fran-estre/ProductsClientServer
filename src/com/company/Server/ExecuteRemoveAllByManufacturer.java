package com.company.Server;

import com.company.Shared.Commands.Command;

public class ExecuteRemoveAllByManufacturer extends ExecuteCommand {

    @Override
    public String execute(Command command) {
        ServerApp.products.removeIf(actual -> actual.getManufacturer().getName().equals(command.getDataBox().getManufacturer()));
        return "The products with the manufacturer name (" + command.getDataBox().getManufacturer() + ") were deleted.";
    }
}
