package com.company.Server;

import com.company.Shared.Commands.Command;

import java.util.Vector;

public class ExecuteRemoveAllByManufacturer extends ExecuteCommand {

    @Override
    public String execute(Command command) {
        ServerApp.products.removeIf(actual -> actual.getManufacturer().getName().equals(command.getDataCommand().getManufacturer()));
        return "The products with the manufacturer name (" + command.getDataCommand().getManufacturer() + ") were deleted.";
    }
}
