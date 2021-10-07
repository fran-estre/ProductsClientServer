package com.company.Server;

import com.company.Shared.Commands.Command;

public class ExecuteInfo extends ExecuteCommand {

    @Override
    public String execute(Command command) {
        return "type: Vector<Product>\n" +
                "initialization: " + ServerApp.getInitialization() + "\n" +
                "length: " + ServerApp.products.size();
    }
}
